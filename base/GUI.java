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

        /**
         * Sets an empty border for the panel with specified padding values.
         *
         * @param top    the padding value for the top side of the border
         * @param left   the padding value for the left side of the border
         * @param bottom the padding value for the bottom side of the border
         * @param right  the padding value for the right side of the border
         */
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        /**
         * Sets the layout manager for the panel to a GridLayout with a single column and variable number of rows.
         * 
         * @param panel the panel to set the layout for
         */
        panel.setLayout(new GridLayout(0, 1));

        panel.add(button);
        panel.add(label);

        /**
        * Adds a panel to the center of the frame.
        *
        * @param panel the panel to be added
        */
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

    /**
     * This method is called when an action event occurs.
     * It increments the count variable and updates the label text with the new count value.
     * 
     * @param e the action event that occurred
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Nombre de clicks : " + count);
    }
}