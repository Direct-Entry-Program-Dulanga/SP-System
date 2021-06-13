package Controller;

import Model.Student;
import Model.StudentTM;
import Service.StudentService;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
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
    public AnchorPane root;
    public Label lblTitle;

    private StudentService studentService = new StudentService();

    public void initialize(){
        MaterialUI.paintTextFields(txtStudentName, txtAddress, txtEmail, txtPhone, txtRegisterID, txtRegisterDate);
        setCustomerID();
//        setCourse();

        Platform.runLater(()->{

            if (root.getUserData() != null){
                StudentTM tm = (StudentTM) root.getUserData();
                Student student = studentService.findStudent(tm.getRegisterID());

                txtRegisterID.setEditable(false);
                txtRegisterID.setText(student.getRegisterID());
                txtStudentName.setText(student.getFullName());
                txtAddress.setText(student.getAddress());
                txtPhone.setText(student.getContact());
                txtEmail.setText(student.getEmail());

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
            keyEvent.consume();     // This is not going to forward to the Java FX Runtime Env.
            return;
        }

        if ((txtPhone.getText().length() == 3) && (txtPhone.getCaretPosition() == txtPhone.getLength())){
            txtPhone.appendText("-");
            txtPhone.positionCaret(txtPhone.getText().length() +1);
        }
    }

    public void setCustomerID(){
        if(StudentService.studentsDB.size()>0){
            String tempNumber = StudentService.studentsDB.get(
                    StudentService.studentsDB.size()-1).getRegisterID();
            String array[] = tempNumber.split("R-");
            int number = Integer.parseInt(array[1]);
            number++;

            if(number>100){
                tempNumber = "R-"+number;
            }else if(number>10){
                tempNumber = "R-0"+number;
            }
            txtRegisterID.setText(tempNumber);
        }else{
            txtRegisterID.setText("R-001");
        }
    }

//    public void setCourse(){
//        Button button = new Button("Submit");
//        ToggleGroup ques = new ToggleGroup();
//        rbnDep.setToggleGroup(ques);
//        rbnGDse.setToggleGroup(ques);
//
//        button.setOnAction(e ->{
//            if(rbnDep.isSelected()){
//                button.getText()
//            }
//        });
//    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        try {
            Student student = new Student(
                    txtRegisterID.getText(),
                    txtStudentName.getText(),
                    txtAddress.getText(),
                    txtPhone.getText(),
                    txtEmail.getText());

            if (btnSave.getText().equals("ADD NEW STUDENT")){
                studentService.saveStudent(student);
            }else{
                StudentTM tm = (StudentTM) root.getUserData();
                tm.setFullName(txtStudentName.getText());
                tm.setAddress(txtAddress.getText());
                studentService.updateStudent(student);
            }
            new Alert(Alert.AlertType.NONE, "Student has been saved successfully", ButtonType.OK).show();
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR, "Failed to save the student", ButtonType.OK).show();
        }
    }
}
