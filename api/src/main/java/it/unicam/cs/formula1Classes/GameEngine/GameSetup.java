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

import it.unicam.cs.formula1Classes.Track.FIleIOtrack;
import it.unicam.cs.formula1Classes.Track.RaceTrack;
import it.unicam.cs.formula1Classes.InputOutput.InputPlayer;
import it.unicam.cs.formula1Classes.Player.*;

import java.util.List;
/**
 * This class represents the setup initialization of the game
 */
public class GameSetup {
    private final Controller[] controllers;
    private final FIleIOtrack fIleIOtrack = new FIleIOtrack();
    private final InputPlayer inputPlayer = new InputPlayer();
    private final int numPlayers = fIleIOtrack.getPlayersNumber();
    private final int numHumPl = inputPlayer.getNumberOfPlayers();
    public GameSetup() {
        this.controllers = new Controller[numPlayers+numHumPl];
    }
    /**
     * This method initializes the game
     * @return the controllers of the game
     */
    public Controller[] initGame() {
        RaceTrack raceTrack = new RaceTrack();
        List<Position> positions = raceTrack.getStartLine();
            if (this.numHumPl + this.numPlayers > 5) {
                System.out.println("The number of players is too high");
                System.exit(0);
            }
            for (int n = 0; n < this.numHumPl; n++) {
                controllers[n] = new Controller(new HumanPlayer(
                        new Car(positions.get(n))));
            }
            for (int i = this.numHumPl; i < this.numPlayers+this.numHumPl; i++) {
            controllers[i] = new Controller(new Bot(
                    new Car(positions.get(i))));
             }
        return controllers;
    }

}
