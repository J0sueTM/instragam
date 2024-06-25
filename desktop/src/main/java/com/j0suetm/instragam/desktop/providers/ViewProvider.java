package com.j0suetm.instragam.desktop.providers;

import de.saxsys.mvvmfx.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;

public class ViewProvider <
  ViewType extends FxmlView<? extends ViewModelType>,
  ViewModelType extends ViewModel
> {
  private Stage mainStage;
  private Map<String, Class<? extends ViewType>> views = new HashMap<>();

  public ViewProvider(Stage mainStage) {
    this.mainStage = mainStage;
  }

  public ViewProvider<ViewType, ViewModelType> add(
    String viewName,
    Class<? extends ViewType> view
  ) {
    views.put(viewName, view);

    return this;
  }

  public void switchTo(String viewName) {
    if (views.containsKey(viewName)) {
      mainStage.getScene().setRoot(
        FluentViewLoader
          .fxmlView(views.get(viewName))
          .load()
          .getView()
      );
    } else {
      throw new IllegalArgumentException("view " + viewName + " not found");
    }
  }
}
