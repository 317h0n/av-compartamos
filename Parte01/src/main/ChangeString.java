package main;

public class ChangeString {

	public static void main(String[] args) {
		String cadena = "123 abcd*3";
		if (args != null && args.length > 0) {
			cadena = args[0];
		}
		build(cadena);
	}
	
	private static void build(String cadena) {
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
		switch ((int)letra) {
		case 90:
			letra = (char)(65);
			break;
		case 122:
			letra = (char)(97);
			break;
		case 241:
			letra = (char)(111);
			break;
		case 209:
			letra = (char)(79);
			break;
		case 110:
			letra = (char)(241);
			break;
		case 78:
			letra = (char)(209);
			break;
		default:
			letra = (char)(letra+1);
			break;
		}
		return letra;
	}
}
