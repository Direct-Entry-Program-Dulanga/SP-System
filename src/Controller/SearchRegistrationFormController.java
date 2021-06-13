package Controller;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.MaterialUI;

public class SearchRegistrationFormController {

    public TableView tblResults;
    public TextField txtQuery;

    public void initialize(){
        MaterialUI.paintTextFields(txtQuery);
    }
}
