package com.j0suetm.instragam.desktop.providers;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import java.net.*;

public class ViewProvider {
  private Stage mainStage;
  private List<String> views = new ArrayList<>();

  public ViewProvider(Stage mainStage) {
    this.mainStage = mainStage;
  }

  private String buildViewFilepath(String viewName) {
    return "../views/" + viewName + "View.fxml";
  }

  public ViewProvider add(String viewName) {
    views.add(viewName);

    return this;
  }

  public void switchTo(String viewName) {
    if (!views.contains(viewName)) {
      throw new IllegalArgumentException("view " + viewName + " not found");
    }

    try {
      mainStage.getScene().setRoot(
        new FXMLLoader().load(
          getClass().getResource(
            buildViewFilepath(viewName)
          )
        )
      );
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
