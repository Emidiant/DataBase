package entity;

import javafx.scene.control.Button;

import java.sql.Date;

public class GameViewTable {

    private int idGame;




    private String developerCompany;
    private String platform;
    private String publisher;
    private String name;
    private int metacritic;
    private String multiplayer;
    private int pegi;
    private int cost;
    private int userRating;
    private Date releaseDate;
    private Button button;


    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public GameViewTable() {

    }

    public String getDeveloperCompany() {
        return developerCompany;
    }

    public Button getButton() {
        return button;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getName() {
        return name;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public String getMultiplayer() {
        return multiplayer;
    }

    public int getPegi() {
        return pegi;
    }

    public int getCost() {
        return cost;
    }

    public int getUserRating() {
        return userRating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setDeveloperCompany(String developerCompany) {
        this.developerCompany = developerCompany;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public void setMultiplayer(String multiplayer) {
        this.multiplayer = multiplayer;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameViewTable that = (GameViewTable) o;

        if (metacritic != that.metacritic) return false;
        if (multiplayer != null ? !multiplayer.equals(that.multiplayer) : that.multiplayer != null) return false;
        if (pegi != that.pegi) return false;
        if (cost != that.cost) return false;
        if (userRating != that.userRating) return false;
        if (developerCompany != null ? !developerCompany.equals(that.developerCompany) : that.developerCompany != null)
            return false;
        if (platform != null ? !platform.equals(that.platform) : that.platform != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return releaseDate != null ? releaseDate.equals(that.releaseDate) : that.releaseDate == null;
    }

    @Override
    public int hashCode() {
        int result = developerCompany != null ? developerCompany.hashCode() : 0;
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + metacritic;
        result = 31 * result + (multiplayer != null ? multiplayer.hashCode() : 0);
        result = 31 * result + pegi;
        result = 31 * result + cost;
        result = 31 * result + userRating;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GameViewTable{" +
                "DeveloperCompany='" + developerCompany + '\'' +
                ", Platform='" + platform + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", name='" + name + '\'' +
                ", metacritic=" + metacritic +
                ", multiplayer=" + multiplayer +
                ", pegi=" + pegi +
                ", cost=" + cost +
                ", userRating=" + userRating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}