package br.aplicacao.eletrica.modelo.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@Table(name = "Circuito")
@TableModel
public class Circuito implements Entidade<Circuito> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "quadro_id")
	private Quadro quadro;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Condutor", colPosition = 1)
	private Condutor condutor;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Dados CC", colPosition = 2)
	private Curto dadosCurtoCircuito;
	@OneToMany(mappedBy = "circuito", targetEntity = Equipamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Equipamento> equipamentos;
	@Column(colName = "Circuito", colPosition = 0)
	private String nome;

	public Circuito() {
		equipamentos = new ArrayList<Equipamento>();
		condutor = new Condutor();
		dadosCurtoCircuito = new Curto();
	}

	public void addEquipamento(Equipamento equipamento) {
		this.equipamentos.add(equipamento);
	}

	@Override
	public Circuito clonarSemID() {
		Circuito c = copiar();
		c.setId(null);
		return c;
	}

	@Override
	public Circuito copiar() {
		Circuito c = new Circuito();
		c.setId(id);
		c.setNome(nome);
		c.setCondutor(condutor);
		c.setCurto(dadosCurtoCircuito);

		for (Equipamento e : equipamentos) {
			c.equipamentos.add(e);
		}
		return c;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())

			return false;
		final Circuito other = (Circuito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public double getCorrenteIB() {

		ArrayList<Double> FFF = new ArrayList<Double>();
		ArrayList<Double> FF = new ArrayList<Double>();
		ArrayList<Double> FN = new ArrayList<Double>();
		ArrayList<Integer> cargaSeq = new ArrayList<Integer>();

		double somaAN = 0;
		double somaBN = 0;
		double somaCN = 0;
		double somaAB = 0;
		double somaCA = 0;
		double somaBC = 0;
		double somaABC = 0;

		double total = 0;
		int aux = 0;
		int fasesCircuito = 0;

		for (int i = 0; i < equipamentos.size(); i++) {

			double corrente = equipamentos.get(i).getCorrente();
			int fase = equipamentos.get(i).getNFases();

			switch (fase) {
			case 1:
				FN.add(corrente);
				cargaSeq.add(1);
				if (fasesCircuito < 1)
					fasesCircuito = 1;
				break;
			case 2:
				FF.add(corrente);
				cargaSeq.add(2);
				if (fasesCircuito < 2)
					fasesCircuito = 2;
				break;
			case 3:
				FFF.add(corrente);
				cargaSeq.add(3);
				if (fasesCircuito < 3)
					fasesCircuito = 3;
				break;
			}
		}

		switch (fasesCircuito) {

		case 1:
			for (int h = 0; h < FN.size(); h++) {
				somaAN = somaAN + FN.get(h);
				equipamentos.get(aux).setLigacaoReal("AN");
				aux += 1;
			}
			break;

		case 2:
			int aux4 = 0;
			int aux3 = 0;

			for (int i = 0; i < cargaSeq.size(); i++) {
				if (cargaSeq.get(i) == 1) {
					if (somaAN <= somaBN) {
						somaAN = somaAN + FN.get(aux3);
						equipamentos.get(aux).setLigacaoReal("AN");
						aux += 1;
					} else {
						somaBN = somaBN + FN.get(aux3);
						equipamentos.get(aux).setLigacaoReal("BN");
						aux += 1;
					}
					aux3 += 1;
				} else {
					somaAB = somaAB + FF.get(aux4);
					equipamentos.get(aux).setLigacaoReal("AB");
					aux += 1;
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
					if (somaAN <= somaBN && somaAN <= somaCN) {
						somaAN = somaAN + FN.get(aux5);
						equipamentos.get(aux).setLigacaoReal("AN");
						aux += 1;
					} else if (somaBN <= somaAN && somaBN <= somaCN) {
						somaBN = somaBN + FN.get(aux5);
						equipamentos.get(aux).setLigacaoReal("BN");
						aux += 1;
					} else if (somaCN <= somaAN && somaCN <= somaBN) {
						somaCN = somaCN + FN.get(aux5);
						equipamentos.get(aux).setLigacaoReal("CN");
						aux += 1;
					}
					aux5 += 1;
				} else if (cargaSeq.get(i) == 2) {
					if (somaAB <= somaBC && somaAB <= somaCA) {
						somaAB = somaAB + FF.get(aux6);
						equipamentos.get(aux).setLigacaoReal("AB");
						aux += 1;
					} else if (somaBC <= somaAB && somaBC <= somaCA) {
						somaBC = somaBC + FF.get(aux6);
						equipamentos.get(aux).setLigacaoReal("BC");
						aux += 1;
					} else if (somaCA <= somaAB && somaCA <= somaBC) {
						somaCA = somaCA + FF.get(aux6);
						equipamentos.get(aux).setLigacaoReal("CA");
						aux += 1;
					}
					aux6 += 1;
				} else if (cargaSeq.get(i) == 3) {
					somaABC = somaABC + FFF.get(aux7);
					equipamentos.get(aux).setLigacaoReal("ABC");
					aux += 1;
					aux7 += 1;
				}
			}
			break;
		}

		// ------------------------------------

		switch (fasesCircuito) {

		case 1:
			total = somaAN;
			break;

		case 2:
			if (somaAN >= somaBN) {
				total = somaAB + somaAN;
			} else {
				total = somaAB + somaBN;
			}
			break;

		case 3:
			aux = 0;
			boolean uso = false;

			if (somaAN >= somaBN && somaAN >= somaCN && uso == false) {
				if (somaAB >= somaBC && somaAB >= somaCA) {
					total = somaABC + somaAB + somaAN;
				}
				uso = true;
			}
			if (somaAN >= somaBN && somaAN >= somaCN && uso == false) {
				if (somaBC >= somaAB && somaBC >= somaCA) {
					total = somaABC + somaBC + somaAN;
				}
				uso = true;
			}
			if (somaAN >= somaBN && somaAN >= somaCN && uso == false) {
				if (somaCA >= somaAB && somaCA >= somaBC) {
					total = somaABC + somaCA + somaAN;
				}
			} else {
				if (somaBN >= somaAN && somaBN >= somaCN && uso == false) {
					if (somaAB >= somaBC && somaAB >= somaCA) {
						total = somaABC + somaAB + somaBN;
					}
					uso = true;
				}
				if (somaBN >= somaAN && somaBN >= somaCN && uso == false) {
					if (somaBC >= somaAB && somaBC >= somaCA) {
						total = somaABC + somaBC + somaBN;
					}
					uso = true;
				}
				if (somaBN >= somaAN && somaBN >= somaCN && uso == false) {
					if (somaCA >= somaAB && somaCA >= somaBC) {
						total = somaABC + somaCA + somaBN;
					}
				} else {
					if (somaCN >= somaAN && somaCN >= somaBN && uso == false) {
						if (somaAB >= somaBC && somaAB >= somaCA) {
							total = somaABC + somaAB + somaCN;
						}
						uso = true;
					}
					if (somaCN >= somaAN && somaCN >= somaBN && uso == false) {
						if (somaBC >= somaAB && somaBC >= somaCA) {
							total = somaABC + somaBC + somaCN;
						}
						uso = true;
					}
					if (somaCN >= somaAN && somaCN >= somaBN && uso == false) {
						if (somaCA >= somaAB && somaCA >= somaBC) {
							total = somaABC + somaCA + somaCN;
						}
					}
				}
			}
			break;
		}
		return total;
	}

	public Curto getCurto() {
		return dadosCurtoCircuito;
	}



	@Override
	public Integer getId() {
		return id;
	}

	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
	}

	public String getNome() {
		return nome;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setCurto(Curto dadosCurtoCircuito) {
		this.dadosCurtoCircuito = dadosCurtoCircuito;
	}

	public void setEquipamentos(List<Equipamento> equipamentosLista) {
		this.equipamentos.clear();
		this.equipamentos.addAll(equipamentosLista);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public void apagar() {

		id = null;
		quadro = null;
		condutor = null;
		dadosCurtoCircuito = null;
		equipamentos.clear();
		nome = "";

	}
}
