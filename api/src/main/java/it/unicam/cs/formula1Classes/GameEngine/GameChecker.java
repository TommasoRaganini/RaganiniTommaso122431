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

import it.unicam.cs.formula1Classes.Player.Controller;
import it.unicam.cs.formula1Classes.Player.DirectionVector;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * This class implements the IChecker interface and is responsible
 * for checking the  status of the game
 */
public class GameChecker implements IChecker {
    private final Controller[] controllers;

    public GameChecker(Controller[] controllers) {
        this.controllers = controllers;
    }

    public boolean checkWin(Controller c) {
        Position p1 = c.getCar().getPosition();
        Position p2 = c.getCar().getPath().get(c.getCar().getPath().size() - 2);

        return ResearchPath.searchPath(c.getRaceTrack().getTrack(), p1, p2);
    }

    public List<Directions> getValidMoves(Controller c) {
        List<Directions> validMoves = new ArrayList<>();
        int[] module = c.getCar().getVector().getModule();
        int y = c.getCarCoordinates()[0];
        int x = c.getCarCoordinates()[1];
        for (Map.Entry<Directions, int[]> entry : DirectionVector.getMap().entrySet()) {
            int[] direction = entry.getValue();
            int newY = y + direction[0] + module[0];
            int newX = x + direction[1] + module[1];
            if (isValidMove(c, newY, newX)) {
                validMoves.add(entry.getKey());
            }
        }
        return validMoves;
    }

    /**
     * This method checks if the move is valid
     *
     * @param c    the controller of the game
     * @param newY the y coordinate of the car
     * @param newX the x coordinate of the car
     * @return true if the move is valid, false otherwise
     */
    private boolean isValidMove(Controller c, int newY, int newX) {
        for (Controller controller : controllers) {
            if (!(controller.equals(c)) && controller.getCarCoordinates()[0] == newY && controller.getCarCoordinates()[1] == newX) {
                return false;
            }
        }
        return newY >= 0 && newY < c.getRaceTrack().getRows() && newX >= 0
                && newX < c.getRaceTrack().getColumns() && !(c.getRaceTrack().getTrack()[newY][newX].equals("*"));
    }

}
