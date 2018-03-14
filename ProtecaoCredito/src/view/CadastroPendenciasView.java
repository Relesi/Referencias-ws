package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroPendenciasController;
import model.Cliente;
import model.Credor;
import model.NaturezaDivida;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroPendenciasView extends JFrame {

	private JPanel contentPane;
	private JTextField txtcpfcnpj;
	private JTextField txtnomeCliente;
	private JTextField txtcnpj;
	private JTextField txtnomeCredor;
	private JTextField txtcontatoCredor;
	private JTextField txtValorDivida;
	private JTextField txtNatureza;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPendenciasView frame = new CadastroPendenciasView();
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
	public CadastroPendenciasView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePendncias = new JLabel("Cadastro de Pend\u00EAncias");
		lblCadastroDePendncias.setBounds(171, 11, 172, 14);
		contentPane.add(lblCadastroDePendncias);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setBounds(10, 45, 46, 14);
		contentPane.add(lblPessoa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsica", "Jur\u00EDdica"}));
		comboBox.setBounds(66, 42, 110, 20);
		contentPane.add(comboBox);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 81, 46, 14);
		contentPane.add(lblCpf);
		
		txtcpfcnpj = new JTextField();
		txtcpfcnpj.setBounds(66, 78, 172, 20);
		contentPane.add(txtcpfcnpj);
		txtcpfcnpj.setColumns(10);
		
		JButton localizarCliente = new JButton("Localizar");
		localizarCliente.setBounds(275, 77, 89, 23);
		localizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lblCpf = Integer.parseInt(txtcnpj.getText());
				CadastroPendenciasController cp = new CadastroPendenciasController();			
				cp.localizarCliente(lblCpf);
				
			}
		});
		contentPane.add(localizarCliente);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(10, 112, 129, 14);
		contentPane.add(lblNomeCompleto);
		
		txtnomeCliente = new JTextField();
		txtnomeCliente.setEditable(false);
		txtnomeCliente.setBounds(115, 109, 249, 20);
		contentPane.add(txtnomeCliente);
		txtnomeCliente.setColumns(10);
		
		JLabel lblInformaesReferenteA = new JLabel("Informa\u00E7\u00F5es referente a d\u00EDvida");
		lblInformaesReferenteA.setBounds(152, 171, 222, 14);
		contentPane.add(lblInformaesReferenteA);
		
		JLabel lblCjpj = new JLabel("CNPJ:");
		lblCjpj.setBounds(10, 211, 46, 14);
		contentPane.add(lblCjpj);
		
		txtcnpj = new JTextField();
		txtcnpj.setBounds(66, 208, 172, 20);
		contentPane.add(txtcnpj);
		txtcnpj.setColumns(10);
		
		JButton localizarCredor = new JButton("Localizar");
		localizarCredor.setBounds(275, 207, 89, 23);
		contentPane.add(localizarCredor);
		localizarCredor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cpfCnpj = Integer.parseInt(txtcnpj.getText());
				CadastroPendenciasController cp = new CadastroPendenciasController();			
				cp.localizarCredor(cpfCnpj);
				
			}
		});
		
		JLabel lblNomeCredor = new JLabel("Nome Credor:");
		lblNomeCredor.setBounds(10, 242, 83, 14);
		contentPane.add(lblNomeCredor);
		
		txtnomeCredor = new JTextField();
		txtnomeCredor.setEditable(false);
		txtnomeCredor.setBounds(103, 239, 261, 20);
		contentPane.add(txtnomeCredor);
		txtnomeCredor.setColumns(10);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(10, 273, 71, 14);
		contentPane.add(lblContato);
		
		txtcontatoCredor = new JTextField();
		txtcontatoCredor.setEditable(false);
		txtcontatoCredor.setBounds(103, 270, 177, 20);
		contentPane.add(txtcontatoCredor);
		txtcontatoCredor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor da d\u00EDvida:");
		lblValor.setBounds(10, 304, 100, 14);
		contentPane.add(lblValor);
		
		txtValorDivida = new JTextField();
		txtValorDivida.setBounds(103, 301, 177, 20);
		contentPane.add(txtValorDivida);
		txtValorDivida.setColumns(10);
		
		JLabel lblNatureza = new JLabel("Natureza:");
		lblNatureza.setBounds(10, 333, 83, 14);
		contentPane.add(lblNatureza);
		
		txtNatureza = new JTextField();
		txtNatureza.setBounds(103, 330, 261, 20);
		contentPane.add(txtNatureza);
		txtNatureza.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(103, 361, 177, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 364, 46, 14);
		contentPane.add(lblData);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(363, 391, 110, 23);
		contentPane.add(btnLimpar);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				Credor cr = new Credor();
				NaturezaDivida n = new NaturezaDivida();
				Date data = null;
				double valor = Double.parseDouble(txtValorDivida.getText());
				
						
				CadastroPendenciasController cp = new CadastroPendenciasController();			
				cp.inserirPendencia(c, cr, n, data, valor, "Pendente");
				
			}
		});
		cadastrar.setBounds(363, 426, 110, 23);
		contentPane.add(cadastrar);
	}
}
