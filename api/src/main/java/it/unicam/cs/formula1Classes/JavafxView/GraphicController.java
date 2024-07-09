/*
 * MIT License
 *
 * Copyright (c) 2024 Tommaso Raganini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.unicam.cs.formula1Classes.JavafxView;

import it.unicam.cs.formula1Classes.GameEngine.GameLauncher;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.TrackGenerator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/**
 * Controller class for managing the graphical user interface of the Formula 1 game.
 * This class handles user interactions, updates the UI based on game state, and initializes
 * the game components.
 */
public class GraphicController implements GameUIUpdater,Initializable {
    @FXML
    private Label RulesLabel;
    @FXML
    private Label WinnerText;
    @FXML
    private Label InsertLabel;
    @FXML
    private Label NoteLabel;
    @FXML
    private Label WarningLabel;
    @FXML
    private Button startButton;
    @FXML
    private Button moveButton;
    @FXML
    private Pane PaneTrack;
    @FXML
    private ChoiceBox<Directions> moves;
    @FXML
    private ChoiceBox<Integer> numPLayers;

    private final MoveListener moveListener;

    public GraphicController() {
        this.moveListener = new MoveViewController();
    }

    @FXML
    void onButtonStartGame() {
        new Thread(() -> {
            Integer numPlayers = getNumPlayers(); // Recupera il numero di giocatori selezionato
            if (numPlayers == null) {
                Platform.runLater(() -> setInsertLabel("Please select the number of players."));
                return;
            }
            setComponents();
            GameLauncher gameEngine = new GameLauncher(this, moveListener);
            gameEngine.launchGame();
        }).start();
    }

    private void setComponents() {
        setInsertLabel("");
        NoteLabel.setVisible(true);
        moves.setVisible(true);
        moveButton.setVisible(true);
        WarningLabel.setVisible(false);
        numPLayers.setVisible(false);
        startButton.setVisible(false);
        RulesLabel.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] trackMatrix =TrackGenerator.generateTrack();
        Util.drawTrack(trackMatrix, PaneTrack);
        Platform.runLater(this::setNumPlayers);
    }

    public void updateTrackUI(String[][] trackMatrix, Player[] players) {
        Platform.runLater(() -> Util.updateTrack(players, trackMatrix, PaneTrack));
    }

    public void updateWinnerUI(Player player){
        Platform.runLater(() -> WinnerText.setText("The winner is: " + player.toString()));
    }

    public void updateMovesChoiceBox(List<Directions> validMoves) {
        Platform.runLater(() -> {
            moves.getItems().clear();
            moves.getItems().addAll(validMoves);
        });
    }

    @FXML
    void onButtonMove() {
        Directions selectedMove = moves.getSelectionModel().getSelectedItem();
        moveListener.onMoveSelected(selectedMove);
    }

    public void setInsertLabel(String message){
        Platform.runLater(() -> InsertLabel.setText(message));
    }

    public void setNumPlayers(){
        numPLayers.getItems().clear();
        numPLayers.getItems().addAll(1,2,3,4,5);
    }

    public Integer getNumPlayers(){
        return numPLayers.getSelectionModel().getSelectedItem();
    }

}
