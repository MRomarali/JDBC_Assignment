package ECutb.OmarAli.data;

import static ECutb.OmarAli.data.Database.getConnection;

import ECutb.OmarAli.entity.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {

  private static final String INSERT =
      "INSERT INTO world.city (name, countryCode, district, population) VALUES(?,?,?,?)";

  private static final String FIND_BY_cityID =
      "SELECT * FROM world.city WHERE ID = ?";

  private static final String FIND_BY_NAME =
      "SELECT * FROM city WHERE name = ?";

  private static final String FIND_BY_countryCODE =
      "SELECT * FROM world.city WHERE countryCode = ?";

  private static final String FIND_BY_ALL =
      "SELECT * FROM world.city";

  private static final String UPDATE_CITY =
      "UPDATE world.city SET name = ?,countryCode = ?,district = ?,population = ? WHERE ID = ?";

  private static final String DELETE_CITY =
      "DELETE FROM world.city WHERE ID = ?";


  @Override
  public City findById(int id) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    City city = null;
    try {
      connection = getConnection();
      statement = create_findById(connection, id);
      resultSet = statement.executeQuery();
      while (resultSet.next()){
        city = new City(
            resultSet.getInt("ID"),
            resultSet.getString("Name"),
            resultSet.getString("CountryCode"),
            resultSet.getString("District"),
            resultSet.getInt("Population")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        if (resultSet != null){
          resultSet.close();
        }
        if (statement != null){
          statement.close();
        }
        if (connection != null){
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return city;

  }
  private PreparedStatement create_findById(Connection connection, int id) throws SQLException{
    PreparedStatement statement = connection.prepareStatement(FIND_BY_cityID);
    statement.setInt(1,id);
    return statement;
  }

  @Override
  public List<City> findByCode(String code) {
    List<City> cityList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = getConnection();
      statement = create_findByCode(connection, code);
      resultSet = statement.executeQuery();
      while (resultSet.next()){
        cityList.add(
            new City(
                resultSet.getInt("ID"),
                resultSet.getString("Name"),
                resultSet.getString("CountryCode"),
                resultSet.getString("District"),
                resultSet.getInt("Population")
            )
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        if (resultSet != null){
          resultSet.close();
        }
        if (statement != null){
          statement.close();
        }
        if (connection != null){
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cityList;
  }
  private PreparedStatement create_findByCode(Connection connection, String code) throws SQLException{
    PreparedStatement statement = connection.prepareStatement(FIND_BY_countryCODE);
    statement.setString(1,code);
    return statement;
  }

  @Override
  public List<City> findByName(String name) {
    List<City> cityList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = getConnection();
      statement = create_findByName(connection, name);
      resultSet = statement.executeQuery();
      while (resultSet.next()){
        cityList.add(
            new City(   resultSet.getInt("ID"),
                resultSet.getString("Name"),
                resultSet.getString("CountryCode"),
                resultSet.getString("District"),
                resultSet.getInt("Population")
            )
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        if (resultSet != null){
          resultSet.close();
        }
        if (statement != null){
          statement.close();
        }
        if (connection != null){
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return cityList;
  }

  private PreparedStatement create_findByName(Connection connection, String name) throws SQLException{
    PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
    statement.setString(1,name);
    return statement;
  }

  @Override
  public List<City> findAll() {
    List<City> cityList = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
     connection = getConnection();
     statement = connection.prepareStatement(FIND_BY_ALL);
     resultSet = statement.executeQuery();
      while (resultSet.next()){
        cityList.add(
            new City(
                resultSet.getInt("ID"),
                resultSet.getString("Name"),
                resultSet.getString("CountryCode"),
                resultSet.getString("District"),
                resultSet.getInt("Population")
            )
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
      }finally {
        try {
          if (resultSet != null){
            resultSet.close();
          }
          if (statement != null){
            statement.close();
          }
          if (connection != null){
            connection.close();
          }
  
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
    return cityList;

}

      @Override
  public City add(City city) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = getConnection();
      statement = connection.prepareStatement(INSERT, statement.RETURN_GENERATED_KEYS);
      statement.setString(1, city.getName());
      statement.setString(2, city.getCountryCode());
      statement.setString(3, city.getDistrict());
      statement.setObject(4, city.getPopulation());
      statement.execute();
      resultSet = statement.getGeneratedKeys();
      while (resultSet.next()){
        city = new City(
            resultSet.getInt(1),
            city.getName(),
            city.getCountryCode(),
            city.getDistrict(),
            city.getPopulation()
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        if (resultSet != null){
          resultSet.close();
        }
        if (statement != null){
          statement.close();
        }
        if (connection != null){
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return city;
  }

  @Override
  public City update(City city) {
    try(Connection connection = getConnection();
      PreparedStatement statement = connection.prepareStatement(UPDATE_CITY)) {
      statement.setString(1, city.getName());
      statement.setString(2, city.getCountryCode());
      statement.setString(3, city.getDistrict());
      statement.setObject(4, city.getPopulation());
      statement.setInt(5, city.getCityId());
      statement.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return city;
  }

  @Override
  public int delete(City city) {
    int deletedRows = 0;
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_CITY)
    ) {
      statement.setInt(1, city.getCityId());
      deletedRows = statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    if (findById(city.getCityId()) != null){
      return 0;
    }else {
      return deletedRows;
    }
  }
}
