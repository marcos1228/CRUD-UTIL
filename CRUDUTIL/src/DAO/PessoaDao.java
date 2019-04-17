package DAO;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DATABASE.Conexao;
import ENTIDADES.Pessoa;

public class PessoaDao {
	
 
    private final String INSERT = "INSERT INTO PESSOA (NOME, ENDERECO, BAIRRO, CPF, SEXO) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE PESSOA SET NOME=?, ENDERECO=?, BAIRRO=?, CPF=?, SEXO=? WHERE ID=?";
    private final String DELETE = "DELETE FROM PESSOA WHERE ID =?";
    private final String LIST = "SELECT * FROM PESSOA";
    private final String LISTBYID = "SELECT * FROM PESSOA WHERE ID=?";
    private final String LISTPORNOME = "SELECT * FROM PESSOA WHERE UPPER(NOME) LIKE =?";
    public void inserir(Pessoa pessoa) {
        if (pessoa != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);
 
                pstm.setString(1, pessoa.getNome());
                pstm.setString(2, pessoa.getEndereco());
                pstm.setString(3, pessoa.getBairro());
                pstm.setString(4, pessoa.getCpf());
                pstm.setString(5,pessoa.getSexo());
                pstm.execute();
                System.out.println(pstm);
                JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso");
                Conexao.fechaConexao(conn, pstm);
 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir pessoa no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            System.out.println("A pessoa envaida por parametro estar vazia");
        }
    }
 
    public void atualizar(Pessoa pessoa) {
        if (pessoa != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, pessoa.getNome());
                pstm.setString(2, pessoa.getEndereco());
                pstm.setString(3, pessoa.getBairro());
                pstm.setString(4, pessoa.getCpf());
                pstm.setString(5, pessoa.getSexo());
                pstm.setLong(6, pessoa.getId());
 
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Pessoa Alterada com sucesso");
                Conexao.fechaConexao((com.mysql.jdbc.Connection) conn);
 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar pessoa  no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "A pessoa envaida por parametro estar vazia");
        }
 
 
    }
 
    public void remover(Long id) {
        Connection conn = null;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement(DELETE);
 
            pstm.setLong(1, id);
 
            pstm.execute();
            Conexao.fechaConexao(conn, pstm);
 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Pessoa no  banco de"
                    + "dados " + e.getMessage());
        }
    }
    
    
    public List<Pessoa> buscarPessoaPorNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement("select p from pessao p where upper(p.nome) like ?");
            pstm.setString(1, "%"+nome.toUpperCase()+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
            	
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setSexo(rs.getString("sexo"));
                
                pessoas.add(pessoa);
            }
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas" + e.getMessage());
        }
        return pessoas;
    }
 
    public List<Pessoa> getPessoas() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
 
                pessoa.setId(rs.getLong("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoas.add(pessoa);
            }
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas" + e.getMessage());
        }
        return pessoas;
    }
 
    public Pessoa getPessoaById(Long id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pessoa pessoa = new Pessoa();
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                pessoa.setId(rs.getLong("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setEndereco(rs.getString("endereco"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setSexo(rs.getString("sexo"));
                
            }
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas" + e.getMessage());
        }
        return pessoa;
    }
    
	public Pessoa getPessoaById(Component lbId) {
		// TODO Auto-generated method stub
		return null;
	}


}