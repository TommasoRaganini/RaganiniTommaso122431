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
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.RaceTrack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCheckerTest {

    @Test
    void checkWin() {
        Player c = new Bot(new Car(9,5));
        GameChecker g = new GameChecker(new Player[]{c});
        RaceTrack track= new RaceTrack();
        c.getCar().move(Directions.UP_RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        g.checkWin(c,track,2);
        c.getCar().move(Directions.UP_RIGHT);
        g.checkWin(c,track,3);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.DOWN_RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        assertFalse(g.checkWin(c,track,15));
        c.getCar().move(Directions.DOWN_RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        System.out.println(c.getCar().getCoordinates()[0]+" "+c.getCar().getCoordinates()[1]);
        c.getCar().move(Directions.RIGHT);
        assertTrue(g.checkWin(c,track,20));
    }

    @Test
    void getValidMoves() {
        Player c = new Bot(new Car(5,30));
        RaceTrack track= new RaceTrack();
        GameChecker g = new GameChecker(new Player[]{c});
        assertEquals(9,g.getValidMoves(c,track).size());
        c.getCar().move(Directions.DOWN_RIGHT);
        assertEquals(3,g.getValidMoves(c,track).size());
        c.getCar().move(Directions.UP_RIGHT);
        assertEquals(6,g.getValidMoves(c,track).size());
    }
}