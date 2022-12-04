package com.example.comp228_f22_lab5;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class GameAndPlayerController {

    @FXML
    private TableColumn<?, ?> PlayerGameID;

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
    private TableColumn<?, ?> game_id;

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
    private TableColumn<?, ?> player_id;

    @FXML
    private TableColumn<?, ?> player_score;

    @FXML
    private TableColumn<?, ?> playing_date;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private TextField provinceTextField;

    @FXML
    private Pane qqqqqqqqq;

    @FXML
    private TextField scoreTextField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView table;

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
    public void onButtonDeleteClick(ActionEvent actionEvent) throws SQLException {
        PlayerGame playerGame = (PlayerGame) table.getSelectionModel().getSelectedItem();
        DBUtil.deleteData("PLAYERANDGAME", playerGame.getGame_id());
        populateData();
    }




    public void populateData() throws SQLException{
        ResultSet rs = DBUtil.query("SELECT * FROM PLAYERANDGAME");

//        ObservableList<Player> player = FXCollections.observableArrayList();
//        ObservableList<Game> game = FXCollections.observableArrayList();
        ObservableList<PlayerGame> playerGame = FXCollections.observableArrayList();

        while(rs.next()){
            PlayerGame playerGames = new PlayerGame(rs.getInt("player_game_id"),rs.getInt("game_id"), rs.getInt("player_id"), rs.getString("playing_date"), rs.getInt("score"));
            playerGame.add(playerGames);
        }

        PlayerGameID.setCellValueFactory(new PropertyValueFactory("playerGameID"));
        game_id.setCellValueFactory(new PropertyValueFactory("game_id"));
        player_id.setCellValueFactory(new PropertyValueFactory("player_id"));
        playing_date.setCellValueFactory(new PropertyValueFactory("playingDate"));
        player_score.setCellValueFactory(new PropertyValueFactory("score"));


        table.getItems().clear();

//        table.getItems().add(game);
//        table.getItems().add(player);
        table.getItems().addAll(playerGame);
    }



    public void onButtonSearchClick(ActionEvent actionEvent) throws SQLException {
        populateData();
    }


}
