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

import it.unicam.cs.formula1Classes.Player.Position;

/**
 * The only purpose of this class is to help the other methods with the research
 * of the finish line and to check if the car has reached it
 */
public class ResearchPath {

    /**
     * This method searches for a path between two points
     *
     * @param track the track of the game
     * @param start the starting point
     * @param end   the ending point
     * @return true if the car had reached or passed the finish line, false otherwise
     */
    public static boolean searchPath(String[][] track, Position start, Position end) {
        int[] p1 = {start.getY(), start.getX()};
        int[] p2 = {end.getY(), end.getX()};
        Position newStart = new Position(Math.min(p1[0], p2[0]), Math.min(p1[1], p2[1]));
        Position newEnd = new Position(Math.max(p1[0], p2[0]), Math.max(p1[1], p2[1]));
        for (int i = newStart.getY(); i <= newEnd.getY(); i++) {
            for (int j = newStart.getX(); j <= newEnd.getX(); j++) {
                if (track[i][j].equals("F")) {
                    return true;
                }
            }
        }
        return false;
    }

}
