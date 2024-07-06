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

package it.unicam.cs.formula1Classes.Track;

import java.util.List;

public class TrackGenerator {

    private static final FIleIOtrack f= new FIleIOtrack();

    /**
     * This method generates the track from the file read by the method readFile
     *
     * @return String[][]
     */
    public static String[][] generateTrack() {
        List<String> lines;
        try {
            lines = f.readFile("track.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int[] RandC = countRowsAndColumns(lines);
        String[][] track = new String[RandC[0]][RandC[1]];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                track[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return track;
    }
    /**
     * This method counts the number of rows and columns of the track
     *
     * @param lines List<String>
     * @return int[]
     */
    public static int[] countRowsAndColumns(List<String> lines) {
        int rows = lines.size();
        int columns = lines.getFirst().length();
        return new int[]{rows, columns};
    }




}
