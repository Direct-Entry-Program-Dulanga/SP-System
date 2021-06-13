package Controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.MaterialUI;

public class StudentChangeFormController {


    public TextField txtQuery;
    public TableView<> tblAdminStudents;

    public void initialize(){
        MaterialUI.paintTextFields(txtQuery);
    }
    public void tblResults_OnKeyPressed(KeyEvent keyEvent) {
    }
}
