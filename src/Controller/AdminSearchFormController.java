package Controller;

import Model.Admin;
import Model.AdminTM;
import Service.AdminService;
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

public class AdminSearchFormController {
    public TextField txtQuery;
    public TableView<AdminTM> tblAdStudents;

    private AdminService adminService = new AdminService();


    public void initialize() {
        MaterialUI.paintTextFields(txtQuery);
        tblAdStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblAdStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tblAdStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tblAdStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("registerFee"));
        tblAdStudents.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("paymentFee"));
        TableColumn<AdminTM, HBox> lastCol = (TableColumn<AdminTM, HBox>) tblAdStudents.getColumns().get(6);
        lastCol.setCellValueFactory(param -> {
            ImageView imgEdit = new ImageView("/View/assets/Edit.png");
            ImageView imgTrash = new ImageView("/View/assets/Trash.png");

            imgEdit.getStyleClass().add("action-icons");
            imgTrash.getStyleClass().add("action-icons");

            imgEdit.setOnMouseClicked(event -> updateStudent(param.getValue()));
            imgTrash.setOnMouseClicked(event -> deleteStudent(param.getValue()));

            return new ReadOnlyObjectWrapper<>(new HBox(10, imgEdit, imgTrash));
        });

        txtQuery.textProperty().addListener((observable, oldValue, newValue) -> loadAllStudents(newValue));

        loadAllStudents("");
    }

    private void loadAllStudents(String query) {
        tblAdStudents.getItems().clear();

        for (Admin admin : adminService.findStudents(query)) {
            tblAdStudents.getItems().add(new AdminTM(admin.getNic(), admin.getFullName(), admin.getAddress(), admin.getRegisterFee(), admin.getPaymentFee()));
            System.out.println(tblAdStudents.getItems());
        }
    }

    private void deleteStudent(AdminTM tm){
        try {
            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this student?", ButtonType.YES, ButtonType.NO).showAndWait();
            if (buttonType.get() == ButtonType.YES) {
                adminService.deleteStudent(tm.getNic());
                tblAdStudents.getItems().remove(tm);
            }
        }catch (RuntimeException e){
            new Alert(Alert.AlertType.ERROR, "Failed to delete the item", ButtonType.OK).show();
        }
    }

    private void updateStudent(AdminTM tm){
        try {
            Stage secondaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/View/MainForm.fxml"));
            Scene secondaryScene = new Scene(loader.load());
            MainFormController ctrl = loader.getController();

            secondaryStage.setScene(secondaryScene);
            secondaryScene.setFill(Color.TRANSPARENT);
            secondaryStage.initStyle(StageStyle.TRANSPARENT);
            secondaryStage.initModality(Modality.WINDOW_MODAL);
            secondaryStage.initOwner(txtQuery.getScene().getWindow());
            secondaryStage.setTitle("Update Student");
            ctrl.navigate("Update Student","/View/AdminStudentForm.fxml", AppBarIcon.NAV_ICON_NONE, null, tm);

            secondaryStage.showAndWait();
            tblAdStudents.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
