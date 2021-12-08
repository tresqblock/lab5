import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class City {
    private int id;
    private Collection<Integer> companies = new ArrayList<>();
    private String name;

    public City(int id, Collection<Integer> companies, String name) {
        this.id = id;
        this.companies = companies;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Integer> getCompanies() {
        return companies;
    }

    public void setCompanies(Collection<Integer> companies) {
        this.companies = companies;
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
        City city = (City) o;
        return Objects.equals(companies, city.companies) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companies, name);
    }

    @Override
    public String toString() {
        return "City{" +
                "companies=" + companies +
                ", name='" + name + '\'' +
                '}';
    }
}
