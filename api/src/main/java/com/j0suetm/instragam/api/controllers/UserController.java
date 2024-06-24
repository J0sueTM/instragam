package com.j0suetm.instragam.api.controllers;

import com.j0suetm.instragam.api.services.db.*;
import com.j0suetm.instragam.api.providers.*;
import com.j0suetm.instragam.api.models.*;
import com.j0suetm.instragam.api.models.db.*;
import com.j0suetm.instragam.api.models.wire.*;

import com.google.gson.Gson;
import spark.Route;
import org.slf4j.*;
import java.util.*;
import java.util.stream.*;
import jakarta.validation.*;
import at.favre.lib.crypto.bcrypt.*;

public class UserController {
  private final Gson gson = new Gson();
  private final Logger logger = LoggerFactory.getLogger(UserController.class);
  private UserDBService userDBService;
  private JWTProvider jwtProvider;

  public UserController(UserDBService userDBService) {
    this.userDBService = userDBService;
    this.jwtProvider = new JWTProvider();
  }

  private ResultModel createUser(UserWireInModel userIn) {
    String passwordHash = BCrypt
      .withDefaults()
      .hashToString(12, userIn.password.toCharArray());

    ResultModel res = userDBService.insert(new UserDBModel(userIn, passwordHash));
    if (res.isSuccess) {
      res.content = new UserWireOutModel(res.content);
      res.message = "created user succesfully";
    }

    return res;
  }

  private ResultModel getUserByID(UUID id) {
    ResultModel res = userDBService.selectByID(id);
    if (res.isSuccess) {
      res.content = new UserWireOutModel(res.content);
      res.message = "retrieved user succesfully";
    }

    return res;
  }

  private ResultModel loginUser(UserWireInModel userIn) {
    ResultModel res = userDBService.selectByHandle(userIn.handle);
    if (res.isSuccess) {
      UserDBModel userDB = (UserDBModel)res.content;
      BCrypt.Result passRes = BCrypt.verifyer().verify(
        userIn.password.toCharArray(), userDB.passwordHash
      );
      res.isSuccess = passRes.verified;
    }

    res.content = new UserLogInWireOutModel(
      res.isSuccess,
      res.isSuccess ? new UserWireOutModel(res.content) : null,
      res.isSuccess ? jwtProvider.signUser((UserDBModel)res.content) : null
    );
    res.message = res.isSuccess ? "logged in succesfully" : "password incorrect";

    return res;
  }

  public final Route create = (req, resp) -> {
    resp.type("application/json");

    UserWireInModel userIn = gson.fromJson(req.body(), UserWireInModel.class);
    String[] violationsIn = new ValidatorProvider().validate(userIn);
    if (violationsIn != null) {
      resp.status(400);
      return gson.toJson(
        new ResultModel(
          "invalid user in data",
          violationsIn
        )
      );
    }

    ResultModel res = createUser(userIn);
    if (res.isSuccess) {
      String[] violationsOut = new ValidatorProvider().validate(
        (UserWireOutModel)res.content
      );
      
      if (violationsOut != null) {
        resp.status(500);
        return gson.toJson(
          new ResultModel(
            "invalid user out data",
            violationsOut
          )
        );
      }
    }

    resp.status(res.isSuccess ? 201 : 500);
    return gson.toJson(res);
  };

  public final Route login = (req, resp) -> {
    resp.type("application/json");

    UserWireInModel userIn = gson.fromJson(req.body(), UserWireInModel.class);
    String[] violationsIn = new ValidatorProvider().validate(userIn);
    if (violationsIn != null) {
      resp.status(400);
      return gson.toJson(
        new ResultModel(
          "invalid user in data",
          violationsIn
        )
      );
    }
    
    ResultModel res = loginUser(userIn);
    return gson.toJson(res);
  };

  public final Route getByID = (req, resp) -> {
    resp.type("application/json");

    UUID userID;
    try {
      String idIn = Objects.requireNonNull(req.params("id"), "user id cannot be null");
      userID = UUID.fromString(idIn);
    } catch (Exception ex) {
      resp.status(400);

      return gson.toJson(new ResultModel(ex.getMessage()));
    }

    ResultModel res = userDBService.selectByID(userID);
    resp.status(res.isSuccess ? 200 : 404);
    return gson.toJson(res);
  };

  public final Route updateByID = (req, resp) -> {
    return "ok";
  };

  public final Route deleteByID = (req, resp) -> {
    return "ok";
  };
}
