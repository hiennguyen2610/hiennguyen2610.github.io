package film_management;

import film_management.controller.FilmController;

public class Main {
    public static void main(String[] args) {
        FilmController filmController = new FilmController();
        filmController.run();
    }
}
