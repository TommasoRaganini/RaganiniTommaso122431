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

import java.util.List;
import java.util.Random;
/**
 * This class represents the bot player
 */
public class Bot implements Player {
    private final Car car;
    private final Random random;
    private static int id = 1;
    private final int botId;


    public Bot(Car car) {
        this.car = car;
        this.random = new Random();
        this.botId = id++;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void move(List<Directions> moves) {
        Directions[] directions = moves.toArray(new Directions[0]);
        Directions randomDirection = directions[random.nextInt(directions.length)];
        System.out.println("Bot"+botId+" moved " + randomDirection);
        this.car.move(randomDirection);
    }

    @Override
    public String toString() {
        return "Bot"+botId;
    }

}
