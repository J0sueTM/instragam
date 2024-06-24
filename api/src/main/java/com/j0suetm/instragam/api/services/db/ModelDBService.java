package com.j0suetm.instragam.api.services.db;

import com.j0suetm.instragam.api.models.*;

import java.util.UUID;

public interface ModelDBService {
  public ResultModel insert(Object obj);
  public ResultModel selectByID(UUID id);
  public ResultModel updateByID(UUID id, Object obj);
  public ResultModel deleteByID(UUID id);
}
