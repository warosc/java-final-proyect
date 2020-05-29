import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasedeDatos {

    Scanner sc = new Scanner(System.in);
    RandomAccessFile fichero = null, entidades = null, atributos = null;
    private final String rutaBase = "/";
    private final String rutaEntidades = "entidades.dat";
    private final String rutaAtributos = "atributos.dat";
    private final int totalBytes = 83, bytesEntidad = 47, bytesAtributo = 43;
    private final static String formatoFecha = "dd/MM/yyyy";
    static DateFormat format = new SimpleDateFormat(formatoFecha);
    public JPanel mainGUI;
    private JMenuBar jbarMenu;
    private JMenuItem addEnti;
    private JMenuItem modEnti;
    private JMenuItem listEnti;
    private JMenuItem addRegist;
    private JMenuItem deleteBD;
    private JTextField textFieldNombre;
    private JTextField textFieldAtrubuto;
    private JComboBox comboBox1;
    private JButton btnTipoDAto;
    private JTextField tipoDatoSelecionado;
    private List<Entidad> listaEntidades = new ArrayList<>();

    public BasedeDatos() {
        Main main = new Main();
        //JOptionPane.showMessageDialog(null,"Seleccione el tipo de dato");
        comboBox1.addItem(TypeData.INT.getValue() + " .......... " + TypeData.INT.name());
        comboBox1.addItem(TypeData.LONG.getValue() + " .......... " + TypeData.LONG.name());
        comboBox1.addItem(TypeData.STRING.getValue() + " .......... " + TypeData.STRING.name());
        comboBox1.addItem(TypeData.DOUBLE.getValue() + " .......... " + TypeData.DOUBLE.name());
        comboBox1.addItem(TypeData.FLOAT.getValue() + " .......... " + TypeData.FLOAT.name());
        comboBox1.addItem(TypeData.DATE.getValue() + " .......... " + TypeData.DATE.name());
        comboBox1.addItem(TypeData.CHAR.getValue() + " .......... " + TypeData.CHAR.name());





        addEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean resultado = false;
                try {
                    Entidad entidad = new Entidad();
                    entidad.setIndice(listaEntidades.size() + 1);
                    entidad.setNombre(textFieldNombre.getText().trim());
                    String strNombre = null;
                    int longitud = 0;
                    do {
                        entidad.setNombre(textFieldNombre.getText().trim());
                        longitud = entidad.getNombre().length();
                        strNombre = entidad.getNombre();
                        if (longitud < 2 || longitud > 30) {
                            JOptionPane.showMessageDialog(null,"La longitud no es valida");
                        } else {
                            if (strNombre.contains(" ")) {
                                JOptionPane.showMessageDialog(null,"El nombre no puede contener espacios, sustituya por guion bajo");
                                longitud = 0;
                            }
                        }
                    } while (longitud < 2 || longitud > 30);

                    entidad.setNombre(textFieldNombre.getText().trim());
                    JOptionPane.showMessageDialog(null,"Atrubuto de Identidad");
                    int bndDetener = 0;
                    do {
                        Atributo atributo = new Atributo();
                        atributo.setIndice(entidad.getIndice());
                        longitud = 0;
                        JOptionPane.showInputDialog("Escriba el nombre de atributo no" + (entidad.getCantidad()+1));
                        do {
                            strNombre = JOptionPane.showInputDialog("Ingrese Atributo: ");
                            longitud = strNombre.length();
                            if (longitud < 2 || longitud > 30) {
                                JOptionPane.showMessageDialog(null,"La longitud del nombre no es valida");
                            } else {
                                if (strNombre.contains(" ")) {
                                    System.out.println(
                                            "El nombre no puede contener espacios, sustituya por guion bajo");
                                    longitud = 0;
                                }
                            }
                        } while (longitud < 2 || longitud > 30);
                        atributo.setNombre(strNombre);
                        atributo.setValorTipoDato(sc.nextInt());
                        if (atributo.isRequiereLongitud()) {
                            System.out.println("Ingrese la longitud");
                            atributo.setLongitud(sc.nextInt());
                        } else {
                            atributo.setLongitud(0);
                        }
                        atributo.setNombreTipoDato();
                        entidad.setAtributo(atributo);
                        System.out.println("Desea agregar otro atributo presione cualquier numero, de lo contrario 0");
                        bndDetener = sc.nextInt();
                    } while (bndDetener != 0);
                    System.out.println("Los datos a registrar son: ");
                    main.mostrarEntidad(entidad);
                    System.out.println("Presione 1 para guardar 0 para cancelar");
                    longitud = sc.nextInt();
                    if (longitud == 1) {
                        entidad.setPosicion(atributos.length());
                        atributos.seek(atributos.length());
                        for (Atributo atributo : entidad.getAtributos()) {
                            atributos.writeInt(atributo.getIndice());
                            atributos.write(atributo.getBytesNombre());
                            atributos.writeInt(atributo.getValorTipoDato());
                            atributos.writeInt(atributo.getLongitud());
                            atributos.write("\n".getBytes());
                        }
                        entidades.writeInt(entidad.getIndice());
                        entidades.write(entidad.getBytesNombre());
                        entidades.writeInt(entidad.getCantidad());
                        entidades.writeInt(entidad.getBytes());
                        entidades.writeLong(entidad.getPosicion());
                        entidades.write("\n".getBytes());
                        listaEntidades.add(entidad);
                        resultado = true;
                    } else {
                        System.out.println("No se guardo la entidad debido a que el usuario decidio cancelarlo");
                        resultado = false;
                    }
                    System.out.println("Presione una tecla para continuar...");
                    System.in.read();
                } catch (Exception e) {
                    resultado = false;
                    e.printStackTrace();
                }
                //return resultado;
            }

        });
        modEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //main.modificarEntidad();
            }
        });
        listEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
        btnTipoDAto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tipoDatoSelecionado.setText(comboBox1.getSelectedItem().toString());
            }




        });
    }




}
