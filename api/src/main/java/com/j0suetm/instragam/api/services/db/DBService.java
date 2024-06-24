package com.j0suetm.instragam.api.services.db;

import com.j0suetm.instragam.api.providers.*;

import org.jooq.*;
import org.jooq.impl.*;
import java.sql.*;

public class DBService {
  protected Connection connection;
  protected DSLContext dslCtx;

  public DBService(DBProvider dbProvider) {
    connection = dbProvider.getConnection();
    dslCtx = DSL.using(connection, SQLDialect.POSTGRES);
  }
}
