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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
/**
 * This class reads the files that are needed for generating the track and the players
 */
public class FIleIOtrack {

    /**
     * This method reads a file and returns a list of strings
     *
     * @param path String that specifies the path of the file
     * @return List of strings
     * @throws Exception if the file is not found or if there is an error while reading it
     */
    public List<String> readFile(String path) throws Exception {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + path + ".");
            }
            return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error while reading the file: " + e.getMessage());
        }

    }

    /**
     * This method returns the number of players
     * from the file giocatoriBot.txt
     *
     * @return int
     */
    public int getPlayersNumber() {
        List<String> lines;
        try {
            lines = readFile("giocatoriBot.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Integer.parseInt(lines.getFirst());
    }

}


