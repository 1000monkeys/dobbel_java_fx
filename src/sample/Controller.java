package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    @FXML
    private ImageView imageView;

    @FXML
    private ListView listView;

    @FXML
    private Slider slider;

    public void setImage(){
        File file = new File("six.png");

        Image image = new Image(file.toURI().toString());

        imageView.setImage(image);

        ArrayList tempList = new ArrayList();
        for (int i = 0; i < 100; i++) {
            tempList.add("Number " + i);
        }
        ObservableList<String> list = FXCollections.observableList(tempList);

        listView.setItems(list);

        slider.setMin(3);
        slider.setMax(5);
        slider.setBlockIncrement(1);
    }
}
