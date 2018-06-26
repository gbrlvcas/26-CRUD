package br.com.crud.main;

import br.com.crud.connection.ConnectionFactory;
import br.com.crud.view.ProdutoView;

public class Main {

	public static void main(String[] args) {
		
		ConnectionFactory cf = new ConnectionFactory();
		cf.obterConexao();
		
		//Exibir o JFrame Produto
		ProdutoView pv = new ProdutoView();
		pv.setVisible(true);

	}

}
