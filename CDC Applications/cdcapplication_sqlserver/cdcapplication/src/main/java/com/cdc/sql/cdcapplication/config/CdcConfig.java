package com.cdc.sql.cdcapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class CdcConfig {

    @Value("${inventory.datasource.host}")
    private String sqlServerDbHost;
    @Value("${inventory.datasource.port}")
    private String sqlServerDbPort;
    @Value("${inventory.datasource.username}")
    private String sqlServerDbUsername;
    @Value("${inventory.datasource.password}")
    private String sqlServerDbPassword;
    @Value("${inventory.datasource.database}")
    private String sqlServerDbName;

    @Bean
    public io.debezium.config.Configuration sqlServerConnector() throws Exception {
        File offsetStorageTempFile = File.createTempFile("offsets_", ".dat");
        File dbHistoryTempFile = File.createTempFile("dbhistory_", ".dat");

        return io.debezium.config.Configuration.create()
                .with("name", "inventory-sqlserver-connector")
                .with("connector.class", "io.debezium.connector.sqlserver.SqlServerConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
                .with("offset.flush.interval.ms", "60000")
                .with("database.hostname", sqlServerDbHost)
                .with("database.port", sqlServerDbPort)
                .with("database.user", sqlServerDbUsername)
                .with("database.password", sqlServerDbPassword)
                .with("database.dbname", sqlServerDbName)
//                .with("database.include.list", sqlServerDbName)
                .with("include.schema.changes", "false")
                .with("database.allowPublicKeyRetrieval", "true")
                .with("database.server.name", "inventory-sql-server")
                .with("topic.prefix", "product_topic")
                .with("database.history", "io.debezium.relational.history.FileDatabaseHistory")
                .with("database.history.file.filename", dbHistoryTempFile.getAbsolutePath())
                .build();
    }
}
