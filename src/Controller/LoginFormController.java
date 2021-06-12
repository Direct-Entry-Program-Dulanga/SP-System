package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.AppBarIcon;

import java.io.IOException;

public class LoginFormController {

    public BorderPane brpLogin;
    public Button btnSave;
    public TextField txtPassword;
    public TextField txtUserName;
    public Label lblError;

    public void btnSave_OnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().toString().equals("Dulanga") && txtPassword.getText().toString().equals("123")){
            navigate("View/HomeForm.fxml");
            lblError.setVisible(false);
            lblError.setText("Success");
        }else if(txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()){
            lblError.setVisible(true);
            lblError.setText("Please Enter your UserName & Password...");
        }else{
            lblError.setVisible(true);
            lblError.setText("Enter Correct Username & Password");
        }
    }

    private void navigate(String url) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource(url));
        Stage newStage = new Stage();
        Scene tableScene = new Scene(root);
        newStage.setScene(tableScene);
//        newStage.setTitle(title);
        newStage.centerOnScreen();
        newStage.setResizable(false);
        newStage.show();
    }





}
