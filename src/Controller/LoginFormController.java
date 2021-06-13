package Controller;

import com.jfoenix.controls.JFXRippler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.AppBarIcon;

public class LoginFormController {


    public TextField txtPassword;
    public TextField txtUserName;
    public Label lblError;

    public JFXRippler rprLogin;
    public AnchorPane pneLoginUser;


    public void initialize() {
        rprLogin.setControl(pneLoginUser);
        pneLoginUser.setFocusTraversable(true);
    }


//    public void btnSave_OnAction(ActionEvent actionEvent) throws IOException {
//        if(txtUserName.getText().toString().equals("Dulanga") && txtPassword.getText().toString().equals("123")){
//            navigate("View/HomeForm.fxml");
//            lblError.setVisible(false);
//            lblError.setText("Success");
//        }else if(txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()){
//            lblError.setVisible(true);
//            lblError.setText("Please Enter your UserName & Password...");
//        }else{
//            lblError.setVisible(true);
//            lblError.setText("Enter Correct Username & Password");
//        }
//    }

//    private void navigate(String url) throws IOException {
//        Parent root = FXMLLoader.load(this.getClass().getResource(url));
//        Stage newStage = new Stage();
//        Scene tableScene = new Scene(root);
//        newStage.setScene(tableScene);
////        newStage.setTitle(title);
//        newStage.centerOnScreen();
//        newStage.setResizable(false);
//        newStage.show();
//    }


//    public void pneLoginUser_OnKeyPress(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
//            rprLoginUser.createManualRipple().run();
//        }
//    }
//
//    public void pneLoginUser_OnKeyRelease(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.ENTER || keyEvent.getCode() == KeyCode.SPACE) {
//           navigate("Student Payment System", "/View/HomeForm.fxml");
//        }
//    }
//
//    public void pneLoginUser_OnMouseClick(MouseEvent mouseEvent) {
//        if(txtUserName.getText().equals("User") && txtPassword.getText().equals("123")){
//            navigate("Student Payment System", "/View/HomeForm.fxml");
//            lblError.setVisible(false);
//            lblError.setText("Success");
//
//        }else if(txtUserName.getText().equals("Admin") && txtPassword.getText().equals("123")){
//            navigate("Student Payment System", "/View/HomeForm.fxml");
//            lblError.setVisible(false);
//            lblError.setText("Success");
//        }else if(txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()){
//            lblError.setVisible(true);
//            lblError.setText("Please Enter your UserName & Password...");
//        }else{
//            lblError.setVisible(true);
//            lblError.setText("Enter Correct Username & Password");
//        }
//    }
//
//    private void navigate(String title, String url) {
//        MainFormController ctrl = (MainFormController) pneLoginUser.getScene().getUserData();
//        ctrl.navigate(title, url, AppBarIcon.NAV_ICON_BACK, () ->
//                ctrl.navigate("Student Management System", "/View/LoginForm.fxml", AppBarIcon.NAV_ICON_HOME));
//    }
}
