package com.example.comp228_f22_lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class GameAndPlayerController {

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button gameAddButton;

    @FXML
    private TextField gameIdTextArea;

    @FXML
    private TextField gameIdTextField;

    @FXML
    private TextField gameTitleTextArea;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField playGameIdTextField;

    @FXML
    private DatePicker playerDate;

    @FXML
    private Button playerGameDetails;

    @FXML
    private TextField playerIdDetailsTextField;

    @FXML
    private TextField playerIdTextArea;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private TextField provinceTextField;

    @FXML
    private TextField scoreTextField;

    @FXML
    void onButtonGameClick(ActionEvent event) throws SQLException {
        DBUtil.insertDataGame("Game", parseInt(gameIdTextArea.getText()), gameTitleTextArea.getText());
    }

    @FXML
    void onButtonPlayerClick(ActionEvent event) throws SQLException {
        DBUtil.insertDataPlayer("PLAYER", parseInt(playerIdTextArea.getText()), firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), postalCodeTextField.getText(), provinceTextField.getText(), phoneNumberTextField.getText());
    }

    @FXML
    void onButtonPlayerGameClick(ActionEvent event) throws SQLException {
        DBUtil.insertDataPlayerGame("PLAYERANDGAME", parseInt(playGameIdTextField.getText()), parseInt(gameIdTextField.getText()), parseInt(playerIdDetailsTextField.getText()), String.valueOf(playerDate.getValue()), parseInt(scoreTextField.getText()));
    }

}
