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

    userHandleFld
      .textProperty()
      .bindBidirectional(presenter.userHandle);
    userPasswordFld
      .textProperty()
      .bindBidirectional(presenter.userPassword);
  }

  @FXML
  private TextField userHandleFld;

  @FXML
  private PasswordField userPasswordFld;

  @FXML
  void logInUser(ActionEvent event) {
    presenter.loginUser();
  }

  @FXML
  void signUpUser(ActionEvent event) {
    presenter.signupUser();
  }
}
