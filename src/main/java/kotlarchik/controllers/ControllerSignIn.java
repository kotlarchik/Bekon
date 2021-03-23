package kotlarchik.controllers;

import com.sun.javafx.webkit.theme.ScrollBarWidget;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kotlarchik.dao.DAO;
import kotlarchik.model.Users;
import kotlarchik.service.ServiceUsers;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class ControllerSignIn {
    private ObservableList<Users> usersList = FXCollections.observableArrayList();

    @FXML
    public TextField txtLogin;
    @FXML
    public PasswordField txtPass;
    @FXML
    public Label txtStatus;
    @FXML
    private Button buttonSign;

    public void pressSign(ActionEvent event) throws IOException {
        initData();
        for (Users users: usersList){
            if (txtLogin.getText().equals(users.getName()) && txtPass.getText().equals(users.getPassword())){
                Parent root = FXMLLoader.load(getClass().getResource("/view/StartMenu.fxml"));
                buttonSign.getScene().getWindow().hide();
                Stage stage = new Stage();
                stage.setTitle("Главное меню");
                stage.setScene(new Scene(root));
                stage.show();
                break;
            }
            else {
                txtStatus.setText("Вы ввели неверный логин или пароль. Пожалуйста, проверьте ещё раз введенные данные.");
            }
        }

    }

    private void initData(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Users, Integer> usersDAO = new ServiceUsers(factory);
        usersList.addAll(usersDAO.readAll());
    }
}
