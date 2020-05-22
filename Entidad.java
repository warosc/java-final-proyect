import java.util.List;

public class Entidad {
    private int indice;
    private String nombre;
    private int cantidad;
    private long posicion;
    private byte[] bytesNombre;
    private int bytes = 1;

    private List<Atributo> atributos;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }

    public byte[] getBytesNombre() {
        return bytesNombre;
    }

    public void setBytesNombre(byte[] bytesNombre) {
        this.bytesNombre = bytesNombre;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
