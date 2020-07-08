package com.github.wojtechm.ox;

// TODO find better name for this class
public class InitializeGame implements GameState {

    private final Settings settings;
    private final Players players;

    public InitializeGame(Settings settings, Players players) {
        this.settings = settings;
        this.players = players;
    }

    @Override
    public GameState update() {
        Board board = new Board(settings.width, settings.height);
        return new Printer(board, players, settings);
    }
}
