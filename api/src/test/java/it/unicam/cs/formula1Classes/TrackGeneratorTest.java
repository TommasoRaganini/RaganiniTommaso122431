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
import it.unicam.cs.formula1Classes.Track.TrackGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackGeneratorTest {
        @Test
    void generateTrack() {
        FIleIOtrack fIleIOtrack = new FIleIOtrack();
        TrackGenerator tr = new TrackGenerator();
        String[][] track = tr.generateTrack();
        assertTrue(track.length > 0, "The track should have at least one row.");
        assertTrue(track[0].length > 0, "The first row of the track should have at least one column.");
        assertTrue(track[0][0].contains("*"), "The first cell of the track should contain a '*'.");
        assertTrue(track[2][7].contains("p"), "The first cell of the track should contain a 'p'.");
        int count = 0;
        int d = 0;
        for(int i = 0; i < track.length; i++){
            d++;
            for(int j = 0; j < track[i].length; j++){
                count++;
            }
        }
        assertEquals(2000, count);
        assertEquals(25, d);
    }

    @Test
    void countRowsAndColumns() throws Exception {
        FIleIOtrack fIleIOtrack = new FIleIOtrack();
        TrackGenerator trackGenerator = new TrackGenerator();
        List<String> lines = fIleIOtrack.readFile("track.txt");
        int[] rowsAndColumns = trackGenerator.countRowsAndColumns(lines);
        assertEquals(25, rowsAndColumns[0]);
        assertEquals(80, rowsAndColumns[1]);
    }


}