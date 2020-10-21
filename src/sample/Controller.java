package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private ListView listView;

    @FXML
    private Button button;

    @FXML
    private VBox vBox;

    @FXML
    private ToggleGroup amountDice;

    private Image[] diceImages = new Image[6];

    private ArrayList arrayList;
    private ObservableList<String> observableList;

    public Controller(){
        diceImages[0] = new Image("one.png");
        diceImages[1] = new Image("two.png");
        diceImages[2] = new Image("three.png");
        diceImages[3] = new Image("four.png");
        diceImages[4] = new Image("five.png");
        diceImages[5] = new Image("six.png");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arrayList = new ArrayList();
        observableList = FXCollections.observableList(arrayList);
        listView.setItems(observableList);
    }

    public void rollDice(){
        RadioButton selectedRadioButton = (RadioButton) amountDice.getSelectedToggle();
        int toggleGroupValue = Integer.parseInt(selectedRadioButton.getText());

        List<Integer> results = new ArrayList();

        for(int i = 0; i < toggleGroupValue; i++) {
            results.add(new Random().nextInt(6) + 1);
        }

        vBox.getChildren().removeAll(vBox.getChildren());
        for (int i = 0 ; i < results.size(); i++) {
            ImageView imageView = new ImageView();
            imageView.setImage(diceImages[results.get(i) - 1]);

            imageView.setFitHeight(50);
            imageView.setFitWidth(50);

            vBox.getChildren().add(imageView);
        }

        String resultString = "";
        for (int j = 0; j < results.size(); j++){
            resultString += "[" + results.get(j) + "]";
        }
        observableList.add(resultString);
    }
}