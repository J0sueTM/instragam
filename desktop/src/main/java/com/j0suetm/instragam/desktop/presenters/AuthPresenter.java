package com.j0suetm.instragam.desktop.presenters;

import static com.j0suetm.instragam.desktop.Main.mainPresenter;
import com.j0suetm.instragam.desktop.models.*;

import javafx.beans.property.*;

public class AuthPresenter {
  public UserModel userModel = new UserModel();

  public StringProperty userHandle = new SimpleStringProperty("");
  public StringProperty userPassword = new SimpleStringProperty("");

  public AuthPresenter() {
    userHandle.addListener((,, newValue) -> {
      userModel.handle = newValue;
    });

    userPassword.addListener((,, newValue) -> {
      // TODO: validate
      // userModel.password = newValue;
    });

    // TODO: handle token
  }

  public void loginUser() {
    // mainPresenter.viewName.set("Feed");
  }

  public void signupUser() {
    System.out.println(userModel);
  }
}
