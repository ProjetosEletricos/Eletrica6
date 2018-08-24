package teste;

import br.aplicacao.eletrica.enums.Ligacao;
import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.modelo.Circuito;
import br.aplicacao.eletrica.modelo.Equipamento;

public class ex3_3 {

	public static void main(String[] args) {

		Circuito CIR_1 = new Circuito();
		CIR_1.setNome("CIR_1");

		Equipamento motor1 = new Equipamento();
		motor1.setNome("Motor3000");
		motor1.setPotencia(3000);
		motor1.setUnidade(UnidadePontencia.W);
		motor1.setFp(0.90);
		motor1.setLigacao(Ligacao.FN);
		motor1.setTensaoFN(220.0);

		Equipamento motor2 = new Equipamento();
		motor2.setNome("Motor800");
		motor2.setPotencia(800);
		motor2.setUnidade(UnidadePontencia.W);
		motor2.setFp(0.70);
		motor2.setLigacao(Ligacao.FN);
		motor2.setTensaoFN(220.0);

		Equipamento motor3 = new Equipamento();
		motor3.setNome("Motor600");
		motor3.setPotencia(600);
		motor3.setUnidade(UnidadePontencia.W);
		motor3.setFp(0.60);
		motor3.setLigacao(Ligacao.FN);
		motor3.setTensaoFN(220.0);

		Equipamento motor4 = new Equipamento();
		motor4.setNome("Motor2500");
		motor4.setPotencia(2500);
		motor4.setUnidade(UnidadePontencia.W);
		motor4.setFp(0.80);
		motor4.setLigacao(Ligacao.FF);
		motor4.setTensaoFN(380.0);

		CIR_1.addEquipamento(motor1);
		CIR_1.addEquipamento(motor2);
		CIR_1.addEquipamento(motor3);
		CIR_1.addEquipamento(motor4);

		double correnteIB = CIR_1.getCorrenteIB();

		System.out.println("CorrenteIB: " + correnteIB);

		for (Equipamento eq : CIR_1.getEquipamentos()) {
			System.out.println("Equipamento: " + eq.getNome() + ". Ligação: " + eq.getLigacaoReal());
		}

		// CorrenteIB: 23.375199362041464
		// Equipamento: Motor3000. Ligacao: AN
		// Equipamento: Motor800. Ligacao: BN
		// Equipamento: Motor600. Ligacao: BN
		// Equipamento: Motor2500. Ligacao: AB

	}

}
