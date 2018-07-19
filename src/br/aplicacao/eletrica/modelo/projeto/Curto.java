package br.aplicacao.eletrica.modelo.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curto implements Entidade<Curto>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double correnteCurto;
	private double tempAdmissRegime;
	private double tempMaxCurto;
	private double tempoElimDef;

	public double getCorrenteCurto() {
		return correnteCurto;
	}

	public double getTempAdmissRegime() {
		return tempAdmissRegime;
	}

	public double getTempMaxCurto() {
		return tempMaxCurto;
	}

	public double getTempoElimDef() {
		return tempoElimDef;
	}

	public void setCorrenteCurto(double correnteCurto) {
		this.correnteCurto = correnteCurto;
	}

	public void setTempAdmissRegime(double tempAdmissRegime) {
		this.tempAdmissRegime = tempAdmissRegime;
	}

	public void setTempMaxCurto(double tempMaxCurto) {
		this.tempMaxCurto = tempMaxCurto;
	}

	public void setTempoElimDef(double tempoElimDef) {
		this.tempoElimDef = tempoElimDef;
	}

	@Override
	public Curto clonarSemID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curto copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String nome = "id:"+this.id;
		return nome;
	}
}