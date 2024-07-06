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
import it.unicam.cs.formula1Classes.Player.Bot;
import it.unicam.cs.formula1Classes.Player.Car;
import it.unicam.cs.formula1Classes.Player.Controller;
import it.unicam.cs.formula1Classes.Player.Directions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCheckerTest {

    @Test
    void checkWin() {
        Controller c = new Controller(new Bot(new Car(5,30)));
        GameChecker g = new GameChecker(new Controller[]{c});
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        assertFalse(g.checkWin(c));
        c.getCar().move(Directions.UP_RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        assertTrue(g.checkWin(c));

    }

    @Test
    void getValidMoves() {
        Controller c = new Controller(new Bot(new Car(5,30)));
        GameChecker g = new GameChecker(new Controller[]{c});
        assertEquals(9,g.getValidMoves(c).size());
        c.getCar().move(Directions.DOWN_RIGHT);
        assertEquals(3,g.getValidMoves(c).size());
        c.getCar().move(Directions.UP_RIGHT);
        assertEquals(6,g.getValidMoves(c).size());
    }
}