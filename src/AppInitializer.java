import Controller.MainFormController;
import javafx.scene.control.Alert;
import util.AppBarIcon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        try{
            spinUpRedisServerInstance();
        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load data, please contact").show();
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/View/MainForm.fxml"));
        Parent root = fxmlLoader.load();
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        MainFormController ctrl = fxmlLoader.getController();
        ctrl.navigate("Student Payment System","/View/LoginForm.fxml", AppBarIcon.NAV_ICON_NONE);
        mainScene.setUserData(ctrl);
        mainScene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Student Payment System");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void spinUpRedisServerInstance() throws Exception {
        String[] commands = {"redis-server", "redis.conf"};
        Process redisServer = Runtime.getRuntime().exec(commands);

        int exitCode = redisServer.waitFor();

        if (exitCode != 0) {
            throw new Exception("Failed to spin up the redis server instance");
        }
    }
}
