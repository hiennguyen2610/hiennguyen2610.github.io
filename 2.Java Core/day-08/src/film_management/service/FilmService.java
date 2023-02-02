package film_management.service;

import film_management.model.Movie;
import film_management.model.Serial;
import film_management.repository.FilmRepository;

public class FilmService {
    FilmRepository filmRepository = new FilmRepository();
    Movie movie = new Movie();
    Serial serial = new Serial();

    public void findByTitle(String title) {
        int count = 0;
        for (Movie movie : filmRepository.findMovie()) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(movie);
                count++;
            }
        }

        for (Serial serial : filmRepository.findSerial()) {
            if (serial.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(serial);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("\nKhông có phim có title là: " + title);
        }
    }

    public void showFilm() {
        for (Movie movie : filmRepository.findMovie()) {
            System.out.println(movie);
        }
        for (Serial serial : filmRepository.findSerial()) {
            System.out.println(serial);
        }
    }
}
