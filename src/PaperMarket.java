import java.util.ArrayList;
import java.util.List;

public class PaperMarket extends Market{ ///gielda papierow
    private List<Index> index_list = new ArrayList<Index>();
    //private  List<Asset> asset_list = new ArrayList<Asset>();

    public PaperMarket(String name, Country Co,String ci, String S_a ){
        super(name,Co,ci,S_a);
    }

    public List<Index> getIndex_list() {
        return index_list;
    }

    public void setIndex_list(List<Index> index_list) {

        this.index_list = index_list;
    }

    public void addIndex(Index index){
        this.index_list.add(index);
    }

}
