package com.example.projetojavafxjdbc.controller;

import com.example.projetojavafxjdbc.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationController {
    @FXML
    private MenuItem cadastrar;
    private MenuItem login;
    private MenuItem loginMonitor;
    private MenuItem buscar;
    private MenuItem administracao;
    private MenuItem jogos;
    private MenuItem jogosMonitores;
    private MenuItem sair;

    @FXML
    public void menuItemCadastrarOnClicked() throws IOException {
        Application.newStage("cadastrar-jogador-view.fxml");
    }

    @FXML
    public void menuItemBuscarOnClicked() throws IOException {
       Application.newStage("buscar-jogador-view.fxml");
    }

    @FXML
    public void menuItemLoginOnClicked() throws IOException {
        Application.newStage("login-jogador-view.fxml");
    }

    @FXML
    public void menuItemLoginMonitorOnClicked() throws IOException {
        Application.newStage("administracao-monitor-view.fxml");
    }

    @FXML
    public void menuItemAdministracaoOnClicked() throws IOException {
        Application.newStage("administracao-monitor-view.fxml");
    }

    @FXML
    public void menuItemJogosMonitoresOnClicked() throws IOException {
        Application.newStage("jogos-monitor-view.fxml");
    }

    @FXML
    public void menuItemJogosOnClicked() throws IOException {
        Application.newStage("jogos-jogador-view.fxml");
    }

    @FXML
    public void menuItemSairOnClicked() throws IOException {
        Application.newStage("sair-jogador-view.fxml");
    }


}