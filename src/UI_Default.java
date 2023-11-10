import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Default {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        ///// MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createTitledBorder("Slang word dictionary"));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(200,100));

        //// SEARCH BUTTON
        JButton button = new JButton("Search");
        button.setActionCommand("Search");
        button.addActionListener(listener);

        /// PADDING for search button
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(0, 10, 5, 5));
        paddingPanel.add(button);
        mainPanel.add(paddingPanel, BorderLayout.CENTER);

        //// HISTORY BUTTON
        button = new JButton("History");
        button.setActionCommand("History");
        button.addActionListener(listener);

        /// PADDING for history button
        paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(0, 5, 5, 10));
        paddingPanel.add(button);
        mainPanel.add(paddingPanel, BorderLayout.LINE_END);

        //// QUIZ BUTTON
        button = new JButton("Quiz");
        button.setActionCommand("Quiz");
        button.addActionListener(listener);

        /// PADDING for quiz button
        paddingPanel = new JPanel();
        paddingPanel.add(button);
        mainPanel.add(button, BorderLayout.PAGE_END);

        //// PADDING for main panel
        paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(mainPanel);

        container.add(paddingPanel);
    }

    public static JFrame createFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Dictionary");
        frame.setPreferredSize(new Dimension(250, 150));
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
