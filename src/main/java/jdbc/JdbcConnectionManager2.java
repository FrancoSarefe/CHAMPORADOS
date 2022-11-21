package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.AppConfiguration;

public class JdbcConnectionManager2 {

    private static final Logger logger = LogManager.getLogger(JdbcConnectionManager2.class);
    
    private static JdbcConnectionManager2 INSTANCE;

    public static JdbcConnectionManager2 instance() {
        if (INSTANCE == null) {
            INSTANCE = new JdbcConnectionManager2();
        }
        return INSTANCE;
    }

    private JdbcConnectionManager2() {
    	//initiate method included here if not singleton
    }
    
    public JdbcConnectionManager2 initiate() {
        try {
            Class.forName(AppConfiguration.getString("jdbc.driver"));
            logger.info("operation=load_jdbc_driver, message=jdbc_driver_loaded_successfully, status=success");

        } catch (ClassNotFoundException e) {
            logger.error("operation=load_jdbc_driver, error_message={}", e.getMessage());
        }
        return this;
    }

    public Connection getConnection() throws SQLException {
        try {
            final Connection connection = DriverManager.getConnection(AppConfiguration.getString("jdbc.url"),
                                                                      AppConfiguration.getString("jdbc.username"),
                                                                      AppConfiguration.getString("jdbc.password"));
            logger.info("operation=create_jdbc_connection, message=jdbc_connection_created, status=success");

            return connection;

        } catch (SQLException e) {
            logger.error("operation=create_jdbc_connection, error_message={}", e.getMessage());
            throw e;
        }
    }

}
