import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentcalculation {
    private JTextField textStudent;
    private JTextField textMarks1;
    private JTextField textMarks2;
    private JTextField textMarks3;
    private JTextField textTotal;
    private JTextField textGrade;
    private JTextField textAverage;
    private JButton calButton;
    private JPanel main;

    public static void main(String[] args) {
        JFrame frame = new JFrame("studentcalculation");
        frame.setContentPane(new studentcalculation().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public studentcalculation() {
    calButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             int  m1,m2,m3;
             double avg;
             m1=Integer.parseInt(textMarks1.getText());
            m2=Integer.parseInt(textMarks2.getText());
            m3=Integer.parseInt(textMarks3.getText());
             int total=m1+m2+m3;
            textTotal.setText(String.valueOf(total));
             avg= (total/3);
            textAverage.setText(String.valueOf(avg));
            String grade =" ";
            if (avg > 85) {
                textGrade.setText("A");
            } else if (avg > 75) {
                textGrade.setText("B");
            } else if (avg > 60) {
                textGrade.setText("C");
            } else if (avg > 50) {
                textGrade.setText("D");
            } else if (avg > 45) {
                textGrade.setText("E");
            }

        }
    });
}
}
