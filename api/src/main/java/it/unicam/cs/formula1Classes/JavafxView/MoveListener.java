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

package it.unicam.cs.formula1Classes.JavafxView;

import it.unicam.cs.formula1Classes.Player.Directions;


/**
 * Interface defining the contract for listening to move selections in a Formula 1 game.
 * Implementations of this interface are responsible for handling user input regarding
 * the direction of a player's move in the game.
 */
public interface MoveListener {

    /**
     * Invoked when a move is selected by the player.
     * Implementations should define how the game handles the selected direction.
     *
     * @param direction The direction of the move selected by the player.
     */
    void onMoveSelected(Directions direction);

    /**
     * Retrieves the current direction selected by the player.
     * This method allows querying the last known direction that was selected.
     *
     * @return The current direction selected by the player.
     */
    Directions getDirection();

    /**
     * Waits for the player to make a move selection.
     * This method may block until a move is selected, depending on the implementation.
     *
     * @throws InterruptedException if the thread waiting for the move selection is interrupted.
     */
    void waitForMoveSelection() throws InterruptedException;

}
