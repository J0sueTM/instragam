package com.j0suetm.instragam.api.services.db;

import com.j0suetm.instragam.api.models.*;
import com.j0suetm.instragam.api.models.db.*;
import com.j0suetm.instragam.api.providers.*;

import org.slf4j.*;
import java.util.UUID;
import org.jooq.*;
import org.jooq.Record;

import static org.jooq.impl.DSL.*;

public class UserDBService
  extends DBService
  implements ModelDBService
{
  private final Logger logger = LoggerFactory.getLogger(UserDBService.class);

  public UserDBService(DBProvider dbProvider) {
    super(dbProvider);
  }

  @Override
  public ResultModel insert(Object obj) {
    UserDBModel user;

    try {
      user = new UserDBModel(obj);

      dslCtx
        .insertInto(table("users"))
        .set(field("id"), user.id)
        .set(field("handle"), user.handle)
        .set(field("password_hash"), user.passwordHash)
        .execute();
      
      logger.info("inserted user into db", user.id);
    } catch (IllegalArgumentException ex) {
      logger.error("failed to insert new user into db", ex.getMessage(), obj);
      ex.printStackTrace();

      return new ResultModel(ex.getMessage());
    } catch (Exception ex) {
      logger.error("failed to insert new user into db", obj);
      ex.printStackTrace();

      return new ResultModel(ex.getMessage());
    }

    return new ResultModel(user);
  }

  @Override
  public ResultModel selectByID(UUID id) {
    UserDBModel user;

    try {
      Result<Record> res = dslCtx
        .selectFrom("users")
        .where(field("id").eq(id))
        .limit(1)
        .fetch();

      if (res.isEmpty()) {
        return null;
      }

      Record userRec = res.get(0);
      user = new UserDBModel(
        userRec.get("id", UUID.class),
        userRec.get("handle", String.class),
        userRec.get("password_hash", String.class)
      );

      logger.info("selected user from db", user.id);
    } catch (IllegalArgumentException ex) {
      logger.error("failed to select user from db", id, ex.getMessage());
      ex.printStackTrace();

      return new ResultModel(ex.getMessage(), id);
    } catch (Exception ex) {
      logger.error("failed to select user from db", id);
      ex.printStackTrace();

      return new ResultModel(ex.getMessage(), id);
    }

    return new ResultModel(user);
  }

  public ResultModel selectByHandle(String handle) {
    UserDBModel user;

    try {
      Result<Record> res = dslCtx
        .selectFrom("users")
        .where(field("handle").eq(handle))
        .limit(1)
        .fetch();

      if (res.isEmpty()) {
        return new ResultModel("no users found with handle", handle);
      }

      Record userRec = res.get(0);
      user = new UserDBModel(
        userRec.get("id", UUID.class),
        userRec.get("handle", String.class),
        userRec.get("password_hash", String.class)
      );

      logger.info("selected user from db", user.id);
    } catch (IllegalArgumentException ex) {
      logger.error("failed to select user from db", handle, ex.getMessage());
      ex.printStackTrace();

      return new ResultModel(ex.getMessage(), handle);
    } catch (Exception ex) {
      logger.error("failed to select user from db", handle);
      ex.printStackTrace();

      return new ResultModel(ex.getMessage(), handle);
    }

    return new ResultModel(user);
  }

  @Override
  public ResultModel updateByID(UUID id, Object obj) {
    return null;
  }

  @Override
  public ResultModel deleteByID(UUID id) {
    return null;
  }
}
