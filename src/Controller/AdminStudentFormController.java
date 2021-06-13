package Controller;

import Model.Admin;
import Model.StudentATM;
import Service.AdminService;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import util.MaterialUI;

public class AdminStudentFormController {
    public TextField txtQuery;
    public TableView<StudentATM> tblAdStudents;

    private AdminService adminService = new AdminService();


    public void initialize() {
        MaterialUI.paintTextFields(txtQuery);
        tblAdStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("registerID"));
        tblAdStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tblAdStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tblAdStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("registerFee"));
        tblAdStudents.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("paymentFee"));

        txtQuery.textProperty().addListener((observable, oldValue, newValue) -> loadAllStudents(newValue));

        loadAllStudents("");
    }

    private void loadAllStudents(String query) {
        tblAdStudents.getItems().clear();

        for (Admin admin : adminService.findStudents(query)) {
            tblAdStudents.getItems().add(new StudentATM(admin.getRegisterID(), admin.getFullName(), admin.getAddress(), admin.getRegisterFee(), admin.getPaymentFee()));
            System.out.println(tblAdStudents.getItems());
        }
    }
}
