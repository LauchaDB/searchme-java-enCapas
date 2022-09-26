package Negocio;

import Datos.Conexion;
import Negocio.model.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuarios {

    String baseDeDatos = "viajes";
    String usuario = "root";
    String password = "elbudipmf";
    String host = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

    Conexion conexionUsuarios = new Conexion();

    public List<Usuario> findAllUsuarios() throws SQLException {
        List<Usuario> listado = new ArrayList<>();
        String sql = "SELECT * FROM `tbusuarios`;";
        ResultSet resultado = conexionUsuarios.listar(sql, conexionUrl);
        while(resultado.next()) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(resultado.getInt("id_us"));
            usuario.setNombreUsuario(resultado.getString("nombre_us"));
            usuario.setEmailUsuario(resultado.getString("email_us"));
            usuario.setPassword(resultado.getString("password_us"));
            listado.add(usuario);
        }
        return listado;
    }
}
