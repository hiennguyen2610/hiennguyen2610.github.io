package film_management.model;

public class Movie extends Film {
    private int time;

    public Movie() {
    }

    public Movie(int id, String title, String category, String director, int debut, int time) {
        super(id, title, category, director, debut);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", derector='" + getDirector() + '\'' +
                ", debut=" + getDebut() +
                ", time=" + time +
                '}';
    }
}
