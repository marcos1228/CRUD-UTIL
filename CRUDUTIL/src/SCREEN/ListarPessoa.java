package SCREEN;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.PessoaDao;
import ENTIDADES.Contato;
import ENTIDADES.Pessoa;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
 
public class ListarPessoa extends JFrame {

    protected static final Long eventMask = null;
	protected static final String conexao = null;
	private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JTextField txtAgendaEletrnica;
    private JTextField txtAgendaEletrnica_1;
   
    public ListarPessoa() {
        super("pessoas");
        setTitle("Agenda Eletr\u00F4nica");
        criaJTable();
        criaJanela();
        
    }
 
    public void criaJanela() {
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(44, 139, 599, 145);
        barraRolagem.setEnabled(false);
        painelFundo = new JPanel();
        painelFundo.setBackground(Color.WHITE);
        painelFundo.setLayout(null);
        painelFundo.add(barraRolagem);
 
        getContentPane().add(painelFundo, BorderLayout.CENTER);
        btInserir = new JButton("Inserir");
        btInserir.setBounds(44, 295, 124, 52);
        painelFundo.add(btInserir);
        btEditar = new JButton("Editar");
        btEditar.setBounds(200, 295, 124, 52);
        painelFundo.add(btEditar);
        btExcluir = new JButton("Excluir");
        btExcluir.setBounds(361, 295, 124, 52);
        painelFundo.add(btExcluir);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 798, 84);
        painelFundo.add(panel);
        panel.setLayout(null);
        
        txtAgendaEletrnica = new JTextField();
        txtAgendaEletrnica.setBounds(100, 500, 500, 100);
        txtAgendaEletrnica.setText("Agenda Eletr\u00F4nica");
        panel.add(txtAgendaEletrnica);
        txtAgendaEletrnica.setColumns(10);
        
        txtAgendaEletrnica_1 = new JTextField();
        txtAgendaEletrnica_1.setEditable(false);
        txtAgendaEletrnica_1.setForeground(new Color(255, 255, 255));
        txtAgendaEletrnica_1.setBackground(new Color(50, 205, 50));
        txtAgendaEletrnica_1.setFont(new Font("Arial", Font.PLAIN, 43));
        txtAgendaEletrnica_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtAgendaEletrnica_1.setText("Agenda Eletr\u00F4nica");
        txtAgendaEletrnica_1.setBounds(0, 0, 758, 67);
        panel.add(txtAgendaEletrnica_1);
        txtAgendaEletrnica_1.setColumns(10);
        
        JButton btnAdconatos = new JButton("Ver Contatos");
        btnAdconatos.setBounds(519, 295, 124, 52);
        btnAdconatos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int linhaSelecionada = -1;
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    InserirContato ip = new InserirContato((Long) tabela.getValueAt(linhaSelecionada, 0), linhaSelecionada);
                    ip.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                }
        		
        		
        	}
        });
        painelFundo.add(btnAdconatos);
        btExcluir.addActionListener(new BtExcluirListener());
        btEditar.addActionListener(new BtEditarListener());
        btInserir.addActionListener(new BtInserirListener());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(775, 398);
        setVisible(true);
    }
 
    protected List<Pessoa> buscarPessoaPorNome(String text) {
		return null;
	}

	private void criaJTable() {
        tabela = new JTable(modelo);
        
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereco");
        modelo.addColumn("Bairro");
        modelo.addColumn("CPF");
        modelo.addColumn("Sexo");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(25);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        pesquisar(modelo);
    }
 
    public static void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        PessoaDao dao = new PessoaDao();
        for (Pessoa p : dao.getPessoas()) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getEndereco(), p.getBairro(), p.getCpf(), p.getSexo()});
        }
    }
 
    private class BtInserirListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            InserirPessoa ip = new InserirPessoa(modelo);
            ip.setVisible(true);
        }
    }
 
    
    /*
     * botão editar registro
     * */
    private class BtEditarListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                Long idPessoa = (Long) tabela.getValueAt(linhaSelecionada, 0);
                AtualizarPessoa ip = new AtualizarPessoa(modelo, (long) idPessoa, linhaSelecionada);
                ip.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }
 
    private class BtExcluirListener implements ActionListener {
    	
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                Long idPessoa = (Long) tabela.getValueAt(linhaSelecionada, 0);
                PessoaDao dao = new PessoaDao();
                dao.remover(idPessoa);
                modelo.removeRow(linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }
 
    public static void main(String[] args) {
        ListarPessoa lp = new ListarPessoa();
        lp.setVisible(true);
    }
}