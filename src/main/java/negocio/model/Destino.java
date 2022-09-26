package negocio.model;

public class Destino {

    private long idDest;

    private String provinciaDest;

    private String ciudadDest;

    private String descripDest;

    private int idViaje;

    public Destino() {
    }

    public long getIdDest() {
        return idDest;
    }

    public void setIdDest(long idDest) {
        this.idDest = idDest;
    }

    public String getProvinciaDest() {
        return provinciaDest;
    }

    public void setProvinciaDest(String provinciaDest) {
        this.provinciaDest = provinciaDest;
    }

    public String getCiudadDest() {
        return ciudadDest;
    }

    public void setCiudadDest(String ciudadDest) {
        this.ciudadDest = ciudadDest;
    }

    public String getDescripDest() {
        return descripDest;
    }

    public void setDescripDest(String descripDest) {
        this.descripDest = descripDest;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
}
