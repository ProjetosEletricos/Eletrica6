package br.aplicacao.eletrica.calculo;

import java.util.ArrayList;
import java.util.List;

import br.aplicacao.eletrica.modelo.projeto.Equipamento;

public class CorrenteIB {

	private ArrayList<Double> FFF;
	private ArrayList<Double> FF;
	private ArrayList<Double> FN;
	private ArrayList<Integer> cargaSeq;
	private List<Equipamento> equipamentos;
	private double SOMA_AN = 0;
	private double SOMA_BN = 0;
	private double SOMA_CN = 0;
	private double SOMA_AB = 0;
	private double SOMA_CA = 0;
	private double SOMA_BC = 0;
	private double SOMA_ABC = 0;
	private double TOTAL = 0;
	private int AUX = 0;
	private int FASES_CIRCUITO = 0;

	public CorrenteIB() {
		FFF = new ArrayList<Double>();
		FF = new ArrayList<Double>();
		FN = new ArrayList<Double>();
		cargaSeq = new ArrayList<Integer>();
		equipamentos = new ArrayList<Equipamento>();
	}

	public CorrenteIB withEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
		return this;
	}

	public double valor() {
		separaLigacoes();
		separaCorrentesPorCircuito();
		somaCorrentesPorCircuito();

		return TOTAL;
	}

	private void separaLigacoes() {

		for (int i = 0; i < equipamentos.size(); i++) {

			double corrente = equipamentos.get(i).getCorrente();
			int fase = equipamentos.get(i).getNFases();

			switch (fase) {
			case 1:
				FN.add(corrente);
				cargaSeq.add(1);
				if (FASES_CIRCUITO < 1)
					FASES_CIRCUITO = 1;
				break;
			case 2:
				FF.add(corrente);
				cargaSeq.add(2);
				if (FASES_CIRCUITO < 2)
					FASES_CIRCUITO = 2;
				break;
			case 3:
				FFF.add(corrente);
				cargaSeq.add(3);
				if (FASES_CIRCUITO < 3)
					FASES_CIRCUITO = 3;
				break;
			}
		}
	}

	private void separaCorrentesPorCircuito() {

		switch (FASES_CIRCUITO) {

		case 1:
			for (int h = 0; h < FN.size(); h++) {
				SOMA_AN = SOMA_AN + FN.get(h);
				equipamentos.get(AUX).setLigacaoReal("AN");
				AUX += 1;
			}
			break;

		case 2:
			int aux4 = 0;
			int aux3 = 0;

			for (int i = 0; i < cargaSeq.size(); i++) {
				if (cargaSeq.get(i) == 1) {
					if (SOMA_AN <= SOMA_BN) {
						SOMA_AN = SOMA_AN + FN.get(aux3);
						equipamentos.get(AUX).setLigacaoReal("AN");
						AUX += 1;
					} else {
						SOMA_BN = SOMA_BN + FN.get(aux3);
						equipamentos.get(AUX).setLigacaoReal("BN");
						AUX += 1;
					}
					aux3 += 1;
				} else {
					SOMA_AB = SOMA_AB + FF.get(aux4);
					equipamentos.get(AUX).setLigacaoReal("AB");
					AUX += 1;
					aux4 += 1;
				}
			}
			break;

		case 3:
			int aux5 = 0;
			int aux6 = 0;
			int aux7 = 0;

			for (int i = 0; i < cargaSeq.size(); i++) {
				if (cargaSeq.get(i) == 1) {
					if (SOMA_AN <= SOMA_BN && SOMA_AN <= SOMA_CN) {
						SOMA_AN = SOMA_AN + FN.get(aux5);
						equipamentos.get(AUX).setLigacaoReal("AN");
						AUX += 1;
					} else if (SOMA_BN <= SOMA_AN && SOMA_BN <= SOMA_CN) {
						SOMA_BN = SOMA_BN + FN.get(aux5);
						equipamentos.get(AUX).setLigacaoReal("BN");
						AUX += 1;
					} else if (SOMA_CN <= SOMA_AN && SOMA_CN <= SOMA_BN) {
						SOMA_CN = SOMA_CN + FN.get(aux5);
						equipamentos.get(AUX).setLigacaoReal("CN");
						AUX += 1;
					}
					aux5 += 1;
				} else if (cargaSeq.get(i) == 2) {
					if (SOMA_AB <= SOMA_BC && SOMA_AB <= SOMA_CA) {
						SOMA_AB = SOMA_AB + FF.get(aux6);
						equipamentos.get(AUX).setLigacaoReal("AB");
						AUX += 1;
					} else if (SOMA_BC <= SOMA_AB && SOMA_BC <= SOMA_CA) {
						SOMA_BC = SOMA_BC + FF.get(aux6);
						equipamentos.get(AUX).setLigacaoReal("BC");
						AUX += 1;
					} else if (SOMA_CA <= SOMA_AB && SOMA_CA <= SOMA_BC) {
						SOMA_CA = SOMA_CA + FF.get(aux6);
						equipamentos.get(AUX).setLigacaoReal("CA");
						AUX += 1;
					}
					aux6 += 1;
				} else if (cargaSeq.get(i) == 3) {
					SOMA_ABC = SOMA_ABC + FFF.get(aux7);
					equipamentos.get(AUX).setLigacaoReal("ABC");
					AUX += 1;
					aux7 += 1;
				}
			}
			break;
		}
	}

	private void somaCorrentesPorCircuito() {

		switch (FASES_CIRCUITO) {

		case 1:
			TOTAL = SOMA_AN;
			break;

		case 2:
			if (SOMA_AN >= SOMA_BN) {
				TOTAL = SOMA_AB + SOMA_AN;
			} else {
				TOTAL = SOMA_AB + SOMA_BN;
			}
			break;

		case 3:
			AUX = 0;
			boolean uso = false;

			if (SOMA_AN >= SOMA_BN && SOMA_AN >= SOMA_CN && uso == false) {
				if (SOMA_AB >= SOMA_BC && SOMA_AB >= SOMA_CA) {
					TOTAL = SOMA_ABC + SOMA_AB + SOMA_AN;
				}
				uso = true;
			}
			if (SOMA_AN >= SOMA_BN && SOMA_AN >= SOMA_CN && uso == false) {
				if (SOMA_BC >= SOMA_AB && SOMA_BC >= SOMA_CA) {
					TOTAL = SOMA_ABC + SOMA_BC + SOMA_AN;
				}
				uso = true;
			}
			if (SOMA_AN >= SOMA_BN && SOMA_AN >= SOMA_CN && uso == false) {
				if (SOMA_CA >= SOMA_AB && SOMA_CA >= SOMA_BC) {
					TOTAL = SOMA_ABC + SOMA_CA + SOMA_AN;
				}
			} else {
				if (SOMA_BN >= SOMA_AN && SOMA_BN >= SOMA_CN && uso == false) {
					if (SOMA_AB >= SOMA_BC && SOMA_AB >= SOMA_CA) {
						TOTAL = SOMA_ABC + SOMA_AB + SOMA_BN;
					}
					uso = true;
				}
				if (SOMA_BN >= SOMA_AN && SOMA_BN >= SOMA_CN && uso == false) {
					if (SOMA_BC >= SOMA_AB && SOMA_BC >= SOMA_CA) {
						TOTAL = SOMA_ABC + SOMA_BC + SOMA_BN;
					}
					uso = true;
				}
				if (SOMA_BN >= SOMA_AN && SOMA_BN >= SOMA_CN && uso == false) {
					if (SOMA_CA >= SOMA_AB && SOMA_CA >= SOMA_BC) {
						TOTAL = SOMA_ABC + SOMA_CA + SOMA_BN;
					}
				} else {
					if (SOMA_CN >= SOMA_AN && SOMA_CN >= SOMA_BN && uso == false) {
						if (SOMA_AB >= SOMA_BC && SOMA_AB >= SOMA_CA) {
							TOTAL = SOMA_ABC + SOMA_AB + SOMA_CN;
						}
						uso = true;
					}
					if (SOMA_CN >= SOMA_AN && SOMA_CN >= SOMA_BN && uso == false) {
						if (SOMA_BC >= SOMA_AB && SOMA_BC >= SOMA_CA) {
							TOTAL = SOMA_ABC + SOMA_BC + SOMA_CN;
						}
						uso = true;
					}
					if (SOMA_CN >= SOMA_AN && SOMA_CN >= SOMA_BN && uso == false) {
						if (SOMA_CA >= SOMA_AB && SOMA_CA >= SOMA_BC) {
							TOTAL = SOMA_ABC + SOMA_CA + SOMA_CN;
						}
					}
				}
			}
			break;
		}
	}
}