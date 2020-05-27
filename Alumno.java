import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno {
    private final DateFormat formatoFecha = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
    private String nombre;
    private Date fechaNacimiento;
    private long carne;
    private String telefono;
    private double peso;
    private byte[] bytesNombre;
    private byte[] bytesTelefono;
    private byte[] bytesFechaNacimiento;

    public DateFormat getFormatoFecha() {
        return formatoFecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        bytesNombre = new  byte[100];
        for (int i = 0; i<nombre.length();i++){
            bytesNombre[i] = (byte)nombre.charAt(i);
        }
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getCarne() {
        return carne;
    }

    public void setCarne(long carne) {
        this.carne = carne;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
        bytesTelefono = new byte[15];
        for (int i = 0; i < telefono.length(); i++) {
            bytesTelefono[i] = (byte) telefono.charAt(i);
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public byte[] getBytesNombre() {
        return bytesNombre;
    }

    public void setBytesNombre(byte[] bytesNombre) {
        this.bytesNombre = bytesNombre;
        nombre = new String(bytesNombre);
    }

    public byte[] getBytesTelefono() {
        return bytesTelefono;
    }

    public void setBytesTelefono(byte[] bytesTelefono) {
        this.bytesTelefono = bytesTelefono;
        telefono = new String(bytesTelefono);
    }

    public void setBytesFechaNacimiento(byte[] bytesFechaNacimiento) throws ParseException {
        this.bytesFechaNacimiento = bytesFechaNacimiento;
        String strFecha = new String(bytesFechaNacimiento);
        this.fechaNacimiento = formatoFecha.parse(strFecha);
    }

    public byte[] getBytesFechaNacimiento() {
        return bytesFechaNacimiento;
    }
}
