package br.ifba.saj.ads10.core;

import br.ifba.saj.ads10.net.TcpClient;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import java.util.Map; import java.util.concurrent.*;

public class HeartbeatManager {
    private static final Logger log = LoggerFactory.getLogger(HeartbeatManager.class);
    private final Config cfg; private final LamportClock clock;
    private final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
    private final Map<String,Integer> misses = new ConcurrentHashMap<>();

    public HeartbeatManager(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }

    public void start() {
        for (String peer : cfg.peers()) misses.put(peer, 0);
        ses.scheduleAtFixedRate(this::beatAll, 1, 2, TimeUnit.SECONDS);
    }
    private void beatAll() {
        for (String p : cfg.peers()) {
            try {
                String[] parts = p.split(":"); String host = parts[0]; int port = Integer.parseInt(parts[1]);
                String resp = TcpClient.send(host, port, "HB " + cfg.group() + "-" + cfg.nodeId() + " " + clock.send());
                if (resp != null && resp.startsWith("OK")) { misses.put(p, 0); }
                else misses.compute(p, (k,v)-> (v==null?0:v)+1);
            } catch (Exception e) {
                misses.compute(p, (k,v)-> (v==null?0:v)+1);
            }
            misses.forEach((peer, m)-> {
                if (m>=3) log.warn("Peer {} considered DOWN ({} misses). Simulating replacement.", peer, m);
            });
        }
    }
}
