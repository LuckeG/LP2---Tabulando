package com.example.projetojavafxjdbc.controller;

import com.example.projetojavafxjdbc.Application;
import com.example.projetojavafxjdbc.model.dao.DaoFactory;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AdministracaoMonitorController {
    @FXML
    private Button AdicionarNovoJogo;
    @FXML
    private Button RemoverJogo;
    @FXML
    private Button LiberarJogo;
    @FXML
    private Button ExpulsarJogador;
    @FXML
    private Button VerHistorico;
    @FXML
    private Button BotaoSair;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void menuItemSairOnClicked(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacao");
        alert.setHeaderText("Você está prestes a sair");
        alert.setContentText("Deseja realmente sair?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Saiu com sucesso");
            stage.close();
        }

    }


}
