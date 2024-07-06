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

package it.unicam.cs.formula1Classes.JavafxView;
import it.unicam.cs.formula1Classes.Player.Controller;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;

public record Util() {
    private static final double CELL_SIZE = 20;

    
    public static void drawTrack(String[][] trackMatrix, Pane pane) {
        pane.getChildren().clear(); // Pulisce il pane prima di disegnare il nuovo tracciato
         for (int i = 0; i < trackMatrix.length; i++) {
            for (int j = 0; j < trackMatrix[i].length; j++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setX(j * CELL_SIZE);
                cell.setY(i * CELL_SIZE);
                cell.setFill(getColorFromSymbol(trackMatrix[i][j]));
                pane.getChildren().add(cell);
            }
        }
    }
    private static Color getColorFromSymbol(String cell) {
        return switch (cell) {
            case "S" -> Color.GREEN;
            case "F" -> Color.RED;
            case "p" -> Color.GRAY;
            default -> Color.WHITE;
        };
    }
    public static void updateTrack(Controller[] controllers, String[][] trackMatrix, Pane pane) {
        drawTrack(trackMatrix, pane);
        for (Controller c : controllers) {
            int[] coordinates = c.getCarCoordinates();
            Text carText = new Text(coordinates[1] * CELL_SIZE, coordinates[0] * CELL_SIZE + CELL_SIZE / 2, "C");
            carText.setX(coordinates[1] * CELL_SIZE + CELL_SIZE / 4); // Centra il testo orizzontalmente nella cella
            carText.setY(coordinates[0] * CELL_SIZE + CELL_SIZE * 0.75); // Centra il testo verticalmente nella cella
            pane.getChildren().add(carText);
        }
    }



    /**
     * This method checks if a car is in a certain position
     *
     * @param controllers the controllers of the game
     * @param i the row of the position
     * @param j the column of the position
     * @return true if a car is in the position, false otherwise
     */
    private static boolean CarPos(Controller[] controllers, int i, int j) {
        for (Controller c : controllers) {
            if (c.getCarCoordinates()[0] == i && c.getCarCoordinates()[1] == j) {
                return true;
            }
        }
        return false;
    }

}
