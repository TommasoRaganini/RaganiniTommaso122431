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

import java.util.EnumMap;
import java.util.Map;

/**
 * Represents the direction vector of a car in a 2D space.
 * This abstract class provides the basic functionality to manage the direction and movement
 * of a car by using a module vector that indicates the direction and magnitude of the movement.
 */
public abstract class DirectionVector {
    private final int[] module;
    private static final Map<Directions, int[]> directionMap = new EnumMap<>(Directions.class);

    static {
        directionMap.put(Directions.UP, new int[]{-1, 0});
        directionMap.put(Directions.UP_RIGHT, new int[]{-1, 1});
        directionMap.put(Directions.UP_LEFT, new int[]{-1, -1});
        directionMap.put(Directions.DOWN, new int[]{1, 0});
        directionMap.put(Directions.DOWN_RIGHT, new int[]{1, 1});
        directionMap.put(Directions.DOWN_LEFT, new int[]{1, -1});
        directionMap.put(Directions.LEFT, new int[]{0, -1});
        directionMap.put(Directions.RIGHT, new int[]{0, 1});
        directionMap.put(Directions.CENTER, new int[]{0, 0});
    }

    /**
     * Constructs a new DirectionVector with an initial module vector pointing to the center (0,0).
     */
    public DirectionVector() {
        this.module = new int[]{0, 0};
    }

    /**
     * Provides the module vector of the car.
     *
     * @return the module vector of the car
     */
    public int[] getModule() {
        return module;
    }
    /**
     * Sets the module vector of the car.
     *
     * @param y the y coordinate of the car
     * @param x the x coordinate of the car
     */
    public void setModule(int y, int x) {
        this.module[0] = y;
        this.module[1] = x;
    }

    /**
     * Updates the module vector of the car by moving it in the specified direction.
     *
     * @param direction the direction of the movement
     * @return the new module of the vector
     */
    public int[] updateModule(Directions direction) {
        int[] d = directionMap.get(direction);
        if (d == null)
            return this.module;
        this.module[0] += d[0];
        this.module[1] += d[1];
        return this.module;
    }
    /**
     * Returns the map of the directions
     *
     * @return the map of the directions
     */
    public static Map<Directions, int[]> getMap() {
        return directionMap;
    }

}
