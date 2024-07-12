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
/**
 * This class represents the position of the car in the track
 */
public class Position {
    private int x;
    private int y;
    /**
     * This is the constructor of the class Position
     *
     * @param y the y coordinate of the car
     * @param x the x coordinate of the car
     */
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    /**
     * Returns the x coordinate of the car
     *
     * @return the x coordinate of the car
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of the car
     *
     * @param x the x coordinate of the car
     */
    public void setX(int x) {
        this.x = x;
    }


    /**
     * Returns the y coordinate of the car.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of the car.
     *
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * An overridden equals method that compares two Position objects based on their x and y coordinates.
     * @param obj the object to compare
     * @return true if the two Position objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Position other))
            return false;
        return y == other.y && x == other.x;
    }

    @Override
    public String toString() {
        return "Position [y=" + y + ", x=" + x + "]";
    }
    /**
     * An overridden hashCode method that generates a hash code based on the x and y coordinates of the Position object.
     * @return the hash code of the Position object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }


}
