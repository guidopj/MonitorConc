import java.util.LinkedList;
import java.util.List;



/*size que retorna el tamano de la lista

isEmpty que indica si la lista esta o no vacia

contains que indica si la lista contiene o no un elemento dado

add que agrega un elemento al final de la lista

get que retorna el elemento almacenado una posici ́on dada

set que permite alterar el valor del elemento almacenado en una posicion

dada*/

public class Lista {
	
	List<Integer> listaNumeros;
	int cantThreads;
	Sorter s;
	
	public Lista(int canti){
		this.cantThreads = canti;
		this.listaNumeros = new LinkedList<Integer>();
	}
	
	public Lista(){
		this.listaNumeros = new LinkedList<Integer>();
	}
	
	public synchronized int sizeList(){
		return this.getListaNumeros().size();
	}
	
	public synchronized boolean isEmpty(){
		return this.getListaNumeros().isEmpty();
	}
	
	public synchronized boolean contains(int n){
		return this.getListaNumeros().contains(n);
	}
	
	public synchronized void add(int n){
		this.getListaNumeros().add(n);
	}
	
	public synchronized void addAll(Lista n){
		this.getListaNumeros().addAll(n.getListaNumeros());
	}
	
	public synchronized int getList(int index){
		return this.getListaNumeros().get(index);
	}
	
	public synchronized int popList(int index){
		int n = this.getListaNumeros().get(index);
		this.getListaNumeros().remove(index);
		return n;
	}
	
	public synchronized void set(int index, int n){
		this.getListaNumeros().set(index, n);
	}
	
	Lista menoresA( int pivot) {
		Lista listaRet = new Lista();
		for(int n : this.getListaNumeros()){
			if(n < pivot){
				listaRet.add(n);
			}
		}
		return listaRet;
	}
		
	Lista mayoresA( int pivot) {
		Lista listaRet = new Lista();
		for(int n : this.getListaNumeros()){
			if(n > pivot){
				listaRet.add(n);
			}
		}
		return listaRet;
	}
	

	public synchronized void sort(){
		this.quicksort();
	}
	
	private Lista concat(Lista left, int pivot,
			Lista right) {
			left.add(pivot);
			left.addAll(right);
			return left;
	}
	
	public synchronized Lista quicksort(){
		if(this.sizeList() <= 1){
			return this;
		}
		int pivot = this.popList(0);
		Lista left =  this.menoresA(pivot);
		Lista right = this.mayoresA(pivot);
		
		Sorter sl = new Sorter(left);
		sl.start();
		//left = left.quicksort();
		
		Sorter sr = new Sorter(right);
		sr.start();
		//right = right.quicksort();
		
		return concat(left, pivot, right);
	}
	
	
	//////G AND S///////////////////////////
	public List<Integer> getListaNumeros() {
		return listaNumeros;
	}
	public void setListaNumeros(List<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}
	
	public int getCantThreads() {
		return cantThreads;
	}

	public void setCantThreads(int cantThreads) {
		this.cantThreads = cantThreads;
	}

	public Sorter getS() {
		return s;
	}

	public void setS(Sorter s) {
		this.s = s;
	}
}
