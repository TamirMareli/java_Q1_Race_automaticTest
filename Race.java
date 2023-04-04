import java.util.Scanner;
public class Race {
    Scanner scanner = new Scanner(System.in);
    private static int numOfRace=0;
    private String [] name;
    private int segments;
    private double [] arrLength;
    private int numOfdrivers;
    private String [] arryname;
    private double[] arrybreak;
    private double[] arrydelay;
    private String [] arrynmanuf;
    private double[] arryaccel;
    private double[] arryspeed;

    public Race(){
         numOfdrivers=0;
         segments=0;
         name=new String[numOfdrivers];
         arrLength=new double[segments];
         arryname=new String[numOfdrivers];
         arrybreak=new double[segments];
         arrydelay=new double[segments];
         arrynmanuf=new String[numOfdrivers];
         arryaccel=new double[segments];
         arryspeed=new double[segments];
         numOfRace++;//add one of every object that create
    }

    public void getRouteFromSysIn(){
        double length;
        do {//input of num of segmants
            System.out.println("How many segments does the route contain ?");
            this.segments = scanner.nextInt();
            if(this.segments<=0){
                System.out.println("input must be a positive integer,got"+this.segments);
            }
        }while(this.segments<=0);
         this.arrLength=new double[segments];
        for(int i=0;i<segments;i++){
            do{//enter the length of every segments
                System.out.println("What is the length of segment"+i+" ?");
                length=scanner.nextDouble();
                if(length<=0)
                    System.out.println("input must be a positive double,got"+length);
                else
                    this.arrLength[i]=length;
            }while(length<=0);
        }
    }

    public void getDriversAndCarsFromSysIn(){
        do {//input the numbers of participants
            System.out.println("How many participants are there in the race ?");
            this.numOfdrivers = scanner.nextInt();
            if(this.numOfdrivers<=0){
                System.out.println("input must be a positive integer,got"+numOfdrivers);
            }
        }while(this.numOfdrivers<=0);
        this.numOfdrivers=numOfdrivers;
      this.arryname= new String[this.numOfdrivers];
         this.arrybreak=new double[this.numOfdrivers];
         this.arrydelay=new double[this.numOfdrivers];
        for(int i=0;i<this.numOfdrivers;i++){//input the details of every driver
            System.out.println("Please enter details for driver "+i);
            System.out.println("What is the driver's name?");
            scanner.nextLine();
            this.arryname[i]=scanner.nextLine();
            System.out.println("What is the driver's breakig rate?");
            this.arrybreak[i]=scanner.nextDouble();
            System.out.println("What is the driver's delay time?");
            this.arrydelay[i]= scanner.nextDouble();
            scanner.nextLine();
        }

        this.arrynmanuf= new String[this.numOfdrivers];
        this.arryaccel=new double[this.numOfdrivers];
        this.arryspeed=new double[this.numOfdrivers];
        scanner.nextLine();
        for(int i=0;i<numOfdrivers;i++){//input the details of every car
            System.out.println("Please enter details for car "+i+":");
            System.out.println("What is the car's manufacturer?");
            scanner.nextLine();
            arrynmanuf[i]=scanner.nextLine();
            System.out.println("What is the car's acceleration?");
            arryaccel[i]=scanner.nextDouble();
            System.out.println("What is the car's maximun speed?");
            arryspeed[i]= scanner.nextDouble();
            scanner.nextLine();
        }

    }

    public void runRace() {
        double [] timeA=new double[this.numOfdrivers];
        double [] timeB=new double[this.numOfdrivers];
        double [] timeM=new double[this.numOfdrivers];
        double [] timeTot=new double[this.numOfdrivers];
        double [] distance=new double[this.numOfdrivers];
        double win;
        int indexWin=0;
        for(int i=0;i<this.numOfdrivers;i++){//the time of acceleration
            timeA[i]=this.arryspeed[i]/this.arryaccel[i];
            distance[i]=0.5*this.arryaccel[i]*timeA[i]*timeA[i];
        }
        for(int i=0;i<this.numOfdrivers;i++){//the time of breaking
            timeB[i]=this.arryspeed[i]/this.arrybreak[i];
            distance[i]+=0.5*this.arrybreak[i]*timeB[i]*timeB[i];
        }
        for (int i = 0; i < this.numOfdrivers; i++) {//restart the array of time max speed
            timeM[i]=0.0;
        }
        for(int j=0;j<this.segments;j++) {//the time of drive in max speed
            for (int i = 0; i < this.numOfdrivers; i++) {
                timeM[i] += (this.arrLength[j]-distance[i])/this.arryspeed[i];
            }
        }
        for(int i=0;i<this.numOfdrivers;i++){//calculate the total time
            timeTot[i]=this.segments*timeA[i]+this.segments*timeB[i]+timeM[i]+(this.segments-1)*this.arrydelay[i];
        }
        win=timeTot[1];
        for(int i=0;i<this.numOfdrivers;i++){//print every driver whit kind of car and how long will is takes
            System.out.println(this.arryname[i]+", "+this.arrynmanuf[i]+", "+timeTot[i]);
            if(timeTot[i]<=win) {
                win = timeTot[i];
                indexWin = i;
            }
        }
        System.out.println("The winner is: "+this.arryname[indexWin]);


    }

    public void runAllPairsRace() {
        double [] timeA=new double[this.numOfdrivers*this.numOfdrivers];
        double [] timeB=new double[this.numOfdrivers*this.numOfdrivers];
        double [] timeM=new double[this.numOfdrivers*this.numOfdrivers];
        double [] timeTot=new double[this.numOfdrivers*this.numOfdrivers];
        double [] distance=new double[this.numOfdrivers*this.numOfdrivers];
        double win;
        int indexWin=0;
        Draivers[] arrDC=new Draivers[this.numOfdrivers*this.numOfdrivers];
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//initialize the array of driver car
            arrDC[i]=new Draivers();
        }
        int index=0;
        for(int i=0;i<this.numOfdrivers;i++){//entering the value to the array driver car
            for(int j=0;j<this.numOfdrivers;j++){
                arrDC[index].setName(arryname[i]);
                arrDC[index].setDilay(arrydelay[i]);
                arrDC[index].setBreaking(arrybreak[i]);
                arrDC[index].setmanuf(arrynmanuf[j]);
                arrDC[index].setAcceleration(arryaccel[j]);
                arrDC[index].setMaxSpeed(arryspeed[j]);
                index++;
            }
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//calculate the time of acceleration
            timeA[i]=arrDC[i].getMaxSpeed()/arrDC[i].getAcceleration();
            distance[i]=0.5*arrDC[i].getAcceleration()*timeA[i]*timeA[i];
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//calculate the time of breaking
            timeB[i]=arrDC[i].getMaxSpeed()/arrDC[i].getBreaking();
            distance[i]+=0.5*arrDC[i].getBreaking()*timeB[i]*timeB[i];
        }
        for (int i = 0; i < this.numOfdrivers*this.numOfdrivers; i++) {//restart the array of time max speed
            timeM[i]=0.0;
        }
        for(int j=0;j<this.segments;j++) {//calculate the time of drive in max speed
            for (int i = 0; i < this.numOfdrivers*this.numOfdrivers; i++) {
                timeM[i] += (this.arrLength[j]-distance[i])/arrDC[i].getMaxSpeed();
            }
        }
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//calculate the total time
            timeTot[i]=this.segments*timeA[i]+this.segments*timeB[i]+timeM[i]+(this.segments-1)*arrDC[i].getDilay();
        }
        win=timeTot[1];
        for(int i=0;i<this.numOfdrivers*this.numOfdrivers;i++){//print every driver whit every car
            System.out.println(arrDC[i].getName()+", "+arrDC[i].getmanuf()+", "+timeTot[i]);
            if(timeTot[i]<=win) {
                win = timeTot[i];
                indexWin = i;
            }
        }
        //print the winner driver and car
        System.out.println("The winner is: "+arrDC[indexWin].getName()+" and "+arrDC[indexWin].getmanuf()+", who completed the race iz  "+timeTot[indexWin]+" swconds");






    }

    public void printTotalInstantiatedRaces() {
        //print the numbers of kinds of object Race
      System.out.println("The number of constructedn Race instances is "+numOfRace);
    }

    public void runRaceWithSortedOutput() {
        double [] timeA=new double[this.numOfdrivers];
        double [] timeB=new double[this.numOfdrivers];
        double [] timeM=new double[this.numOfdrivers];
        double [] timeTot=new double[this.numOfdrivers];
        double [] tempTimeTot=new double[this.numOfdrivers];
        double [] distance=new double[this.numOfdrivers];
        int [] sortarry=new int[numOfdrivers];
        double ferstcar=0;
        int indexWin=0;
        for(int i=0;i<this.numOfdrivers;i++){//calculate the time of acceleration
            timeA[i]=this.arryspeed[i]/this.arryaccel[i];
            distance[i]=0.5*this.arryaccel[i]*timeA[i]*timeA[i];
        }
        for(int i=0;i<this.numOfdrivers;i++){//calculate the time of breaking
            timeB[i]=this.arryspeed[i]/this.arrybreak[i];
            distance[i]+=0.5*this.arrybreak[i]*timeB[i]*timeB[i];
        }
        for (int i = 0; i < this.numOfdrivers; i++) {//restart the array of time max speed
            timeM[i]=0.0;
        }
        for(int j=0;j<this.segments;j++) {//calculate the time of drive in max speed
            for (int i = 0; i < this.numOfdrivers; i++) {
                timeM[i] += (this.arrLength[j]-distance[i])/this.arryspeed[i];
            }
        }
        for(int i=0;i<this.numOfdrivers;i++){//calculate the total time
            timeTot[i]=this.segments*timeA[i]+this.segments*timeB[i]+timeM[i]+(this.segments-1)*this.arrydelay[i];
        }

        for(int i=0;i<numOfdrivers;i++){//copy to temp array the result of total time of every drive whit every car
            tempTimeTot[i]=timeTot[i];
        }
        for(int i=0;i<numOfdrivers;i++){//sort the result of total time
            ferstcar=10000;
            for(int j=0;j<numOfdrivers;j++){
                if(ferstcar>=tempTimeTot[j]){
                    ferstcar=tempTimeTot[j];
                    indexWin=j;
                }
            }
            tempTimeTot[indexWin]=10000000;//put max integer in the value of total time to every driver
            sortarry[i]=indexWin;//entering the index of place of driver that arrives first to the last
        }

        for(int i=0;i<this.numOfdrivers;i++){//prints drivers results first to the last
            System.out.println(this.arryname[sortarry[i]]+", "+this.arrynmanuf[sortarry[i]]+", "+timeTot[sortarry[i]]);
        }



    }

}