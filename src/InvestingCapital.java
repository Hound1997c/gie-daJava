import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class InvestingCapital extends Buyer{
    //fundusz inwestycyjny
    private String label;


    public InvestingCapital(Semaphore semaphore,List<Asset> assetList, List<Company> companyList){
        super(semaphore,assetList,companyList);
        this.label=impementations.RandomString(7,4);
    }



    public void show_all_actives(){
        System.out.println("oto aktywa: ");
        for(Asset a : assetList){
            System.out.println(a.get_name());
        }
    }

    public float giveUnitPart(Investor investor){
        if(this.upList.size()<=0) return -1;
        UnitParticipation unitParticipation = (UnitParticipation)impementations.chooseAsset(this.upList);
        float a = unitParticipation.getBindAsset().get_actual_value();
        float b = unitParticipation.get_actual_value();
        if(a>b){
            unitParticipation.setActual_value(a);
            this.investing_budget+=a;
        }
        else {
            this.investing_budget+=b;
        }
        unitParticipation.setInvestor(investor);
        return unitParticipation.get_actual_value();
    }

    public void sellUnitPart(){
        if(this.upList.size()<=0) return;
        UnitParticipation unitParticipation = (UnitParticipation)impementations.chooseAsset(this.upList);
        float a = unitParticipation.getBindAsset().get_actual_value();
        float b = unitParticipation.get_actual_value();
        if(a<b){
            unitParticipation.getInvestor().takeMoney(a);
        }
        else {
            float c = a - b;
            c = c * (1 - c*unitParticipation.getBindAsset().getOwner().getPercentMargin());
            this.investing_budget+=c/2;
            unitParticipation.getInvestor().takeMoney(b+(c/2));
        }
        this.assetList.remove(unitParticipation.getBindAsset());
        this.upList.remove(unitParticipation);
    }

    public void run() {
        while (true) {
            //System.out.println(this.name);
            try {
                semaphore.acquire();
                if (impementations.randomint(3) >= impementations.randomint(10)) {
                    Asset asset = impementations.chooseAsset(this.assetListToBuy);
                    if (Buy(asset) == 0) {
                        asset.addChangetoLast(asset.get_actual_value());
                        asset.expensiver();
                        UnitParticipation unitParticipation = new UnitParticipation(asset.get_name() + "_UP", asset.get_actual_value(),
                                asset);
                        this.upList.add(unitParticipation);
                    }

                } else if (impementations.randomint(3) >= impementations.randomint(10)) {
                    System.out.println(this.name + "else if");
                    Company company = impementations.chooseCompany(this.companyList);
                    Action action = buyAction(company);
                    if(action!=null){
                        UnitParticipation uP = new UnitParticipation(action.getName()+"_UP",action.getActual_value(),
                                action);
                        this.upList.add(uP);
                    }
                } else if(impementations.randomint(3) >= impementations.randomint(10)){
                    sellUnitPart();
                }
                semaphore.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showAllUP(){
        System.out.println("UP:");
        if(upList.size()<=0) System.out.println("ni ma");
        for(Asset unitParticipation : upList){
            System.out.println(unitParticipation.get_name());
        }
    }

}
//wtorek
//