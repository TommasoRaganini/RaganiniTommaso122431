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

package it.unicam.cs.formula1Classes.GameEngine;

import it.unicam.cs.formula1Classes.JavafxView.GameUIUpdater;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.HumanPlayer;
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.IRaceTrack;

import java.util.List;
/**
 * Implements the strategy for rounds after the first in the game.
 * This strategy allows for dynamic movement options based on the game state and player type.
 */
public class NormalRoundStrategy implements GameStrategy {
    /**
     * Executes the round's logic for a given player within the context of the current game state.
     * This method determines the valid moves for the player, updates the UI accordingly if the player is human,
     * and then performs the move. After moving, it updates the track UI to reflect the new state.
     *
     * @param player  The player for whom the round is being played.
     * @param updater An instance of {@link GameUIUpdater} used to update the game's UI elements.
     * @param track   The racetrack on which the game is being played, providing context for valid moves.
     * @param checker An instance of {@link IChecker} used to determine valid moves for the player.
     * @param players An array of all players in the game, used for updating the track UI.
     */
    @Override
    public void playRound(Player player, GameUIUpdater updater, IRaceTrack track, IChecker checker, Player[] players) {
        List<Directions> moves = checker.getValidMoves(player, track);
        if (player instanceof HumanPlayer) {
            updater.updateMovesChoiceBox(moves);
        }
        player.move(moves, updater);
        updater.updateTrackUI(track.getTrack(), players);
    }
}
