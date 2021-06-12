package com.sps.Controller;

import com.sps.util.AppBarIcon;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HomeFormController {
//    public JFXRippler rprAddNewStudent;
//    public JFXRippler rprSearchStudents;
    public AnchorPane pneAddNewStudent;
    public AnchorPane pneSearchStudents;

    public void initialize() {
//        rprAddNewStudent.setControl(pneAddNewStudent);
//        rprSearchStudents.setControl(pneSearchStudents);
        pneAddNewStudent.setFocusTraversable(true);
        pneSearchStudents.setFocusTraversable(true);
    }

    public void pneAddNewRegister_OnKeyPress(KeyEvent keyEvent) {
    }

    public void pneAddNewRegister_OnKeyReleased(KeyEvent keyEvent) {
    }

    public void pneAddNewRegister_OnMouseClicked(MouseEvent mouseEvent) {
    }

    public void pneSearchStudents_OnKeyPress(KeyEvent keyEvent) {
    }

    private void navigate(String title, String url) {
        MainFormController ctrl = (MainFormController) pneSearchStudents.getScene().getUserData();
        ctrl.navigate(title, url, AppBarIcon.NAV_ICON_BACK, () ->
                ctrl.navigate("Student Management System", "/view/HomeForm.fxml", AppBarIcon.NAV_ICON_HOME));
    }

    public void pneSearchStudents_OnKeyReleased(KeyEvent keyEvent) {
    }
}
