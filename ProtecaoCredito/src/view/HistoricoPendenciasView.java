package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CadastroPendenciasController;

import javax.swing.border.LineBorder;
import java.awt.Color;

public class HistoricoPendenciasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpfcnpj;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoPendenciasView frame = new HistoricoPendenciasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoricoPendenciasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistricoDePendncias = new JLabel("Hist\u00F3rico de Pend\u00EAncias");
		lblHistricoDePendncias.setBounds(169, 11, 164, 14);
		contentPane.add(lblHistricoDePendncias);
		
		txtcpfcnpj = new JTextField();
		txtcpfcnpj.setBounds(218, 36, 164, 20);
		contentPane.add(txtcpfcnpj);
		txtcpfcnpj.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(179, 39, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setBounds(10, 39, 46, 14);
		contentPane.add(lblPessoa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		comboBox.setBounds(66, 36, 103, 20);
		contentPane.add(comboBox);
		
		JButton localizarCliente = new JButton("Buscar");
		localizarCliente.setBounds(396, 35, 89, 23);
		localizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lblCpf = Integer.parseInt(txtcpfcnpj.getText());
				CadastroPendenciasController cp = new CadastroPendenciasController();			
				cp.localizarCliente(lblCpf);
				
			}
		});
		contentPane.add(localizarCliente);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(396, 69, 89, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(10, 73, 103, 14);
		contentPane.add(lblNomeCompleto);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(113, 70, 269, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Natureza", "Nome do Credor", "Valor da D\u00EDvida", "Situacao"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Natureza", "Nome do Credor", "Valor da D\u00EDvida", "Situa\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.setBounds(10, 124, 475, 179);
		contentPane.add(table);
	}
}
