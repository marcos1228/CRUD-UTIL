package SCREEN;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.PessoaDao;
import ENTIDADES.Pessoa;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InserirPessoa extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JComboBox Sexo = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbNome;
	private JLabel lbEndereco;
	private JLabel lbBairro;
	private JLabel lbRua;
	private JLabel lbCpf;
	private JLabel lbSexo;
	private JTextField txNome;
	private JTextField txEndereco;
	private JTextField txBairro;
	private JTextField txRua;
	private JTextField txCpf;
	private JPanel panel;
	private JTextField txtAgendaEletrnica;
	private JComboBox sexo;
	private JComboBox Tipo;

	public InserirPessoa(DefaultTableModel md) {
		super("Pessoas");
		criaJanela();
		modelo = md;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btSalvar.setBackground(new Color(192, 192, 192));
		btSalvar.setBounds(440, 254, 144, 34);
		btLimpar = new JButton("Limpar");
		btLimpar.setBackground(new Color(192, 192, 192));
		btLimpar.setBounds(311, 254, 119, 35);
		lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(46, 139, 83, 20);
		lbEndereco = new JLabel("Endere\u00E7o:");
		lbEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEndereco.setBounds(47, 193, 93, 20);
		lbBairro = new JLabel("Bairro:");
		lbBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lbBairro.setBounds(389, 193, 48, 20);
		lbCpf = new JLabel("CPF:");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(56, 87, 65, 20);
		lbSexo = new JLabel("Sexo:");
		lbSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSexo.setBounds(353, 140, 65, 18);
		txNome = new JTextField(10);
		txNome.setBounds(92, 163, 287, 20);
		txEndereco = new JTextField();
		txEndereco.setBounds(92, 213, 295, 20);
		txBairro = new JTextField();
		txBairro.setBounds(397, 213, 187, 20);
		txCpf = new JTextField();
		txCpf.setBounds(96, 111, 215, 20);
		painelFundo = new JPanel();
		painelFundo.setBackground(new Color(255, 255, 255));
		painelFundo.setLayout(null);
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbEndereco);
		painelFundo.add(txEndereco);
		painelFundo.add(lbBairro);
		painelFundo.add(txBairro);
		painelFundo.add(lbCpf);
		painelFundo.add(txCpf);
		painelFundo.add(lbSexo);

		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);

		panel = new JPanel();
		panel.setBounds(0, 0, 745, 76);
		painelFundo.add(panel);
		panel.setLayout(null);

		txtAgendaEletrnica = new JTextField();
		txtAgendaEletrnica.setEditable(false);
		txtAgendaEletrnica.setForeground(new Color(255, 255, 255));
		txtAgendaEletrnica.setBackground(new Color(50, 205, 50));
		txtAgendaEletrnica.setFont(new Font("Arial", Font.PLAIN, 43));
		txtAgendaEletrnica.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgendaEletrnica.setText("Agenda Eletr\u00F4nica");
		txtAgendaEletrnica.setBounds(0, 0, 645, 65);
		panel.add(txtAgendaEletrnica);
		txtAgendaEletrnica.setColumns(10);
		
		Sexo = new JComboBox();
		Sexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		Sexo.setBounds(409, 163, 98, 20);
		painelFundo.add(Sexo);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(660, 361);
		setVisible(true);
		btSalvar.addActionListener(new BtSalvarListener());
		btLimpar.addActionListener(new BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(txNome.getText());
			pessoa.setEndereco(txEndereco.getText());
			pessoa.setBairro(txBairro.getText());
			pessoa.setCpf(txCpf.getText());
			pessoa.setSexo((String) Sexo.getSelectedItem());
			PessoaDao dao = new PessoaDao();
			dao.inserir(pessoa);
			ListarPessoa.pesquisar(modelo);

			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txEndereco.setText("");
			txBairro.setText("");
			txCpf.setText("");
			
		}
	}
}