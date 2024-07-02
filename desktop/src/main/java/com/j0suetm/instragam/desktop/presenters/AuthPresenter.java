package com.j0suetm.instragam.desktop.presenters;

import static com.j0suetm.instragam.desktop.Main.mainPresenter;
import com.j0suetm.instragam.desktop.models.*;
import com.j0suetm.instragam.desktop.models.wire.*;
import com.j0suetm.instragam.desktop.services.*;

import javafx.beans.property.*;

public class AuthPresenter {
  private AuthService authService = new AuthService();
  
  public StringProperty userHandle = new SimpleStringProperty("");
  public StringProperty userPassword = new SimpleStringProperty("");
  public ObjectProperty errRes = new SimpleObjectProperty();

  public AuthPresenter() {
    userPassword.addListener((,, newValue) -> {
      // TODO: validate
    });

    // TODO: handle token
  }

  public void loginUser() {
    ResultModel res = authService.login(userHandle.get(), userPassword.get());
    if (!res.isSuccess) {
      errRes.set(res);

      return;
    }

    UserLogInWireInModel userLogIn = (UserLogInWireInModel)res.content;
    UserModel user = new UserModel(
      userLogIn.user.id,
      userLogIn.user.handle,
      userLogIn.token
    );
    mainPresenter.user.set(user);
    mainPresenter.viewName.set("Feed");
  }

  public void signupUser() {
    // System.out.println(userModel);
  }
}
