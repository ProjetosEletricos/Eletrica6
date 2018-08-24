package teste;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;
import br.aplicacao.eletrica.modelo.Circuito;
import br.aplicacao.eletrica.modelo.Equipamento;
import br.aplicacao.eletrica.modelo.Fonte;
import br.aplicacao.eletrica.modelo.Projeto;
import br.aplicacao.eletrica.modelo.Quadro;
import br.aplicacao.eletrica.servico.ProjetoService;

public class TesteComBanco {

	public static void main(String[] args) {

		Projeto pro = new Projeto();
		pro.setNome("Projeto");

		Fonte fonte = new Fonte();
		fonte.setNome("Fonte");

		Quadro QGF = new Quadro();
		QGF.setId(1);
		QGF.setNome("QGF");

		Quadro CCM1 = new Quadro();
		CCM1.setNome("CCM1");
		CCM1.setId(2);

		Quadro CCM2 = new Quadro();
		CCM2.setNome("CCM2");
		CCM2.setId(3);

		Quadro QDL = new Quadro();
		QDL.setNome("QDL");
		QDL.setId(4);

		Circuito CIR_1 = new Circuito();
		CIR_1.setNome("CIR_1");
		Circuito CIR_2 = new Circuito();
		CIR_2.setNome("CIR_2");
		Circuito CIR_3 = new Circuito();
		CIR_3.setNome("CIR_3");
		Circuito CIR_FL = new Circuito();
		CIR_FL.setNome("CIR_FL");
		Circuito CIR_IN = new Circuito();
		CIR_IN.setNome("CIR_IN");

		Equipamento motor1 = new Equipamento();
		motor1.setNome("Motor1");
		motor1.setPotencia(75);
		motor1.setUnidade(UnidadePontencia.CV);
		motor1.setQuantidade(10);
		motor1.setFd(0.87);
		motor1.setRendimento(0.92);
		motor1.setFp(0.86);
		motor1.setfSimu(0.65);
		motor1.setUsabilidade(Usabilidade.GERAL);

		Equipamento motor2 = new Equipamento();
		motor2.setNome("Motor2");
		motor2.setPotencia(30);
		motor2.setUnidade(UnidadePontencia.CV);
		motor2.setQuantidade(10);
		motor2.setFd(0.85);
		motor2.setRendimento(0.9);
		motor2.setFp(0.83);
		motor2.setfSimu(0.65);
		motor2.setUsabilidade(Usabilidade.GERAL);

		Equipamento motor3 = new Equipamento();
		motor3.setNome("Motor3");
		motor3.setPotencia(50);
		motor3.setUnidade(UnidadePontencia.CV);
		motor3.setQuantidade(5);
		motor3.setFd(0.87);
		motor3.setRendimento(0.92);
		motor3.setFp(0.86);
		motor3.setfSimu(0.70);
		motor3.setUsabilidade(Usabilidade.GERAL);

		Equipamento lampFlu = new Equipamento();
		lampFlu.setNome("LampFlu");
		lampFlu.setQuantidade(150);
		lampFlu.setPotencia(40);
		lampFlu.setUnidade(UnidadePontencia.W);
		lampFlu.setPerdasReator(15.3);
		lampFlu.setFp(0.4);
		lampFlu.setUsabilidade(Usabilidade.ILUMINACAO_FLUORESCENTE);

		Equipamento lampInc = new Equipamento();
		lampInc.setNome("LampInc");
		lampInc.setQuantidade(52);
		lampInc.setPotencia(100);
		lampInc.setUnidade(UnidadePontencia.W);
		lampInc.setUsabilidade(Usabilidade.ILUMINACAO_INCADESCENTE);

		CIR_1.addEquipamento(motor1);
		CIR_2.addEquipamento(motor2);
		CIR_3.addEquipamento(motor3);
		CIR_FL.addEquipamento(lampFlu);
		CIR_IN.addEquipamento(lampInc);

		CCM1.addCircuito(CIR_1);
		CCM2.addCircuito(CIR_2);
		CCM2.addCircuito(CIR_3);
		QDL.addCircuito(CIR_FL);
		QDL.addCircuito(CIR_IN);

		QGF.addQuadro(CCM1);
		QGF.addQuadro(CCM2);
		QGF.addQuadro(QDL);

		fonte.addQuadro(QGF);
		pro.addFonte(fonte);

		ProjetoService.salva(pro);

	}
}
