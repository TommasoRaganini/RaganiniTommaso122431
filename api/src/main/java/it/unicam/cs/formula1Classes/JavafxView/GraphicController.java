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

import it.unicam.cs.formula1Classes.GameEngine.Game;
import it.unicam.cs.formula1Classes.Player.Controller;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Track.TrackGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.List;

public class GraphicController implements GameUIUpdater {

    @FXML
    private Button startButton;
    @FXML
    private Label welcomeText;
    @FXML
    private Pane PaneTrack;
    @FXML
    private ChoiceBox<Directions> moves;
    @FXML
    private Button moveButton;


    @FXML
    void onButtonStartGame() {
        Game gameEngine = new Game(this);
        gameEngine.startGame();
    }

    public void initialize(){
        String[][] trackMatrix =TrackGenerator.generateTrack();
        Util.drawTrack(trackMatrix, PaneTrack);
    }

    public void updateTrackUI(String[][] trackMatrix, Controller[] controllers) {
        Util.updateTrack(controllers, trackMatrix, PaneTrack);
    }

    public void updateMovesChoiceBox(List<Directions> validMoves) {
        moves.getItems().clear(); // Pulisce le mosse precedenti
        moves.getItems().addAll(validMoves); // Aggiunge le nuove mosse
        if (!validMoves.isEmpty()) {
            moves.getSelectionModel().selectFirst(); // Seleziona la prima mossa valida per default
        }
    }
    @FXML
    void onButtonMove() {
        Directions selectedMove = moves.getSelectionModel().getSelectedItem();
    }


    public Pane getPaneTrack() {
        return PaneTrack;
    }
}
