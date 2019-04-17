package DAO;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATABASE.Conexao;
import ENTIDADES.Contato;
import ENTIDADES.Pessoa;

public class ContatoDao {

    private final String INSERT = "INSERT INTO CONTATO (TIPO, REGISTRO, PESSOAID) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE CONTATO SET TIPO=?, REGISTRO=? WHERE ID=?";
    private final String DELETE = "DELETE FROM CONTATO WHERE ID =?";
    private final String LISTCONTATOSPESSOA = "SELECT * FROM CONTATO WHERE PESSOAID=?";
    private final String LISTBYID = "SELECT * FROM CONTATO WHERE ID=?";
	public Object getContatos;
   
    public void inserir(Contato contato) {
        if (contato != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);
 
                pstm.setString(1, contato.getTipo());
                pstm.setString(2, contato.getRegistro());
                pstm.setInt(3,contato.getPessoaid());
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Contato cadastrada com sucesso");
                Conexao.fechaConexao(conn, pstm);
 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir contato no banco de"
                        + " dados " + e.getMessage());
            }
        } else {
            System.out.println("O contato envaida por parametro estar vazia");
        }
    }
 
    public void atualizar(Contato contato) {
        if (contato != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(UPDATE);

                pstm.setString(1, contato.getTipo());
                pstm.setString(2, contato.getRegistro());
                pstm.setLong(3, contato.getId());
 
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Contato Alterado com sucesso");
                Conexao.fechaConexao((com.mysql.jdbc.Connection) conn);
 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar contato  no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "O contato envaida por parametro estar vazia");
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
            JOptionPane.showMessageDialog(null, "Erro ao excluir contato no  banco de"
                    + "dados " + e.getMessage());
        }
    }
 
    
    public List<Contato> getContatosPorIdPessoa(Long id) {
    	List<Contato> contatos = new ArrayList<Contato>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTCONTATOSPESSOA);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	
            	Contato contato = new Contato();
            	contato.setId(rs.getLong("id"));
                contato.setTipo(rs.getString("Tipo"));
                contato.setRegistro(rs.getString("Registro"));
                contato.setPessoaid(rs.getInt("PessoaId"));
                
                contatos.add(contato);
            }
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas" + e.getMessage());
        }
        return contatos;
    }
    
    public Contato getContatoById(Long id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Contato contato = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
            	contato = new Contato();
            	contato.setId(rs.getLong("id"));
                contato.setTipo(rs.getString("Tipo"));
                contato.setRegistro(rs.getString("Registro"));
                contato.setPessoaid(rs.getInt("pessoaid"));
            }
            Conexao.fechaConexao(conn, pstm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pessoas" + e.getMessage());
        }
        return contato;
    }

    public Pessoa getContatoById(Component lbId) {
		return null;
	}
    
}