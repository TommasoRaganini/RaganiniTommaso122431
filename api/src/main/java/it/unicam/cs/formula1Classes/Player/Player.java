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

import it.unicam.cs.formula1Classes.JavafxView.GameUIUpdater;

import java.util.List;

/**
 * Abstract class representing a player in the Formula 1 game.
 * This class provides the basic structure and functionalities that all types of players (human, AI, etc.) should have.
 */
public abstract class Player {
    private final Car car;
    private final int playerId;

    /**
     * Constructs a Player with a specified car and player ID.
     *
     * @param car      The car assigned to the player.
     * @param playerId The unique identifier for the player.
     */
    public Player(Car car, int playerId) {
        this.car = car;
        this.playerId = playerId;
    }
    /**
     * Returns the car of the player
     *
     * @return the car of the player
     */
    public Car getCar() {
        return car;
    }

    /**
     * This method moves the car of the player due to the logic that the player implements for the movement
     *
     * @param moves   the list of moves allowed for the car
     * @param updater the object that updates the UI
     */
    public abstract void move(List<Directions> moves, GameUIUpdater updater);


    /**
     * This method checks if the car of the player went out of the track
     *
     * @param moves the list of moves allowed for the car
     * @return true if the car can move, false otherwise
     */
    public boolean checkAllowedMoves(List<Directions> moves) {
        boolean allowed = moves.isEmpty();
        if (allowed) {
            getCar().getVector().setModule(0, 0);
        }
        return allowed;
    }
    /**
     * Returns the player ID
     *
     * @return the player ID
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Returns the actual coordinates of the car
     *
     * @return the coordinates of the car
     */
    public int[] getCarCoordinates() {
        return getCar().getCoordinates();
    }

    /**
     * Returns the previous coordinates of the car
     *
     * @return the previous coordinates of the car
     */
    public int[] getPreviousCarCoordinates() {
        return getCar().getPreviousCoordinates();
    }

    /**
     * Removes the last position of the car
     */
    public void removeLastPosition() {
        getCar().removeLastPosition();
    }

    /**
     * Sets the check point of the car to true once the car has passed through it
     *
     * @param checkPoint the check point of the car
     */
    public void setCheckPoint(boolean checkPoint) {
        getCar().setCheckPoint(checkPoint);
    }

    /**
     * Returns the check point of the car
     *
     * @return the check point of the car
     */
    public boolean getCheckPoint() {
        return getCar().getCheckPoint();
    }

}
