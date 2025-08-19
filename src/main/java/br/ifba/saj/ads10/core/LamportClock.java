package br.ifba.saj.ads10.core;
import java.util.concurrent.atomic.AtomicLong;

public class LamportClock {
    private final AtomicLong time = new AtomicLong(0);
    public long tick() { return time.incrementAndGet(); }           // local event
    public long send() { return tick(); }                            // before send
    public long recv(long other) {                                   // on receive
        while (true) {
            long current = time.get();
            long next = Math.max(current, other) + 1;
            if (time.compareAndSet(current, next)) return next;
        }
    }
    public long now() { return time.get(); }
}
