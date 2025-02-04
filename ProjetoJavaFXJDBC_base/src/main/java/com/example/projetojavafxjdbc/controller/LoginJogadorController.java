package com.example.projetojavafxjdbc.controller;

import com.example.projetojavafxjdbc.model.dao.DaoFactory;
import com.example.projetojavafxjdbc.model.entities.Jogos;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class LoginJogadorController {
    @FXML
    private Button BotaoSair;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TableView jogosDisponiveis;

    public void initialize() { mostrarTabela();}

    public void mostrarTabela(){
        TableColumn<Jogo, Jogo> colunaJogo = new TableColumn<>("Jogo");
        colunaJogo.setCellValueFactory(param -> new javafx.beans.property.SimpleObjectProperty<>(param.getValue()));

        colunaJogo.setCellFactory(new Callback<TableColumn<Jogos, Jogos>, TableCell<Jogos, Jogos>>() {
            @Override
            public TableCell<Jogo, Jogo> call(TableColumn<Jogo, Jogo> param) {
                return updateItem(Jogo jogo, boolean empty) {
                    super.updateItem(jogo, empty);

                    if(empty || jogo == null){
                        setGraphic(null);
                    } else {
                        ByteArrayInputStream bis = new ByteArrayInputStream(jogo.getCapa());
                        Image imagem = new Image(bis);

                        ImageView imageView = new ImageView(imagem);
                        imageView.setFitWidth(170);
                        imageView.setFitHeight(200);
                        imageView.setPreserveRatio(true);

                        Text nome = new Text(jogo.getNome());
                        nome.setWrappingWidth(150);

                        Label idJogo = new Label(Integer.toString(jogo.getIdJogo()));

                        VBox vbox = new VBox(nome, idJogo);
                        vbox.setStyle("-fx-alignment: center-left;");

                        HBox hbox = new HBox(imageView, vbox);
                        hbox.setSpacing(10);
                        setGraphic(hbox);
                    }
                }
            }
        });
        tableColumn<Jogos, String> colunaGeneros = new TableColumn<>("Gênero(s)");
        colunaGeneros.setCellValueFactory(param -> {

            List<Integer> generosID = DaoFactory.createJoggoGeneroDao(). procurarPorId(param.getValue().getIdJogo());
            List<String> generosNomes = new ArrayList<>();
            for (Integer id : generosID) {
                generosNomes.add(DaoFactory.createGeneroDao().procurarPorId(id).getGenero());
            }
            return new SimpleStringProperty(String.join("\n",generoNomes));

        });

        //Adicionando as colunas a TableView
        tableView.getColumns().add(colunaJogo);
        tableView.getColumns().add(colunaGeneros);

        //Inserindo Dados
        List<Jogo> jogo = DaoFactory.createJogosDao().procurarTodos();
        ObservableList<Jogo> jogos = FXCollections.observableArrayList(jogo);

        //Setando os dados na TableView
        tablewView.setItens(jogos);
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
