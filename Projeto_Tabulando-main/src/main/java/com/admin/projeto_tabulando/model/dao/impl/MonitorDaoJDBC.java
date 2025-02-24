package com.admin.projeto_tabulando.model.dao.impl;

import com.admin.projeto_tabulando.db.DB;
import com.admin.projeto_tabulando.model.dao.MonitorDao;
import com.admin.projeto_tabulando.model.entities.Jogo;
import com.admin.projeto_tabulando.utils.Alerta;
import javafx.scene.control.Alert;

import java.sql.*;

public class MonitorDaoJDBC implements MonitorDao {
    private Connection conn;


    public MonitorDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void removerJogador(int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM Jogador WHERE ID_Jogador = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void encerrarJogo(Jogo jogo) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM Jogador_Jogo WHERE ID_Jogo = ?");
            st.setInt(1, jogo.getId());
            st.executeUpdate();

            st = conn.prepareStatement("UPDATE Jogo SET disponivel = true WHERE ID_Jogo = ?");
            st.setInt(1, jogo.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void adicionarJogo(String nome, String tipo, int maxJogadores, Jogo jogo) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO Jogo (nome, tipo, maxJogadores, disponivel) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, nome);
            st.setString(2, tipo);
            st.setInt(3, maxJogadores);
            st.setBoolean(4, true);
            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    jogo.setId(id);
                }
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void removerJogo(Jogo jogo) {
        PreparedStatement st = null;
        ResultSet rs = null;

        if(jogo.isDisponivel()) {
            try {
                st = conn.prepareStatement("DELETE FROM Jogador_Jogo WHERE ID_jogo = ?");
                st.setInt(1, jogo.getId());
                st.executeUpdate();

                st = conn.prepareStatement("DELETE FROM Jogo WHERE ID_jogo = ?");
                st.setInt(1, jogo.getId());
                st.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            Alerta.mostrarAlerta("Jogo em andamento.", null, "Encerre o jogo para poder excluí-lo!", Alert.AlertType.INFORMATION);
        }
    }
}
