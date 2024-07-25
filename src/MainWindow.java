import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480,640);

        JLayeredPane jp = new JLayeredPane();
        Menu mn = new Menu();
        PlayingField pf = new PlayingField();
        add(jp);

        jp.add(mn, new Integer(0),0);
        jp.add(pf, new Integer(0),0);
        mn.setBounds(0,0,480,640);
        pf.setBounds(0,160,480,480);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }

}
