import java.util.ArrayList;
import java.util.List;

public class MineralMarket extends Market { //giełda surowcow
    //private String tradeUnit;
    private List<Mineral> list_of_minerals;
    //private String notedValute;
    public MineralMarket(String name, Country Co,String ci, String S_a){
        super(name,Co,ci,S_a);
        //this.tradeUnit=tradeUnit;
        this.list_of_minerals=new ArrayList<Mineral>();
    }

    public void setList_of_minerals(List<Mineral> mineralList){
        for(Mineral mineral : mineralList){
            this.list_of_minerals.add(mineral);
        }
    }

    public void addMineral(Mineral mineral){
        Mineral mineral1 = new Mineral(mineral.get_name(),mineral.get_actual_value(),mineral.getTrade_unit());
        list_of_minerals.add(mineral1);
        asset_list.add(mineral1);
        mineral1.setOwner(this);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }
}
