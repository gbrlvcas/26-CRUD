package br.com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.crud.dao.ProdutoDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField textField_2;
	private JButton btnExcluir;
	private JButton btnCancelar;


	public AlterarProdutoView(int idProduto) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setForeground(Color.BLACK);
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigo.setBounds(48, 35, 67, 26);
		contentPane.add(lblCdigo);
		
		txtCodigo = new JTextField(String.valueOf(idProduto));
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(119, 38, 224, 25);
		contentPane.add(txtCodigo);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduto.setForeground(Color.BLACK);
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduto.setBounds(32, 86, 76, 26);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(119, 89, 224, 25);
		contentPane.add(txtProduto);
		
		JButton btnAlterarProduto = new JButton("Alterar");
		btnAlterarProduto.setForeground(Color.WHITE);
		btnAlterarProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarProduto.setBackground(Color.DARK_GRAY);
		btnAlterarProduto.setBounds(10, 198, 105, 41);
		contentPane.add(btnAlterarProduto);
		
		JLabel label_2 = new JLabel("Valor");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(58, 138, 50, 26);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(119, 140, 224, 25);
		contentPane.add(textField_2);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExcluir.setBackground(Color.DARK_GRAY);
		btnExcluir.setBounds(137, 198, 129, 41);
		contentPane.add(btnExcluir);

		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Chamar o método para excluir
				ProdutoDao pd = new ProdutoDao();
				pd.excluirProduto(idProduto);
				
				//Fechar JFrame
				dispose();
				
				//Chamar o outro JFrame
				ProdutoView pv = new ProdutoView();
				pv.setVisible(true);
				
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(289, 198, 105, 41);
		contentPane.add(btnCancelar);
	}
}
