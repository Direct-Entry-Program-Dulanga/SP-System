package Controller;

import com.jfoenix.controls.JFXRippler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.AppBarIcon;

public class HomeAdminFormController {

    public JFXRippler rprAddNewStudent;
    public AnchorPane pneAddNewStudent;
    public JFXRippler rprSearchStudents;
    public AnchorPane pneSearchStudents;


    public void pneViewStudent_OnKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            rprAddNewStudent.createManualRipple().run();
        }
    }

    public void pneViewStudent_OnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            navigate("Add New Student", "/View/AdminSearchForm.fxml");
        }
    }

    public void pneViewStudent_OnMouseClicked(MouseEvent mouseEvent) {
        navigate("Add New Student", "/View/AdminSearchForm.fxml");
    }

    public void pneViewCourse_OnKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            rprSearchStudents.createManualRipple().run();
        }
    }

    public void pneViewCourse_OnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
            navigate("Search Registrations", "/View/PaymentForm.fxml");
        }
    }

    public void pneViewCourse_OnMouseClicked(MouseEvent mouseEvent) {
        navigate("Search Registrations", "/View/PaymentForm.fxml");
    }

    private void navigate(String title, String url) {
        MainFormController ctrl = (MainFormController) pneSearchStudents.getScene().getUserData();
        ctrl.navigate(title, url, AppBarIcon.NAV_ICON_BACK, () ->
                ctrl.navigate("Student Payment System", "/View/HomeAdminForm.fxml", AppBarIcon.NAV_ICON_BACK));
    }


}
