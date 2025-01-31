package com.example.projetojavafxjdbc.model.dao;

import com.example.projetojavafxjdbc.db.DB;
import com.example.projetojavafxjdbc.model.dao.impl.JogadorDaoJDBC;



public interface DaoFactory {

    public static AlunoDao createAlunoDao(){
        return new JogadorDaoJDBC(DB.getConnection());
    }

}

