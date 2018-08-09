import javax.swing.JOptionPane;

public class problem2 {

	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String[] args) {
		problem2 a = new problem2();
		a.mediana();
	}


	private void mediana() {
		int nums=1;
		boolean ready = false;
		while(!ready) {
			try {
				nums = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos numeros desea agregar? "));
				ready=true;
			}
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ingresa un numero");
			}
		}

		int[] numeros = new int[nums];
		boolean control;
		for(int i=0;i<nums;i++) {
			control=false;
			while(!control) {
				try {
					numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero: "+(i+1)));
					if(numeros[i] != 0) {
						control=true;
					}
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Ingresa un numero ");
				}
			}
		}

		//comienza  acontar el tiempo
		long startTime = System.currentTimeMillis();

		sort(numeros);

		//	for (int i = 0; i < numeros.length; i++) {
		//		System.out.println(numeros[i]);
		//	}


		double res=0;
		if(numeros.length == 1) {
			res = numeros[0];
		}
		else if(numeros.length/2f % 1 == 0){
			double num1 = numeros.length/2f;
			double num2 = num1 - 1;		
			res = (numeros[(int)num1] + numeros[(int)num2])/2f;
		}
		else {
			res = numeros[numeros.length/2];
		}

		//finaliza el timepo
		long timems = System.currentTimeMillis() - startTime;

		JOptionPane.showMessageDialog(null, "La mediana es: "+res+" y tomó un tiempo de: "+ timems + " ms");
	}

	// ordenamiento por mergesort

	private void sort(int inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}
