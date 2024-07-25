import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayingField extends JPanel {

    private final int WIDTH = 140;
    private final int HEIGHT = 140;
    private  final Font FONT = new Font("sanserif", Font.BOLD, 72);
    private int hod = 0;
    private String[][] arr = new String[3][3];
    private boolean inGame = true;
    private String snach;


    public PlayingField() {
        setBackground(Color.ORANGE);
        setLayout(new FlowLayout());
        butt();
    }

    public void butt() {//подгружаю кнопки
        snach = " ";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr [i][j] = snach;
                creatButton(i,j);
            }
        }
    }

    private void creatButton(int x, int y) {
        JButton jBut = new JButton();
        add(jBut);
        jBut.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jBut.setFont(FONT);

        actionListener(jBut, x, y);
    }

    private  void actionListener (JButton jButton, int x, int y){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jButton);
                arr[x][y]= snach;
                winer();
            }
        });
    }

    public void buttonEvent(JButton but) {
        //but.setFont(font);
        if (hod % 2 == 0) {
            but.setText("X");
            snach = "x";
        } else {
            but.setText("O");
            snach = "o";
        }
        hod++;
        but.setEnabled(false);
    }

    public void draw() {//
        if (hod == 9) {
            inGame = false;
            JOptionPane.showMessageDialog(null, "Ничья");
            startNewGame();
        }
    }

    public void proverkaWinnera() {
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) && arr[i][i] == "x") {
                inGame = false;
                break;
            }
            if ((arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]) && arr[i][i] == "o") {
                inGame = false;
                break;
            }
            if ((arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i]) && arr[i][i] == "x") {
                inGame = false;
                break;
            }
            if ((arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i]) && arr[i][i] == "o") {
                inGame = false;
                break;
            }
            if ((arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) && arr[i][i] == "x") {
                inGame = false;
                break;
            }
            if ((arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) && arr[i][i] == "o") {
                inGame = false;
                break;
            }
        }
    }

    public void winer() {
        proverkaWinnera();
        if (!inGame) {
            JOptionPane.showMessageDialog(null, "Победа");
            startNewGame();
        }
        else {
            draw();
        }
    }

    private void startNewGame(){
        setVisible(false);
        new MainWindow();
    }
}



