public class Mineral extends Asset { //surowiec
    private String trade_unit; //jednostka hndlowa
    //private Valute wchith_valute;

    public Mineral(String name, float actual_value, String trade_unit){
        super(name,actual_value);
        this.trade_unit=trade_unit;
    }

    public String getTrade_unit() {
        return trade_unit;
    }

}
