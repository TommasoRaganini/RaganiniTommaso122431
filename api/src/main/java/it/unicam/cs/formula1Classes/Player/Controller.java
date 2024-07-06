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

package it.unicam.cs.formula1Classes.Player;


import it.unicam.cs.formula1Classes.Track.RaceTrack;

import java.util.List;

/**
 * This class represents the controller of the game
 * that manages the player and the track
 */
public class Controller {
    private final Player player;
    private final RaceTrack track;

    /**
     * Constructor for the Controller class.
     *
     * @param player the player of the game
     */
    public Controller(Player player) {
        this.player = player;
        this.track = new RaceTrack();
    }

    /**
     * This method moves the car of the player in the direction passed as parameter
     * @param moves the list of moves allowed for the car
     */
    public void moveCar(List<Directions> moves) {
        if (moves.isEmpty()) {
            getCar().getVector().setModule(0, 0);
            return;
        }
        this.player.move(moves);
    }

    public Player getPlayer() {
        return player;
    }

    public int[] getCarCoordinates() {
        return player.getCar().getCoordinates();
    }

    public int[] getPreviousCarCoordinates() {
        return player.getCar().getPreviousCoordinates();
    }

    public RaceTrack getRaceTrack() {
        return track;
    }

    public Car getCar() {
        return player.getCar();
    }

    @Override
    public String toString() {
        return player.toString();
    }

}