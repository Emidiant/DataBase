package entity;

public class Platform {

    private int idPlatform;
    private String name;

    public Platform(){

    }

    public int getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(int idPlatform) {
        this.idPlatform = idPlatform;
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

        Platform platform = (Platform) o;

        if (idPlatform != platform.idPlatform) return false;
        return name != null ? name.equals(platform.name) : platform.name == null;
    }

    @Override
    public int hashCode() {
        int result = idPlatform;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "idPlatform=" + idPlatform +
                ", name='" + name + '\'' +
                '}';
    }
}
