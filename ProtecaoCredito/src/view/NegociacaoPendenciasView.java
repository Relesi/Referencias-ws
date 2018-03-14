package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CadastroPendenciasController;
import controller.NegociacaoPendenciasController;
import model.Cliente;
import model.Credor;
import model.FormaEnvioCobranca;
import model.FormaPagamento;
import model.NaturezaDivida;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NegociacaoPendenciasView extends JFrame {

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
					NegociacaoPendenciasView frame = new NegociacaoPendenciasView();
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
	public NegociacaoPendenciasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNegociao = new JLabel("Negocia\u00E7\u00E3o");
		lblNegociao.setBounds(202, 11, 114, 14);
		contentPane.add(lblNegociao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		comboBox.setBounds(66, 36, 101, 20);
		contentPane.add(comboBox);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setBounds(10, 39, 46, 14);
		contentPane.add(lblPessoa);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(177, 39, 46, 14);
		contentPane.add(lblCpf);
		
		txtcpfcnpj = new JTextField();
		txtcpfcnpj.setBounds(212, 36, 174, 20);
		contentPane.add(txtcpfcnpj);
		txtcpfcnpj.setColumns(10);
		
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
		lblNomeCompleto.setBounds(10, 73, 114, 14);
		contentPane.add(lblNomeCompleto);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(118, 70, 268, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Natureza", "Nome do Credor", "Valor da D\u00EDvida", "Situacao", "Selecionar"},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 117, 475, 32);
		contentPane.add(table);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setBounds(10, 172, 124, 14);
		contentPane.add(lblFormaDePagamento);
		
		JComboBox cbFormaPag = new JComboBox();
		cbFormaPag.setModel(new DefaultComboBoxModel(new String[] {"A prazo", "A vista"}));
		cbFormaPag.setBounds(140, 169, 83, 20);
		contentPane.add(cbFormaPag);
		
		JLabel lblOpesDeParcelamento = new JLabel("Op\u00E7\u00F5es de Parcelamento:");
		lblOpesDeParcelamento.setBounds(231, 172, 152, 14);
		contentPane.add(lblOpesDeParcelamento);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(384, 169, 101, 20);
		contentPane.add(comboBox_2);
		
		JButton gerarBoleto = new JButton("Gerar Boleto");
		gerarBoleto.setBounds(10, 222, 138, 23);
		contentPane.add(gerarBoleto);
		
		JLabel lblNewLabel = new JLabel("Op\u00E7\u00F5es de envio:");
		lblNewLabel.setBounds(10, 268, 107, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Endere\u00E7o", "E-mail"}));
		comboBox_3.setBounds(123, 265, 100, 20);
		contentPane.add(comboBox_3);
		
		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpar_1.setBounds(396, 247, 89, 23);
		contentPane.add(btnLimpar_1);
		
		JButton cadastrar = new JButton("Concluir");
		cadastrar.setBounds(396, 281, 89, 23);
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				Credor cr = new Credor();
				Date data = null;
				FormaPagamento formaPagamento = new FormaPagamento();
				FormaEnvioCobranca formaEnvio = new FormaEnvioCobranca();
				int parc = Integer.parseInt(comboBox_2.getToolTipText());			
						
				NegociacaoPendenciasController cp = new NegociacaoPendenciasController();			
				cp.inserirNegociacao(c, cr, data, formaPagamento, formaEnvio, parc );
				
			}
		});
		contentPane.add(cadastrar);
	}
}
