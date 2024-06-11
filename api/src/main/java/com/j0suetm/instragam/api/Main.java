package com.j0suetm.instragam.api;

import org.slf4j.*;
import com.j0suetm.instragam.api.providers.*;
import io.github.cdimascio.dotenv.*;
import org.flywaydb.core.Flyway;

public class Main {
  private final Logger logger = LoggerFactory.getLogger(Main.class);
  private final Dotenv env = Dotenv.configure().load();

  public Main() {
    logger.info("starting instragam");
    DBProvider dbProvider = new DBProvider(
      env.get("DB_HOST"),
      env.get("DB_PORT"),
      env.get("DB_USER"),
      env.get("DB_PASS"),
      env.get("DB_NAME")
    );

    Flyway
      .configure()
      .dataSource(dbProvider.dataSource)
      .load()
      .migrate();
  }

  public static void main(String[] args) {
    new Main();
  }
}
