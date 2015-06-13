/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.sohlich.workstack;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import cz.sohlich.workstack.repository.auditing.TaskSecurityAuditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 *
 * @author radek
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableMongoAuditing
public class Application extends AbstractMongoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected String getDatabaseName() {
        return "WorkStack";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

    @Bean
    public AuditorAware<String> myAuditor() {
        return new TaskSecurityAuditor();
    }
}
