public class Action extends Asset{
    private Company company;
    private int total;

    public Action(String name,float actual_value,Company owner,int total){
        super(name,actual_value);
        this.company=owner;
        this.total=total;
    }

    public Company getCompany() {
        return company;
    }

    public int getTotal() {
        return total;
    }
}
