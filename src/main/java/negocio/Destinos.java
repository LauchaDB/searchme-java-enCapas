package negocio;

import datos.Conexion;
import negocio.model.Destino;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Destinos {

    String baseDeDatos = "viajes";
    String usuario = "root";
    String password = "elbudipmf";
    String host = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";

    Conexion conexionDestino = new Conexion();

    /*public List<Destino> destinosDeUnViaje(int id){
        return conexionDestino.listarDestinosDeViaje(conexionUrl, id);
    }*/

    public List<Destino> destinosDeUnViaje(int id) throws SQLException {
        List<Destino> listado = new ArrayList<>();
        String sql = "SELECT * FROM `tbdestinos` WHERE id_viaje = "+id+";";
        ResultSet resultado = conexionDestino.listar(sql, conexionUrl);
        while(resultado.next()) {
            Destino destino = new Destino();
            destino.setIdDest(resultado.getInt("id_dest"));
            destino.setProvinciaDest(resultado.getString("provincia_dest"));
            destino.setCiudadDest(resultado.getString("ciudad_dest"));
            destino.setDescripDest(resultado.getString("descrip_dest"));
            destino.setIdViaje(resultado.getInt("id_viaje"));
            listado.add(destino);
        }
        return listado;
    }

    public void saveDestino(Destino destino){
        String sql = "INSERT INTO `tbdestinos` (`id_dest`, `provincia_dest`, `ciudad_dest`, `descrip_dest`, `id_viaje`) VALUES (NULL, '"
                + destino.getProvinciaDest() + "', '"
                + destino.getCiudadDest() + "', '"
                + destino.getDescripDest() + "', '"
                + destino.getIdViaje() + "');";

        conexionDestino.agregar(sql, conexionUrl);
    }

    public void deleteDestino(int id){
        String sql = "DELETE FROM `tbdestinos` WHERE `tbdestinos`.`id_dest` = " + id;
        conexionDestino.eliminar(sql, conexionUrl);
    }

    public void updateDestino(int id, Destino destino){
        String sql = "UPDATE `tbdestinos` SET `provincia_dest` = '" + destino.getProvinciaDest()
                + "', `ciudad_dest` = '" + destino.getCiudadDest()
                + "', `descrip_dest` = '" + destino.getDescripDest()
                + "', `id_viaje` = '" + destino.getIdViaje()
                +"' WHERE `tbdestinos`.`id_dest` = "+id+";";
        conexionDestino.actualizar(sql, conexionUrl);
    }

}
