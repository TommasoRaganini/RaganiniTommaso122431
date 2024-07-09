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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @Test
    void move() {
        Bot bot = new Bot(new Car(4, 44));
        Player[] players = new Player[]{bot};
        GameChecker gameChecker = new GameChecker(players);
        RaceTrack track = new RaceTrack();
        List<Directions> moves = gameChecker.getValidMoves(players[0],track);
        for(Directions d : moves){
            System.out.println(d);
        }
        System.out.println(" ");
        bot.move(moves);
        Bot bot2 = new Bot(new Car(2, 44));
        Player[] players2 = new Player[]{bot2};
        RaceTrack track2 = new RaceTrack();
        GameChecker gameChecker2 = new GameChecker(players2);
        List<Directions> moves2 = gameChecker2.getValidMoves(players2[0],track2);
        for(Directions d : moves2){
            System.out.println(d);
        }
        bot2.move(moves2);
    }

    @Test
    void testToString() {
        Bot bot = new Bot(new Car(4, 44));
        assertEquals("Bot1", bot.toString());
        Bot bot2 = new Bot(new Car(2, 44));
        assertEquals("Bot2", bot2.toString());
        assertEquals("Bot1", bot.toString());
        Bot bot3 = new Bot(new Car(3, 44));
        assertEquals("Bot3", bot3.toString());
        assertEquals("Bot2", bot2.toString());
        assertEquals("Bot1", bot.toString());
    }
}