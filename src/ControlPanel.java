//import swingi.GEI;


//import javafx.scene.chart.XYChart;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;
import java.util.Random;
//import java.util.Locale;
import java.util.Scanner;

public class ControlPanel {
    protected int time=0;
    protected List<Market> marketList = new ArrayList<Market>();
    protected List<Market> mineralMarketList = new ArrayList<>();
    protected List<Market> paperMarketList = new ArrayList<>();
    protected List<Market> valuteMarketList = new ArrayList<>();
    protected List<Index> indexList = new ArrayList<Index>();
    protected List<Company> companyList = new ArrayList<Company>();
    protected List<Action> actionList = new ArrayList<>();
    protected List<Asset> assetList = new ArrayList<Asset>();
    protected List<Asset> valuteList = new ArrayList<>();
    protected List<Asset> mineralList = new ArrayList<>();
    protected List<Buyer> buyerList = new ArrayList<>();
    protected List<Buyer> investorList = new ArrayList<>();
    protected List<Buyer> investingCapitalList = new ArrayList<>();
    protected List<Country> countryList = new ArrayList<>();
    protected String name;


    public void run(){
        ;
    }

    public void Marketings(){ //marketings

        this.name="cbfz";
        Gui gui = new Gui();
        gui.cate(null);

        //MarketChart chart = new MarketChart();
        //chart.cate(null,4);

        /////////////////////////////////////////////
        /*int q=1;
        while(true){
            //System.out.println("while");
            //System.out.println(q);
            if(q==1){
                Investor investor1 = new Investor(this.getAssetList());
                Investor investor2 = new Investor(this.getAssetList());
                new Thread(investor1).start();
                new Thread(investor2).start();
                q=0;
            }
        }*/


        /*Impementations impementations = new Impementations();
        impementations.setAsset("v",valuteList,assetList);
        impementations.setCountry(countryList,valuteList);
        //impementations.setCountry(countryList,valuteList);
        impementations.setMarket("v",countryList,valuteMarketList,marketList);
        impementations.Asset2Market(valuteList,valuteMarketList);
        InvestingCapital investingCapital = new InvestingCapital("qwe","asd",12345f,assetList,"rty");

        System.out.println(investingCapital.Buy(impementations.chooseAsset(assetList)));
        investingCapital.show_all_actives();
        investingCapital.show_all_up();
        //Scanner scanner = new Scanner(System.in);*/

    }

    public void AssetsWithOwner(){
        System.out.println("assets with owner:");
        for(Asset asset : this.assetList){
            if(asset.getOwner()!=null) System.out.println(asset.get_name());
        }
        System.out.println("over with owner");
    }

    public List<Asset> getMineralList() {
        return mineralList;
    }
    public String getName(){
        return this.name;
    }

    public int getTime() {
        return time;
    }

    public List<Market> getMarketList() {
        return marketList;
    }

    public List<Market> getMineralMarketList() {
        return mineralMarketList;
    }

    public List<Market> getPaperMarketList() {
        return paperMarketList;
    }

    public List<Market> getValuteMarketList() {
        return valuteMarketList;
    }

    public List<Index> getIndexList() {
        return indexList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public List<Asset> getValuteList() {
        return valuteList;
    }

    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public List<Buyer> getInvestorList() {
        return investorList;
    }

    public List<Buyer> getInvestingCapitalList() {
        return investingCapitalList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMarketList(List<Market> marketList) {
        this.marketList = marketList;
    }

    public void setMineralMarketList(List<Market> mineralMarketList) {
        this.mineralMarketList = mineralMarketList;
    }

    public void setPaperMarketList(List<Market> paperMarketList) {
        this.paperMarketList = paperMarketList;
    }

    public void setValuteMarketList(List<Market> valuteMarketList) {
        this.valuteMarketList = valuteMarketList;
    }

    public void setIndexList(List<Index> indexList) {
        this.indexList = indexList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public void setValuteList(List<Asset> valuteList) {
        this.valuteList = valuteList;
    }

    public void setMineralList(List<Asset> mineralList) {
        this.mineralList = mineralList;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    public void setInvestorList(List<Buyer> investorList) {
        this.investorList = investorList;
    }

    public void setInvestingCapitalList(List<Buyer> investingCapitalList) {
        this.investingCapitalList = investingCapitalList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public void setName(String name) {
        this.name = name;
    }
}
