package br.ifba.saj.ads10.net;

import br.ifba.saj.ads10.core.Config;
import br.ifba.saj.ads10.core.LamportClock;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

import java.io.*; import java.net.*; import java.util.concurrent.*;

public class TcpServer {
    private static final Logger log = LoggerFactory.getLogger(TcpServer.class);
    private final Config cfg; private final LamportClock clock;
    public TcpServer(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }
    public void start() throws IOException {
        ServerSocket server = new ServerSocket(cfg.tcpPort());
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(()->{
            while(true){
                try {
                    Socket s = server.accept();
                    pool.submit(()->handle(s));
                } catch (IOException e) { log.error("Accept error", e); }
            }
        });
        log.info("TCP server listening on {}", cfg.tcpPort());
    }
    private void handle(Socket s){
        try(s; var in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                var out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true)) {
            String line = in.readLine();
            if (line==null) return;
            String[] parts = line.split(" ");
            switch (parts[0]){
                case "HB" -> { clock.recv(Long.parseLong(parts[2])); out.println("OK "+clock.now()); }
                case "ELECT?" -> { clock.recv(Long.parseLong(parts[2])); out.println("ALIVE "+clock.now()); }
                case "LEADER" -> { log.info("New leader announced: {}", parts[1]); out.println("ACK"); }
                case "RING" -> { log.info("Received ring token from {}", parts[1]); out.println("ACK"); }
                default -> { out.println("ERR"); }
            }
        } catch (Exception e){ log.error("TCP handle error", e); }
    }
}
