package core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public class Controller implements Initializable {

    @FXML
    private
    VBox vMenu ;



    FileChooser fileChooser = new FileChooser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("C\\temp"));
        createMenu();
    }


    private void createMenu(){
        MenuBar mBar = new MenuBar();
        Menu mainMenu = new Menu("Игра");
        MenuItem mSave = new MenuItem("Сохранить");
        MenuItem mLoad = new MenuItem("Загрузить");

    }

    @FXML
    private void menuClicked(ActionEvent event){
        System.out.println("Menu Click");
    }
    @FXML
    private void saveClicker(ActionEvent event){
        Window stage = vMenu.getScene().getWindow();
        fileChooser.setTitle("Сохранить игру");
        fileChooser.setInitialFileName("Мой файл");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Текстовый файл", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        try {
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile()); // save the chosen directory
        }
        catch (Exception e) {

        }

    }
    @FXML
    private void loadClicker(ActionEvent event){
        Window stage = vMenu.getScene().getWindow();
        fileChooser.setTitle("Загрузить игру");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Текстовый файл", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        try {
            File file = fileChooser.showOpenDialog(stage);
            List<File> files = fileChooser.showOpenMultipleDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile()); // save the chosen directory
        }
        catch (Exception e){

        }
    }
}
