import java.util.ArrayList;
import java.util.List;

public class Index {
    private List<Company> companyList = new ArrayList<Company>();
    private String name;
    private Impementations impementations = new Impementations();
    private Market paperMarket;

    public void setMarket(Market market) {
        this.market = market;
    }

    private Market market=null;

    public Index(PaperMarket paperMarket) {
        this.name = impementations.RandomString(2,3);
        this.paperMarket=paperMarket;
    }

    public List<Company> getCompanyList() {

        return companyList;
    }

    public String getName() {
        return name;
    }

    public void addToCompanylist(Company company){
        this.companyList.add(company);
    }

    public Impementations getImpementations() {
        return impementations;
    }

    public Market getPaperMarket() {
        return paperMarket;
    }

    public Market getMarket() {
        return market;
    }
}
