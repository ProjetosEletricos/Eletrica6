package br.aplicacao.eletrica.calculo;

public class faseMaisCarregada {
	/*
	 * private static ArrayList<Double> FFF; private static ArrayList<Double> FF;
	 * private static ArrayList<Double> FN; private static ArrayList<Integer>
	 * cargaSeq;
	 * 
	 * private static double correnteIB; private static boolean equilibrado = false;
	 * 
	 * public static double correnteIB(String tipo, ArrayList<?> objeto, double
	 * porcConsideradaParaEquilibrio) {
	 * 
	 * cargaSeq = new ArrayList<Integer>();
	 * 
	 * FFF = new ArrayList<Double>(); FF = new ArrayList<Double>(); FN = new
	 * ArrayList<Double>();
	 * 
	 * double somaAN = 0; double somaBN = 0; double somaCN = 0; double somaAB = 0;
	 * double somaCA = 0; double somaBC = 0; double somaABC = 0;
	 * 
	 * double total = 0; int aux = 0;
	 * 
	 * lerCorrentesCargas(objeto);
	 * 
	 * switch (tipo) {
	 * 
	 * case "Monof�sico": for (int h = 0; h < FN.size(); h++) { somaAN = somaAN +
	 * FN.get(h); if (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("AN"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("AN"); } aux += 1; } setEquilibrado(true); break;
	 * 
	 * 
	 * case "Bif�sico": int aux4 = 0; int aux3 = 0;
	 * 
	 * for (int i = 0; i < cargaSeq.size(); i++) {
	 * 
	 * if (cargaSeq.get(i) == 1) {
	 * 
	 * if (somaAN <= somaBN) { somaAN = somaAN + FN.get(aux3); if (objeto.get(0)
	 * instanceof Carga) { ((Carga) objeto.get(aux)).setLigacao("AN"); } else {
	 * ((Circuito) objeto.get(aux)).setLigacao("AN"); } aux += 1; } else { somaBN =
	 * somaBN + FN.get(aux3); if (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("BN"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("BN"); } aux += 1;
	 * 
	 * } aux3 += 1; } else {
	 * 
	 * somaAB = somaAB + FF.get(aux4); if (objeto.get(0) instanceof Carga) {
	 * ((Carga) objeto.get(aux)).setLigacao("AB"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("AB"); } aux += 1;
	 * 
	 * aux4 += 1; }
	 * 
	 * }
	 * 
	 * setEquilibrado(SupostaEquilibrado.verifica(somaAN, somaBN, somaCN,
	 * porcConsideradaParaEquilibrio)); break;
	 * 
	 * case "Trif�sico": int aux5 = 0; int aux6 = 0; int aux7 = 0;
	 * 
	 * for (int i = 0; i < cargaSeq.size(); i++) { if (cargaSeq.get(i) == 1) {
	 * 
	 * if (somaAN <= somaBN && somaAN <= somaCN) { somaAN = somaAN + FN.get(aux5);
	 * if (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("AN"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("AN"); } aux += 1; } else if (somaBN <= somaAN &&
	 * somaBN <= somaCN) { somaBN = somaBN + FN.get(aux5); if (objeto.get(0)
	 * instanceof Carga) { ((Carga) objeto.get(aux)).setLigacao("BN"); } else {
	 * ((Circuito) objeto.get(aux)).setLigacao("BN"); } aux += 1; } else if (somaCN
	 * <= somaAN && somaCN <= somaBN) { somaCN = somaCN + FN.get(aux5); if
	 * (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("CN"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("CN"); } aux += 1; } aux5 += 1; } else if
	 * (cargaSeq.get(i) == 2) {
	 * 
	 * // for (int h = 0; h < FF.size(); h++) { if (somaAB <= somaBC && somaAB <=
	 * somaCA) { somaAB = somaAB + FF.get(aux6); if (objeto.get(0) instanceof Carga)
	 * { ((Carga) objeto.get(aux)).setLigacao("AB"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("AB"); } aux += 1; } else if (somaBC <= somaAB &&
	 * somaBC <= somaCA) { somaBC = somaBC + FF.get(aux6); if (objeto.get(0)
	 * instanceof Carga) { ((Carga) objeto.get(aux)).setLigacao("BC"); } else {
	 * ((Circuito) objeto.get(aux)).setLigacao("BC"); } aux += 1; } else if (somaCA
	 * <= somaAB && somaCA <= somaBC) { somaCA = somaCA + FF.get(aux6); if
	 * (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("CA"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("CA"); } aux += 1; } aux6 += 1; } else if
	 * (cargaSeq.get(i) == 3) {
	 * 
	 * // for (int h = 0; h < FFF.size(); h++) { somaABC = somaABC + FFF.get(aux7);
	 * if (objeto.get(0) instanceof Carga) { ((Carga)
	 * objeto.get(aux)).setLigacao("ABC"); } else { ((Circuito)
	 * objeto.get(aux)).setLigacao("ABC"); } aux += 1; aux7 += 1; } }
	 * 
	 * setEquilibrado(SupostaEquilibrado.verifica(somaAN, somaBN, somaCN,
	 * porcConsideradaParaEquilibrio)); break; }
	 * 
	 * // aux = 0; // }
	 * 
	 * //------------------------------------
	 * 
	 * switch (tipo) {
	 * 
	 * case "Bif�sico": if (somaAN >= somaBN) { total = somaAB + somaAN;
	 * 
	 * } else { total = somaAB + somaBN;
	 * 
	 * } break;
	 * 
	 * case "Monof�sico": total = somaAN; break;
	 * 
	 * case "Trif�sico":
	 * 
	 * aux = 0; boolean uso = false;
	 * 
	 * if (somaAN >= somaBN && somaAN >= somaCN && uso == false) { if (somaAB >=
	 * somaBC && somaAB >= somaCA) { total = somaABC + somaAB + somaAN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("AN"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("AN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("AB"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("AB"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaAN >= somaBN && somaAN >= somaCN && uso == false) { if
	 * (somaBC >= somaAB && somaBC >= somaCA) { total = somaABC + somaBC + somaAN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("AN"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("AN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("BC"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("BC"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaAN >= somaBN && somaAN >= somaCN && uso == false) { if
	 * (somaCA >= somaAB && somaCA >= somaBC) { total = somaABC + somaCA + somaAN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("AN"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("AN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("CA"); } else { // ((Circuito)
	 * objeto.get(aux)).setLigacao("CA"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) objeto.get(aux)).setLigacao("ABC"); } aux += 1; } }
	 * 
	 * } else {
	 * 
	 * if (somaBN >= somaAN && somaBN >= somaCN && uso == false) { if (somaAB >=
	 * somaBC && somaAB >= somaCA) { total = somaABC + somaAB + somaBN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("BN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("BN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("AB"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("AB"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaBN >= somaAN && somaBN >= somaCN && uso == false) { if
	 * (somaBC >= somaAB && somaBC >= somaCA) { total = somaABC + somaBC + somaBN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("BN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("BN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("BC"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("BC"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaBN >= somaAN && somaBN >= somaCN && uso == false) { if
	 * (somaCA >= somaAB && somaCA >= somaBC) { total = somaABC + somaCA + somaBN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("BN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("BN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * objeto.get(aux)).setLigacao("CA"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("CA"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) objeto.get(aux)).setLigacao("ABC"); } else {
	 * // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } } else
	 * { if (somaCN >= somaAN && somaCN >= somaBN && uso == false) { if (somaAB >=
	 * somaBC && somaAB >= somaCA) { total = somaABC + somaAB + somaCN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * // objeto.get(aux)).setLigacao("CN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("CN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga) //
	 * objeto.get(aux)).setLigacao("AB"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("AB"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) // objeto.get(aux)).setLigacao("ABC"); } else
	 * { // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaCN >= somaAN && somaCN >= somaBN && uso == false) { if
	 * (somaBC >= somaAB && somaBC >= somaCA) { total = somaABC + somaBC + somaCN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * // objeto.get(aux)).setLigacao("CN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("CN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga) //
	 * objeto.get(aux)).setLigacao("BC"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("BC"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) // objeto.get(aux)).setLigacao("ABC"); } else
	 * { // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } uso =
	 * true; } if (somaCN >= somaAN && somaCN >= somaBN && uso == false) { if
	 * (somaCA >= somaAB && somaCA >= somaBC) { total = somaABC + somaCA + somaCN;
	 * 
	 * if (cargaSeq.get(0) == 1) { if (objeto.get(0) instanceof Carga) { // ((Carga)
	 * // objeto.get(aux)).setLigacao("CN"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("CN"); } aux += 1; } else if (cargaSeq.get(0) ==
	 * 2) { if (objeto.get(0) instanceof Carga) { // ((Carga) //
	 * objeto.get(aux)).setLigacao("CA"); } else { // ((Circuito) //
	 * objeto.get(aux)).setLigacao("CA"); } aux += 1; } else { if (objeto.get(0)
	 * instanceof Carga) { // ((Carga) // objeto.get(aux)).setLigacao("ABC"); } else
	 * { // ((Circuito) // objeto.get(aux)).setLigacao("ABC"); } aux += 1; } } } } }
	 * 
	 * }
	 * 
	 * return setCorrenteIB(total); }
	 * 
	 * private static void lerCorrentesCargas(ArrayList<?> objeto) {
	 * 
	 * for (int i = 0; i < objeto.size(); i++) {
	 * 
	 * double corrente = 0; int nFases = 0;
	 * 
	 * if (objeto.get(0) instanceof Carga) { corrente = ((Carga)
	 * objeto.get(i)).getCorrenteCarga(); } else { corrente = ((Circuito)
	 * objeto.get(i)).getCorrenteIB(); }
	 * 
	 * if (objeto.get(0) instanceof Carga) { nFases = ((Carga)
	 * objeto.get(i)).getnFases(); } else {
	 * 
	 * nFases = ((Circuito) objeto.get(i)).getNumFases();
	 * 
	 * } switch (nFases) {
	 * 
	 * case 1: FN.add(corrente); cargaSeq.add(1); break; case 2: FF.add(corrente);
	 * cargaSeq.add(2); break; case 3: FFF.add(corrente); cargaSeq.add(3); break;
	 * 
	 * } } }
	 * 
	 * public static double getCorrenteIB() { return correnteIB; }
	 * 
	 * public static double setCorrenteIB(double correnteIB) {
	 * faseMaisCarregada.correnteIB = correnteIB; return correnteIB; }
	 * 
	 * public static boolean isEquilibrado() { return equilibrado; }
	 * 
	 * public static void setEquilibrado(boolean equilibrado) {
	 * faseMaisCarregada.equilibrado = equilibrado; }
	 */
}