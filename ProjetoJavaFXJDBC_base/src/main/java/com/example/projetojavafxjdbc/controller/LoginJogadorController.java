package com.example.projetojavafxjdbc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginJogadorController {
    @FXML
    private Button BotaoSair;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TableView jogosDisponiveis;

    public void mostrarTabela(){
        TableColumn<Jogo, Jogo> colunaJogo = new TableColumn<>("Jogo");
        colunaJogo.setCellValueFactory(CellDataFeatures<Jogo, Jogo> param -> new javafx.beans.property.SimpleObjectProperty<>(param.getValue()));
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
}
