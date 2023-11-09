import javax.swing.*;
import java.awt.*;

public class UI_Default {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        //// SEARCH BUTTON
        JButton button = new JButton("Search");
        button.setActionCommand("Search");
        button.addActionListener(listener);
        container.add(button, BorderLayout.CENTER);

        //// HISTORY BUTTON
        button = new JButton("History");
        button.setActionCommand("History");
        button.addActionListener(listener);
        container.add(button, BorderLayout.LINE_END);

        //// QUIZ BUTTON
        button = new JButton("Quiz");
        button.setActionCommand("Quiz");
        button.addActionListener(listener);

        container.add(button, BorderLayout.PAGE_END);
    }

    public static JFrame createFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Dictionary");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createContentPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static void main(String[] args){
    }

}
