package constant;

public enum Level {
    GS_TS("Giáo sư - Tiến sĩ"),
    PGS_TS("Phó Giáo sư - Tiến sĩ"),
    GV("Giảng viên chính"),
    TS("Thạc sĩ");

    public String value;

    Level(String value) {
        this.value = value;
    }
}
