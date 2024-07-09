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
import it.unicam.cs.formula1Classes.JavafxView.MoveListener;

import java.util.List;
/**
 * Represents a human player in the Formula 1 game.
 * This class extends the {@link Player} class, adding the functionality to interact with the game through a GUI.
 */
public class HumanPlayer extends Player {
    private final MoveListener moveListener;
    private static int idPl = 1;

    /**
     * Constructs a new HumanPlayer with a specified car and move listener.
     *
     * @param car The car assigned to the player.
     * @param moveListener The listener for move events.
     */
    public HumanPlayer(Car car, MoveListener moveListener) {
        super(car,idPl++);
        this.moveListener = moveListener;

    }

    public Car getCar() {
        return super.getCar();
    }

    /**
     * Performs a move operation for the player. This method waits for a move selection from the GUI,
     * checks if the moves are allowed, and then updates the game UI accordingly.
     *
     * @param moves The list of possible moves.
     * @param updater The game UI updater to reflect changes.
     */
    @Override
    public void move(List<Directions> moves, GameUIUpdater updater) {
        try {
            moveListener.waitForMoveSelection();
            if (checkAllowedMoves(moves))
                return;
            updater.setInsertLabel(this + " has moved");
            getCar().move(moveListener.getDirection());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Move interrupted: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Player" + getPlayerId();
    }

}