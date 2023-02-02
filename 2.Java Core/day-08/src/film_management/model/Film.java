package film_management.model;

public class Film {
    private int id;
    private String title;
    private String category;
    private String director;
    private int debut;

    public Film() {
    }

    public Film(int id, String title, String category, String director, int debut) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.debut = debut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", debut=" + debut +
                '}';
    }
}
