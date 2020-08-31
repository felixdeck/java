package ListenPaket;
import java.util.List;
import java.util.*;

public class ListTest{
	public static void main(String[] argv) {
		Long t1,t2,t3;
		List<Long> arrayList = new ArrayList<>();
		List<Long> linkedList = new LinkedList<>();
		t1 = System.nanoTime();
		arrayList.add(t1);
		t2 = System.nanoTime();
		linkedList.add(t2);
		t3 = System.nanoTime();

		Long td1 = t2-t1;
		Long td2 = t3-t2;
		System.out.println("Zeitdifferenz mit arrayList: " + td1);
		System.out.println("Zeitdifferenz mit linkedList: " + td2);
		/*Aufgabe 8.2 
		* Interpretation des Ergebnisses:
		* Das Hinzufügen von Listeneinträgen dauert in der ArrayList
		* kürzer als bei der LinkedList  (Faktor 2-3), da die ArrayList einfach nur 
		* ein Element an die Stelle des letzten Index's hinzufügt.
		* Die LinkedList muss allerdings erst ein Hilfsobjekt erstellen und dann noch
		* zwei Referenzen ergänzt werden.
		*/
	}
}
