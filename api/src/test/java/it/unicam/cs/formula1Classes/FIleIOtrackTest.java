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

import it.unicam.cs.formula1Classes.Track.FIleIOtrack;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class FIleIOtrackTest {

    @Test
    void readFile() throws Exception {
        FIleIOtrack fIleIOtrack = new FIleIOtrack();
        List<String> lines = fIleIOtrack.readFile("track.txt");
        assertNotNull(lines);
        // Verifica che il file non sia vuoto
        assertFalse(lines.isEmpty(), "Il file non dovrebbe essere vuoto.");
      //  lines.forEach(System.out::println);
        assertTrue(lines.contains("*************************" +
                "*******************************************************"));
        assertTrue(lines.contains("******ppppppppppppppppppppppppppppppp" +
                "FSppppppppppppppppppppppppppppppppppp******"));

    }

    @Test
    void numPlayers() {
        FIleIOtrack fIleIOtrack = new FIleIOtrack();
        int i = fIleIOtrack.getPlayersNumber();
        assertEquals(2, i);
    }




}