package br.ifba.saj.ads10.core;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;

// Simplified outline of Chandy–Lamport snapshot.
// Here we just log the start; extending to record channel state is left as TODO notes.
public class SnapshotCoordinator {
    private static final Logger log = LoggerFactory.getLogger(SnapshotCoordinator.class);
    public void startGlobalSnapshot(int superCoordinatorId, long lamport) {
        log.info("Starting global snapshot (super-coordinator={} lamport={})", superCoordinatorId, lamport);
        // TODO: send "MARKER" over TCP intra-group channels and record in-flight messages per channel.
    }
}
