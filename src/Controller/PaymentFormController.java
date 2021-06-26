package Controller;

import Model.Admin;
import Model.AdminTM;
import Model.Payment;
import Model.PaymentTM;
import Service.AdminService;
import Service.PaymentService;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.AppBarIcon;
import util.MaterialUI;

import java.io.IOException;
import java.util.Optional;

public class PaymentFormController {

    public TableView<PaymentTM> tblAPayment;
    public TextField txtQuery;

    private PaymentService paymentService = new PaymentService();


    public void initialize() {
        MaterialUI.paintTextFields(txtQuery);
        tblAPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblAPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblAPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("register"));
        tblAPayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("payment"));
        TableColumn<PaymentTM, HBox> lastCol = (TableColumn<PaymentTM, HBox>) tblAPayment.getColumns().get(4);
        lastCol.setCellValueFactory(param -> {
            ImageView imgEdit = new ImageView("/View/assets/Edit.png");
            ImageView imgTrash = new ImageView("/View/assets/Trash.png");

            imgEdit.getStyleClass().add("action-icons");
            imgTrash.getStyleClass().add("action-icons");

//            imgEdit.setOnMouseClicked(event -> updateStudent(param.getValue()));
//            imgTrash.setOnMouseClicked(event -> deleteStudent(param.getValue()));

            return new ReadOnlyObjectWrapper<>(new HBox(10, imgEdit, imgTrash));
        });

        txtQuery.textProperty().addListener((observable, oldValue, newValue) -> loadAllStudents(newValue));

        loadAllStudents("");
    }

    private void loadAllStudents(String query) {
        tblAPayment.getItems().clear();

        for (Payment payment : paymentService.findStudents(query)) {
            tblAPayment.getItems().add(new PaymentTM(payment.getCid(), payment.getCourseName(), payment.getRegister(), payment.getPayment()));
            System.out.println(tblAPayment.getItems());
        }
    }

//    private void deleteStudent(AdminTM tm){
//        try {
//            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this student?", ButtonType.YES, ButtonType.NO).showAndWait();
//            if (buttonType.get() == ButtonType.YES) {
//                paymentService.deleteStudent(tm.getNic());
//                tblAPayment.getItems().remove(tm);
//            }
//        }catch (RuntimeException e){
//            new Alert(Alert.AlertType.ERROR, "Failed to delete the item", ButtonType.OK).show();
//        }
//    }

//    private void updateStudent(AdminTM tm){
//        try {
//            Stage secondaryStage = new Stage();
//            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/View/MainForm.fxml"));
//            Scene secondaryScene = new Scene(loader.load());
//            MainFormController ctrl = loader.getController();
//
//            secondaryStage.setScene(secondaryScene);
//            secondaryScene.setFill(Color.TRANSPARENT);
//            secondaryStage.initStyle(StageStyle.TRANSPARENT);
//            secondaryStage.initModality(Modality.WINDOW_MODAL);
//            secondaryStage.initOwner(txtQuery.getScene().getWindow());
//            secondaryStage.setTitle("Update Payment");
//            ctrl.navigate("Update Payment","/View/AdminStudentForm.fxml", AppBarIcon.NAV_ICON_NONE, null, tm);
//
//            secondaryStage.showAndWait();
//            tblAPayment.refresh();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
