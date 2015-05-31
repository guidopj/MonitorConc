public class Sorter extends Thread{
	
	Lista lista;
	
	public Sorter(Lista l){
		this.lista = l;
	}
	
	@Override
	public void run() {
		lista.quicksort();
	}
}
