package com.j0suetm.instragam.desktop.controllers;

import com.j0suetm.instragam.desktop.presenters.*;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;

public class AuthController {
  private AuthPresenter presenter;

  @FXML
  public void initialize() {
    presenter = new AuthPresenter();
  }

  @FXML
  private TextField userHandle;

  @FXML
  private PasswordField userPassword;

  @FXML
  void logInUser(ActionEvent event) {
    System.out.println("tried to login");
  }

  @FXML
  void signUpUser(ActionEvent event) {
    System.out.println("tried to signup");
  }
}
