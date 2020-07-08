package com.github.wojtechm.ox;

public class Printer implements GameState {

    private final Board board;
    private final Players players;
    private final Settings settings;

    public Printer(Board board, Players players, Settings settings) {
        this.board = board;
        this.players = players;
        this.settings = settings;
    }

    @Override
    public PlayerRound update() {
        System.out.printf("Player %s turn\n", players.getCurrentPlayerName());
        System.out.println("~".repeat(settings.width));
        System.out.println(board);
        System.out.println("~".repeat(settings.width));
        return new PlayerRound(players, board, settings);
    }
}
