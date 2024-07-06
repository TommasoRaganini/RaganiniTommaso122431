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
import it.unicam.cs.formula1Classes.JavafxView.Util;
import it.unicam.cs.formula1Classes.Player.Controller;
import it.unicam.cs.formula1Classes.Player.Directions;

import java.util.List;

/**
 * This class represents the motor of the game

 */
public class Game {
    private final Controller[] controllers;
    private final IChecker checker;
    private final GameUIUpdater updater;
    private int round = 1;
    private boolean endGame = false;

    public Game(GameUIUpdater updater) {
        GameSetup setup = new GameSetup();
        this.controllers = setup.initGame();
        this.checker = new GameChecker(controllers);
        this.updater = updater;
    }

    /**
     * This method starts the game
     */
    public void startGame() {
        while (!endGame) {
            for (Controller c : controllers) {
                if (round < 5) {
                    c.moveCar(List.of(Directions.RIGHT));
                } else {
                    c.moveCar(this.checker.getValidMoves(c));
                    if (checker.checkWin(c)) {
                        endGame = true;
                        //OutputGame.printWinner(c.getPlayer());
                        break;
                    }
                }
            }
            updater.updateTrackUI(controllers[0].getRaceTrack().getTrack(), controllers);
           // OutputGame.printTrack(controllers[0].getRaceTrack(), controllers, round);
            round++;
        }
    }


}
