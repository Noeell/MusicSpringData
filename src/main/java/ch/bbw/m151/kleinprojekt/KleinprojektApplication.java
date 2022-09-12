package ch.bbw.m151.kleinprojekt;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class KleinprojektApplication {

    public static void main(String[] args) {
        SpringApplication.run(KleinprojektApplication.class, args);
    }


    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        // connectable on: jdbc:h2:tcp://localhost:9090/mem:mydb
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }
}
