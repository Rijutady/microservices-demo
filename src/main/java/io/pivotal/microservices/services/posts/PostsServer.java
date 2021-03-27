package io.pivotal.microservices.services.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import io.pivotal.microservices.posts.PostConfiguration;
import io.pivotal.microservices.posts.PostRepository;
import io.pivotal.microservices.services.registration.RegistrationServer;

@SpringBootApplication
@EnableDiscoveryClient
@Import(PostConfiguration.class)
public class PostsServer {

    @Autowired
    protected PostRepository postRepository;

    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "posts-server");

        SpringApplication.run(PostsServer.class, args);
    }
}