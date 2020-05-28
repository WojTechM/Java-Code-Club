package com.github.wojtechm.snake;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InputProvider {

    private final Scanner scanner;

    public InputProvider(InputStream in) {
        scanner = new Scanner(in);
    }

    public Direction getDirection(Direction currentDirection) {
        switch (currentDirection) {
            case UP:
                return getOneOfDirections(Direction.LEFT, Direction.UP, Direction.RIGHT);
            case RIGHT:
                return getOneOfDirections(Direction.UP, Direction.RIGHT, Direction.DOWN);
            case DOWN:
                return getOneOfDirections(Direction.LEFT, Direction.DOWN, Direction.RIGHT);
            case LEFT:
                return getOneOfDirections(Direction.LEFT, Direction.UP, Direction.DOWN);
        }
        return Direction.NONE;
    }

    private Direction getOneOfDirections(Direction... directions) {
        printOptions(directions);
        while (true) {
            String input = scanner.nextLine();
            Direction matchingDir = findMatch(input, directions);
            if (matchingDir != null) {
                return matchingDir;
            }
        }
    }

    private Direction findMatch(String input, Direction[] directions) {
        for (Direction direction : directions) {
            if (direction.asKey.equals(input)) {
                return direction;
            }
        }
        return null;
    }

    private void printOptions(Direction[] directions) {
        System.out.println(Arrays.toString(directions));
    }
}
