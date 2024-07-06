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

package it.unicam.cs.formula1Classes;

import it.unicam.cs.formula1Classes.GameEngine.GameChecker;
import it.unicam.cs.formula1Classes.InputOutput.InputPlayer;
import it.unicam.cs.formula1Classes.Player.Car;
import it.unicam.cs.formula1Classes.Player.Controller;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.HumanPlayer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputPlayerTest {

    @Test
    void getDirection() {
        String input = "UP_RIGHT\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputPlayer inputPlayer = new InputPlayer(in);
        Controller[] controllers = new Controller[]{new Controller(new HumanPlayer(new Car(2,44))),
                new Controller(new HumanPlayer(new Car(3,44)))};
        GameChecker gameChecker = new GameChecker(controllers);
        assertEquals(Directions.UP_RIGHT, inputPlayer.getDirection(gameChecker.getValidMoves(controllers[0])));
    }

    @Test
    void getNumberOfPlayers() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputPlayer inputPlayer = new InputPlayer(in);
        assertEquals(2, inputPlayer.getNumberOfPlayers());
    }
}