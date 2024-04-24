import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public GUI() {
        frame = new JFrame();
        button = new JButton("Click ici");
        button.addActionListener(this);
        panel = new JPanel();
        label = new JLabel("Nombre de clicks : " + count);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        /**
         * Sets the layout manager for the panel to a GridLayout with a single column and variable number of rows.
         * 
         * @param panel the panel to set the layout for
         */
        panel.setLayout(new GridLayout(0, 1));

        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Ma première fenêtre Java");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        System.out.println("It works !");
        new GUI();
        System.out.println("The Frame is visible");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        count++;
        label.setText("Nombre de clicks : " + count);
    }
}