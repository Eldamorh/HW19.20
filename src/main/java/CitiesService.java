import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitiesService {

    static void addCity(City city, Connection connection) throws SQLException {
        String sql = "INSERT INTO cities VALUES('" + city.getId() + "', '" + city.getName() + "');";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    static List<String> getCities(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        List<String> cities = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM cities");
        while (resultSet.next()) {
            cities.add(resultSet.getString(2));
        }
        return cities;
    }
}
