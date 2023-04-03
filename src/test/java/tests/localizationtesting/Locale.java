package tests.localizationtesting;

public enum Locale {
    UA("Українська (Ukrainian)"),
    EN("English (англійська)"),
    RU("Русский (Russian)");
    private final String desc;

    Locale(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
