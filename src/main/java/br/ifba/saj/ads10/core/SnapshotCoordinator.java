package br.ifba.saj.ads10.core;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;

// Aqui apenas registramos o início; estender para gravar o estado do canal
public class SnapshotCoordinator {
    private static final Logger log = LoggerFactory.getLogger(SnapshotCoordinator.class);
    public void startGlobalSnapshot(int superCoordinatorId, long lamport) {
        log.info("Iniciando snapshot global (super-coordinator={} lamport={})", superCoordinatorId, lamport);
        //enviar "MARCADOR" através de canais intra-grupo TCP e registrar mensagens em trânsito por canal.
    }
}
