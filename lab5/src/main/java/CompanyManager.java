import java.sql.*;

public class CompanyManager {
    final String url = "";
    final String login = "root";
    final String pass = "78u78u9U!";

    private Connection connection;

    public CompanyManager() {
        try{
            connection = DriverManager.getConnection(url,login,pass);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void addTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate
                ("CREATE TABLE companies(id INT(15) PRIMARY KEY," +
                        " workersCount INT(15),capitalization INT(32),name VARCHAR (15), location VARCHAR (15);");
    }
    public void removeTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE companies");

    }
    public void addCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO companies VALUES(?,?,?,?,?);");
        preparedStatement.setInt(1,company.getId());
        preparedStatement.setInt(2,company.getWorkersCount());
        preparedStatement.setLong(3,company.getCapitalization());
        preparedStatement.setString(4,company.getName());
        preparedStatement.setString(5,company.getLocation());
        preparedStatement.executeUpdate();
    }
    public void removeCompany(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM companies WHERE id = ?;");
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}
