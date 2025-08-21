package br.ifba.saj.ads10;

import br.ifba.saj.ads10.core.*;
import br.ifba.saj.ads10.net.*;
import br.ifba.saj.ads10.grpcimpl.GrpcNode;
import br.ifba.saj.ads10.rmiimpl.RmiNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Config cfg = Config.fromEnv();
        log.info("Iniciando node: {}", cfg);
        LamportClock clock = new LamportClock();
        HeartbeatManager hb = new HeartbeatManager(cfg, clock);
        MulticastService multicast = new MulticastService(cfg, clock);
        TcpServer tcpServer = new TcpServer(cfg, clock);
        tcpServer.start();

        // Iniciar middleware específico para a role
        if (cfg.group().equalsIgnoreCase("A")) {
            GrpcNode node = new GrpcNode(cfg, clock);
            node.start();
        } else {
            RmiNode node = new RmiNode(cfg, clock);
            node.start();
        }

        // Iniciar a eleição por grupo
        if (cfg.group().equalsIgnoreCase("A")) {
            new Thread(() -> {
                try { new BullyElection(cfg, clock).startElection(); } catch (Exception e) { log.error("Election error", e); }
            }).start();
        } else {
            new Thread(() -> {
                try { new RingElection(cfg, clock).startElection(); } catch (Exception e) { log.error("Election error", e); }
            }).start();
        }

        // Heartbeats + multicast
        hb.start();
        multicast.start();

        Thread.currentThread().join();
    }
}
