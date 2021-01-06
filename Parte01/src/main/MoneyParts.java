package main;

public class MoneyParts {

	static private final Double[] MONEDAS = { 0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0, 100.0, 200.0 };

	public static void main(String[] args) {
		String entrada = "5.80";
		String salida = build(entrada);
		System.out.println("entrada: " + entrada + " salida: " + salida);
	}

	private static String build(String entrada) {
		Double total = Double.valueOf(entrada);
		// System.out.println(cambiar(total));
		return obtenerCambinaciones(total);
		// return null;
	}

	private static String obtenerCambinaciones(Double total) {
		int c = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Double moneda : MONEDAS) {
			if (total < moneda) {
				break;
			}
			// System.out.println("Vuelta " + ++c);
			String cadena = "";
			Double tmp = 0.0;
			for (int i = 0; i < round(total / moneda, 0); i++) {
				cadena += moneda + ", ";
				tmp += moneda;
				Double tmp2 = round(tmp + moneda, 2);
				if (tmp2 > total) {
					break;
				}
			}
			tmp = round(tmp, 2);
			if (tmp < total) {
				Double diff = round(total - tmp, 2);
				for (int x = 0; x < MONEDAS.length; x++) {
					Double moneda2 = MONEDAS[x];
					if (diff < moneda2) {
						break;
					}
					String cadena2 = "";
					Double tmp2 = 0.0;
					for (int i = 0; i < round(diff / moneda2, 0); i++) {
						cadena2 += moneda2 + ", ";
						tmp2 = round(tmp2 + moneda2, 2);
					}
					if (round(diff - tmp2, 2) == 0) {
						sb.append("[" + cadena + cadena2.substring(0, cadena2.length() - 2) + "], ");
					} else {
						diff = round(diff - tmp2, 2);
						cadena = cadena + cadena2;
						x = -1;
					}
				}
			} else {
				sb.append("[" + cadena.substring(0, cadena.length() - 2) + "]").append(", ");
			}
		}
		String cadena = sb.substring(0, sb.toString().length() - 2) + "]";
		return cadena;
	}

	private static Double round(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

}
