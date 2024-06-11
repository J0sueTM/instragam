package com.j0suetm.instragam.api.providers;

import org.slf4j.*;
import java.sql.*;
import com.zaxxer.hikari.*;

public class DBProvider {
  private final Logger logger = LoggerFactory.getLogger(DBProvider.class);
  public HikariDataSource dataSource;

  public DBProvider(
    String host,
    String port,
    String username,
    String password,
    String dbName
  ) {
    logger.info("creating datasource from db");

    String jdbcURL = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(jdbcURL);
    config.setUsername(username);
    config.setPassword(password);
    dataSource = new HikariDataSource(config);
  }

  public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException ex) {
      logger.error("failed to connect to db", ex);
    }

    return null;
  }
}
