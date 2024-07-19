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

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the RaceTrack of the game
 */
public class RaceTrack implements IRaceTrack {
    private final String[][] track;
    private final List<Position> startLine;
    private final List<Position> finishLine;
    private final int rows;
    private final int columns;

    /**
     * Constructor for the RaceTrack class.
     */
    public RaceTrack() {
        this.track = TrackGenerator.generateTrack();
        this.rows = track.length;
        this.columns = track[0].length;
        this.startLine = getStartAndFinishLine("S");
        this.finishLine = getStartAndFinishLine("F");
    }

    /**
     * This method returns the start or finish line of the track
     * based on the string passed as parameter
     *
     * @param s the string to search
     * @return the list of the start or finish line
     */
    public List<Position> getStartAndFinishLine(String s) {
        ArrayList<Position> StartAndFinishLine = new ArrayList<>();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.track[i][j].equals(s)) {
                    StartAndFinishLine.add(new Position(i, j));
                }
            }
        }
        return StartAndFinishLine;
    }

    public int getColumns() {
        return columns;
    }

    /**
     * Returns the element contained in the cell specified by the given row and column.
     * @param row    the row of the matrix
     * @param column the column of the matrix
     * @return the track position
     */
    public String getTrackPositionElement(int row, int column) {
        return track[row][column];
    }

    /**
     * Set the element in the cell specified by the given row and column. Only used for testing
     * @param row    the row to set
     * @param column the column to set
     * @param value  the value to insert in the cell
     *               {@code @void}  Set the track position
     */
    public void setTrackPositionElement(int row, int column, String value) {
        track[row][column] = value;
    }

    public List<Position> getStartLine() {
        return this.startLine;
    }

    public List<Position> getFinishLine() {
        return this.finishLine;
    }

    public String[][] getTrack() {
        return track;
    }

    public int getRows() {
        return rows;
    }

}

