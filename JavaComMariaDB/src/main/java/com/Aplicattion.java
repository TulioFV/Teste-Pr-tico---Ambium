package com;


import reader.PDF;

import java.io.IOException;
import java.sql.*;



public class Aplicattion {

    public static void main(String[] args) throws SQLException, IOException {

        OperacoesBD op = new OperacoesBD();

            op.readData();
    }
}

