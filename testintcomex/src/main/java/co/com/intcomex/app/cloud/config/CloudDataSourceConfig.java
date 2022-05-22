package co.com.intcomex.app.cloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.cloud.config.java.AbstractCloudConfig;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {

    @Bean
    public DataSource dataSource() {
        return connectionFactory().dataSource();
    }

}