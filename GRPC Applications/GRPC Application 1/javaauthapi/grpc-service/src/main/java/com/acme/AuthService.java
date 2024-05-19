package com.acme;

//import com.acme.Repository.UserRepository;

import com.acme.Entity.DbUser;
import com.acme.Repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@GrpcService
public class AuthService extends authServiceGrpc.authServiceImplBase {

    Logger logger = Logger.getLogger(AuthService.class.getName());

    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUserById(User request, StreamObserver<User> responseObserver) {

        DbUser user = getUserDetailsById(request);

        List<User> userList = Collections.singletonList(User.newBuilder().setId(user.getId()).setUserName(user.getUser_name()).setDisplayName(user.getDisplayName())
                .setEmail(user.getEmail()).setExtension(user.getExtension()).setGivenName(user.getGivenName())
                .setFamilyName(user.getFamilyName()).setFirstName(user.getFirstName()).setLastName(user.getLastName())
                .setOid(user.getOid()).setMobile(user.getMobile()).setManagerId(user.getManagerId())
                .setSecondaryEmail(user.getSecondaryEmail()).setUserRoleId(user.getUserRoleId())
                .setIsActive(user.isActive()).setUserRoleId(user.getUserRoleId()).setPreferredUsername(user.getPreferredUsername())
                .setPosition(user.getPosition()).build());

        userList.stream().findFirst().ifPresent(responseObserver::onNext);


        responseObserver.onCompleted();

    }


    private DbUser getUserDetailsById(User request){
        Optional<DbUser> user = userRepository.findById(request.getId());
        return user.get();
    }




    public List<DbUser> getById(String id){
        DbUser user =userRepository.getById(id);
        logger.info("user: "+ user);
        return (List<DbUser>) user;
    }
}
