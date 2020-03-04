package application;

public class CORTest {
	public static void main(String[] args) {
		
		Bus busB01 = new Bus(BusType.B01);
		Bus busB02 = new Bus(BusType.B02);
		Bus busB03 = new Bus(BusType.B03);
		Bus busB04 = new Bus(BusType.B04);
		
		Einfahrt einfahrtB01 = new EinfahrtB01();
		Einfahrt einfahrtB02 = new EinfahrtB02(einfahrtB01);
		Einfahrt einfahrtB03 = new EinfahrtB03(einfahrtB02);
		
		einfahrtB03.einfahrt(busB01);
		einfahrtB03.einfahrt(busB02);
		einfahrtB03.einfahrt(busB03);
		einfahrtB03.einfahrt(busB04);
		
	}
}
