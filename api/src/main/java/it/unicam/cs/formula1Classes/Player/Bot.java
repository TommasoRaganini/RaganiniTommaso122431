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

import it.unicam.cs.formula1Classes.JavafxView.GameUIUpdater;

import java.util.List;
import java.util.Random;

/**
 * This class represents the bot player
 */
public class Bot extends Player {
    private final Random random;
    private static int idBot = 1;

    public Bot(Car car) {
        super(car, idBot++);
        this.random = new Random();
    }

    public Car getCar() {
        return super.getCar();
    }

    @Override
    public void move(List<Directions> moves, GameUIUpdater updater) {
        if(checkAllowedMoves(moves))
            return;
        Directions[] directions = moves.toArray(new Directions[0]);
        Directions randomDirection = directions[random.nextInt(directions.length)];
        super.getCar().move(randomDirection);
    }
    public void move(List<Directions> moves){
        if(moves.isEmpty()) {
            super.getCar().getVector().setModule(0, 0);
            return;
        }
        Directions[] directions = moves.toArray(new Directions[0]);
        Directions randomDirection = directions[random.nextInt(directions.length)];
        super.getCar().move(randomDirection);
    }

    @Override
    public String toString() {
        return "Bot" + getPlayerId();
    }


}
