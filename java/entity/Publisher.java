package entity;

public class Publisher {

    private int idPublisher;
    private String country;
    private String name;

    public Publisher(){

    }

    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (idPublisher != publisher.idPublisher) return false;
        if (country != null ? !country.equals(publisher.country) : publisher.country != null) return false;
        return name != null ? name.equals(publisher.name) : publisher.name == null;
    }

    @Override
    public int hashCode() {
        int result = idPublisher;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "idPublisher=" + idPublisher +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
