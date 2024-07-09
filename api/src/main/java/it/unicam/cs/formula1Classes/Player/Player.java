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
 * This interface represents the player of the game
 */
public abstract class Player {
    private final Car car;
    private final int playerId;


    public Player(Car car, int playerId) {
        this.car = car;
        this.playerId = playerId;
    }
    public Car getCar(){
        return car;
    }
    /**
     * This method moves the car of the player in a random direction
     * @param moves the list of moves allowed for the car
     * @param updater the object that updates the UI
     */
    public abstract void move(List<Directions> moves, GameUIUpdater updater);


    /**
     * This method checks if the car of the player can move in the direction chosen
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

    public int getPlayerId() {
        return playerId;
    }

    @Override
    public abstract String toString();

    public int[] getCarCoordinates() {
        return getCar().getCoordinates();
    }

    public int[] getPreviousCarCoordinates() {
        return getCar().getPreviousCoordinates();
    }

    public void removeLastPosition() {
        getCar().removeLastPosition();
    }

    public void setCheckPoint(boolean checkPoint) {
        getCar().setCheckPoint(checkPoint);
    }

    public boolean getCheckPoint() {
        return getCar().getCheckPoint();
    }

}
