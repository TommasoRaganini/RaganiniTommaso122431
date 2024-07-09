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
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.IRaceTrack;

/**
 * Represents the core game engine that manages the gameplay logic, including player movements,
 * track updates, and determining the game outcome.
 */
public class Game {
    private final Player[] players;
    private final IRaceTrack track;
    private final IChecker checker;
    private final GameUIUpdater updater;
    private int round = 1;
    private boolean endGame = false;
    private final static int FIRST_ROUND_CONTROL = 2;
    private GameStrategy currentStrategy;

    /**
     * Constructs a new Game instance with specified UI updater, track, checker, and players.
     *
     * @param updater The interface for updating the game UI.
     * @param track The racetrack where the game takes place.
     * @param checker The checker used to determine game outcomes.
     * @param players The array of players participating in the game.
     */
    public Game(GameUIUpdater updater, IRaceTrack track, IChecker checker, Player[] players) {
        this.track= track;
        this.players = players;
        this.checker = checker;
        this.updater = updater;
    }

    /**
     * Starts the game and manages the game loop until the game ends.
     * It updates the UI with the initial state, decides the game strategy based on the round,
     * and plays rounds until a win condition is met.
     */
    public void startGame() {
        updater.updateTrackUI(track.getTrack(), players);
        while (!endGame) {
            if (round < FIRST_ROUND_CONTROL) {
                currentStrategy = new FirstRoundStrategy();
            } else {
                currentStrategy = new NormalRoundStrategy();
            }
            playRound();
        }
    }
    /**
     * Plays a single round of the game.
     * It iterates through each player, allowing them to take their turn based on the current strategy.
     * Checks for a win condition after each player's turn and updates the UI if a winner is found.
     */
    private void playRound() {
        for (Player player : players) {
            currentStrategy.playRound(player, updater, track, checker, players);
            endGame = checker.checkWin(player, track, round);
            if (endGame) {
                updater.updateWinnerUI(player);
                break;
            }
        }
        round++;
    }

}




