package com.j0suetm.instragam.desktop.presenters;

import com.j0suetm.instragam.desktop.models.*;
import com.j0suetm.instragam.desktop.providers.*;

import javafx.beans.property.*;

public class MainPresenter {
  public MainModel mainModel = new MainModel();

  public StringProperty viewName;

  public MainPresenter(ViewProvider viewProvider) {
    viewName = new SimpleStringProperty("");
    
    viewName.addListener((observable, oldValue, newValue) -> {
      mainModel.viewName = newValue;
      viewProvider.switchTo(newValue);
    });
  }
} 
