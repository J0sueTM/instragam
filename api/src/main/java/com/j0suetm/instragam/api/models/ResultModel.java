package com.j0suetm.instragam.api.models;

public class ResultModel {
  public boolean isSuccess;
  public String message;
  public Object content;

  public ResultModel () {
    this.isSuccess = true;
  }

  public ResultModel (Object content) {
    this.isSuccess = true;
    this.content = content;
  }

  public ResultModel (String message) {
    this.isSuccess = false;
    this.message = message;
  }

  public ResultModel (String message, Object content) {
    this.isSuccess = false;
    this.message = message;
    this.content = content;
  }

  public ResultModel (boolean isSuccess, String message, Object content) {
    this.isSuccess = isSuccess;
    this.message = message;
    this.content = content;
  }
}
