package br.aplicacao.eletrica.uteis;

public class TrataID {

public static Integer StringToInteger(String id) {
	Integer valor = 0;
	if(id.equals("") || id.equals(null)|| id.equals("0")) {
		valor = null;
	}else {
		valor = Integer.valueOf(id);
	}
	return valor;
}

}
 