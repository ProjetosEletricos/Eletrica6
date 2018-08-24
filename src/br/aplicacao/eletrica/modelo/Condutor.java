package br.aplicacao.eletrica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Condutor implements Entidade<Condutor> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bitolaSucessiva;
	private String enterrado;
	private String espacoCabos;
	private String formaAgrupa;
	private String isolacao;
	private String material;
	private String modoInstalacao;
	private String multipolar;
	private int nCamadas;
	private int nCirAgrupa;
	private double quedaTensao;
	private double resistiTermica;
	private double temperatura;
	private double comprimento;

	public Condutor() {

	}

	public String getEnterrado() {
		return enterrado;
	}

	public String getMultipolar() {
		return multipolar;
	}

	public int getnCamadas() {
		return nCamadas;
	}

	public double getQuedaTensao() {
		return quedaTensao;
	}

	public void setEnterrado(String enterrado) {
		this.enterrado = enterrado;
	}

	public void setMultipolar(String multipolar) {
		this.multipolar = multipolar;
	}

	public void setnCamadas(int nCamadas) {
		this.nCamadas = nCamadas;
	}

	public void setQuedaTensao(double quedaTensao) {
		this.quedaTensao = quedaTensao;
	}

	public String getBitolaSucessiva() {
		return bitolaSucessiva;
	}

	public void setBitolaSucessiva(String bitolaSucessiva) {
		this.bitolaSucessiva = bitolaSucessiva;
	}

	public String getEspacoCabos() {
		return espacoCabos;
	}

	public void setEspacoCabos(String espacoCabos) {
		this.espacoCabos = espacoCabos;
	}

	public String getFormaAgrupa() {
		return formaAgrupa;
	}

	public void setFormaAgrupa(String formaAgrupa) {
		this.formaAgrupa = formaAgrupa;
	}

	public String getIsolacao() {
		return isolacao;
	}

	public void setIsolacao(String isolacao) {
		this.isolacao = isolacao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getModoInstalacao() {
		return modoInstalacao;
	}

	public void setModoInstalacao(String modoInstalacao) {
		this.modoInstalacao = modoInstalacao;
	}

	public int getnCirAgrupa() {
		return nCirAgrupa;
	}

	public void setnCirAgrupa(int nCirAgrupa) {
		this.nCirAgrupa = nCirAgrupa;
	}

	public double getResistiTermica() {
		return resistiTermica;
	}

	public void setResistiTermica(double resistiTermica) {
		this.resistiTermica = resistiTermica;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	@Override
	public Condutor clonarSemID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condutor copiar() {
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
		String nome = "id:" + this.id;
		return nome;
	}

	@Override
	public void apagar() {

		id = null;
		bitolaSucessiva = "";
		enterrado = "";
		espacoCabos = "";
		formaAgrupa = "";
		isolacao = "";
		material = "";
		modoInstalacao = "";
		multipolar = "";
		nCamadas = 0;
		nCirAgrupa = 0;
		quedaTensao = 0;
		resistiTermica = 0;
		temperatura = 0;
		comprimento = 0;

	}

}