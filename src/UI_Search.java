import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Search {
    private static JTextField textInput;
    private static JList<String> searchResult;
    private static JComboBox<String> comboBox;

    public static JTextField getTextInput(){
        return textInput;
    }

    public static void setSearchResult(String[] results){
        searchResult.setListData(results);
    }

    public static JComboBox<String> getComboBox(){
        return comboBox;
    }

    private static void addComponentsToPane(Container container) {
        EventListener listener = new EventListener();

        //// MAIN PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //// INPUT PANEL
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input text"));
        inputPanel.setBackground(Color.WHITE);

        /// TEXT FIELD for input text
        textInput = new JTextField();
        textInput.setPreferredSize(new Dimension(200, 20));
        inputPanel.add(textInput);

        /// PADDING for input panel
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(inputPanel);

        mainPanel.add(paddingPanel);

        //// SEARCH PANEL
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        /// COMBO BOX for choosing between 2 search modes
        comboBox = new JComboBox<String>(new String[]{"Find by word", "Find by definition"});
        comboBox.setBackground(Color.WHITE);
        searchPanel.add(comboBox);

        /// FIND BUTTON
        JButton button = new JButton("Find");
        button.setActionCommand("Find");
        button.addActionListener(listener);
        searchPanel.add(button);

        mainPanel.add(searchPanel);

        //// UPDATE PANEL
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new FlowLayout());

        /// ADD BUTTON
        button = new JButton("Add word");
        button.setActionCommand("Add");
        button.addActionListener(listener);
        updatePanel.add(button);

        /// EDIT BUTTON
        button = new JButton("Edit word");
        button.setActionCommand("Edit");
        button.addActionListener(listener);
        updatePanel.add(button);

        /// DELETE BUTTON
        button = new JButton("Delete word");
        button.setActionCommand("Delete");
        button.addActionListener(listener);
        updatePanel.add(button);

        mainPanel.add(updatePanel, BorderLayout.LINE_END);

        //// SEARCH RESULT PANEL
        JPanel searchResultPanel = new JPanel();
        searchResultPanel.setBorder(BorderFactory.createTitledBorder("Search result"));
        searchResultPanel.setBackground(Color.WHITE);

        /// LIST for displaying search results
        searchResult = new JList<String>();
        searchResult.setListData(new String[] {""});
        searchResultPanel.add(searchResult, BorderLayout.CENTER);

        /// SCROLL PANE for search results list
        JScrollPane scrollPane = new JScrollPane(searchResult);
        searchResultPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        /// PADDING for search result panel
        paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(searchResultPanel);

        mainPanel.add(paddingPanel);

        //// BOTTOM PANEL
        JPanel bottomPanel = new JPanel();

        /// RESET BUTTON
        button = new JButton("Reset");
        button.setActionCommand("Reset");
        button.addActionListener(listener);
        bottomPanel.add(button);

        /// BACK BUTTON
        button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        bottomPanel.add(button);

        mainPanel.add(bottomPanel, BorderLayout.PAGE_END);

        ///// SCROLL PANE for container
        JScrollPane mainScroll = new JScrollPane(mainPanel);
        container.add(mainScroll);
    }

    public static JFrame createFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Search");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static void main(String[] args){
    }

}
