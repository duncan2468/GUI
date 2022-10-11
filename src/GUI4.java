import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// this code continues from GUI3 and will give us working code.
// we will update the button label to display the number of clicks
// The actionPerformed method needs visibility of JLabel,
// so we bring it into scope in the class, just after the count declaration.
// When we bring it into scope we can remove "JPanel" object declaration from in front of panel
public class GUI4 implements ActionListener {

    // we define a counter here - accessible to all the methods
    // we perform the counting in the actionPerformed method
    int count = 0;
    JLabel label;


    // constructor
    public GUI4() {
        // we make a frame object for the window using the JFrame class
        JFrame frame = new JFrame();

        // make a button with some text on it
        JButton button = new JButton("Click this");

        // add listener to the button. Use "this" to refer to current class
        button.addActionListener(this);
        // add a label for the button
        // *** we remove "JLabel" object declaration from in front of label as it is in scope in class
        label = new JLabel("Number of clicks: 0");

        // we need a panel inside the frame
        JPanel panel = new JPanel();
        // then we set the border of the panel (Note wide variety of JPanel methods)
        // Note - we need a border object, we can get one with the BorderFactory class
        // We enter the parameters for the border in pixels (top, bottom, left, right)
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        // panel.setBackground(Color.BLUE);
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
        new GUI4();
    }

    // this gets included when you implement ActionListener and shift-alt-enter
    @Override
    public void actionPerformed(ActionEvent e) {
        //perform the count
        count++;
        // we now need to update the button label to display the number of clicks
        // this must be done here because actionPerformed is unaware of JLabel
        // So we bring JLabel into scope in the GUI class
        label.setText("Number of clicks: " + count);
    }
}