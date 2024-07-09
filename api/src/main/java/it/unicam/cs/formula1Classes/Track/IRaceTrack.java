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

package it.unicam.cs.formula1Classes.Track;

import it.unicam.cs.formula1Classes.Player.Position;

import java.util.List;

/**
 * Interface representing the racetrack in the Formula 1 game.
 * Provides methods to access the track layout, start and finish lines, and dimensions.
 */
public interface IRaceTrack {
    String[][] getTrack();
    int getRows();
    int getColumns();
    /**
     * Retrieves the positions of the start line on the racetrack.
     * This method is crucial for setting up the initial positions of the cars at the beginning of the race.
     *
     * @return A list of {@link Position} objects representing the start line positions. Each position indicates a specific grid coordinate on the track where a car can be placed at the start of the race.
     */
    List<Position> getStartLine();
    /**
     * Retrieves the positions of the finish line on the racetrack.
     * This method is crucial for determining when a car has completed a lap and crossed the finish line.
     *
     * @return A list of {@link Position} objects representing the finish line positions. Each position indicates a specific grid coordinate on the track where a car can be placed at the end
     */
    List<Position> getFinishLine();
}
