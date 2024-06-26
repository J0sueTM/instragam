package com.j0suetm.instragam.desktop.presenters;

import com.j0suetm.instragam.desktop.models.*;
import com.j0suetm.instragam.desktop.providers.*;

import javafx.beans.property.*;

public class MainPresenter {
  public MainModel mainModel = new MainModel();

  public StringProperty viewName = new SimpleStringProperty("");

  public MainPresenter(ViewProvider viewProvider) {
    viewName.addListener((,, newValue) -> {
      mainModel.viewName = newValue;
      viewProvider.switchTo(newValue);
    });
  }
} 
