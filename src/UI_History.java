import javax.swing.*;
import java.awt.*;

public class UI_History {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        ///// MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //// SEARCH HISTORY PANEL
        JPanel searchHistoryPanel = new JPanel();
        searchHistoryPanel.setBorder(BorderFactory.createTitledBorder("Search history"));

        /// LIST for storing search history
        JList wordList = new JList(HistoryTable.wordHistory.toArray());

        /// SCROLL PANE for list
        JScrollPane listScroll = new JScrollPane(wordList);
        listScroll.setPreferredSize(new Dimension(250, 150));

        searchHistoryPanel.add(listScroll);
        mainPanel.add(searchHistoryPanel);

        /// BACK BUTTON
        JButton button = new JButton("Back");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("Back");
        button.addActionListener(listener);
        mainPanel.add(button);

        //// SCROLL PANE for container
        JScrollPane mainScroll = new JScrollPane(mainPanel);
        container.add(mainScroll);
    }

    public static JFrame createFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("History");
        frame.setPreferredSize(new Dimension(300, 250));
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
