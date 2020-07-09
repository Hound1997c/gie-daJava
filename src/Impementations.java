import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Impementations {
    Random r = new Random();
    //public Impementations()
    public  String RandfromStringPack(List<String> LS){
        Random r = new Random();
        return LS.get(r.nextInt(LS.size()));
    }
    public String RandomString(int range_of_letters, int min_letters){
        String out="";
        Random r= new Random();
        int letters = r.nextInt(range_of_letters)+min_letters;
        for(int i=0;i<letters;i++){
            int letter = r.nextInt(122-97+1)+97;
            out+=(char)letter;
        }
        return out;
    }

    public int randomint(int rage){
        return r.nextInt(rage);
    }

    public Country chooseCountry(List<Country> countryList) {
        if(countryList.size()<=0) return  null;
        return countryList.get(r.nextInt(countryList.size()));
    }
    //public InvestingCapital chooseCapital

    public Asset chooseAsset(List<Asset> assetList){
        if(assetList.size()<=0) return null;
        Asset asset = assetList.get(r.nextInt(assetList.size()));
        //System.out.println(asset.get_name());
        return asset;
    }

    public Object chooseObject(List<Object> objectList){
        if(objectList.size()<=0) return null;
        return objectList.get(r.nextInt(objectList.size()));
    }

    public Company chooseCompany(List<Company> objectList){
        if(objectList.size()<=0) return null;
        return objectList.get(r.nextInt(objectList.size()));
    }

    public float RandomDefault4Value() {
        return r.nextFloat()*10;
    }
    public float RandomBudget(int multiply){
        return r.nextFloat()*multiply;
    }






    public int setCountry(List<Country> countryList,List<Asset> valuteList){
        if(valuteList.size()>0){
            System.out.println("tworzymy");
            Country country = new Country(RandomString(10,3));
            country.setUsing_valute((Valute)chooseAsset(valuteList));
            country.getUsing_valute().addCountry(country);
            countryList.add(country);
            return 0;
        }
        else{
            System.out.println("nie Tworzymy");
            return -1;
        }
    }


    public int setMarket(String type, List<Country> countryList,List<Market> marketList, List<Market> BigMarketList){
        if(countryList.size()<=0) return -1;
        switch (type){
            case "v":
                ValuteMarket valuteMarket = new ValuteMarket(RandomString(10,3),
                        chooseCountry(countryList),RandomString(5,3),RandomString(5,3));
                marketList.add(valuteMarket);
                BigMarketList.add(valuteMarket);
                return 0;
            case "m":
                MineralMarket market=new MineralMarket(RandomString(4,3),chooseCountry(countryList),
                        RandomString(4,3),RandomString(4,3));
                marketList.add(market);
                BigMarketList.add(market);
                return 0;
            case "p":
                PaperMarket paperMarket = new PaperMarket(RandomString(4,3),chooseCountry(countryList),
                        RandomString(4,3),RandomString(4,3));
                marketList.add(paperMarket);
                BigMarketList.add(paperMarket);
                return 0;
            default:
                return -2;
        }
    }

    public int setAsset(String type,List<Asset> assetList, List<Asset> BigAssetlist){
        switch (type){
            case "m":
                Mineral mineral = new Mineral(RandomString(5,3),RandomDefault4Value(),RandomString(5,3));
                assetList.add(mineral);
                BigAssetlist.add(mineral);
                return 0;
            case "v":
                Valute v = new Valute(RandomString(5,3),RandomDefault4Value());
                assetList.add(v);
                BigAssetlist.add(v);
                return 0;
            case "p":
                return 0;
            default:
                return -1;
        }
    }



    public int setIndex(List<Index> indexList, List<Market> paperMarketList){
        PaperMarket paperMarket = (PaperMarket)chooseMarket(paperMarketList);
        if(paperMarket==null) return 1;
        Index index = new Index(paperMarket);
        paperMarket.addIndex(index);
        indexList.add(index);
        return 0;
    }
    public int setCompany(List<Company> companyList, List<Index> indexList){
        Index index = chooseIndex(indexList);
        if(index==null) return  1;
        Company company = new Company(index);
        companyList.add(company);
        index.addToCompanylist(company);
        return 0;
    }



    public Market chooseMarket(List<Market> marketList){
        if(marketList.size()<=0) return null;
        return marketList.get(r.nextInt(marketList.size()));
    }

    public PaperMarket choosePaperMarket(List<PaperMarket> paperMarketList){
        if(paperMarketList.size()<=0) return null;
        return paperMarketList.get(r.nextInt(paperMarketList.size()));
    }

    public Index chooseIndex(List<Index> indexList){
        if(indexList.size()<=0) return null;
        return indexList.get(r.nextInt(indexList.size()));
    }

    public Buyer chooseBuyer(List<Buyer> buyerList){
        if(buyerList.size()<=0) return null;
        return buyerList.get(r.nextInt(buyerList.size()));
    }

    public InvestingCapital chooseIC(List<InvestingCapital> iCList){
        if(iCList.size()<=0) return null;
        return iCList.get(r.nextInt(iCList.size()));
    }




    public void Asset2Market(List<Asset> assetList, List<Market> marketList){
        if(marketList.size()<=0 || assetList.size()<=0) return;
        System.out.println("A2A");
        for(Asset asset : assetList){
            if(asset.getOwner()!=null) continue;
            Market market = chooseMarket(marketList);
            asset.setOwner(market);
            market.addAsset(asset);
        }
    }

    public void Index2PaperMarket(List<Index> indexList, List<PaperMarket> paperMarketList){
        if(indexList.size()<=0 || paperMarketList.size()<=0) return;
        //for ()
    }

    public String getRandomPesel(){
        String out="";
        for(int i=0;i<11;i++){
            int number = r.nextInt(10);
            out+=(char)number-'0';
        }
        return out;

    }
}
