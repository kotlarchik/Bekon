package kotlarchik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/SignIn.fxml"));
        stage.setTitle("Авторизуйетсь");
        stage.setScene(new Scene(root));
        stage.getIcons().addAll(new Image(getClass().getResourceAsStream("/icon/666.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
