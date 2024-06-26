package com.j0suetm.instragam.desktop.controllers;

import com.j0suetm.instragam.desktop.presenters.*;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;

public class FeedController {
  private FeedPresenter presenter;

  @FXML
  public void initialize() {
    presenter = new FeedPresenter();
  }

  @FXML
  private Button searchBtn;

  @FXML
  private TextField searchPrompt;

  @FXML
  void searchUser(ActionEvent event) {
    System.out.println("tried to search user");
  }
}
