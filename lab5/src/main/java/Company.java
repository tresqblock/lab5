import java.util.Objects;

public class Company {
    private int id;
    private int workersCount;
    private long capitalization;
    private String name;
    private String location;

    public Company(int id, int workersCount, long capitalization, String name, String location) {
        this.id = id;
        this.workersCount = workersCount;
        this.capitalization = capitalization;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkersCount() {
        return workersCount;
    }

    public void setWorkersCount(int workersCount) {
        this.workersCount = workersCount;
    }

    public long getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(long capitalization) {
        this.capitalization = capitalization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return workersCount == company.workersCount && capitalization == company.capitalization && Objects.equals(name, company.name) && Objects.equals(location, company.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workersCount, capitalization, name, location);
    }

    @Override
    public String toString() {
        return "Company{" +
                "workersCount=" + workersCount +
                ", capitalization=" + capitalization +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
