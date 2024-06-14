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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FIleIOtrack {


    public static List<String> leggiFile() {
        List<String> lines = new ArrayList<>();
        try {
            System.out.println("Reading file from: " + Paths.get("api/src/main/resources/track.txt").toAbsolutePath());
            lines = Files.readAllLines(Paths.get("api/src/main/resources/track.txt"));
            System.out.println("File read successfully. Number of lines: " + lines.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String[][] generateTrack() {
        List<String> lines = leggiFile();
        String[][] track = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            track[i] = lines.get(i).split(" ");
        }
        return track;
    }

}


