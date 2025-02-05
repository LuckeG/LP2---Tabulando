package com.admin.projeto_tabulando.controller;

import com.admin.projeto_tabulando.model.dao.DaoFactory;
import com.admin.projeto_tabulando.model.dao.JogoDao;
import com.admin.projeto_tabulando.model.dao.impl.JogoDaoJDBC;
import com.admin.projeto_tabulando.model.entities.Jogador;
import com.admin.projeto_tabulando.model.entities.Jogo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @FXML
    private Button BotaoSair;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label nome;
    @FXML
    private Button buscar;

    public void setNomeJogador(String nomeJogador) {
        nome.setText(nomeJogador); // Define o texto do label
    }

    Stage stage;

    public void menuItemSairOnClicked(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacao");
        alert.setHeaderText("Você está prestes a sair");
        alert.setContentText("Deseja realmente sair?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Saiu com sucesso");
            stage.close();
        }
    }

    public void menuItemBuscarOnClicked(ActionEvent actionEvent) {
    }
}