public class Main {
    public static void main(String[] args) {
        Race r1 = new Race();
        r1.printTotalInstantiatedRaces();
        r1.getRouteFromSysIn();
        r1.getDriversAndCarsFromSysIn();
        r1.runRace();
        r1.runAllPairsRace();
        r1.runRaceWithSortedOutput() ;

    }
}