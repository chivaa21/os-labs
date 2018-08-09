public class problem1 {

	public static void main(String[] args) {
		problem1 a = new problem1();

		String palabra = "aabcdfggdfbckpopopoluiluiyljmhothy";
		System.out.println(a.norepetida(palabra));
	}


	private char norepetida(String palabra) {
		char tmp = ' ';
		int[] bandera = new int[500]; 

		for (int i = 0; i < palabra.length(); i++) { 
			bandera[(int)palabra.charAt(i)]++ ;
		}

		for (int i = 0; i < palabra.length(); i++) {
			if(bandera[(int)palabra.charAt(i)] == 1 && tmp == ' ') {
				tmp = palabra.charAt(i);
			}		
		}
		return tmp;
	}
}
