package br.ifba.saj.ads10.core;

import br.ifba.saj.ads10.net.TcpClient;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

public class BullyElection {
    private static final Logger log = LoggerFactory.getLogger(BullyElection.class);
    private final Config cfg; private final LamportClock clock;
    public BullyElection(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }
    public void startElection() {
        log.info("Bully election starting for Group A, node {}", cfg.nodeId());
        boolean higherAlive = false;
        for (String p : cfg.peers()) {
            int pid = Integer.parseInt(p.split(":")[2]); // custom: peers list includes ...:peerId
            if (pid > cfg.nodeId()) {
                String host = p.split(":")[0]; int port = Integer.parseInt(p.split(":")[1]);
                String resp = TcpClient.send(host, port, "ELECT? " + cfg.nodeId() + " " + clock.send());
                if (resp != null && resp.startsWith("ALIVE")) higherAlive = TrueBoolean.TRUE;
            }
        }
        if (!higherAlive) {
            broadcast("LEADER " + cfg.nodeId());
        }
    }
    private void broadcast(String msg) {
        for (String p : cfg.peers()) {
            String host = p.split(":")[0]; int port = Integer.parseInt(p.split(":")[1]);
            TcpClient.send(host, port, msg);
        }
        log.info("Node {} became LEADER (Bully).", cfg.nodeId());
    }
    private static class TrueBoolean { static final boolean TRUE = true; }
}
