package Controller;

import Model.Student;
import Model.StudentA;
import Model.StudentATM;
import Model.StudentTM;
import Service.ManageService;
import Service.StudentService;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.AppBarIcon;
import util.MaterialUI;

import java.io.IOException;
import java.util.Optional;

public class StudentChangeFormController {


//    public TextField txtQuery;
//    public TableView<StudentA,Student> tblAdStudents;
//
//    private final StudentService studentService = new StudentService();
//    private final ManageService manageService = new ManageService();
//
//    public void initialize(){
//        MaterialUI.paintTextFields(txtQuery);
//
//
//        tblAdStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registerID"));
//        tblAdStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullName"));
//        tblAdStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
//        tblAdStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("registerFee"));
//        tblAdStudents.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("paymentFee"));
//
//        TableColumn<StudentATM, HBox> lastCol = (TableColumn<StudentATM, HBox>) tblAdStudents.getColumns().get(7);
//
//        lastCol.setCellValueFactory(param -> {
//            ImageView imgEdit = new ImageView("/View/assets/Edit.png");
//            ImageView imgTrash = new ImageView("/View/assets/Trash.png");
//
//            imgEdit.getStyleClass().add("action-icons");
//            imgTrash.getStyleClass().add("action-icons");
//
//            imgEdit.setOnMouseClicked(event -> updateStudent(param.getValue()));
//            imgTrash.setOnMouseClicked(event -> deleteStudent(param.getValue()));
//
//            return new ReadOnlyObjectWrapper<>(new HBox(10, imgEdit, imgTrash));
//        });
//
//        txtQuery.textProperty().addListener((observable, oldValue, newValue) -> loadAllStudents(newValue));
//
//        loadAllStudents("");
//    }
//
//    private void deleteStudent(StudentATM tm){
//        try {
//            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this student?", ButtonType.YES, ButtonType.NO).showAndWait();
//            if (buttonType.get() == ButtonType.YES) {
//                studentService.deleteStudent(tm.getRegisterID());
//                tblAdStudents.getItems().remove(tm);
//            }
//        }catch (RuntimeException e){
//            new Alert(Alert.AlertType.ERROR, "Failed to delete the item", ButtonType.OK).show();
//        }
//    }
//
//    private void updateStudent(StudentATM tm) {
//        try {
//            Stage secondaryStage = new Stage();
//            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/MainForm.fxml"));
//            Scene secondaryScene = new Scene(loader.load());
//            MainFormController ctrl = loader.getController();
//
//            secondaryStage.setScene(secondaryScene);
//            secondaryScene.setFill(Color.TRANSPARENT);
//            secondaryStage.initStyle(StageStyle.TRANSPARENT);
//            secondaryStage.initModality(Modality.WINDOW_MODAL);
//            secondaryStage.initOwner(txtQuery.getScene().getWindow());
//            secondaryStage.setTitle("Update Student");
//            ctrl.navigate("Update Student","/view/StudentForm.fxml", AppBarIcon.NAV_ICON_NONE, null, tm);
//
//            secondaryStage.showAndWait();
//            tblAdStudents.refresh();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private void loadAllStudents(String query){
//        tblAdStudents.getItems().clear();
//
//        for (Student student : studentService.findStudents(query)) {
//            tblAdStudents.getItems().add(new StudentTM(student.getRegisterID(), student.getFullName(), student.getAddress()));
//        }
//        for (StudentA studentA : manageService.findStudents(query)) {
//            tblAdStudents.getItems().add(new StudentTM(studentA.getRegisterFee(), studentA.getPaymentFee()));
//        }
//    }



//    public void tblAdStudents_OnKeyPressed(KeyEvent keyEvent) {
//        if (keyEvent.getCode() == KeyCode.DELETE){
//            deleteStudent(tblAdStudents.getSelectionModel().getSelectedItem());
//        }else if (keyEvent.getCode() == KeyCode.ENTER){
//            updateStudent(tblAdStudents.getSelectionModel().getSelectedItem());
//        }
//    }
}
