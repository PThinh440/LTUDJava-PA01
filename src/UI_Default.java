import javax.swing.*;
import java.awt.*;

public class UI_Default {
    private static void createContentPane(Container container) {
        JButton button;
        ScreenManager listener = new ScreenManager();

        button = new JButton("Search");
        button.setActionCommand("Search");
        button.addActionListener(listener);
        container.add(button, BorderLayout.CENTER);

        button = new JButton("History");
        button.setActionCommand("History");
        button.addActionListener(listener);
        container.add(button, BorderLayout.LINE_END);

        button = new JButton("Quiz");
        button.setActionCommand("Quiz");
        button.addActionListener(listener);

        container.add(button, BorderLayout.PAGE_END);

    }

    public static JFrame createFrame() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Dictionary");
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
