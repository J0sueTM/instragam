package com.j0suetm.instragam.desktop.services;

import com.j0suetm.instragam.desktop.models.*;
import com.j0suetm.instragam.desktop.models.wire.*;

import okhttp3.*;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.*;

public class AuthService extends Service {
  public ResultModel login(String handle, String password) {
    Request request = new Request.Builder()
      .url(buildURL("/users/auth"))
      .post(
        RequestBody.create(
          gson.toJson(
            new UserLogInWireOutModel(handle, password)
          ),
          JSON_MEDIATYPE
        )
      )
      .build();

    try (Response response = client.newCall(request).execute()) {
      return gson.fromJson(response.body().string(), ResultModel.class);
    } catch (Exception ex) {
      ex.printStackTrace();

      return new ResultModel("failed to login user", ex.getMessage());
    }
  }
}
