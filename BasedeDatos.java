import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasedeDatos {

    public JPanel mainGUI;
    private JMenuBar jbarMenu;
    private JMenuItem addEnti;
    private JMenuItem modEnti;
    private JMenuItem listEnti;
    private JMenuItem addRegist;
    private JMenuItem deleteBD;


    public BasedeDatos() {
        Main main = new Main();



        addEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                main.agregarEntidad();
            }
        });
        modEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
