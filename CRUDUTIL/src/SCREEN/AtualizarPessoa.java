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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;





public class AtualizarPessoa extends JFrame {
	
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
    private JLabel lbId;
    private JTextField txNome;
    private JTextField txId;
    private	JTextField txEndereco;
    private JTextField txRua;
    private JTextField txCpf;
    private JTextField txBairro;
    Pessoa pessoa;
    private int linhaSelecionada;
    private JTable table;
    private JTextField txtAgendaEletrnica;
    private JComboBox sexo;
 
    public AtualizarPessoa(DefaultTableModel md, Long idSelecionado, int linha) {
        super("Pessoas");
        setTitle("AtualizarPessoa");
        criaJanela();
        modelo = md;
        PessoaDao dao = new PessoaDao();
        pessoa = dao.getPessoaById(idSelecionado);
        txId.setText(Long.toString(pessoa.getId()));
        txNome.setText(pessoa.getNome());
        txEndereco.setText(pessoa.getEndereco());
        txBairro.setText(pessoa.getBairro());
        txCpf.setText(pessoa.getCpf());
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 745, 65);
        painelFundo.add(panel);
        panel.setLayout(null);
        
        txtAgendaEletrnica = new JTextField();
        txtAgendaEletrnica.setEditable(false);
        txtAgendaEletrnica.setForeground(new Color(255, 255, 255));
        txtAgendaEletrnica.setBackground(new Color(50, 205, 50));
        txtAgendaEletrnica.setFont(new Font("Arial", Font.PLAIN, 43));
        txtAgendaEletrnica.setHorizontalAlignment(SwingConstants.CENTER);
        txtAgendaEletrnica.setBounds(0, 0, 620, 65);
        txtAgendaEletrnica.setText("Agenda Eletr\u00F4nica");
        panel.add(txtAgendaEletrnica);
        txtAgendaEletrnica.setColumns(10);
        
        sexo = new JComboBox();
        sexo.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
        sexo.setBounds(62, 211, 104, 20);
        painelFundo.add(sexo);
        getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lbId, txId, lbNome, txNome, lbEndereco, txEndereco, lbBairro, txBairro, lbRua, txRua, lbCpf, txCpf, btLimpar, btSalvar, painelFundo}));
        
        
    }
 
    public void criaJanela() {
        getContentPane().getLayout();
        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(184, 294, 93, 30);
        btSalvar.setBackground(Color.LIGHT_GRAY);
        btLimpar = new JButton("Limpar");
        btLimpar.setBackground(Color.LIGHT_GRAY);
        btLimpar.setBounds(41, 294, 93, 30);
        lbNome = new JLabel(" Nome ");
        lbNome.setBounds(20, 107, 93, 19);
        lbEndereco = new JLabel("Endereco:");
        lbEndereco.setBounds(23, 161, 93, 19);
        lbBairro = new JLabel("Bairro:");
        lbBairro.setBounds(348, 160, 93, 19);
        lbId = new JLabel(" Id:");
        lbId.setBounds(10, 77, 32, 19);
        lbCpf = new JLabel("CPF:");
        lbCpf.setBounds(347, 102, 49, 19);
        lbSexo = new JLabel(" Sexo:");
        lbSexo.setBounds(20, 211, 74, 21);
        txNome = new JTextField();
        txNome.setBounds(37, 130, 288, 19);
        txEndereco= new JTextField();
        txEndereco.setBounds(41, 181, 256, 19);
        txBairro = new JTextField();
        txBairro.setBounds(352, 181, 256, 19);
        txId = new JTextField();
        txId.setBounds(41, 76, 93, 19);
        txCpf = new JTextField();
        txCpf.setBounds(352, 130, 256, 19);
        txId.setEditable(false);
 
        painelFundo = new JPanel();
        painelFundo.setBackground(new Color(255, 255, 255));
        painelFundo.setBounds(0, 761, 784, 1);
        painelFundo.setLayout(null);
        painelFundo.add(lbId);
        painelFundo.add(txId);
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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(636, 393);
        setVisible(true);
 
        btSalvar.addActionListener(new AtualizarPessoa.BtSalvarListener());
        btLimpar.addActionListener(new AtualizarPessoa.BtLimparListener());
    }
 
    private class BtSalvarListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            
            pessoa.setNome(txNome.getText());
            pessoa.setEndereco(txEndereco.getText());
            pessoa.setBairro(txBairro.getText());
            pessoa.setCpf(txCpf.getText());
            pessoa.setSexo((String) sexo.getSelectedItem());
            PessoaDao dao = new PessoaDao();
            dao.atualizar(pessoa);
            modelo.removeRow(linhaSelecionada);
            modelo.addRow(new Object[]{pessoa.getId(), pessoa.getNome(), pessoa.getEndereco(),pessoa.getBairro(), 
            		pessoa.getCpf(),pessoa.getSexo()});
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