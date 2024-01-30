package com.digvijayb.bookstore.grpc;

import com.digvijayb.bootstore.grpc.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class HelloWorldImpl extends HelloWordServiceGrpc.HelloWordServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

        System.out.println("request = " + request);

        System.out.println("request.getName() = " + request.getName());

        HelloReply res = HelloReply.newBuilder().setMessage("Hello, " + request.getName()).build();

        responseObserver.onNext(res);
        responseObserver.onCompleted();

    }

    @SneakyThrows
    @Override
    public void generatePing(Empty request, StreamObserver<PingReply> responseObserver) {

        System.out.println("request = " + request);

        int i = 0;
//        for (int i = 0; i < 10; i++) {
            responseObserver.onNext(PingReply.newBuilder().setCount(i + 1).build());
//            Thread.sleep(1_000);
//        }

        responseObserver.onCompleted();


    }
}
