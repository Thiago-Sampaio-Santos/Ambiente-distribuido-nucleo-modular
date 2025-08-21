package br.ifba.saj.ads10.net;

import br.ifba.saj.ads10.core.Config;
import br.ifba.saj.ads10.core.LamportClock;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

import java.net.*; import java.nio.charset.StandardCharsets;

public class MulticastService {
    private static final Logger log = LoggerFactory.getLogger(MulticastService.class);
    private final Config cfg; private final LamportClock clock;
    public MulticastService(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }
    public void start() {
        new Thread(this::listen).start();
        new Thread(()-> {
            try {
                Thread.sleep(3000);
                broadcast("HELLO from "+cfg.group()+"-"+cfg.nodeId()+" t="+clock.send());
            } catch (Exception ignored) {}
        }).start();
    }
    private void listen(){
        try (MulticastSocket socket = new MulticastSocket(cfg.mcastPort())) {
            InetAddress group = InetAddress.getByName(cfg.mcastAddr());
            socket.joinGroup(group);
            byte[] buf = new byte[1024];
            while(true){
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_8);
                log.info("MCAST recv: {}", received);
            }
        } catch (Exception e){ log.error("Multicast error", e); }
    }
    public void broadcast(String msg){
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] buf = msg.getBytes(StandardCharsets.UTF_8);
            InetAddress group = InetAddress.getByName(cfg.mcastAddr());
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, cfg.mcastPort());
            socket.send(packet);
        } catch (Exception e){ log.error("MCAST, erro de envio", e); }
    }
}
