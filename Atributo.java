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
        bytesNombre = new byte[30];
         for (int i = 0; i < nombre.length(); i++) {
            bytesNombre[i] = (byte)nombre.charAt(i);
        }
    }

    public byte[] getBytesNombre() {
        return bytesNombre;
    }

    public void setBytesNombre(byte[] bytesNombre) {
        this.bytesNombre = bytesNombre;
        nombre = new String(bytesNombre);
    }

    public int getValorTipoDato() {
        return valorTipoDato;
    }

    public void setValorTipoDato(int valorTipoDato) {
        this.valorTipoDato = valorTipoDato;
        if (valorTipoDato == TipoDatos.STRING.getValue()) {
            this.requiereLongitud = true;
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean isRequiereLongitud() {
        return requiereLongitud;
    }

    public String getNombreTipoDato() {
        return nombreTipoDato;
    }

    public void setNombreTipoDato() {
        if (this.valorTipoDato == TipoDatos.STRING.getValue()) {
            this.nombreTipoDato = TipoDatos.STRING.name();
            this.bytes = this.longitud;
            tipoDato = TipoDatos.STRING;
        }
        if (this.valorTipoDato == TipoDatos.INT.getValue()) {
            this.nombreTipoDato = TipoDatos.INT.name();
            this.bytes = 4;
            tipoDato = TipoDatos.INT;
        }
        if (this.valorTipoDato == TipoDatos.LONG.getValue()) {
            this.nombreTipoDato = TipoDatos.LONG.name();
            this.bytes = 8;
            tipoDato = TipoDatos.LONG;
        }
        if (this.valorTipoDato == TipoDatos.DOUBLE.getValue()) {
            this.nombreTipoDato = TipoDatos.DOUBLE.name();
            this.bytes = 8;
            tipoDato = TipoDatos.DOUBLE;
        }
        if (this.valorTipoDato == TipoDatos.FLOAT.getValue()) {
            this.nombreTipoDato = TipoDatos.FLOAT.name();
            this.bytes = 4;
            tipoDato = TipoDatos.FLOAT;
        }
        if (this.valorTipoDato == TipoDatos.DATE.getValue()) {
            this.nombreTipoDato = TipoDatos.DATE.name();
            this.bytes = 28;
            tipoDato = TipoDatos.DATE;
        }
        if (this.valorTipoDato == TipoDatos.CHAR.getValue()) {
            this.nombreTipoDato = TipoDatos.CHAR.name();

            this.bytes = 1;
            tipoDato = TipoDatos.CHAR;
        }
    }

     public int getBytes() {
        return bytes;
    }

    public TipoDatos getTipoDato() {
        return tipoDato;
    }

    public void setValorTipoDato() {
    }
}