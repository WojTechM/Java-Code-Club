package com.github.wojtechm.recursivebacktracker;

import java.util.*;
import java.util.function.Function;

public class MazeGenerator {

    private final int width;
    private final int height;

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
//        x * width + y
    }

    public Maze generate() {
        Map<Point, Cell> cells = getPointCellMap();
        Stack<Cell> stack = getCellsStack(cells);
        demolishWallsRandomly(cells, stack);

        return new Maze(width, height, cells);
    }

    private Map<Point, Cell> getPointCellMap() {
        Map<Point, Cell> cells = new HashMap<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Point point = new Point(x, y);
                cells.put(point, new Cell(point));
            }
        }
        return cells;
    }

    private Stack<Cell> getCellsStack(Map<Point, Cell> cells) {
        Stack<Cell> stack = new Stack<>();
        Cell item = cells.get(new Point(0, 0));
        item.markAsVisited();
        stack.push(item);
        return stack;
    }

    private void demolishWallsRandomly(Map<Point, Cell> cells, Stack<Cell> stack) {
        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            if (hasUnvisitedNeighbours(cells, current)) {
                stack.push(current);
                Cell randomNeighbour = getRandomUnvisitedNeighbour(cells, current);
                removeWallsBetween(current, randomNeighbour);
                randomNeighbour.markAsVisited();
                stack.push(randomNeighbour);
            }
        }
    }

    private boolean hasUnvisitedNeighbours(Map<Point, Cell> cells, Cell cell) {
        if (isNeighbourUnvisited(cells, cell.point.onTop())) return true;
        if (isNeighbourUnvisited(cells, cell.point.onDown())) return true;
        if (isNeighbourUnvisited(cells, cell.point.onLeft())) return true;
        return isNeighbourUnvisited(cells, cell.point.onRight());
    }

    private boolean isNeighbourUnvisited(Map<Point, Cell> cells, Point point) {
        Cell topNeighbour = cells.get(point);
        return topNeighbour != null && !topNeighbour.wasVisited();
    }

    private Cell getRandomUnvisitedNeighbour(Map<Point, Cell> cells, Cell cell) {
//        A bit easier to understand, but also a bit less optimal solution proposed by Adam Sz. Still great idea!
//        List<Cell> neighbours = new LinkedList<>();
//        Cell neighbour = getUnvisitedNeighbour(cells, cell.point.onTop());
//        if (neighbour != null) neighbours.add(neighbour);
//        neighbour = getUnvisitedNeighbour(cells, cell.point.onRight());
//        if (neighbour != null) neighbours.add(neighbour);
//        neighbour = getUnvisitedNeighbour(cells, cell.point.onDown());
//        if (neighbour != null) neighbours.add(neighbour);
//        neighbour = getUnvisitedNeighbour(cells, cell.point.onLeft());
//        if (neighbour != null) neighbours.add(neighbour);
//        if (neighbours.isEmpty())
//            throw new IllegalArgumentException("No unvisited neighbours :(");
//        return neighbours.get(ThreadLocalRandom.current().nextInt(neighbours.size()));

        List<Function<Point, Point>> possiblePoints = new LinkedList<>();
        possiblePoints.add(Point::onTop);
        possiblePoints.add(Point::onRight);
        possiblePoints.add(Point::onLeft);
        possiblePoints.add(Point::onDown);
        Collections.shuffle(possiblePoints);
        for (Function<Point, Point> possiblePoint : possiblePoints) {
            Point neighbourPosition = possiblePoint.apply(cell.point);
            Cell neighbour = getUnvisitedNeighbour(cells, neighbourPosition);
            if (neighbour != null) return neighbour;
        }
        throw new IllegalArgumentException("No unvisited neighbours :(");
    }

    private Cell getUnvisitedNeighbour(Map<Point, Cell> cells, Point point) {
        Cell neighbour = cells.get(point);
        if (neighbour != null && !neighbour.wasVisited())
            return neighbour;
        return null;
    }

    private void removeWallsBetween(Cell cell1, Cell cell2) {
        if (isAbove(cell1, cell2)) {
            cell1.demolishDownWall();
            cell2.demolishTopWall();
            return;
        }
        if (isBelow(cell1, cell2)) {
            cell1.demolishTopWall();
            cell2.demolishDownWall();
            return;
        }
        if (isOnLeft(cell1, cell2)) {
            cell1.demolishRightWall();
            cell2.demolishLeftWall();
            return;
        }
        if (isOnRight(cell1, cell2)) {
            cell1.demolishLeftWall();
            cell2.demolishRightWall();
            return;
        }
        throw new IllegalArgumentException("Cells are not connected :(");
    }

    private boolean isAbove(Cell cell1, Cell cell2) {
        return cell1.point.Y == cell2.point.Y - 1;
    }

    private boolean isBelow(Cell cell1, Cell cell2) {
        return cell1.point.Y == cell2.point.Y + 1;
    }

    private boolean isOnLeft(Cell cell1, Cell cell2) {
        return cell1.point.X == cell2.point.X - 1;
    }

    private boolean isOnRight(Cell cell1, Cell cell2) {
        return cell1.point.X == cell2.point.X + 1;
    }
}
