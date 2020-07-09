import java.util.ArrayList;
import java.util.List;


public class ValuteMarket extends Market{
    private List<Valute> Valutes_to_buy = new ArrayList<>();

    public ValuteMarket(String name, Country Co,String ci, String S_a){
        super(name,Co,ci,S_a);
    }

    public void set_Valutes(List<Valute> valuteList){
        for(Valute valute : valuteList){
            this.Valutes_to_buy.add(valute);
        }
    }

    public void addValute(Valute valute){
        Impementations impementations = new Impementations();
        Valute valute1 = new Valute(valute.get_name(),valute.get_actual_value());
        Valutes_to_buy.add(valute1);
        asset_list.add(valute1);
        valute1.setOwner(this);
    }


}
