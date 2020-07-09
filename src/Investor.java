import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Investor extends Buyer{
    private String PESEL;
    private Impementations impementations = new Impementations();
    private List<Buyer> investingCapitalList = new ArrayList<>();

    public Investor(Semaphore semaphore,List<Asset> assetList, List<Company> companyList, List<Buyer> InvestingCapital){
        super(semaphore,assetList,companyList);
        this.PESEL=impementations.getRandomPesel();
        this.investingCapitalList=InvestingCapital;
        System.out.println("PESEL to " + this.PESEL);
    }

    public String getPESEL() {
        return PESEL;
    }

    public Impementations getImpementations() {
        return impementations;
    }


    public void sell() {
        if(this.assetList.size()>0){
            Asset asset = get_and_remove_random_from_list(this.assetList);
            float money=asset.get_actual_value();
            money=money-(asset.getOwner().getPercentMargin()*money);
            investing_budget+=money;
        }
    }

    public void sellAction() {
        if(this.actionList.size()>0){
            Action action = (Action) impementations.chooseAsset(this.actionList);
            float money=action.get_actual_value();
            money=money-(action.getCompany().getIdex().getMarket().getPercentMargin()*money);
            investing_budget+=money;
            this.actionList.remove(action);
        }
    }

    public float get_budget(){
        return this.investing_budget;
    }

    public void show_all_assets(){
        for(Asset asset: assetList){
            System.out.println(asset.get_name());
        }
    }

    public void addAction(Action action){
        this.actionList.add(action);
    }

    public int buyUnitPar(List<Buyer> investingCapitalList) {
        if (investingCapitalList.size() <= 0) return 1;
        InvestingCapital investingCapital = (InvestingCapital) impementations.chooseBuyer(investingCapitalList);
        if (investingCapital.getUpList().size() <= 0) return 2;
        float koszt = investingCapital.giveUnitPart(this);
        if (koszt<0) return 3;
        this.investing_budget -=koszt;
        return 0;
    }

    public void takeMoney(float cash){
        this.investing_budget+=cash;
    }

    public void run(){
        while (true) {
            System.out.println(this.name);
            try {
                semaphore.acquire();
                System.out.println(this.get_budget());
                if(impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println("if");
                    Asset asset = impementations.chooseAsset(this.assetListToBuy);
                    if(Buy(asset)==0){
                        System.out.println("kupilem");
                        asset.addChangetoLast(asset.get_actual_value());
                        asset.expensiver();
                    }
                }
                else if (impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println("else if");
                    Company company = impementations.chooseCompany(this.companyList);
                    Action action = buyAction(company);
                    if(action!=null){
                        System.out.println("kupilem akcje");

                    }
                }
                else if (impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println("Sprzedanie aktywa");
                    sell();
                }
                else if (impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println("Sprzedanie akcji");
                    sellAction();
                }
                else if (impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println("kupienie jednostki udzialu");
                    if(buyUnitPar(this.investingCapitalList)==0){
                        System.out.println(this.name + "kupilem UP");
                    }
                }
                semaphore.release();
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
