package entity;

public class Genre {

    private int idGenre;
    private String genreName;

    public Genre(){

    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (idGenre != genre.idGenre) return false;
        return genreName != null ? genreName.equals(genre.genreName) : genre.genreName == null;
    }

    @Override
    public int hashCode() {
        int result = idGenre;
        result = 31 * result + (genreName != null ? genreName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
