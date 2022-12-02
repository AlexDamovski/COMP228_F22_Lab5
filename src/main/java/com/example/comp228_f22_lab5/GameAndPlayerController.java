package com.example.comp228_f22_lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class GameAndPlayerController {

    @FXML
    private Button gameAddButton;

    @FXML
    private TextField gameIdTextArea;

    @FXML
    private TextField gameTitleTextArea;

    @FXML
    private TextField playerIdTextArea;

    @FXML
    void onButtonGameClick(ActionEvent event) throws SQLException {
        DBUtil.insertData("Game", parseInt(gameIdTextArea.getText()), gameTitleTextArea.getText());

    }

}
