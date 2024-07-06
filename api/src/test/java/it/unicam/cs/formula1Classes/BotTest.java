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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    @Test
    void move() {
        Bot bot = new Bot(new Car(4, 44));
        Controller controller = new Controller(bot);
        GameChecker gameChecker = new GameChecker(new Controller[]{controller});
        List<Directions> moves = gameChecker.getValidMoves(controller);
        for(Directions d : moves){
            System.out.println(d);
        }
        bot.move(moves);
        Bot bot2 = new Bot(new Car(2, 44));
        Controller controller2 = new Controller(bot2);
        GameChecker gameChecker2 = new GameChecker(new Controller[]{controller2});
        List<Directions> moves2 = gameChecker2.getValidMoves(controller2);
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