package Controller;

import Model.Student;
import Model.StudentTM;
import Service.StudentService;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import util.MaterialUI;

import java.time.LocalDate;

public class NewStudentFormController {

    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtEmail;
    public RadioButton rbnDep;
    public RadioButton rbnGDse;
    public JFXButton btnSave;
    public TextField txtRegisterDate;
    public TextField txtRegisterID;

    private StudentService studentService = new StudentService();

    public void initialize(){
        MaterialUI.paintTextFields(txtStudentName, txtAddress, txtEmail, txtPhone, txtRegisterID, txtRegisterDate);



    }


    public void txtPhone_OnKeyTyped(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().equals("-") && (txtPhone.getText().length() == 3)){
            return;
        }

        if (!Character.isDigit(keyEvent.getCharacter().charAt(0))){
            keyEvent.consume();     // This is not going to forward to the Java FX Runtime Env.
            return;
        }

        if ((txtPhone.getText().length() == 3) && (txtPhone.getCaretPosition() == txtPhone.getLength())){
            txtPhone.appendText("-");
            txtPhone.positionCaret(txtPhone.getText().length() +1);
        }
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        try {
            Student student = new Student(
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    txtPhone.getText(),
                    txtEmail.getText());

            if (btnSave.getText().equals("ADD NEW STUDENT")){
                studentService.saveStudent(student);
            }else{
//                StudentTM tm = (StudentTM) root.getUserData();
//                tm.setFullName(txtFullName.getText());
//                tm.setAddress(txtAddress.getText());
//                studentService.updateStudent(student);
            }
            new Alert(Alert.AlertType.NONE, "Student has been saved successfully", ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR, "Failed to save the student", ButtonType.OK).show();
        }
    }
}
