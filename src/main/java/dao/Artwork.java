package dao;

public class Artwork {
    private String imgPath;
    private String name;
    private Integer year;
    private Artist autor;
    private Museum museum;
    private String description;

    private String wiki;

    public Artwork(String imgPath, String name, Integer year, Artist autor, Museum museum, String description, String wiki) {
        this.imgPath = imgPath;
        this.name = name;
        this.year = year;
        this.autor = autor;
        this.museum = museum;
        this.description = description;
        this.wiki = wiki;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Artist getAutor() {
        return autor;
    }

    public void setAutor(Artist autor) {
        this.autor = autor;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
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
        return "Artwork{" +
                "imgPath='" + imgPath + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", autor=" + autor +
                ", museum=" + museum +
                ", description='" + description + '\'' +
                ", wiki='" + wiki + '\'' +
                '}';
    }
}
