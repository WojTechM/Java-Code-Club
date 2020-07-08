package com.github.wojtechm.ox;

public class OX {

    /*

    0, 1, 2
    3, 4, 5
    6, 7, 8

    start
        |
    ustawienia
        |
    kreacjaGraczy
        |
    inicjalizacjaGry
    |     |
    |     drukarz
    |     |
    |     turaGraczaAktualnego (prośba o wejście z konsoli)
    |         \       /
    |           sędzia -> zmianaGraczaAktualnego -> drukarz
    |     |
     wynikRozgrywki
        |
    koniec
     */

    public static void main(String[] args) {
        GameState game = new StartGame();
        while (true) { // do while?
            try {
                game = game.update();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
