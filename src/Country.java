public class Country {
    private String name;
    private Valute using_valute;
    private boolean enabled=false;

    public Country(String name){
        this.name=name;

        //this.using_valute=using_valute;
    }

    public void setUsing_valute(Valute v){
        this.using_valute=v;
    }

    public Valute getUsing_valute(){
        return this.using_valute;
    }

    public String getName() {
        return name;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
