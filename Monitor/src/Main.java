
public class Main {
	
	public static void main(String[] args) {
		Lista lista = new Lista(3);
		lista.add(100);
		lista.add(10);
		lista.add(30);
		lista.add(20);
		lista.add(40);
		lista.add(20);
		lista.add(50);
		lista.add(70);
		lista.add(210);
			
		Lista l = (lista.quicksort());
		for(Integer i : l.getListaNumeros()){
			System.out.println(i);
		}
	}
}
