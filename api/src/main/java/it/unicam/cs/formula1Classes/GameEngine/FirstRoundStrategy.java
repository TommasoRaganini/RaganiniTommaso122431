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

package it.unicam.cs.formula1Classes.GameEngine;

import it.unicam.cs.formula1Classes.JavafxView.GameUIUpdater;
import it.unicam.cs.formula1Classes.Player.Directions;
import it.unicam.cs.formula1Classes.Player.Player;
import it.unicam.cs.formula1Classes.Track.IRaceTrack;

import java.util.List;

public class FirstRoundStrategy implements GameStrategy {
    @Override
    public void playRound(Player player, GameUIUpdater updater, IRaceTrack track, IChecker checker,Player[] players) {
        // Logica specifica per il primo round
        updater.updateMovesChoiceBox(List.of(Directions.RIGHT));
        player.move(List.of(Directions.RIGHT), updater);
        updater.updateTrackUI(track.getTrack(), players);
    }
}