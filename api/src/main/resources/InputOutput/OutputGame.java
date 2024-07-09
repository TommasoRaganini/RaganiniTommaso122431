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

package InputOutput;

import it.unicam.cs.formula1Classes.Track.RaceTrack;
import it.unicam.cs.formula1Classes.Player.Player;

/**
 * This class is responsible for handling the output of the game
 */
public class OutputGame {
    /**
     * This method prints the track of the game
     *
     * @param raceTrack the track of the game
     * @param players the players of the game
     */
    public static void printTrack(RaceTrack raceTrack, Player[] players, int round) {
        for (int i = 0; i < raceTrack.getRows(); i++) {
            for (int j = 0; j < raceTrack.getColumns(); j++) {
                if (CarPos(players, i, j)) {
                    System.out.print("C");
                } else {
                    System.out.print(raceTrack.getTrack()[i][j]);
                }
            }
            System.out.println();
        }
        printRound(round);
    }
    /**
     * This method checks if a car is in a certain position
     *
     * @param players the players of the game
     * @param i the row of the position
     * @param j the column of the position
     * @return true if a car is in the position, false otherwise
     */
    private static boolean CarPos(Player[] players, int i, int j) {
        for (Player p : players) {
            if (p.getCarCoordinates()[0] == i && p.getCarCoordinates()[1] == j) {
                return true;
            }
        }
        return false;
    }
    /**
     * This method prints the winner of the game
     *
     * @param player the player that won the game
     */
    public static void printWinner(Player player) {
        System.out.println(player.toString() + " won!");
    }
    /**
     * This method prints the round of the game
     *
     * @param round the round of the game
     */
    private static void printRound(int round) {
        System.out.println("Round " + round);
        System.out.println();
    }


}
