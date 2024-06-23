//package com.acme.DBConfig;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
//import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
//
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@EnableReactiveMongoRepositories
//@AutoConfigureAfter()
//public class ApplicationConfiguration extends AbstractReactiveMongoConfiguration {
//    private final Environment environment;
//    public ApplicationConfiguration(Environment environment) {
//        this.environment = environment;
//    }
//
//    @Bean
//    @DependsOn("embeddedMongoServer")
//    public MongoClient mongoClient() {
//        int port = environment.getProperty("local.mongo.port", Integer.class);
//        return MongoClients.create(String.format("mongodb://localhost:27017/java_acme_order", port));
//    }
//    @Override
//    protected String getDatabaseName() {
//        return "reactive-mongo";
//    }
//}
