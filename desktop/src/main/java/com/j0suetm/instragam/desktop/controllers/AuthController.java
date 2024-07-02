package com.j0suetm.instragam.desktop.controllers;

import com.j0suetm.instragam.desktop.presenters.*;
import com.j0suetm.instragam.desktop.models.*;

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

    presenter.errRes.addListener((,, newValue) -> {
        ResultModel res = (ResultModel)newValue;
        new Alert(
          Alert.AlertType.ERROR,
          res.format(),
          ButtonType.OK
        ).showAndWait();
    });
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
