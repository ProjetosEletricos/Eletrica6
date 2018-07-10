package teste;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.modelo.projeto.Equipamento;

public class ex3_3 {

	public static void main(String[] args) {

		Circuito CIR_1 = new Circuito();
		CIR_1.setNome("CIR_1");

		Equipamento motor1 = new Equipamento();
		motor1.setNome("Motor3000");
		motor1.setPotencia(3000);
		motor1.setUnidade(UnidadePontencia.W);
		motor1.setFp(0.86);
		motor1.setLigacao("FN");
		motor1.setTensaoFN(220);

		Equipamento motor2 = new Equipamento();
		motor2.setNome("Motor800");
		motor2.setPotencia(800);
		motor2.setUnidade(UnidadePontencia.W);
		motor2.setFp(0.70);
		motor2.setLigacao("FN");
		motor2.setTensaoFN(220);

		Equipamento motor3 = new Equipamento();
		motor3.setNome("Motor600");
		motor3.setPotencia(600);
		motor3.setUnidade(UnidadePontencia.W);
		motor3.setFp(0.60);
		motor3.setLigacao("FN");
		motor3.setTensaoFN(220);

		Equipamento motor4 = new Equipamento();
		motor4.setNome("Motor2500");
		motor4.setPotencia(2500);
		motor4.setUnidade(UnidadePontencia.W);
		motor4.setFp(0.80);
		motor4.setLigacao("FF");
		motor4.setTensaoFN(220);

		CIR_1.addEquipamento(motor1);
		CIR_1.addEquipamento(motor2);
		CIR_1.addEquipamento(motor3);
		CIR_1.addEquipamento(motor4);

		double correnteIB = CIR_1.getCorrenteIB();

		System.out.println("CorrenteIB: " + correnteIB);

		for (Equipamento eq : CIR_1.getEquipamento()) {
			System.out.println("Equipamento: " + eq.getNome() + ". Ligação: " + eq.getLigacaoReal());
		}

		// CorrenteIB: 24.057234928367436
		// Equipamento: Motor3000. Liga��o: AN
		// Equipamento: Motor800. Liga��o: BN
		// Equipamento: Motor600. Liga��o: BN
		// Equipamento: Motor2500. Liga��o: AB

	}

}
