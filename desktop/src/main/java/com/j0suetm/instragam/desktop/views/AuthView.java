package com.j0suetm.instragam.desktop.views;

import com.j0suetm.instragam.desktop.viewModels.*;

import de.saxsys.mvvmfx.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AuthView implements FxmlView<AuthViewModel> {
  @InjectViewModel
  private AuthViewModel viewModel;

  @FXML
  private TextField userHandle;

  @FXML
  private PasswordField userPassword;
}
