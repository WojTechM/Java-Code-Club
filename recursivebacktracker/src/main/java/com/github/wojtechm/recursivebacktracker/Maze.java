package com.github.wojtechm.recursivebacktracker;

import java.util.Map;

public class Maze {

    private final int width;
    private final int height;
    private final Map<Point, Cell> cells;
    private static final String CLOSED_HORIZONTAL_WALL = "   ";
    private static final String OPENED_HORIZONTAL_WALL = " . ";

    public Maze(int width, int height, Map<Point, Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            printTop(sb, y);
            printMiddle(sb, y);
            printDown(sb, y);
        }
        return sb.toString();
    }

    private void printMiddle(StringBuilder sb, int y) {
        for (int x = 0; x < width; x++) {
            Cell cell = cells.get(new Point(x, y));
            String template = "%s.%s";
            sb.append(String.format(template, cell.isLeft() ? " " : ".", cell.isRight() ? " " : "."));
        }
        sb.append("\n");
    }

    private void printTop(StringBuilder sb, int y) {
        for (int x = 0; x < width; x++) {
            Cell cell = cells.get(new Point(x, y));
            if (cell.isTop()) {
                sb.append(CLOSED_HORIZONTAL_WALL);
            } else {
                sb.append(OPENED_HORIZONTAL_WALL);
            }
        }
        sb.append("\n");
    }

    private void printDown(StringBuilder sb, int y) {
        for (int x = 0; x < width; x++) {
            Cell cell = cells.get(new Point(x, y));
            if (cell.isDown()) {
                sb.append(CLOSED_HORIZONTAL_WALL);
            } else {
                sb.append(OPENED_HORIZONTAL_WALL);
            }
        }
        sb.append("\n");
    }
}
