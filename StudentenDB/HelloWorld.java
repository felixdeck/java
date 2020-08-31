package StudentenDB;

import java.util.StringTokenizer;

// Übung zu Strings 

public class HelloWorld {
	public static void main(String[] args){
		String s = "Hello World!";
		System.out.println(s);

		// ##### Finde Indizes in String die den Wert 'l' haben:		
//		int fromIndex = 0;
//		while(fromIndex < s.length()) { 
//			int res = s.indexOf('l', fromIndex);
//			if(res ==-1) {
//				break;
//			}
//			System.out.println(res);
//			fromIndex=res+1;
//		}

		
		// ##### Gebe nur den Teilstring "World" aus
//		String partOfs=s;
//		System.out.println(partOfs.substring(6, 11));
		
		
		// Datentypen: Dezimal --> Hex-Darstellung durch verweden  von Klassen für Grunddatentypen
//		for(int i = 0; i <= 16;i++) {
//			Integer newI = i;
//			System.out.println(newI.toHexString(i));
//		}
		
		// ##### StringTokenizer spereiert String in Teilstings
		String string = "Felix Deckenbach, Bubenlachring 28, 68642 Bürstadt";
		StringTokenizer toked = new StringTokenizer(string, ",");
		String name="None";
		String street="None";
		String onlyStreet="None";
		String houseNo="None";
	
		String town="None";
		String plz="None";
		String onlyTown="None";
		
		if(toked.countTokens()!=3) {
			System.out.print("Wrong formatted address-string");
		}
		else {
			name=toked.nextToken().trim();
			street=toked.nextToken().trim();
			town=toked.nextToken().trim();
			
		
			onlyStreet=street.substring(0, street.indexOf(" "));	
			houseNo=street.substring(street.indexOf(" ")+1);
		}
		System.out.println("Name: "+name+ " | Street: "+street+ " | Town: "+town);
		System.out.println("Name: "+name+ " | onlyStreet: "+onlyStreet+ " |HouseNo: "+houseNo+" | Town: "+town);
	}
}
