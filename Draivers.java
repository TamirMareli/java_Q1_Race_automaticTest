public class Draivers {
    private String  name;
    private double dilay;
    private double breaking;
    private String  manuf;

    private double acceleration;
    private  double maxSpeed;
    public Draivers(){
        this.name="name";
        this.dilay=0.0;
        this.breaking=0.0;
        this.manuf="manuf";
        this.acceleration=0.0;
        this.maxSpeed=0.0;
    }

    public Draivers(String name,double dilay,double breaking,String manuf,double acceleration,double maxSpeed){
        this.name=name;
        this.dilay=dilay;
        this.breaking=breaking;
        this.manuf=manuf;
        this.acceleration=acceleration;
        this.maxSpeed=maxSpeed;
    }
    public String getName(){
        return this.name;
    }
    public double getDilay(){
        return this.dilay;
    }
    public double getBreaking(){
        return this.breaking;
    }
    public String getmanuf(){
        return this.manuf;
    }
    public double getAcceleration(){
        return this.acceleration;
    }
    public double getMaxSpeed(){
        return this.maxSpeed;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDilay(double dilay){
        this.dilay=dilay;
    }
    public void setBreaking(double breaking){
         this.breaking=breaking;
    }
    public void setmanuf(String manuf){
         this.manuf=manuf;
    }
    public void setAcceleration(double acceleration){
        this.acceleration=acceleration;
    }
    public void setMaxSpeed(double maxSpeed){
        this.maxSpeed=maxSpeed;
    }

}
