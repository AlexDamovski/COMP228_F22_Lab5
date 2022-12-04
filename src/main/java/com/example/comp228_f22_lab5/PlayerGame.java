package com.example.comp228_f22_lab5;

public class PlayerGame {
    int playerGameID;
    int game_id;
    int player_id;
    String playingDate;
    int score;

    public PlayerGame(int playerGameID) {
        this.playerGameID = playerGameID;
    }

    public PlayerGame(int playerGameID, int game_id, int player_id, String playingDate, int score) {
        this.playerGameID = playerGameID;
        this.game_id = game_id;
        this.player_id = player_id;
        this.playingDate = playingDate;
        this.score = score;
    }

    public int getPlayerGameID() {
        return playerGameID;
    }

    public void setPlayerGameID(int playerGameID) {
        this.playerGameID = playerGameID;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(String playingDate) {
        this.playingDate = playingDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
