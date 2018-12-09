package entity;

public class DeveloperCompany {

    private int idDeveloperCompany;
    private String country;
    private String name;

    public DeveloperCompany(){

    }

    public int getIdDeveloperCompany() {
        return idDeveloperCompany;
    }

    public void setIdDeveloperCompany(int idDeveloperCompany) {
        this.idDeveloperCompany = idDeveloperCompany;
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

        DeveloperCompany that = (DeveloperCompany) o;

        if (idDeveloperCompany != that.idDeveloperCompany) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = idDeveloperCompany;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeveloperCompany{" +
                "idDeveloperCompany=" + idDeveloperCompany +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
