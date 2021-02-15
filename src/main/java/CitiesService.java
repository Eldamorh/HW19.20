import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitiesService {
    private static List<City> cities = new ArrayList<>();


    static void addCity(City city, Connection connection) throws SQLException {
        cities.add(city);
        String sql = "INSERT INTO cities VALUES('" + city.getId() + "', '" + city.getName() + "');";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    static ResultSet getCities(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM cities;");
    }
}
