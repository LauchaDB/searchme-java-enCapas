package negocio.model;

import negocio.Destinos;
import negocio.Viajes;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Viaje {

    Viajes viajes = new Viajes();
    Destinos destinos = new Destinos();

    private long idViaje;

    private String nombreViaje;

    private String descripViaje;

    private Date fechaViaje;

    private double valorTotalViaje;

    private boolean isGuardadoViaje;

    private String emailUs;

    public Viaje() {
    }

    public Viaje(int idViaje) throws SQLException {
        Viaje viaje = new Viaje();
        List<Viaje> listViajes= viajes.findAllViajes();
        for (Viaje viajeDB: listViajes) {
            if(viajeDB.getIdViaje() == idViaje){
                viaje.setIdViaje(viajeDB.getIdViaje());
                viaje.setNombreViaje(viajeDB.getNombreViaje());
                viaje.setDescripViaje(viajeDB.getDescripViaje());
                viaje.setFechaViaje(viajeDB.getFechaViaje());
                viaje.setValorTotalViaje(viajeDB.getValorTotalViaje());
                viaje.setIsGuardadoViaje(viajeDB.getIsGuardadoViaje());
                viaje.setEmailUs(viajeDB.getEmailUs());
            }
        }
        System.out.println("VIAJE: " + viaje.getNombreViaje());
        //de aca para abajo anda
        Destinos destinos = new Destinos();
        List<Destino> listaDestinos = destinos.destinosDeUnViaje(idViaje);
        for (Destino destino: listaDestinos) {
            System.out.println("DESTINO "+ destino.getIdDest()+ ": "+ destino.getProvinciaDest() + ". ");
        }
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fecha_viaje) {
        this.fechaViaje = fecha_viaje;
    }

    public double getValorTotalViaje() {
        return valorTotalViaje;
    }

    public void setValorTotalViaje(double valorTotal_viaje) {
        this.valorTotalViaje = valorTotal_viaje;
    }

    public String getEmailUs() {
        return emailUs;
    }

    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }

    public long getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }

    public String getNombreViaje() {
        return nombreViaje;
    }

    public void setNombreViaje(String nombreViaje) {
        this.nombreViaje = nombreViaje;
    }

    public String getDescripViaje() {
        return descripViaje;
    }

    public void setDescripViaje(String descripViaje) {
        this.descripViaje = descripViaje;
    }

    public boolean getIsGuardadoViaje() {
        return isGuardadoViaje;
    }

    public void setIsGuardadoViaje(boolean guardadoViaje) {
        this.isGuardadoViaje = guardadoViaje;
    }
}
