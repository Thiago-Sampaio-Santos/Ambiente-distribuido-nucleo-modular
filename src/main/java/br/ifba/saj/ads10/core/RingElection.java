package br.ifba.saj.ads10.core;

import br.ifba.saj.ads10.net.TcpClient;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RingElection {
    private static final Logger log = LoggerFactory.getLogger(RingElection.class);
    private final Config cfg; private final LamportClock clock;
    public RingElection(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }
    public void startElection() {
        log.info("Eleição de anel iniciando para o Grupo B, node {}", cfg.nodeId());
        List<String> ordered = cfg.peers().stream().sorted(Comparator.comparingInt(p->Integer.parseInt(p.split(":")[2]))).collect(Collectors.toList());
        int myIdx = Math.max(0, ordered.indexOf(selfPeer()));
        String next = ordered.get((myIdx+1)%ordered.size());
        TcpClient.send(next.split(":")[0], Integer.parseInt(next.split(":")[1]), "RING " + cfg.nodeId());
        log.info("Token enviado para {}", next);
    }
    private String selfPeer() {
        for (String p: cfg.peers()) if (Integer.parseInt(p.split(":")[2])==cfg.nodeId()) return p;
        return cfg.peers().getFirst();
    }
}
