import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

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
                MenuEntidad menuEntidad = null;
                try {
                    menuEntidad = new MenuEntidad();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                menuEntidad.setVisible(true);

            }
        });
        modEnti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //main.modificarEntidad();
            }
        });
    }
}
