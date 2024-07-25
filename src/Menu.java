import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    private JMenuBar jmb;
    private JMenu jm1;
    private JMenu jm2;
    private JMenuItem jmi1;
    private JMenuItem jmi2;


    public Menu() {
        window();
        setBackground(Color.ORANGE);
        add(jmb);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void window(){
        jmb = new JMenuBar();
        jm1 = new JMenu();
        jm2 = new JMenu();
        jmi1 = new JMenuItem("New Game");
        jmi2 = new JMenuItem("Options");
        jm1.add(jmi1);
        jm2.add(jmi2);

        jm1.setBounds(0,0,40,10);
        jmb.add(jm1, jm2);
        jmb.updateUI();//нужно для обновления, прорисовки сторки
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow();
            }
        });
    }


}
