package com.acme.Service;

import com.acme.User;
import com.acme.authServiceGrpc;
import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @GrpcClient("grpc-acme-service")
    authServiceGrpc.authServiceBlockingStub synchronousClient;


    public Map<Descriptors.FieldDescriptor, Object> getUser(String userId) {
        User userRequest = User.newBuilder().setId(userId).build();
        User userResponce = synchronousClient.getUserById(userRequest);
        return userResponce.getAllFields();

    }

}
