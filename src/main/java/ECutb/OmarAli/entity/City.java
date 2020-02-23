package ECutb.OmarAli.entity;

import java.util.Objects;

public class City {
  private int cityId;
  private String name;
  private String countryCode;
  private String district;
  private int population;

  public City(int ciyId, String name, String countryCode, String district, int population) {
    this.cityId = ciyId;
    this.name = name;
    this.countryCode = countryCode;
    this.district = district;
    this.population = population;
  }

  public City(String name, String countryCode, String district, int population) {
    this(0, name, countryCode, district, population);
  }

  public int getCityId() {
    return cityId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return cityId == city.cityId &&
        population == city.population &&
        Objects.equals(name, city.name) &&
        Objects.equals(countryCode, city.countryCode) &&
        Objects.equals(district, city.district);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cityId, name, countryCode, district, population);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("City{");
    sb.append("ciyId=").append(cityId);
    sb.append(", name='").append(name).append('\'');
    sb.append(", countryCode='").append(countryCode).append('\'');
    sb.append(", district='").append(district).append('\'');
    sb.append(", population=").append(population);
    sb.append('}');
    return sb.toString();
  }
}
