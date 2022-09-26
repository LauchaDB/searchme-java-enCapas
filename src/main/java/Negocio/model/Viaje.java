package Negocio.model;

import java.util.Date;

public class Viaje {

    private long idViaje;

    private String nombreViaje;

    private String descripViaje;

    private Date fechaViaje;

    private double valorTotalViaje;

    private boolean isGuardadoViaje;

    private int idUs;

    public Viaje() {
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

    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
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
