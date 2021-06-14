package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AdminStudentFormController {
    public Label lblTitle;
    public TextField txtNIC;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public TextField txtRegister;
    public TextField txtPayment;
    public RadioButton rbnGDse;
    public RadioButton rbnDep;
    public ToggleGroup course;
    public JFXButton btnSave;

    public void btnSave_OnAction(ActionEvent actionEvent) {
    }
}
