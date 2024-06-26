package com.j0suetm.instragam.desktop.providers;

import okhttp3.*;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.*;
import java.io.*;

public class HttpProvider {
  private final Gson gson = new Gson();
  private final Dotenv env = Dotenv.configure().load();
  private final OkHttpClient client = new OkHttpClient();

  public static final MediaType JSON_MEDIATYPE = MediaType.get("application/json");

  public static class ShortResponse<T> {
    public int code;
    public String message;
    public T body;

    public ShortResponse(int code, String message, T body) {
      this.code = code;
      this.message = message;
      this.body = body;
    }
  };

  private final String backURL =
    env.get("BACK_PROTOCOL") + "://" +
    env.get("BACK_HOST") + ":" +
    env.get("BACK_PORT");

  public Request.Builder initRequest(String uri) {
    System.out.println(backURL + uri);
    return new Request.Builder().url(backURL + uri);
  }

  public <T> ShortResponse<T> doRequest(Request request, Class<T> bodyClass) {
    try (Response response = client.newCall(request).execute()) {
      String respBody = (response.body() != null) ? response.body().string() : "{}";

      return new ShortResponse<>(
        response.code(),
        response.message(),
        gson.fromJson(respBody, bodyClass)
      );
    } catch (Exception ex) {
      ex.printStackTrace();
      return new ShortResponse<>(500, ex.getMessage(), null);
    }
  }
}
