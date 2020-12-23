package main;

public class ChangeString {

	public static void main(String[] args) {
		String cadena = "123 abcd*3";
		if (args != null && args.length > 0) {
			cadena = args[0];
		}
		char caracteres[] = cadena.toCharArray();
		for (int i = 0; i < caracteres.length; i++) {
			caracteres[i] = next(caracteres[i]);			
		}
		String nuevaCadena = String.valueOf(caracteres);
		System.out.println(nuevaCadena);
	}
	
	private static char next(char letra) {
		if ((int)letra < 65 || ((int)letra > 90 && (int)letra < 97) 
				|| ((int)letra > 122 && (int)letra != 241 && (int)letra != 209)) {			
			return letra;
		}
		if ((int)letra == 90) {
			letra = (char)(65);
		} else if ((int)letra == 122) {
			letra = (char)(97);
		} else if ((int)letra == 241) {
			letra = (char)(111);
		} else if ((int)letra == 209) {
			letra = (char)(79);
		} else if ((int)letra == 110) {
			letra = (char)(241);
		} else if ((int)letra == 78) {
			letra = (char)(209);
		} else {
			letra = (char)(letra+1);
		}
		return letra;
	}
}
