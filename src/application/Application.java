package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String... args) {
    	System.out.println("##############################");
    	System.out.println("########## Erstellen der Busse und der Struktur");
    	System.out.println("##############################");
    	System.out.println();
    	
    	// Erzeugen der Busse
    	List<Bus> busList = new ArrayList<>();
    	
    	for (int i = 0; i < 4; i++) {
    		Bus bus = new Bus(BusType.B01);
    		busList.add(bus);
    	}
    	for (int i = 0; i < 4; i++) {
    		Bus bus = new Bus(BusType.B02);
    		busList.add(bus);
    	}
    	for (int i = 0; i < 4; i++) {
    		Bus bus = new Bus(BusType.B03);
    		busList.add(bus);
    	}
    	System.out.println("Busse erstellt");
    	
    	// Mischen der Liste, für zufällige Anordnung
    	Collections.shuffle(busList);
    	System.out.println("Busse zufällig verteilt");
    	
    	// Liste von Parkplätzen (75) mit je einem Bus
    	List<Parkplatz> parkplaetze = new ArrayList<Parkplatz>();
    	for (int i = 0; i < 12; i++) {
    		Parkplatz parkplatz = new Parkplatz();
    		parkplatz.setBus(busList.get(i));
    		parkplaetze.add(parkplatz);
    	}
    	System.out.println("Busse zu Parkplätzen hinzugefügt");
    	
    	// Einfahrten erstellen
    	Einfahrt einfahrtB01 = new EinfahrtB01();
		Einfahrt einfahrtB02 = new EinfahrtB02(einfahrtB01);
		Einfahrt einfahrtB03 = new EinfahrtB03(einfahrtB02);
    	
    	// Wartungshalle erstellen
    	Wartungshalle halle = new Wartungshalle();
    	halle.setEinfahrt(einfahrtB03);
    	
    	// Wartungsbuehnen erstellen
    	List<Wartungsbuehne> buehnenList1 = new ArrayList<Wartungsbuehne>();
    	for (int i = 0; i < 4; i++) {
    		Wartungsbuehne buehne = new Wartungsbuehne();
    		buehnenList1.add(buehne);
    	}
    	einfahrtB01.setBuehnen(buehnenList1);
    	
    	List<Wartungsbuehne> buehnenList2 = new ArrayList<Wartungsbuehne>();
    	for (int i = 0; i < 4; i++) {
    		Wartungsbuehne buehne = new Wartungsbuehne();
    		buehnenList2.add(buehne);
    	}
    	einfahrtB02.setBuehnen(buehnenList2);
    	
    	List<Wartungsbuehne> buehnenList3 = new ArrayList<Wartungsbuehne>();
    	for (int i = 0; i < 4; i++) {
    		Wartungsbuehne buehne = new Wartungsbuehne();
    		buehnenList3.add(buehne);
    	}
    	einfahrtB03.setBuehnen(buehnenList3);
    	
    	System.out.println("Wartungshallen, Einfahrten, Bühnen erstellt");
    	System.out.println();
    	
    	Bus bus = new Bus(BusType.B01);
    	
    	System.out.println("########## Busse fahren von Parkplatz");
    	System.out.println();
    	
    	// ???? TODO!
    	Zentralrechner.instance.releaseBusses(parkplaetze);
    	// 
    	
    	System.out.println("##############################");
    	System.out.println("########## Einfahrt der Busse");
    	System.out.println("##############################");
    	System.out.println();
    	
    	for (int i = 0; i < 12; i++) {
    		halle.getEinfahrt().einfahrt(busList.get(i));
    		System.out.println();
    	}
    	
    	System.out.println("##############################");
    	System.out.println("########## Busse in Wartungshallen");
    	System.out.println("##############################");
    	System.out.println();
    	
    	for (Wartungsbuehne buehne : buehnenList1) {
    		buehne.enter();
    		buehne.wartung();
    		buehne.leave(parkplaetze);
    		
    		System.out.println();
    	}
    	
    	for (Wartungsbuehne buehne : buehnenList2) {
    		buehne.enter();
    		buehne.wartung();
    		buehne.leave(parkplaetze);
    		
    		System.out.println();
    	}
    	
    	for (Wartungsbuehne buehne : buehnenList3) {
    		buehne.enter();
    		buehne.wartung();
    		buehne.leave(parkplaetze);
    		
    		System.out.println();
    	}
    	
    	System.out.println("##############################");
    	System.out.println("########## Bus fährt an freien Parkplatz");
    	System.out.println("##############################");
    	System.out.println();
    	
    	for (Bus b : busList) {
    		Parkplatz parkplatz = getFreeParkplatz(parkplaetze);
    		parkplatz.enter();
    		parkplatz.setBus(b);
    		
    		System.out.println();
    	}
    	
        /*RemoteControl control = new RemoteControl();

        TrafficLight light = new TrafficLight();

        ICommand lightsOn = new GreenCommand(light);
        ICommand lightsOff = new RedCommand(light);

        control.setCommand(lightsOn);
        control.pressButton();
        System.out.println(light);

        System.out.println();

        control.setCommand(lightsOff);
        control.pressButton();
        System.out.println(light);
        */
    }
    
    public static Parkplatz getFreeParkplatz(List<Parkplatz> parkplaetze) {
    	for (Parkplatz parkplatz : parkplaetze) {
    		if (parkplatz.getBus() == null) {
    			return parkplatz;
    		}
    	}
		return null;
    	
    }
}