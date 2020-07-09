import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Market { //gieuda
    protected String name;
    protected Country country;
    protected Valute valute_to_buy;
    protected String city;
    protected String seat_adres;
    protected float percent_margin;
    protected boolean enabled=false;
    protected List<Asset> asset_list;

    public Market(String name, Country country,String city, String seat_adres){
        this.name=name;
        this.country=country;
        //this.valute_to_buy=country.getValute();
        this.city=city;
        this.seat_adres=seat_adres;
        Random r= new Random();
        this.percent_margin=r.nextFloat()*10;
        asset_list = new ArrayList<Asset>();

        //this.valute_to_buy=list_of_Valutes.get(r.nextInt(list_of_Valutes.size()));

    }


    public void show_all_assets(){
        for(Asset asset : asset_list){
            System.out.println(asset.get_name());
        }
    }

    public void add_asset(Asset asset){
        asset_list.add(asset);
        asset.setOwner(this);
    }

    public float getPercentMargin(){
        return this.percent_margin;
    }

    //public void addPercent()

    public static void zarycz(){
        System.out.println("qweerrty");
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void addAsset(Asset asset){
        this.asset_list.add(asset);
    }

    public List<Asset> getAsset_list() {
        return asset_list;
    }

    public Asset chooseAsset(){
        if(asset_list.size()>0){
            Random r =new Random();
            return asset_list.get(r.nextInt(asset_list.size()));
        }
        else{
            return null;
        }
    }

}
