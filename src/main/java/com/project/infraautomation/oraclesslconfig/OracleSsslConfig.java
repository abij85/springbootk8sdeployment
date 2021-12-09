package com.project.infraautomation.oraclesslconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
class OracleSslConfig {
    @Bean
    public void oracleSslConfig() {

        //VARS injected through kubernetes secrets
        File truststore = new File(System.getenv("TRUSTSTORE_ENV_VAR"));
        String tsp = truststore.getAbsolutePath();
        System.setProperty("javax.net.ssl.trustStore", tsp);
        System.setProperty("javax.net.ssl.trustStorePassword", System.getenv("TRUST_PWD"));
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        File keystore = new File(System.getenv("KEYSTORE_ENV_VAR"));
        String ksp = truststore.getAbsolutePath();
        System.setProperty("javax.net.ssl.keyStore", ksp);
        System.setProperty("javax.net.ssl.keyStorePassword", System.getenv("KEY_PWD"));
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
    }
}
