package com.j0suetm.instragam.desktop;

import com.j0suetm.instragam.desktop.providers.*;
import com.j0suetm.instragam.desktop.presenters.*;

import okhttp3.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
  public static MainPresenter mainPresenter;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainStage) {
    mainStage.setTitle("Instragam Desktop");
    mainStage.setScene(new Scene(new AnchorPane()));

    ViewProvider viewProvider = new ViewProvider(mainStage)
      .add("Auth")
      .add("Feed");
    mainPresenter = new MainPresenter(viewProvider);
    mainPresenter.viewName.set("Auth");

    // HttpProvider httpProvider = new HttpProvider();
    // HttpProvider.ShortResponse<Object> resp = httpProvider
    //   .doRequest(
    //     httpProvider
    //       .initRequest("/users/login")
    //       .post(RequestBody.create("{}", HttpProvider.JSON_MEDIATYPE))
    //       .build(),
    //     Object.class
    //   );
    // System.out.println(resp);

    mainStage.show();
  }
}
