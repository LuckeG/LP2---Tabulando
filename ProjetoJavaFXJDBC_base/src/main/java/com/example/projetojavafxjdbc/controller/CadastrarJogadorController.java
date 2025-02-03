package com.example.projetojavafxjdbc.controller;

import com.example.projetojavafxjdbc.Application;
import com.example.projetojavafxjdbc.model.dao.DaoFactory;
import com.example.projetojavafxjdbc.model.entities.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class CadastrarJogadorController {
    @FXML
    private TextField nome;
    @FXML
    private TextField senha;
    @FXML
    private DatePicker dataNascimento;
    @FXML
    private ImageView foto;
    private File file;

    @FXML
    public void fotoOnClicked(){
        FileChooser fc = new FileChooser();
        file = fc.showOpenDialog(Application.getScene().getWindow());
        if(file!=null){
            foto.setImage(new Image(file.getAbsolutePath()));
        }
    }

    @FXML
    public void salvarOnClicked(){
        Aluno aluno = new Aluno();
        aluno.setNome(nome.getText());
        aluno.setSenha(senha.getText());
        aluno.setDataNascimento(dataNascimento.getValue());
        if(file!=null){
            byte[] fileBytes = null;
            try {
                fileBytes = Files.readAllBytes(Path.of(file.getPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            aluno.setFoto(fileBytes);
        }
        DaoFactory.createAlunoDao().inserir(aluno);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação!");
        alerta.setContentText((""));
    }

}
