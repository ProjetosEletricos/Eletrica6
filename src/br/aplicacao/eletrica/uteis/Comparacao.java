package br.aplicacao.eletrica.uteis;

public class Comparacao {

	public static boolean naFaixa(double valor, String p1, String pSinal1, String pSinal2, String p2) {

		boolean teste = false;
		double v1 = Numero.stringToDouble(p1);
		double v2 = Numero.stringToDouble(p2);

		try {
			if (!((p1.equals(null) || p1.equals("")) && (p2.equals(null) || p2.equals(""))
					&& (pSinal1.equals(null) || pSinal1.equals("")) && (pSinal2.equals(null) || pSinal2.equals("")))) {

				if (pSinal1.equals("ME") && pSinal2.equals("ME")) {
					if (v1 < valor && valor < v2) {
						teste = true;

					}
				} else if (pSinal1.equals("MEI") && pSinal2.equals("ME")) {
					if (v1 <= valor && valor < v2) {
						teste = true;

					}
				} else if (pSinal1.equals("ME") && pSinal2.equals("MEI")) {
					if (v1 < valor && valor <= v2) {
						teste = true;

					}
				} else if (pSinal1.equals("MEI") && pSinal2.equals("MEI")) {
					if (v1 <= valor && valor <= v2) {
						teste = true;

					}
				}
			} else if (pSinal2.equals("ME")) {
				if (valor < v2) {
					teste = true;

				}
			} else if (pSinal2.equals("MEI")) {
				if (valor <= v2) {
					teste = true;

				}
			} else if (pSinal2.equals("MA")) {
				if (valor > v2) {
					teste = true;

				}
			} else if (pSinal2.equals("MAI")) {
				if (valor >= v2) {
					teste = true;

				}
			}
		} catch (Exception e) {
			System.out.println("erro de teste em Comparacao()/naFaixa()");
		}
		return teste;
	}

}
