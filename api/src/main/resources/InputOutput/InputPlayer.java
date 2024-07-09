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

import it.unicam.cs.formula1Classes.Player.Directions;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
/**
 * This class is responsible for getting the input from the player
 */
public class InputPlayer {
    private final Scanner scanner;

    public InputPlayer() {
        this.scanner = new Scanner(System.in);
    }

    public InputPlayer(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }
    /**
     * This method gets the direction from the player
     * @param moves the list of moves allowed for the car
     * @return the direction chosen by the player
     */
   public Directions getDirection(List<Directions> moves) {
    while (true) {
        System.out.println("Enter one of the available directions");
        for(Directions direction : moves){
            System.out.println(direction);
        }
        String input = scanner.nextLine().toUpperCase();
        try {
            return Directions.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid direction. Please enter a valid direction.");
        }
    }
}
    public int getNumberOfPlayers() {
        while (true) {
            System.out.println("Enter the number of human players");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number.");
            }
        }
    }



}
