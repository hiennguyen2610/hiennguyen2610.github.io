package film_management.model;

public class Serial extends Film {
    private int episodeNum;
    private int avgTime;

    public Serial() {
    }

    public Serial(int id, String title, String category, String director, int debut, int episodeNum, int avgTime) {
        super(id, title, category, director, debut);
        this.episodeNum = episodeNum;
        this.avgTime = avgTime;
    }

    public int getEpisodeNum() {
        return episodeNum;
    }

    public void setEpisodeNum(int episodes) {
        this.episodeNum = episodes;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", derector='" + getDirector() + '\'' +
                ", debut=" + getDebut() +
                ", episodes=" + episodeNum +
                ", avgtime=" + avgTime +
                '}';
    }
}
