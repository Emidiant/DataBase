package entity;

import java.sql.Date;

public class Game {

    private int idGame;
    private int idDeveloperCompany;
    private int idPlatform;
    private int idPublisher;
    private String name;
    private int metacritic;
    private byte multiplayer;
    private int pegi;
    private int cost;
    private int userRating;
    private Date releaseDate;

    public Game() {

    }

    /*public Game(Game game){
        this.idGame = game.getIdGame();
        this.idDeveloperCompany = game.getIdDeveloperCompany();
        this.idPlatform = game.getIdPlatform();
        this.name = game.getName();
        this.metacritic = game.getMetacritic();
        this. multiplayer = game.getMultiplayer();
        this.pegi = game.getPegi();
        this.cost = game.getCost();
        this.userRating = game.getUserRating();
        this.releaseDate = game.getReleaseDate();
    }*/

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdDeveloperCompany() {
        return idDeveloperCompany;
    }

    public void setIdDeveloperCompany(int idDeveloperCompany) {
        this.idDeveloperCompany = idDeveloperCompany;
    }

    public int getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(int idPlatform) {
        this.idPlatform = idPlatform;
    }

    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public byte getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(byte multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (idGame != game.idGame) return false;
        if (idDeveloperCompany != game.idDeveloperCompany) return false;
        if (idPlatform != game.idPlatform) return false;
        if (idPublisher != game.idPublisher) return false;
        if (metacritic != game.metacritic) return false;
        if (multiplayer != game.multiplayer) return false;
        if (pegi != game.pegi) return false;
        if (cost != game.cost) return false;
        if (userRating != game.userRating) return false;
        if (name != null ? !name.equals(game.name) : game.name != null) return false;
        return releaseDate != null ? releaseDate.equals(game.releaseDate) : game.releaseDate == null;
    }

    @Override
    public int hashCode() {
        int result = idGame;
        result = 31 * result + idDeveloperCompany;
        result = 31 * result + idPlatform;
        result = 31 * result + idPublisher;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + metacritic;
        result = 31 * result + (int) multiplayer;
        result = 31 * result + pegi;
        result = 31 * result + cost;
        result = 31 * result + userRating;
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "idGame=" + idGame +
                ", idDeveloperCompany=" + idDeveloperCompany +
                ", idPlatform=" + idPlatform +
                ", idPublisher=" + idPublisher +
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