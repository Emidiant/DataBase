package entity;

public class CustomerGame {

    private int idGame;
    private int idCustomer;

    public CustomerGame(){

    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerGame that = (CustomerGame) o;

        if (idGame != that.idGame) return false;
        return idCustomer == that.idCustomer;
    }

    @Override
    public int hashCode() {
        int result = idGame;
        result = 31 * result + idCustomer;
        return result;
    }

    @Override
    public String toString() {
        return "CustomerGame{" +
                "idGame=" + idGame +
                ", idCustomer=" + idCustomer +
                '}';
    }
}
