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
import it.unicam.cs.formula1Classes.JavafxView.MoveListener;
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.IRaceTrack;
import it.unicam.cs.formula1Classes.Track.RaceTrack;

/**
 * This class launches the game
 */
public class GameLauncher {
    private final Game game;

    public GameLauncher(GameUIUpdater updater, MoveListener moveListener) {
        IRaceTrack track = new RaceTrack();
        Player[] players = setupPlayers(moveListener,updater);
        IChecker checker = new GameChecker(players);
        this.game = new Game(updater, track, checker, players);
    }
    /**
     * This method launches the game
     */
    public void launchGame() {
        game.startGame();
    }

    /**
     * This method initializes the players
     *
     * @param moveListener the move listener
     * @return the players
     */
    private Player[] setupPlayers(MoveListener moveListener, GameUIUpdater updater) {
        GameSetup setup = new GameSetup(updater);
        return setup.initGame(moveListener);
    }

}
