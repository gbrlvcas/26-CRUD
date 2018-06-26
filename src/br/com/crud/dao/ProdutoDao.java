package br.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.crud.bean.ProdutoBean;
import br.com.crud.connection.ConnectionFactory;

public class ProdutoDao {

	//Atributo contendo a conex�o
	private Connection conexao;
	
	//Construtor
	public ProdutoDao() {
		
		//Instanciar um objeto da calsse ConnectionFactory
		ConnectionFactory cf = new ConnectionFactory();
		conexao = cf.obterConexao();
	}
	
	//M�todo para cadastrar um produto
	public void cadastrarProduto(ProdutoBean obj) {
		
		//SQL
		String sql = "INSERT INTO produtos (nomeProduto, valorProduto) VALUES (?, ?)";
		
		//Tentar realizar o cadastro
		try{
			//Preparar o envio dos par�metros
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeProduto());
			pstmt.setDouble(2, obj.getValorProduto());
			
			//Executar o comando
			pstmt.execute();
			
			//Finaliza a conex�o
			pstmt.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar, erro"+e.getMessage());
		}
	}
	
	//M�todo para listar os produtos
	public DefaultTableModel listarProdutos(){
		
		//DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();
		
		//Colunas
		modelo.addColumn("C�digo");
		modelo.addColumn("Produto");
		modelo.addColumn("Valor");
		
		//SQL
		String sql = "Select * FROM Produtos";
		
		//Tentar executar
		try{
			//Comando para realizar a conex�o e executar
			Statement stmt = conexao.createStatement();
			
			//Obter todos os dados da tabela
			ResultSet rs = stmt.executeQuery(sql);
			
			//La�o
			while(rs.next()) {
				modelo.addRow(new Object[] {
						rs.getInt("idProduto"),
						rs.getString("nomeProduto"),
						rs.getDouble("valorProduto")
				});
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao executar a sele��o.");
		}
		
		//Retorno
		return modelo;
	}
	}
 
