import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// this code continues from GUI4.
// The purpose here is to clean up some of the code
public class GUI6 implements ActionListener {

    // we define a counter here - accessible to all the methods
    // we perform the counting in the actionPerformed method
    // *** the items below can be made private so they are only available to this class
    // *** which is good practice
    private int count = 0;
    private JLabel label;
    private JLabel colourLabel;
    // we can also bring JFrame and JPanel into scope
    private JFrame frame;
    private JPanel panel;

    // constructor
    public GUI6() {
        // we make a frame object for the window using the JFrame class
        // *** we remove "JFrame" object declaration  from in front of frame as it is in scope in class
        frame = new JFrame();

        // make a button with some text on it
        JButton button = new JButton("Click this");
        colourLabel = new JLabel("Click to change colour");
        JButton colourButton = new JButton("Change colour");
        // add listener to the button. Use "this" to refer to current class
        button.addActionListener(this);
        colourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.CYAN);
                panel.remove(colourButton);
                panel.remove(colourLabel);
            }
        });

        // add a label for the button
        // *** we remove "JLabel" object declaration from in front of label as it is in scope in class
        label = new JLabel("Number of clicks: 0");

        // *** we remove "JPanel" object declaration from in front of panel as it is in scope in class
        // we need a panel inside the frame
        panel = new JPanel();
        // then we set the border of the panel (Note wide variety of JPanel methods)
        // Note - we need a border object, we can get one with the BorderFactory class
        // We enter the parameters for the border in pixels (top, bottom, left, right)
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
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
        new GUI6();
    }

    // this gets included when you implement ActionListener and shift-alt-enter
    @Override
    public void actionPerformed(ActionEvent e) {
        //perform the count
        count++;
        // we now need to update the button label to display the number of clicks
        // this cannot be done here because actionPerformed is unaware of JLabel
        // So we bring JLabel into scope in the GUI class
        label.setText("Number of clicks: " + count);
    }
}
