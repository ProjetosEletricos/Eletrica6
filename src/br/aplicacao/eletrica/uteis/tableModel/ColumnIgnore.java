package br.aplicacao.eletrica.uteis.tableModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})

/**Interface que marca com annota��es quais atributos n�o devem aparecer na Tabela.
 * S� pode ser usada, uma vez que a annotation TableMode, esta com valor false.
	@author Marcos Vinicius Scholl


*/

public @interface ColumnIgnore {

}
