package admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shengbin
 * @since: 2019/3/12 下午12:35
 */
@Configuration
@ComponentScan(basePackages = "admin.client")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminClientApplication.class, args);
    }
}
