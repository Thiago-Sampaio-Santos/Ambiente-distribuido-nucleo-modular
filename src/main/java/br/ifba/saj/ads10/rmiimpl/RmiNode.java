package br.ifba.saj.ads10.rmiimpl;

import br.ifba.saj.ads10.core.*;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiNode {
    private static final Logger log = LoggerFactory.getLogger(RmiNode.class);
    private final Config cfg; private final LamportClock clock;
    public RmiNode(Config cfg, LamportClock clock){ this.cfg=cfg; this.clock=clock; }
    public void start() throws Exception {
        try { LocateRegistry.createRegistry(cfg.rmiPort()); } catch (Exception ignored) {}
        var impl = new RmiServiceImpl(clock, cfg.tokenSecret());
        Naming.rebind("//0.0.0.0:"+cfg.rmiPort()+"/service", impl);
        log.info("RMI service bound on {}", cfg.rmiPort());
    }
}
