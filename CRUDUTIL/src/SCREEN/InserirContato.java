package SCREEN;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.ContatoDao;
import DAO.PessoaDao;
import ENTIDADES.Contato;
import ENTIDADES.Pessoa;

public class InserirContato<ListarContato> extends JFrame {
	
	protected static final Long eventMask = null;
	protected static final String Column = null;
	private JPanel painelFundo;
	private JPanel painelFundo_1;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JLabel lbNome;
	private JLabel lbEndereco;
	private JLabel lbBairro;
	private JLabel lbCpf;
	private JTextField txNome;
	private JTextField txEndereco;
	private JTextField txCpf;
	private JTextField txBairro;
	Pessoa pessoa;
	Contato contato = new Contato();
	
	
	private int linhaSelecionada;
	
	private JTextField txtAgendaEletrnica;
	private JTextField txRegistro;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTextField txRegistro_1;
	private JTable tabelaContatos;
	private JLabel lblListaDeContatos;

	/*
	 * metodo teste criar tabela contato
	 */
	public  void criarTabelaContatos(List<Contato> registros) {
		DefaultTableModel modeloPadrao = new DefaultTableModel();
		
		modeloPadrao.addColumn("Código");
		modeloPadrao.addColumn("Tipo");
		modeloPadrao.addColumn("Registro");
		
		tabelaContatos = new JTable(modeloPadrao);		
		tabelaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaContatos.repaint();
		tabelaContatos.setVisible(true);
		
		if (!registros.isEmpty()) {
			for (Contato c : registros) {
				modeloPadrao.addRow(new Object[] {c.getId(), c.getTipo(), c.getRegistro()});
			}
		}
	}
	

	




	public InserirContato(Long idPessoaSelecionado, int linha) {
		super("");
		criaJanela();
	
		PessoaDao dao = new PessoaDao();
		pessoa = dao.getPessoaById(idPessoaSelecionado);
		txNome.setText(pessoa.getNome());
		txEndereco.setText(pessoa.getEndereco());
		txBairro.setText(pessoa.getBairro());
		txCpf.setText(pessoa.getCpf());

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 87);
		painelFundo_1.add(panel);
		panel.setLayout(null);

		txtAgendaEletrnica = new JTextField();
		txtAgendaEletrnica.setEditable(false);
		txtAgendaEletrnica.setForeground(new Color(255, 255, 255));
		txtAgendaEletrnica.setBackground(new Color(50, 205, 50));
		txtAgendaEletrnica.setFont(new Font("Arial", Font.PLAIN, 43));
		txtAgendaEletrnica.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgendaEletrnica.setBounds(0, 0, 638, 65);
		txtAgendaEletrnica.setText("Agenda Eletr\u00F4nica");
		panel.add(txtAgendaEletrnica);
		txtAgendaEletrnica.setColumns(10);

		JLabel lblNewLabel = new JLabel("Adicionar Contatos");
		lblNewLabel.setBounds(78, 222, 166, 19);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFundo_1.add(lblNewLabel);

		JComboBox Tipo = new JComboBox();
		Tipo.setBounds(78, 252, 91, 20);
		Tipo.setModel(new DefaultComboBoxModel(new String[] { "CELULAR", "EMAIL", "RESIDENCIAL" }));
		painelFundo_1.add(Tipo);

		ContatoDao dao1 = new ContatoDao();
		List<Contato> contatosPorIdPessoa = dao1.getContatosPorIdPessoa(pessoa.getId());
		if(contatosPorIdPessoa.size() > 0) {
			criarTabelaContatos(contatosPorIdPessoa);
		}

		/*
		 * componente para ajudar no scroll dos registro
		 * */
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(10, 313, 613, 273);
		painelFundo_1.add(scrollPaneTabela);
		scrollPaneTabela.setViewportView(tabelaContatos);

		

		JButton btnGrava = new JButton("Grava");
		btnGrava.setBounds(525, 251, 89, 23);
		btnGrava.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				ContatoDao dao = new ContatoDao();
				
				if(contato != null && contato.getRegistro() != null) {
					contato.setTipo(Tipo.getSelectedItem().toString());
					contato.setRegistro(txRegistro_1.getText());
					dao.atualizar(contato);
				}else {
					contato.setTipo(Tipo.getSelectedItem().toString());
					contato.setRegistro(txRegistro_1.getText());
					contato.setPessoaid(idPessoaSelecionado.intValue());					
					dao.inserir(contato);
				}
				
				
				List<Contato> contatosPorIdPessoa = dao.getContatosPorIdPessoa(pessoa.getId());
				if(contatosPorIdPessoa.size() > 0) {
					criarTabelaContatos(contatosPorIdPessoa);
					
				}
				
				scrollPaneTabela.setViewportView(tabelaContatos);	
			}
		
		});

		painelFundo_1.add(btnGrava);

		lblNewLabel_1 = new JLabel("Informa\u00E7\u00F5es da pessoa");
		lblNewLabel_1.setBounds(0, 63, 207, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFundo_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(40, 255, 28, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		painelFundo_1.add(lblNewLabel_2);

		txRegistro_1 = new JTextField();
		txRegistro_1.setBounds(174, 252, 339, 20);
		painelFundo_1.add(txRegistro_1);
		txRegistro_1.setColumns(10);

		lblListaDeContatos = new JLabel("Lista de Contatos pessoa");
		lblListaDeContatos.setBounds(0, 425, 513, 30);
		lblListaDeContatos.setFont(new Font("Arial", Font.PLAIN, 26));
		lblListaDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		painelFundo_1.add(lblListaDeContatos);
		
		//Boton excluir Contato
		JButton btnNewButton_1 = new JButton("Exluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContatoDao dao = new ContatoDao();
				int linhaSelecionada = -1;
	            linhaSelecionada = tabelaContatos.getSelectedRow();
	            if (linhaSelecionada >= 0) {
	                Long idContato = (Long) tabelaContatos.getValueAt(linhaSelecionada, 2);
	                dao.remover(idContato);
	                DefaultTableModel modeloPadrao = (DefaultTableModel) tabelaContatos.getModel();
	                modeloPadrao.removeRow(linhaSelecionada);
					
	            } else {
	                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
	            }
			}
		});
		btnNewButton_1.setBounds(240, 283, 84, 23);
		painelFundo_1.add(btnNewButton_1);
		
		// Editar
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabelaContatos.getSelectedRow();
				if (linhaSelecionada >= 0) {
					String strTipo = (String) tabelaContatos.getValueAt(linhaSelecionada, 1);
					String strRegistro = (String) tabelaContatos.getValueAt(linhaSelecionada, 2);
					String strId = tabelaContatos.getValueAt(linhaSelecionada, 0).toString();

					Tipo.setSelectedItem(strTipo);
					txRegistro_1.setText(strRegistro);

					ContatoDao dao = new ContatoDao();
					contato = dao.getContatoById(Long.parseLong(strId));
					Tipo.setSelectedItem(strTipo);
					txRegistro_1.setText(contato.getRegistro());

				}

			}
		});
		btnNewButton_2.setBounds(141, 283, 89, 23);
		painelFundo_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(63, 183, 46, 14);
		painelFundo_1.add(lblNewLabel_3);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contato = new Contato();
				txRegistro_1.setText("");
				txRegistro_1.grabFocus();
			}
		});
		btnNovo.setBounds(42, 283, 89, 23);
		painelFundo_1.add(btnNovo);
//		txtIdContato.setVisible(false);

	}

	public void criaJanela() {

		getContentPane().getLayout();
		lbNome = new JLabel("Nome:");
		lbNome.setBounds(56, 98, 36, 20);
		lbEndereco = new JLabel(" Endere\u00E7o:");
		lbEndereco.setBounds(40, 160, 69, 20);
		lbBairro = new JLabel("Bairro:");
		lbBairro.setBounds(329, 160, 52, 20);
		lbCpf = new JLabel("C.P.F:");
		lbCpf.setBounds(375, 108, 41, 20);
		txNome = new JTextField();
		txNome.setBounds(56, 129, 309, 20);
		txNome.setEditable(false);
		txEndereco = new JTextField();
		txEndereco.setEditable(false);
		txEndereco.setBounds(56, 180, 268, 20);
		txBairro = new JTextField();
		txBairro.setBounds(334, 180, 248, 20);
		txBairro.setEditable(false);
		txCpf = new JTextField();
		txCpf.setBounds(375, 129, 207, 20);
		txCpf.setEditable(false);

		// criando grid Contatos
		painelFundo_1 = new JPanel();
		painelFundo_1.setBackground(new Color(255, 255, 255));
		painelFundo_1.setBounds(0, 761, 784, 1);
		painelFundo_1.setLayout(null);
		painelFundo_1.add(lbNome);
		painelFundo_1.add(txNome);
		painelFundo_1.add(lbEndereco);
		painelFundo_1.add(txEndereco);
		painelFundo_1.add(lbBairro);
		painelFundo_1.add(txBairro);
		painelFundo_1.add(lbCpf);
		painelFundo_1.add(txCpf);

		getContentPane().add(painelFundo_1);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(650, 635);
		setVisible(true);
	
	}
	long currentTime() {
	    return java.lang.System.currentTimeMillis();
	}
}