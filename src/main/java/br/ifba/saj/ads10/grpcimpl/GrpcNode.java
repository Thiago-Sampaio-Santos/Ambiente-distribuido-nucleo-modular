package br.ifba.saj.ads10.grpcimpl;

import br.ifba.saj.ads10.core.*;
import br.ifba.saj.ads10.grpc.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;

public class GrpcNode {
    private static final Logger log = LoggerFactory.getLogger(GrpcNode.class);
    private final Config cfg; private final LamportClock clock;
    private Server server;
    public GrpcNode(Config cfg, LamportClock clock) { this.cfg = cfg; this.clock = clock; }

    public void start() throws Exception {
        server = ServerBuilder.forPort(cfg.grpcPort()).addService(new GroupAServiceImpl()).build().start();
        log.info("gRPC server started at {}", cfg.grpcPort());
        new Thread(()->{
            try { server.awaitTermination(); } catch (InterruptedException ignored) {}
        }).start();
    }

    class GroupAServiceImpl extends GroupAServiceGrpc.GroupAServiceImplBase {
        private final AuthToken auth = new AuthToken(cfg.tokenSecret());
        @Override
        public void ping(PingRequest request, StreamObserver<PingReply> responseObserver) {
            if (!auth.validate(request.getToken())) {
                responseObserver.onError(new RuntimeException("unauthorized"));
                return;
            }
            long l = clock.recv(request.getLamport());
            PingReply reply = PingReply.newBuilder().setOk("pong").setLamport(l).build();
            responseObserver.onNext(reply); responseObserver.onCompleted();
        }

        @Override
        public void event(EventRequest request, StreamObserver<EventReply> responseObserver) {
            if (!auth.validate(request.getToken())) {
                responseObserver.onError(new RuntimeException("unauthorized"));
                return;
            }
            long l = clock.recv(request.getLamport());
            EventReply reply = EventReply.newBuilder().setAck("ack").setLamport(l).build();
            responseObserver.onNext(reply); responseObserver.onCompleted();
        }
    }
}
