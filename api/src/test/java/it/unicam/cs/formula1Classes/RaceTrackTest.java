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
import it.unicam.cs.formula1Classes.Track.RaceTrack;
import it.unicam.cs.formula1Classes.Player.Position;
import it.unicam.cs.formula1Classes.Track.TrackGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTrackTest {

    @Test
    void getTrackPosition() {
        RaceTrack raceTrack = new RaceTrack();
        assertEquals("*",raceTrack.getTrackPosition(0,0));
    }

    @Test
    void setTrackPosition() {
        RaceTrack raceTrack = new RaceTrack();
        raceTrack.setTrackPosition(0,0,"*");
        assertEquals("*",raceTrack.getTrackPosition(0,0));
    }


    @Test
    void getTrack() {
        TrackGenerator trackGenerator = new TrackGenerator();
        RaceTrack raceTrack = new RaceTrack();
        String[][] track = trackGenerator.generateTrack();
        for(int i = 0; i < track.length; i++){
            for(int j = 0; j < track[i].length; j++){
                assertEquals(track[i][j],raceTrack.getTrackPosition(i,j));
            }
        }
        assertEquals(25,raceTrack.getRows());
    }

    @Test
    void getStartAndFinishLine() {
        RaceTrack raceTrack = new RaceTrack();
        assertEquals(5,raceTrack.getStartAndFinishLine("S").size());
        assertEquals(5,raceTrack.getStartAndFinishLine("F").size());
        assertEquals(5,raceTrack.getStartLine().size());
     for(Position p : raceTrack.getStartLine()){
         System.out.println(p.toString());
     }
     for (Position p : raceTrack.getFinishLine()){
         System.out.println(p.toString());
     }

    }
}