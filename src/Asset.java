import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asset { //aktywo
    protected String name="";
    protected float actual_value=1;
    protected float minimal_value;
    protected float maximum_value;
    protected Market owner = null;
    protected boolean enabled=false;
    protected List<VaT> lastTimes = new ArrayList<>();
    //protected UnitParticipation unitParticipation;

    public Asset(String name,float actual_value){

        this.name=name;
        this.actual_value=actual_value;
        this.maximum_value=this.minimal_value=this.actual_value;

        /*Random r= new Random();
        int n = r.nextInt(10)+3;
        for(int i=0;i<n;i++){
            int k = r.nextInt(122-97+1)+97;
            this.name+=(char)k;
        }
        System.out.println(this.name);*/

        /*float m=r.nextFloat()*1000 +1;
        this.actual_value=m;*/

    }

    public String get_name(){
        return this.name;
    }

    public float get_actual_value() {
        return this.actual_value;
    }

    public float getMinimal_value() {
        return this.minimal_value;
    }

    public float getMaximum_value() {
        return this.maximum_value;
    }

    public void setOwner(Market market){
        this.owner=market;
    }

    public Market getOwner() {
        return owner;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void expensiver(){
        this.actual_value+=this.actual_value/10;
        if(this.actual_value>this.maximum_value){
            this.maximum_value=this.actual_value;
        }
    }
    public void poorover(){
        float f = this.actual_value-this.actual_value/10;
        if(f>0){
            this.actual_value=f;
            if(this.minimal_value<this.actual_value){
                this.minimal_value=this.actual_value;
            }
        }
    }

    public void addChangetoLast(float value){
        VaT vaT = new VaT(value);
        this.lastTimes.add(vaT);
    }

    public void showAlllast() {
        for(VaT vaT : lastTimes){
            System.out.println(vaT.time + " " + vaT.value);
        }
    }

    public String getName() {
        return name;
    }

    public float getActual_value() {
        return actual_value;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<VaT> getLastTimes() {
        return lastTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActual_value(float actual_value) {
        this.actual_value = actual_value;
    }

    public void setMinimal_value(float minimal_value) {
        this.minimal_value = minimal_value;
    }

    public void setMaximum_value(float maximum_value) {
        this.maximum_value = maximum_value;
    }

    public void setLastTimes(List<VaT> lastTimes) {
        this.lastTimes = lastTimes;
    }

    //public void addAsset(Asset asset,)
}
