import java.sql.*;
import java.util.Collection;

public class CityManager {
    final String url = "";
    final String login = "root";
    final String pass = "78u78u9U!";

    private Connection connection;

    public CityManager() {
        try{
            connection = DriverManager.getConnection(url,login,pass);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void close() throws SQLException {
        connection.close();
    }
    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE citys(id INT(15) PRIMARY KEY, name VARCHAR(15));");
        statement.executeUpdate("CREATE TABLE companysCity(cityId int(15),companyId int(15));");
    }

    public void dropTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE citys");
        statement.executeUpdate("DROP TABLE companysCity");
    }
    public void addCompaniesCity(Collection<Integer> collection, int cityId) throws SQLException {
        for (var c: collection) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO companysCity VALUES(?,?);");
            statement.setInt(1,c);
            statement.setInt(2,cityId);
            statement.executeUpdate();
        }
    }
    public void removeCompaniesCity(int cityId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM companysCity WHERE cityId = ?;");
        statement.setInt(1,cityId);
        statement.executeUpdate();
    }

    public void addCity(City city) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO citys VALUES(?,?);");
        statement.setInt(1,city.getId());
        statement.setString(2,city.getName());
        statement.execute();
        addCompaniesCity(city.getCompanies(),city.getId());
    }
    public void removeCity(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM citys WHERE id = ?;");
        statement.setInt(1,id);
        statement.execute();
        removeCompaniesCity(id);
    }


}
