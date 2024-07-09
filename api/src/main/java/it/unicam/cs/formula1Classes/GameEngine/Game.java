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
 * This class parse the interaction between the gamelogic and the UI
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

    public Game(GameUIUpdater updater, IRaceTrack track, IChecker checker, Player[] players) {
        this.track= track;
        this.players = players;
        this.checker = checker;
        this.updater = updater;
    }

    /**
     * This method starts the game
     */
    public void startGame() {
        updater.updateTrackUI(track.getTrack(), players);
        while (!endGame) {
            // Decide la strategia in base al round o ad altre condizioni
            if (round < FIRST_ROUND_CONTROL) {
                currentStrategy = new FirstRoundStrategy();
            } else {
                currentStrategy = new NormalRoundStrategy();
            }
            playRound();
        }
    }

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
        // Potresti voler controllare la condizione di fine gioco qui, in base alla logica specifica
    }

}




