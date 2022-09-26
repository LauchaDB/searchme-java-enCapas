package Datos;

import java.sql.*;

public class Conexion {

    public Connection conectar(String conexionUrl) {
        String usuario = "root";
        String password = "elbudipmf";
        String driver = "com.mysql.jdbc.Driver";

        Connection conexion = null;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);

        } catch (Exception ex) {
            //Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return conexion;
    }

    public void agregar(String sql, String conexionUrl) {

        try {
            Connection conexion = conectar(conexionUrl);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            //Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public void actualizar(String sql, String conexionUrl) {

        try {
            Connection conexion = conectar(conexionUrl);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            //Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }

    public void eliminar(String sql, String conexionUrl) {
        try {
            Connection conexion = conectar(conexionUrl);
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex) {
            //Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet listar(String sql, String conexionUrl){
        ResultSet resultado = null;
        try {
            Connection conexion = conectar(conexionUrl);
            Statement statement = conexion.createStatement();
            resultado = statement.executeQuery(sql);
        } catch (Exception ex) {
            //Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

}
