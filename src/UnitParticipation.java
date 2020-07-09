public class UnitParticipation extends Asset{ //jednostka udzialu
    private Asset bindAsset;
    private Investor investor;

    public void setBindAsset(Asset bindAsset) {
        this.bindAsset = bindAsset;
    }



    public UnitParticipation(String name, float value, Asset asset){
        super(name,value);
        this.bindAsset=asset;


    }

    public Asset getBindAsset(){
        return this.bindAsset;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Investor getInvestor() {
        return investor;
    }


}
