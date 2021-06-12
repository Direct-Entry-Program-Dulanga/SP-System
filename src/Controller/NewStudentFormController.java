package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import util.MaterialUI;

public class NewStudentFormController {

    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public RadioButton rbnDep;
    public RadioButton rbnGDse;
    public JFXButton btnSave;

    public void initialize(){
        MaterialUI.paintTextFields(txtStudentName, txtAddress, txtEmail, txtPhone);
    }
}
