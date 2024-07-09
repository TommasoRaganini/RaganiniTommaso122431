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
 * Controller for handling move selection in the Formula 1 game.
 * This class listens for move selections and notifies other components when a move has been selected.
 * It implements the {@link MoveListener} interface to receive move selection events.
 */
public class MoveViewController implements MoveListener{
    private Directions direction;
    private volatile boolean isMoveSelected = false;

    /**
     * Handles the event when a move is selected.
     * Sets the selected direction and updates the move selection flag.
     * Notifies all waiting threads that a move has been selected.
     *
     * @param direction The direction of the selected move.
     */
    @Override
    public void onMoveSelected(Directions direction) {
        this.direction = direction;
        this.isMoveSelected = true;
        synchronized (this) {
            this.notifyAll();
        }
    }

    /**
     * Waits for a move to be selected.
     * This method blocks until {@code isMoveSelected} becomes true, indicating that a move has been selected.
     * Once a move is selected, it resets the move selection flag for future moves.
     *
     * @throws InterruptedException if any thread interrupted the current thread before or while the current thread was waiting for a move selection.
     */
    public synchronized void waitForMoveSelection() throws InterruptedException {
        while (!isMoveSelected) {
            this.wait();
        }
        isMoveSelected = false; // Reset per la prossima mossa
    }

    public Directions getDirection(){
        return direction;
    }


}
