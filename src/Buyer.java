//import sun.jvm.hotspot.HelloWorld;
import java.lang.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buyer implements Runnable{
    protected String name;
    protected String surname;
    protected float investing_budget;
    protected List<Asset> assetList = new ArrayList<>();
    protected List<Asset> assetListToBuy = new ArrayList<>();
    protected List<Asset> upList = new ArrayList<>();
    protected List<Asset> actionList = new ArrayList<>();
    protected Impementations impementations = new Impementations();
    protected List<Company> companyList = new ArrayList<>();
    protected Semaphore semaphore;


    public Buyer(Semaphore semaphore,List<Asset> assetList, List<Company> companyList){
        this.name=impementations.RandomString(7,4);
        this.surname=impementations.RandomString(7,4);
        this.investing_budget=impementations.RandomBudget(1000);
        this.assetListToBuy=assetList;
        this.companyList=companyList;
        this.semaphore=semaphore;
    }

    protected Asset get_and_remove_random_from_list(List<Asset> asset_list){
        Random r = new Random();
        int index=r.nextInt(asset_list.size());
        Asset asset=asset_list.get(index);
        asset_list.remove(index);
        return asset;
    }

    public Action buyAction(Company company){
        if(company==null) return null;
        int m = (int)(this.investing_budget/company.getActual_course());
        if(m<=0) return null;
        int k = company.getTotal_actions();

        int t = ((m < k) ? impementations.randomint(m)+1 : impementations.randomint(k)+1);
        float cost = t*company.getActual_course();
        this.investing_budget-=cost;
        company.addChangetoLast(company.getActual_course());
        company.addCash(cost,t);


        Action action = new Action(company.getName()+"_AC",company.getActual_course()*t,company,t);
        this.actionList.add(action);
        for(int i=0;i<t;i++){
            company.expensiver();
        }
        return action;
    }



    public int Buy(Asset asset) {
        if (asset==null) return 3;
        if (asset.getOwner()==null) return 1;
        if (this.investing_budget<asset.get_actual_value()) return 2;
        this.assetList.add(asset);
        this.investing_budget-=asset.actual_value;
        return 0;
    }

    public void run(){
        while (true) {
            try {

                if(impementations.randomint(3)>=impementations.randomint(10)){
                    System.out.println(this.name + " " +this.assetListToBuy.size());
                }
                else{
                    System.out.println(this.name + " else");
                }
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public String getname() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setInvesting_budget(float investing_budget) {
        this.investing_budget = investing_budget;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public void setAssetListToBuy(List<Asset> assetListToBuy) {
        this.assetListToBuy = assetListToBuy;
    }

    public void setUpList(List<Asset> upList) {
        this.upList = upList;
    }

    public void setActionList(List<Asset> actionList) {
        this.actionList = actionList;
    }

    public void setImpementations(Impementations impementations) {
        this.impementations = impementations;
    }

    public String getName() {
        return name;
    }

    public float getInvesting_budget() {
        return investing_budget;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public List<Asset> getAssetListToBuy() {
        return assetListToBuy;
    }

    public List<Asset> getUpList() {
        return upList;
    }

    public List<Asset> getActionList() {
        return actionList;
    }

    public Impementations getImpementations() {
        return impementations;
    }
}
