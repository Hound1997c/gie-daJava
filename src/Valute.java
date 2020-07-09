import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Valute extends  Asset{
    List<Country> Country_list;

    public Valute(String name,float actual_value){
        super(name,actual_value);
        Country_list = new ArrayList<Country>();
    }

    public List<Country> getCountry_list() {
        return Country_list;
    }

    public void addCountry(Country country){
        Country_list.add(country);
    }

}
