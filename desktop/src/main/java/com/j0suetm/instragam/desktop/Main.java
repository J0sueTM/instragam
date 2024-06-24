package com.j0suetm.instragam.desktop;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Instragam Desktop");
    Button btn = new Button("Click Me");
    btn.setOnAction(evt -> System.out.println("you clicked the button!"));

    AnchorPane rootPane = new AnchorPane();
    stage.setScene(new Scene(rootPane, 600, 400));
    stage.show();
  }
}
