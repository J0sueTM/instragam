package com.j0suetm.instragam.desktop;

import com.j0suetm.instragam.desktop.providers.*;
import com.j0suetm.instragam.desktop.views.*;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
  private ViewProvider viewProvider;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainStage) {
    viewProvider = new ViewProvider(mainStage)
      .add("Auth", AuthView.class);

    mainStage.setTitle("Instragam Desktop");
    mainStage.setScene(new Scene(new AnchorPane()));
    viewProvider.switchTo("Auth");
    mainStage.show();
  }
}
