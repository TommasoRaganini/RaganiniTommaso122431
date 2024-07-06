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

import it.unicam.cs.formula1Classes.Player.DirectionVector;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Velocity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VelocityTest {

    @Test
    void getVelocity() {
        Velocity v = new Velocity();
        v.setModule(1, 1);
        assertEquals(1, v.getModule()[0]);
        assertEquals(1, v.getModule()[1]);
        assertEquals(Math.sqrt(2), v.getVelocity());
    }


    @Test
    void updateModule() {
        DirectionVector vector = new Velocity();
        vector.updateModule(Directions.UP);
        assertEquals(-1, vector.getModule()[0]);
        assertEquals(0, vector.getModule()[1]);
        vector.updateModule(Directions.UP_RIGHT);
        assertEquals(-2, vector.getModule()[0]);
        assertEquals(1, vector.getModule()[1]);
        vector.updateModule(Directions.DOWN_LEFT);
        assertEquals(-1, vector.getModule()[0]);
        assertEquals(0, vector.getModule()[1]);

    }
    @Test
    void updateModule2() {
        Velocity v = new Velocity();
        v.setModule(1, 1);
        v.updateModule(Directions.UP);
        assertEquals(0, v.getModule()[0]);
        assertEquals(1, v.getModule()[1]);
    }

    @Test
    void getModule() {
        Velocity vector = new Velocity();
        Assertions.assertEquals(0, vector.getModule()[0]);
    }

    @Test
    void setModule() {
        Velocity vector = new Velocity();
        vector.setModule(1, 1);
        assertEquals(1, vector.getModule()[0]);
    }

}