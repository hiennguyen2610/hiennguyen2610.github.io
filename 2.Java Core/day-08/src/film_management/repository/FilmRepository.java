package film_management.repository;

import film_management.database.FilmDatabase;
import film_management.model.Serial;
import film_management.model.Movie;

public class FilmRepository {
    public Movie[] findMovie() {
        return FilmDatabase.movie;
    }

    public Serial[] findSerial() {
        return FilmDatabase.serial;
    }
}
