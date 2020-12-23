package main;

public class MoneyParts {

	public static void main(String[] args) {
		String entrada = "";
		String salida = build(entrada);
	}

	private static String build(String entrada) {
		Double total = Double.valueOf(entrada);
		return obtenerCambio(total);
	}

	private static String obtenerCambio(Double total) {
		// TODO Auto-generated method stub
		return null;
	}

}
