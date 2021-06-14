package Controller;

import Model.Admin;
import Model.AdminTM;
import Model.Student;
import Model.StudentTM;
import Service.AdminService;
import Service.StudentService;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import util.MaterialUI;

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
    public AnchorPane root;

    private final AdminService adminService = new AdminService();


    public void initialize(){
        MaterialUI.paintTextFields(txtStudentName, txtAddress, txtEmail, txtPhone, txtNIC, txtPayment, txtRegister);
//        setCourse();

        Platform.runLater(()->{

            if (root.getUserData() != null){
                AdminTM tm = (AdminTM) root.getUserData();
                Admin admin = adminService.findStudent(tm.getNic());

                txtNIC.setText(admin.getNic());
                txtStudentName.setText(admin.getFullName());
                txtAddress.setText(admin.getAddress());
                txtPhone.setText(admin.getContact());
                txtEmail.setText(admin.getEmail());
                txtRegister.setText(String.valueOf(admin.getRegisterFee()));
                txtPayment.setText(String.valueOf(admin.getPaymentFee()));
                btnSave.setText("UPDATE STUDENT");
                lblTitle.setText("Update Student");

            }
        });

    }

    public void txtPhone_OnKeyTyped(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().equals("-") && (txtPhone.getText().length() == 3)){
            return;
        }

        if (!Character.isDigit(keyEvent.getCharacter().charAt(0))){
            keyEvent.consume();
            return;
        }

        if ((txtPhone.getText().length() == 3) && (txtPhone.getCaretPosition() == txtPhone.getLength())){
            txtPhone.appendText("-");
            txtPhone.positionCaret(txtPhone.getText().length() +1);
        }
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        try {
            Admin admin = new Admin(
                    txtNIC.getText(),
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    txtPhone.getText(),
                    txtEmail.getText(),
                    Double.parseDouble(txtRegister.getText()),
                    Double.parseDouble(txtPayment.getText()));

            if (btnSave.getText().equals("ADD NEW STUDENT")){
                adminService.saveStudent(admin);
            }else{
                AdminTM tm = (AdminTM) root.getUserData();
                tm.setFullName(txtStudentName.getText());
                tm.setAddress(txtAddress.getText());
                adminService.updateStudent(admin);
            }
            new Alert(Alert.AlertType.NONE, "Student has been saved successfully", ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR, "Failed to save the student", ButtonType.OK).show();
        }
    }
}
