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

import it.unicam.cs.formula1Classes.Player.*;
import it.unicam.cs.formula1Classes.Track.IRaceTrack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * This class implements the IChecker interface and is responsible
 * for checking the  status of the game
 */
public class GameChecker implements IChecker {
    private final Player[] players;
    /**
     * The constructor of the class GameChecker
     * @param players the players playing the game
     */
    public GameChecker(Player[] players) {
        this.players = players;
    }

    /**
     * This method checks if the game is over
     *
     * @param p the player that is being checked
     * @return true if the game is over, false otherwise
     */
    public boolean checkWin(Player p, IRaceTrack track,int round) {
        if(round > 1){
            Position p1 = p.getCar().getPosition();
            Position p2 = p.getCar().getPath().get(p.getCar().getPath().size() - 2);

            return ResearchPath.searchPath(track.getTrack(), p1, p2, p);
        }
        return false;
    }

    /**
     * This method returns a list of valid moves for the car
     *
     * @param c one of the player playing the game
     * @return a list of valid moves for the car
     */
    public List<Directions> getValidMoves(Player c, IRaceTrack track) {
        List<Directions> validMoves = new ArrayList<>();
        int[] movementVector = c.getCar().getVector().getModule();
        int y = c.getCarCoordinates()[0];
        int x = c.getCarCoordinates()[1];

        for (Map.Entry<Directions, int[]> entry : DirectionVector.getMap().entrySet()) {
            int newY = y + entry.getValue()[0] + movementVector[0];
            int newX = x + entry.getValue()[1] + movementVector[1];
            if (isValidMove(c, track, newY, newX)) {
                validMoves.add(entry.getKey());
            }
        }
        return validMoves;
    }

    /**
     * This method checks if the move is valid
     *
     * @param p    the player that is being checked
     * @param newY the y coordinate of the car
     * @param newX the x coordinate of the car
     * @return true if the move is valid, false otherwise
     */
    private boolean isValidMove(Player p,IRaceTrack track, int newY, int newX) {
        for (Player player : players) {
            if (!(player.equals(p)) && player.getCarCoordinates()[0] == newY && player.getCarCoordinates()[1] == newX) {
                return false;
            }
        }
        return newY >= 0 && newY < track.getRows() && newX >= 0
                && newX < track.getColumns() && !(track.getTrack()[newY][newX].equals("*"));
    }

}
