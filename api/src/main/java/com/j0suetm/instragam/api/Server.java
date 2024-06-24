package com.j0suetm.instragam.api;

import com.j0suetm.instragam.api.controllers.UserController;
import com.j0suetm.instragam.api.providers.DBProvider;
import com.j0suetm.instragam.api.services.db.UserDBService;

import spark.Service;
import org.slf4j.*;
import io.github.cdimascio.dotenv.*;

public class Server {
  private final Logger logger = LoggerFactory.getLogger(Main.class);
  private final Dotenv env = Dotenv.configure().load();
  private Service instance;

  public Server(DBProvider dbProvider) {
    logger.info("starting server...");

    instance = instance
      .ignite()
      .port(Integer.parseInt(env.get("SRV_PORT")));

    UserController userController = new UserController(
      new UserDBService(dbProvider)
    );

    instance.post("/users", userController.create);
    instance.post("/users/auth", userController.login);
    instance.get("/users/:id", userController.getByID);
    instance.put("/users/:id", userController.updateByID);
    instance.delete("/users/:id", userController.deleteByID);
  }
}
