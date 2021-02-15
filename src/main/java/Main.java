import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:sqlite:C:\\Sqlite\\homeworks.db";

        Connection connection = DriverManager.getConnection(dbUrl);

        createDepartmentsTable(connection);

        CitiesService.addCity(new City("Харьков"), connection);
        CitiesService.addCity(new City("Киев"), connection);
        CitiesService.addCity(new City("Москва"), connection);
        CitiesService.addCity(new City("Лондон"), connection);

        ResultSet resultSet = CitiesService.getCities(connection);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2));
        }

        closeConnection(connection);
    }

    private static void createDepartmentsTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS cities(" +
                "id TEXT PRIMARY KEY," +
                "name TEXT UNIQUE);";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    private static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
