import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Company { //spółka
    private String name;
    private boolean first=true;
    private LocalTime date_of_first_selling; //pierwszej wyceny
    private float opening_course;
    private float actual_course;
    private float minimal_course;
    private float maximal_course;
    private int total_actions; //liczba akcji
    private float gain; //zysk
    private float influance; // przychod
    private float main_capital; //kapitał włąsny
    private float poker_capital; //zakładowy
    private int volume; //liczba akcji jaka zmieniła właściciela
    private float sales; //obroty -> wartosci transakcji wykonanych na akcjach
    private List<Index> indexList = new ArrayList<Index>();
    private List<VaT> lastTimes = new ArrayList<>();
    private PaperMarket market;
    Impementations impementations = new Impementations();

    //private int action_value;
    private int number_of_company;
    private boolean is_first = true;

    public Company(Index index){
        this.indexList.add(index);
        this.name=impementations.RandomString(6,3);
        //
        this.opening_course=impementations.RandomDefault4Value()*10;
        this.actual_course=this.opening_course;
        this.minimal_course=this.opening_course;
        this.maximal_course=this.opening_course;
        this.total_actions=(int)(impementations.RandomDefault4Value()*100);
        //
        //
        this.main_capital=impementations.RandomDefault4Value()*10000;
        this.poker_capital=this.total_actions*this.actual_course;
        this.volume=0;
        this.sales=0;

        this.lastTimes.add(new VaT(this.actual_course));

    }
    public void addCash(float cash, int total){
        float percent = this.getIdex().getMarket().getPercentMargin();
        this.main_capital+=(1-percent)*cash;
        this.total_actions-=total;
    }
    public Index getIdex(){
        return impementations.chooseIndex(this.indexList);
    }
    public String getName(){
        return this.name;
    }
    public int getTotal_actions(){
        return this.total_actions;
    }
    public float getActual_course(){
        return this.actual_course;
    }

    public void setIndex(Index index){
        this.indexList.add(index);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setDate_of_first_selling(LocalTime date_of_first_selling) {
        this.date_of_first_selling = date_of_first_selling;
    }

    public void setOpening_course(float opening_course) {
        this.opening_course = opening_course;
    }

    public void setActual_course(float actual_course) {
        this.actual_course = actual_course;
    }

    public void setMinimal_course(float minimal_course) {
        this.minimal_course = minimal_course;
    }

    public void setMaximal_course(float maximal_course) {
        this.maximal_course = maximal_course;
    }

    public void setTotal_actions(int total_actions) {
        this.total_actions = total_actions;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public void setInfluance(float influance) {
        this.influance = influance;
    }

    public void setMain_capital(float main_capital) {
        this.main_capital = main_capital;
    }

    public void setPoker_capital(float poker_capital) {
        this.poker_capital = poker_capital;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSales(float sales) {
        this.sales = sales;
    }

    public void setIndexList(List<Index> indexList) {
        this.indexList = indexList;
    }

    public void setVaTList(List<VaT> vaTList) {
        this.lastTimes = vaTList;
    }

    public void setMarket(PaperMarket market) {
        this.market = market;
    }

    /*public void setAction_value(int action_value) {
        this.action_value = action_value;
    }*/

    public void setNumber_of_company(int number_of_company) {
        this.number_of_company = number_of_company;
    }

    public void setIs_first(boolean is_first) {
        this.is_first = is_first;
    }

    public LocalTime getDate_of_first_selling() {
        return date_of_first_selling;
    }

    public float getOpening_course() {
        return opening_course;
    }

    public float getMinimal_course() {
        return minimal_course;
    }

    public float getMaximal_course() {
        return maximal_course;
    }

    public float getGain() {
        return gain;
    }

    public float getInfluance() {
        return influance;
    }

    public float getMain_capital() {
        return main_capital;
    }

    public float getPoker_capital() {
        return poker_capital;
    }

    public int getVolume() {
        return volume;
    }

    public float getSales() {
        return sales;
    }

    public List<Index> getIndexList() {
        return indexList;
    }

    public List<VaT> getVaTList() {
        return lastTimes;
    }

    public PaperMarket getMarket() {
        return market;
    }

    /*public int getAction_value() {
        return action_value;
    }*/

    public int getNumber_of_company() {
        return number_of_company;
    }

    public boolean isIs_first() {
        return is_first;
    }

    public void expensiver(){
        this.actual_course+=(this.actual_course/10);
        if(this.actual_course>this.maximal_course) this.maximal_course=this.actual_course;
    }
    public void poorover(){
        this.actual_course-=(this.actual_course/10);
        if(this.actual_course>this.minimal_course) this.minimal_course=this.actual_course;
    }

    public void addChangetoLast(float value){
        VaT vaT = new VaT(value);
        this.lastTimes.add(vaT);
    }
    public boolean isFirst() {
        return first;
    }


    public void setFirst(){
        if(this.first){
            this.date_of_first_selling=LocalTime.now();
            this.first=false;
        }
    }
}
