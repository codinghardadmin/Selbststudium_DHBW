package application;

public class Application {
    public static void main(String... args) {
    	Busdepot busdepot = Busdepot.instance;
    	
    	System.out.println("##############################");
    	System.out.println("########## Erstellen der Busse und der Struktur");
    	System.out.println("##############################");
    	System.out.println();
    	
    	busdepot.createStructure();
    	
    	System.out.println("##############################");
    	System.out.println("########## Busse fahren vom Parkplatz");
    	System.out.println("##############################");
    	
    	busdepot.releaseBusses();
    	
    	System.out.println("##############################");
    	System.out.println("########## Einfahrt der Busse");
    	System.out.println("##############################");
    	System.out.println();
    	
    	busdepot.driveToEntrances();
    	
    	System.out.println("##############################");
    	System.out.println("########## Busse in Wartungsbuehnen");
    	System.out.println("##############################");
    	System.out.println();
    	
    	busdepot.driveToMaintainanceHalls();
    	
    	System.out.println("##############################");
    	System.out.println("########## Busse fahren an freien Parkplatz");
    	System.out.println("##############################");
    	System.out.println();
    	
    	busdepot.driveToFreeParkingSlots();

    }
}