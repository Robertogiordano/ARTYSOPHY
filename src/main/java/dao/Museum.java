package dao;

public class Museum {
    private String name;
    private String street;
    private Integer openingHour;
    private Integer closingHour;
    private String email;
    private String phone;
    private String description;
    private Double price;
    private String webpageUrl;

    private String wiki;
    private String googleMaps;


    public Museum(String name, String street, Integer openingHour, Integer closingHour, String email, String phone, String description, Double price, String webpageUrl, String wiki, String googleMaps) {
        this.name = name;
        this.street = street;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.price = price;
        this.webpageUrl = webpageUrl;
        this.wiki = wiki;
        this.googleMaps = googleMaps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(Integer openingHour) {
        this.openingHour = openingHour;
    }

    public Integer getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(Integer closingHour) {
        this.closingHour = closingHour;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getGoogleMaps() {
        return googleMaps;
    }

    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", openingHour=" + openingHour +
                ", closingHour=" + closingHour +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", webpageUrl='" + webpageUrl + '\'' +
                ", wiki='" + wiki + '\'' +
                ", googleMaps='" + googleMaps + '\'' +
                '}';
    }
}
