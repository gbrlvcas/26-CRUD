package br.com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.crud.bean.ProdutoBean;
import br.com.crud.dao.ProdutoDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProduto;
	private JTextField txtValorProduto;
	private JTable tblListarProdutos;


	public ProdutoView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNomeProduto = new JLabel("Produto");
		lblNomeProduto.setForeground(Color.WHITE);
		lblNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeProduto.setBounds(10, 45, 67, 26);
		contentPane.add(lblNomeProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(81, 48, 224, 25);
		contentPane.add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		JLabel lblValorProduto = new JLabel("Valor");
		lblValorProduto.setForeground(Color.WHITE);
		lblValorProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorProduto.setBounds(20, 82, 50, 26);
		contentPane.add(lblValorProduto);
		
		txtValorProduto = new JTextField();
		txtValorProduto.setColumns(10);
		txtValorProduto.setBounds(81, 85, 224, 25);
		contentPane.add(txtValorProduto);
		
		//Instanciar um objeto da classe ProdutoDao
		ProdutoDao pd = new ProdutoDao();
		
		//Table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 284, 368, 185);
		contentPane.add(scrollPane);
		tblListarProdutos = new JTable();
		tblListarProdutos.setModel(pd.listarProdutos());
		scrollPane.setViewportView(tblListarProdutos);
		
		//Ação do mouse - Clique
		tblListarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Obter a linha selecionada
				int linhaSelecionada = tblListarProdutos.getSelectedRow();
				
				//Obter o idProduto
				int idProduto = (int) tblListarProdutos.getValueAt(linhaSelecionada, 0);
				
				//Fechar formulario
				dispose();
				
				//Abrir o formulario para alterar/excluir
				AlterarProdutoView apv = new AlterarProdutoView(idProduto);
				apv.setVisible(true);
				
				
			}
		});
		
		//Botão cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBounds(101, 148, 185, 41);
		contentPane.add(btnCadastrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\104969\\Desktop\\Trabalho Programador\\25 - CRUD\\BG.gif"));
		label.setBounds(0, 0, 388, 482);
		contentPane.add(label);
		
		btnCadastrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			//Instanciar um objeto da calsse ProdutoBean
			ProdutoBean pb = new ProdutoBean();
			pb.setNomeProduto(txtNomeProduto.getText());
			pb.setValorProduto(Double.parseDouble(txtValorProduto.getText()));

			//Executar o método de cadastro
			ProdutoDao pd = new ProdutoDao();
			pd.cadastrarProduto(pb);
			
			//Limpar campos
			txtNomeProduto.setText("");
			txtValorProduto.setText("");
			
			//Cursor no campo nome produto
			txtNomeProduto.requestFocus();
			
			//Atualizar tabela
			tblListarProdutos.setModel(pd.listarProdutos());
			
		}
	});
		

	}
}
