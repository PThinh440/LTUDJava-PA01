import javax.swing.*;
import java.awt.*;

public class UI_Quiz {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        JPanel returnPanel = new JPanel();
        JButton button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        returnPanel.add(button);

        container.add(returnPanel, BorderLayout.PAGE_END);
    }

    public static JFrame createFrame() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Quiz");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        createContentPane(frame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
//        frame.setLocation(200,200);
        return frame;
    }

    public static void main(String[] args){
    }
}
