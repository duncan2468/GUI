import javax.swing.*;
import java.awt.*;

// this code continues from GUI1 and adds a button with a label
public class GUI2 {
    // constructor
    public GUI2() {
        // we make a frame object for the window using the JFrame class
        JFrame frame = new JFrame();

        // make a button with some text on it
        JButton button = new JButton("Click this");
        // add a label for the button
        JLabel label = new JLabel("Number of clicks: 0");

        // we need a panel inside the frame
        JPanel panel = new JPanel();
        // then we set the border of the panel (Note wide variety of JPanel methods)
        // Note - we need a border object, we can get one with the BorderFactory class
        // We enter the parameters for the border in pixels (top, bottom, left, right)
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        // define the layout as a Grid of 1 column
        panel.setLayout(new GridLayout(0, 1));
        //---------------
        // this adds a button to the panel - Run code now to test
        panel.add(button);
        // import the label and add it to the panel - Run code now to test
        panel.add(label);

        // add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        // define what happens when user closes the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // title the frame
        frame.setTitle("My First GUI");
        // size window according to size of its subcomponents
        frame.pack();
        // make window visible
        frame.setVisible(true);
    }
    public static void main (String[] args) {
        //creates a GUI object
        new GUI2();
    }
}