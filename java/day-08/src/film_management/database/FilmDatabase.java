package film_management.database;

import film_management.model.Movie;
import film_management.model.Serial;

public class FilmDatabase {
    public static Movie[] movie = {
            new Movie(1, "Iron Man 1", "Hành động", "Jon Favreau", 2008, 100),
            new Movie(2, "Captain America", "Hành động", "Joe Johnston", 2011, 120),
            new Movie(3, "Thor 1", "Hành động", "Kenneth Branagh", 2011, 111),
            new Movie(4, "Tôi thấy hoa vàng trên cỏ xanh", "Tình cảm", "Viktor Vũ", 2016, 95),

    };
    public static Serial[] serial = {
            new Serial(5, "Super Girl", "Hành động", "Paul Karasik", 2010, 20, 45),
            new Serial(6, "The Flash", "Viễn tưởng", "Dan Wilken", 2020, 30, 55),
            new Serial(7, "Gotham", "Hành Động", "Felicia Livingston", 2018, 40, 33),
            new Serial(8, "Tom and Jerry", "Cartoon", "Jame", 1990, 250, 24),
    };
}