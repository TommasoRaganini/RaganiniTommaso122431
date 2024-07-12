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

import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Player;

import java.util.List;

/**
 * Interface for updating the game's user interface (UI).
 * This interface defines methods for updating various aspects of the game's UI,
 * including the track, the winner announcement, available moves, and player count.
 */
public interface GameUIUpdater {
    /**
     * Updates the UI to reflect the current state of the track and player positions.
     *
     * @param trackMatrix A 2D array representing the current state of the track.
     * @param players     An array of Player objects representing the current positions of the players.
     */
    void updateTrackUI(String[][] trackMatrix, Player[] players);

    /**
     * Updates the UI to announce the winner of the game.
     *
     * @param player The player who has won the game.
     */
    void updateWinnerUI(Player player);

    /**
     * Updates the choices available for player moves in the UI.
     *
     * @param validMoves A list of Directions representing the valid moves a player can make.
     */
    void updateMovesChoiceBox(List<Directions> validMoves);

    /**
     * Sets the text of a label in the UI, typically used for instructions or information.
     *
     * @param s The string to set as the label text.
     */
    void setInsertLabel(String s);

    /**
     * Retrieves the number of players participating in the game.
     *
     * @return The number of players.
     */
    Integer getNumPlayers();
}
