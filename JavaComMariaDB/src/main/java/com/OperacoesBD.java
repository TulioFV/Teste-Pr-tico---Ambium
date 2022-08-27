package com;

import reader.PDF;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OperacoesBD {

    ConnectionBD con = new ConnectionBD();
    PDF pdf = new PDF();

    public OperacoesBD() throws IOException {
    }

    public void readData() throws SQLException {

        System.out.println("Carregando Arquivos...");

        try (Connection connection = con.getConnection()) {

            List<String> listaPdfs = pdf.leitorPdf();
            for (int a = 0; a < listaPdfs.size(); a++) {
                String car = String.valueOf(listaPdfs.get(a));

                try (PreparedStatement statement = connection.prepareStatement("""
                                SELECT Chave from fazendas_ab where Car = ?
                         
                        """)) {
                    statement.setString(1, car);
                    ResultSet resultSet = statement.executeQuery();

                    while (resultSet.next()) {
                        try (PreparedStatement updateStatement = connection.prepareStatement("""
                                        UPDATE fazendas_ab SET ANEXO = ? WHERE Chave = ?
                                 
                                """)) {
                            updateStatement.setString(1, car);
                            updateStatement.setString(2, resultSet.getString(1));
                            updateStatement.executeUpdate();
                        }
                    }
                }
            }
        }
    }

}
