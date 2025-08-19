package br.ifba.saj.ads10.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: groupa.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GroupAServiceGrpc {

  private GroupAServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "groupa.GroupAService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.PingRequest,
      br.ifba.saj.ads10.grpc.PingReply> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = br.ifba.saj.ads10.grpc.PingRequest.class,
      responseType = br.ifba.saj.ads10.grpc.PingReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.PingRequest,
      br.ifba.saj.ads10.grpc.PingReply> getPingMethod() {
    io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.PingRequest, br.ifba.saj.ads10.grpc.PingReply> getPingMethod;
    if ((getPingMethod = GroupAServiceGrpc.getPingMethod) == null) {
      synchronized (GroupAServiceGrpc.class) {
        if ((getPingMethod = GroupAServiceGrpc.getPingMethod) == null) {
          GroupAServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<br.ifba.saj.ads10.grpc.PingRequest, br.ifba.saj.ads10.grpc.PingReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ifba.saj.ads10.grpc.PingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ifba.saj.ads10.grpc.PingReply.getDefaultInstance()))
              .setSchemaDescriptor(new GroupAServiceMethodDescriptorSupplier("Ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.EventRequest,
      br.ifba.saj.ads10.grpc.EventReply> getEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Event",
      requestType = br.ifba.saj.ads10.grpc.EventRequest.class,
      responseType = br.ifba.saj.ads10.grpc.EventReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.EventRequest,
      br.ifba.saj.ads10.grpc.EventReply> getEventMethod() {
    io.grpc.MethodDescriptor<br.ifba.saj.ads10.grpc.EventRequest, br.ifba.saj.ads10.grpc.EventReply> getEventMethod;
    if ((getEventMethod = GroupAServiceGrpc.getEventMethod) == null) {
      synchronized (GroupAServiceGrpc.class) {
        if ((getEventMethod = GroupAServiceGrpc.getEventMethod) == null) {
          GroupAServiceGrpc.getEventMethod = getEventMethod =
              io.grpc.MethodDescriptor.<br.ifba.saj.ads10.grpc.EventRequest, br.ifba.saj.ads10.grpc.EventReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Event"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ifba.saj.ads10.grpc.EventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.ifba.saj.ads10.grpc.EventReply.getDefaultInstance()))
              .setSchemaDescriptor(new GroupAServiceMethodDescriptorSupplier("Event"))
              .build();
        }
      }
    }
    return getEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GroupAServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupAServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupAServiceStub>() {
        @java.lang.Override
        public GroupAServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupAServiceStub(channel, callOptions);
        }
      };
    return GroupAServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GroupAServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupAServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupAServiceBlockingStub>() {
        @java.lang.Override
        public GroupAServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupAServiceBlockingStub(channel, callOptions);
        }
      };
    return GroupAServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GroupAServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupAServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupAServiceFutureStub>() {
        @java.lang.Override
        public GroupAServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupAServiceFutureStub(channel, callOptions);
        }
      };
    return GroupAServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void ping(br.ifba.saj.ads10.grpc.PingRequest request,
        io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.PingReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     */
    default void event(br.ifba.saj.ads10.grpc.EventRequest request,
        io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.EventReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEventMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GroupAService.
   */
  public static abstract class GroupAServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GroupAServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GroupAService.
   */
  public static final class GroupAServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GroupAServiceStub> {
    private GroupAServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupAServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupAServiceStub(channel, callOptions);
    }

    /**
     */
    public void ping(br.ifba.saj.ads10.grpc.PingRequest request,
        io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.PingReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void event(br.ifba.saj.ads10.grpc.EventRequest request,
        io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.EventReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GroupAService.
   */
  public static final class GroupAServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GroupAServiceBlockingStub> {
    private GroupAServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupAServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupAServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.ifba.saj.ads10.grpc.PingReply ping(br.ifba.saj.ads10.grpc.PingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.ifba.saj.ads10.grpc.EventReply event(br.ifba.saj.ads10.grpc.EventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEventMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GroupAService.
   */
  public static final class GroupAServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GroupAServiceFutureStub> {
    private GroupAServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupAServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupAServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.ifba.saj.ads10.grpc.PingReply> ping(
        br.ifba.saj.ads10.grpc.PingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.ifba.saj.ads10.grpc.EventReply> event(
        br.ifba.saj.ads10.grpc.EventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_EVENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((br.ifba.saj.ads10.grpc.PingRequest) request,
              (io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.PingReply>) responseObserver);
          break;
        case METHODID_EVENT:
          serviceImpl.event((br.ifba.saj.ads10.grpc.EventRequest) request,
              (io.grpc.stub.StreamObserver<br.ifba.saj.ads10.grpc.EventReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              br.ifba.saj.ads10.grpc.PingRequest,
              br.ifba.saj.ads10.grpc.PingReply>(
                service, METHODID_PING)))
        .addMethod(
          getEventMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              br.ifba.saj.ads10.grpc.EventRequest,
              br.ifba.saj.ads10.grpc.EventReply>(
                service, METHODID_EVENT)))
        .build();
  }

  private static abstract class GroupAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GroupAServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.ifba.saj.ads10.grpc.GroupAProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GroupAService");
    }
  }

  private static final class GroupAServiceFileDescriptorSupplier
      extends GroupAServiceBaseDescriptorSupplier {
    GroupAServiceFileDescriptorSupplier() {}
  }

  private static final class GroupAServiceMethodDescriptorSupplier
      extends GroupAServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GroupAServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GroupAServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GroupAServiceFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
