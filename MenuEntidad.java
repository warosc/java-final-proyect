import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MenuEntidad extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JList TipoDato;
    private final String rutaBase = "/";
    private final String rutaEntidades = "entidades.dat";
    private final String rutaAtributos = "atributos.dat";
    private final int totalBytes = 83, bytesEntidad = 47, bytesAtributo = 43;

    public MenuEntidad() throws FileNotFoundException {
        Main main = new Main();
        RandomAccessFile fichero = null, entidades = null, atributos = null;
        entidades = new RandomAccessFile(rutaEntidades, "rw");
        atributos = new RandomAccessFile(rutaAtributos, "rw");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

            buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        RandomAccessFile finalAtributos = atributos;
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Entidad entidad = new Entidad();
                try {
                    entidad.setPosicion(finalAtributos.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    finalAtributos.seek(finalAtributos.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws FileNotFoundException {
        MenuEntidad dialog = new MenuEntidad();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
