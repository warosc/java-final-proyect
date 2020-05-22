public class Atributo {
    private int indice;
    private String nombre;
    private int valorTipoDato;
    private String nombreTipoDato;
    private int longitud;
    private int bytes;
    private boolean requiereLongitud;
    private byte[] bytesNombre;
    private TipoDatos tipoDato;

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

    public int getValorTipoDato() {
        return valorTipoDato;
    }

    public void setValorTipoDato(int valorTipoDato) {
        this.valorTipoDato = valorTipoDato;
    }

    public String getNombreTipoDato() {
        return nombreTipoDato;
    }

    public void setNombreTipoDato(String nombreTipoDato) {
        this.nombreTipoDato = nombreTipoDato;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public boolean isRequiereLongitud() {
        return requiereLongitud;
    }

    public void setRequiereLongitud(boolean requiereLongitud) {
        this.requiereLongitud = requiereLongitud;
    }

    public byte[] getBytesNombre() {
        return bytesNombre;
    }

    public void setBytesNombre(byte[] bytesNombre) {
        this.bytesNombre = bytesNombre;
    }

    public TipoDatos getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoDatos tipoDato) {
        this.tipoDato = tipoDato;
    }
}
