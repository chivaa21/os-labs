import java.util.Collections;
import java.util.LinkedList;

public class problem3 <E> extends LinkedList<E> {
	public LinkedList<Integer> blacklist = new LinkedList<>();
	public LinkedList<Integer> missingNums = new LinkedList<>();
	public int N=3000;
	public int K=2990;
	
	
	public int getRandom(){
		int x=N;
		
		int number =(int)(Math.random()*x);
		return number;	
	}
	
	public void getblacklist(){
		while(this.blacklist.size()<this.K) {
			int valor=getRandom();
			if(!(this.blacklist.contains(valor))) {
				this.blacklist.add(valor);

			}
		}
		Collections.sort(this.blacklist);
		System.out.println("Lista negra: "+this.blacklist);
	}

	public void getmissingNums() {
		while(this.missingNums.size()<(this.N-this.K)) {
			int valor=getRandom();
			if(!(this.blacklist.contains(valor)) && !(this.missingNums.contains(valor)) ) {
				this.missingNums.add(valor);
			}
		}
		Collections.sort(this.missingNums);
		System.out.println("Numeros faltantes: "+this.missingNums);
	}

	public static void main(String[] args) {
		problem3<Integer> lista = new problem3<>();
		lista.getblacklist();
		lista.getmissingNums();	

	}

}
