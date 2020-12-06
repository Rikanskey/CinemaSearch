package bstu.pv.volobuev.CinemaSearch.business.service.impl.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class JDBCTestConnection {

    @Test
    public void DBTestConnection(){
        String url = "jdbc:postgresql://localhost:5432/cinema-search-db";
        String user = "postgres";

        try{
            log.info("Connecting to database " + url);
            Connection connection = DriverManager.getConnection(url, user, "");
            log.info("{}", connection.toString());
        }
        catch (Exception e){
            log.info("Connection failed");
        }
    }
}
