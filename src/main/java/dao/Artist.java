package dao;

public class Artist {
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    private String description;

    private String wiki;

    public Artist(String name, Integer birthYear, Integer deathYear, String description, String wiki) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.description = description;
        this.wiki = wiki;
    }

    public Artist(String name, Integer birthYear, String description, String wiki) {
        this.name = name;
        this.birthYear = birthYear;
        this.description = description;
        this.wiki=wiki;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", description='" + description + '\'' +
                '}';
    }
}
