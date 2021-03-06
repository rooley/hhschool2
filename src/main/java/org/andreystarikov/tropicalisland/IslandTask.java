package org.andreystarikov.tropicalisland;

import org.andreystarikov.utils.StdIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrey on 07.10.2016.
 */
public class IslandTask {
    private TropicalIsland[] islands;

    private final int MAX_ISLAND_SIZE = 50;
    private final int MIN_ISLAND_SIZE = 1;
    private final int MAX_ISLAND_ALTITUDE = 1000;
    private final int MIN_ISLAND_ALTITUDE = 1;

    public static void main(String[] args) {
        IslandTask it = new IslandTask();
        it.readData();
        it.printResults();
    }

    private void readData() {
        int numberOfIslands;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            numberOfIslands = StdIn.readInt(reader);
            if (numberOfIslands > 0) {
                islands = new TropicalIsland[numberOfIslands];
                for (int i = 0; i < numberOfIslands; i++) {
                    int[] size = StdIn.readIntArray(reader, 2, MIN_ISLAND_SIZE, MAX_ISLAND_SIZE);
                    islands[i] = new TropicalIsland(size[0], size[1]);
                    int[][] cells = new int[size[0]][size[1]];
                    for (int j = 0; j < size[0]; j++) {
                        int[] line = StdIn.readIntArray(reader, size[1], MIN_ISLAND_ALTITUDE, MAX_ISLAND_ALTITUDE);
                        System.arraycopy(line, 0, cells[j], 0, size[1]);
                    }
                    islands[i].setCells(cells);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printResults() {
        for (TropicalIsland i : islands) {
//            i.printCells(); //Debug
            System.out.println(i.getVolume());
        }
    }
}
