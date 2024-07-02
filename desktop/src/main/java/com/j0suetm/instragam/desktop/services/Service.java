package com.j0suetm.instragam.desktop.services;

import okhttp3.*;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.*;
import java.io.*;

public class Service {
  protected final Gson gson = new Gson();
  protected final OkHttpClient client = new OkHttpClient();
  public static final MediaType JSON_MEDIATYPE = MediaType.get("application/json");

  private static final Dotenv env = Dotenv.configure().load();
  private static final String backURL =
    env.get("BACK_PROTOCOL") + "://" +
    env.get("BACK_HOST") + ":" +
    env.get("BACK_PORT");

  public String buildURL(String uri) {
    return backURL + uri;
  }
}
