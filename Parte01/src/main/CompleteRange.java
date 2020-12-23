package main;

import java.util.Arrays;

public class CompleteRange {

	public static void main(String[] args) {
		build(new int[]{20,38,5});	
	}
	
	private static void build(int[] rango) {
		int mayor = getMayor(rango);
		int[] arreglo = new int[mayor];
		for (int i = 0; i < arreglo.length; i++) {
			arreglo[i] = i + 1;			
		}
		System.out.println(Arrays.toString(arreglo));
	}

	private static int getMayor(int[] rango) {
		int mayor = rango[0];
		for (int i = 1; i < rango.length; i++) {
			if (mayor < rango[i]) {
				mayor = rango[i];
			}
		}
		return mayor;
	}

}
