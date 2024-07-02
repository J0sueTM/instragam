package com.j0suetm.instragam.desktop.presenters;

import com.j0suetm.instragam.desktop.models.*;
import com.j0suetm.instragam.desktop.providers.*;

import javafx.beans.property.*;

public class MainPresenter {
  public MainModel state = new MainModel();

  public StringProperty viewName = new SimpleStringProperty("");
  public ObjectProperty user = new SimpleObjectProperty();

  public MainPresenter(ViewProvider viewProvider) {
    viewName.addListener((,, newValue) -> {
      state.viewName = newValue;
      viewProvider.switchTo(newValue);
    });

    user.addListener((,, newValue) -> {
      UserModel user = (UserModel)newValue;
      state.user = user;
    });
  }
} 
