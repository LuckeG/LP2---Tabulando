package com.admin.projeto_tabulando.model.dao;

import com.admin.projeto_tabulando.model.entities.Jogador;
import com.admin.projeto_tabulando.model.entities.Jogo;

import java.sql.SQLException;
import java.util.List;

public interface JogoDao {
    List<Jogo> procurarTodosDisponivel();
    Jogo procurarPorNome(String nome);
    List<Jogo> procurarTodosJogando();
    List<Jogo> procurarTodos();
    void marcarComoIndisponivel(Jogo jogo);
    void marcarComoDisponivel(Jogo jogo);
}
