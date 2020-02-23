package ECutb.OmarAli;

import ECutb.OmarAli.data.CityDaoJDBC;
import ECutb.OmarAli.entity.City;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CityDaoJDBC daoJDBC = new CityDaoJDBC();

        /**Hittar via ID
         * System.out.println(daoJDBC.findById(333));
         */
        /**
         * Hittar via Namn
         * System.out.println(daoJDBC.findByName("Mogadishu"));
         */

        /**
         * Hittar Alla
         * System.out.println(daoJDBC.findAll());
         */
        /**
         *
         * Hittar via CountryCode
         * System.out.println(daoJDBC.findByCode("SOM"));*/

        /**
         * Jag kan lägga till
         * City Mogadishu = new City("Mogadishu", "SOM", "Kronoberg", 900);
         * System.out.println(daoJDBC.add(Mogadishu));
         */

        /**
         * Updaterar
         * City UpdMogadishu = daoJDBC.findById(4083);
         * UpdMogadishu.setName("Madagaskar");
         * UpdMogadishu.setPopulation(53456);
         * System.out.println(daoJDBC.update(UpdMogadishu));
         */

        /**
         * Raderar
         * City deleteCity = daoJDBC.findById(4083);
         * System.out.println(daoJDBC.delete(deleteCity));
         */


        }
}
