package negocio;

import datos.Conexion;
import negocio.model.Viaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Viajes {

    String baseDeDatos = "viajes";
    String usuario = "root";
    String password = "elbudipmf";
    String host = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

    Conexion conexionViaje = new Conexion();

    public void saveViaje(Viaje viaje) throws ParseException {

        String sql = "INSERT INTO `tbviajes` (`id_viaje`, `nombre_viaje`, `descrip_viaje`, `fecha_viaje`, `valor_total_viaje`, `is_guardado_viaje`,`id_us`) VALUES (NULL, '"

                + viaje.getNombreViaje() + "', '"
                + viaje.getDescripViaje() + "', '"
                + viaje.getFechaViaje().toInstant().atZone(ZoneId.of("Etc/GMT-3")).toLocalDate() + "', " //casteando la fecha que llega desde front con nuestra zona horaria, porque sql no toma el date de java
                + viaje.getValorTotalViaje() + ", "
                + 0 + ", "
                + viaje.getIdUs() + ");";

        conexionViaje.agregar(sql, conexionUrl);
    }

    public void updateViaje(int id, Viaje viaje){
        String sql = "UPDATE `tbviajes` SET `nombre_viaje` = '" + viaje.getNombreViaje()
                + "', `descrip_viaje` = '" + viaje.getDescripViaje()
                + "', `fecha_viaje` = '" + viaje.getFechaViaje().toInstant().atZone(ZoneId.of("Etc/GMT-3")).toLocalDate()
                + "', `valor_total_viaje` = '" + viaje.getValorTotalViaje()
                + "', `id_us` = '" + viaje.getIdUs()
                +"' WHERE `tbviajes`.`id_viaje` = "+id+";";
        conexionViaje.actualizar(sql, conexionUrl);
    }

    public void likeViaje(int id, boolean isGuardado){
        String sql = "UPDATE `tbviajes` SET `is_guardado_viaje` = " + !isGuardado
                +" WHERE `tbviajes`.`id_viaje` = "+id+";";
        conexionViaje.actualizar(sql, conexionUrl);
    }

    public List<Viaje> findAllViajes() throws SQLException {
        List<Viaje> listado = new ArrayList<>();
        String sql = "SELECT * FROM `tbviajes`;";
        ResultSet resultado = conexionViaje.listar(sql, conexionUrl);
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

    public List<Viaje> findAllViajesLike() throws SQLException {
        List<Viaje> listado = new ArrayList<>();
        String sql = "SELECT * FROM `tbviajes` WHERE `tbviajes`.`is_guardado_viaje` = 1;";
        ResultSet resultado = conexionViaje.listar(sql, conexionUrl);
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


    public void deleteViaje(int id){
        String sqlDestino = "DELETE FROM `tbdestinos` WHERE `tbdestinos`.`id_viaje` = " + id;
        conexionViaje.eliminar(sqlDestino, conexionUrl);
        String sqlViaje = "DELETE FROM `tbviajes` WHERE `tbviajes`.`id_viaje` = " + id;
        conexionViaje.eliminar(sqlViaje, conexionUrl);
    }
}
