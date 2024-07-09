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


import java.util.ArrayList;

/**
 * This class represents the Car of the game
 */
public class Car {
    private final ArrayList<Position> path;
    private final Velocity vector;
    private boolean checkPoint = false;

    /**
     * @param y the y coordinate of the car
     * @param x the x coordinate of the car
     *          creates a car object with a path and a velocity vector
     */
    public Car(int y, int x) {
        this.path = new ArrayList<>();
        this.path.add(new Position(y, x));
        this.vector = new Velocity();
    }
    /**
     * @param position the position of the car
     *          creates a car object with a path and a velocity vector
     */
    public Car(Position position) {
        this.path = new ArrayList<>();
        this.path.add(position);
        this.vector = new Velocity();
    }


    public void setCheckPoint(boolean checkPoint) {
        this.checkPoint = checkPoint;
    }

    public boolean getCheckPoint() {
        return this.checkPoint;
    }

    /**
     * @param direction modifies the position of the car according to the direction vector
     */
    public void move(Directions direction) {
        Position newPosition = new Position(getPosition().getY(), getPosition().getX());
        int[] module;
        module = this.vector.updateModule(direction);
        newPosition.setX(newPosition.getX() + module[1]);
        newPosition.setY(newPosition.getY() + module[0]);
        this.path.add(newPosition);
    }

    public int[] getCoordinates() {
        return new int[]{this.path.getLast().getY(), this.path.getLast().getX()};
    }

    public Position getPosition() {
        return this.path.getLast();
    }

    public ArrayList<Position> getPath() {
        return this.path;
    }

    public Velocity getVector() {
        return this.vector;
    }

    public int[] getPreviousCoordinates() {
        if (this.path.size() < 2) {
            return new int[]{this.path.getFirst().getY(), this.path.getFirst().getX()};
        }
        return new int[]{this.path.get(this.path.size() - 2).getY(), this.path.get(this.path.size() - 2).getX()};
    }
    public void removeLastPosition(){
        this.path.remove(this.path.getLast());
    }
}
