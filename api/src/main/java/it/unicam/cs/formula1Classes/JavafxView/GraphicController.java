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
public class GraphicController implements GameUIUpdater, Initializable {
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
    /**
     * Constructor for the GraphicController class.
     * Initializes the move listener for handling player moves.
     */
    public GraphicController() {
        this.moveListener = new MoveViewController();
    }

    /**
     * Handles the action of starting the game.
     * It retrieves the selected number of players, validates it, and then initializes the game components.
     */
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

    /**
     * Sets the visibility and availability of UI components for the game setup.
     */
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

    /**
     * Initializes the controller class.
     * Generates and displays the track on the UI.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] trackMatrix = TrackGenerator.generateTrack();
        Util.drawTrack(trackMatrix, PaneTrack);
        Platform.runLater(this::setNumPlayers);
    }

    /**
     * Updates the track UI with the current positions of the players.
     *
     * @param trackMatrix The matrix representing the track layout.
     * @param players     The array of players to be displayed on the track.
     */
    public void updateTrackUI(String[][] trackMatrix, Player[] players) {
        Platform.runLater(() -> Util.updateTrack(players, trackMatrix, PaneTrack));
    }

    /**
     * Updates the UI to display the winner of the game.
     *
     * @param player The player who won the game.
     */
    public void updateWinnerUI(Player player) {
        Platform.runLater(() -> WinnerText.setText("The winner is: " + player.toString()));
    }

    /**
     * Updates the UI to display the valid moves for the current player.
     *
     * @param validMoves The list of valid moves for the current player.
     */
    public void updateMovesChoiceBox(List<Directions> validMoves) {
        Platform.runLater(() -> {
            moves.getItems().clear();
            moves.getItems().addAll(validMoves);
        });
    }

    /**
     * Handles the action of moving the player.
     * Retrieves the selected move from the UI and notifies the move listener.
     */
    @FXML
    void onButtonMove() {
        Directions selectedMove = moves.getSelectionModel().getSelectedItem();
        moveListener.onMoveSelected(selectedMove);
    }

    /**
     * Updates the UI to display a message to the user.
     *
     * @param message The message to be displayed.
     */
    public void setInsertLabel(String message) {
        Platform.runLater(() -> InsertLabel.setText(message));
    }

    /**
     * Sets the number of players in the choice box for the user to select.
     */
    public void setNumPlayers() {
        numPLayers.getItems().clear();
        numPLayers.getItems().addAll(1, 2, 3, 4, 5);
    }

    /**
     * Retrieves the number of players selected by the user.
     *
     * @return The number of players selected by the user.
     */
    public Integer getNumPlayers() {
        return numPLayers.getSelectionModel().getSelectedItem();
    }
}
