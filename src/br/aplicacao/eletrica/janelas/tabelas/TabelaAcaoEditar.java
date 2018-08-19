package br.aplicacao.eletrica.janelas.tabelas;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;

public class TabelaAcaoEditar implements TableModelListener {

	private TabelaModeloFrm tabelaFrm;

	public TabelaAcaoEditar(TabelaModeloFrm tabelaFrm) {
		this.tabelaFrm = tabelaFrm;
		this.adicionaTableModelListener();
	}

	private void adicionaTableModelListener() {

		tabelaFrm.getTable().getModel().addTableModelListener(this);
		;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
/*		int col = e.getColumn();
        int row = e.getLastRow();
        
 
        if( col < 0 ){
            // Opps, estou inserindo a linha toda!
        }else{
            System.out.println("Valor atualizado: " + tabelaFrm.getTabelaControle().getTabela().getValueAt(row, col));
        }
        if( e.getType() == e.INSERT )
            System.out.println("Inserindo...");
        if( e.getType() == e.DELETE )
            System.out.println("Apagando...");
        if( e.getType() == e.UPDATE )
            System.out.println("Atualizando...");
*/
		int i = e.getFirstRow();
		CapacidadeCorrente capacidadeCorrente = tabelaFrm.getTabelaControle().getTabela().loadItem(i);
		CapacidadeCorrenteService.salva(capacidadeCorrente);
	}

}
