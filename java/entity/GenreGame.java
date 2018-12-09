package entity;

public class GenreGame {

    private int idGame;
    private int idGenre;

    public GenreGame(){

    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreGame genreGame = (GenreGame) o;

        if (idGame != genreGame.idGame) return false;
        return idGenre == genreGame.idGenre;
    }

    @Override
    public int hashCode() {
        int result = idGame;
        result = 31 * result + idGenre;
        return result;
    }

    @Override
    public String toString() {
        return "GenreGame{" +
                "idGame=" + idGame +
                ", idGenre=" + idGenre +
                '}';
    }
}
