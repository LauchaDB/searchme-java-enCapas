package negocio;

import datos.Conexion;
import negocio.model.Viaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ViajesGuardados {

    String baseDeDatos = "viajes";
    String usuario = "root";
    String password = "elbudipmf";
    String host = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

    Conexion conexionViaje = new Conexion();

    Conexion conexionViajeGuardado = new Conexion();

    public List<Viaje> viajesGuardados(String email_us) throws SQLException {
        List<Viaje> listado = new ArrayList<>();
        String sql = "SELECT * FROM `tbviajes_guardados` WHERE id_us = (SELECT id_us FROM tbusuarios.);";
        ResultSet resultado = conexionViajeGuardado.listar(sql, conexionUrl);
        while(resultado.next()) {
            Viaje viaje = new Viaje();
            viaje.setIdViaje(resultado.getInt("id_viaje"));
            viaje.setNombreViaje(resultado.getString("nombre_viaje"));
            viaje.setDescripViaje(resultado.getString("descrip_viaje"));
            viaje.setFechaViaje(resultado.getDate("fecha_viaje"));
            viaje.setValorTotalViaje(resultado.getDouble("valor_total_viaje"));
            viaje.setIsGuardadoViaje(resultado.getBoolean("is_guardado_viaje"));
            viaje.setIdUs(resultado.getInt("id_us"));
            listado.add(viaje);
        }
        return listado;
    }
}
