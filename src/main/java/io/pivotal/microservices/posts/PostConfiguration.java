package io.pivotal.microservices.posts;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
@ComponentScan
@EntityScan("io.pivotal.microservices.posts")
@EnableJpaRepositories("io.pivotal.microservices.posts")
@PropertySource("classpath:db-config.properties")
public class PostConfiguration {
    @Bean
    public DataSource dataSource() {

        // Create an in-memory H2 relational database containing some demo
        // accounts.
        DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
                .addScript("classpath:testdb/data.sql").build();

        return dataSource;
    }

}
