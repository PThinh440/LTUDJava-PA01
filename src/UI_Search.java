import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Search {
    public static JTextField textInput;
    public static JList<String> searchResult;
    public static JComboBox<String> comboBox;
    private static void addComponentsToPane(Container container) {
        EventListener listener = new EventListener();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        //// INPUT PANEL
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input text"));
        inputPanel.setBackground(Color.WHITE);

        /// TEXT FIELD
        textInput = new JTextField();
        textInput.setPreferredSize(new Dimension(200, 20));
        inputPanel.add(textInput);

        /// PADDING
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(inputPanel);

        container.add(paddingPanel);

        //// SEARCH PANEL
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        /// COMBO BOX
        comboBox = new JComboBox<String>(new String[]{"Find by word", "Find by definition"});
        comboBox.setBackground(Color.WHITE);
        searchPanel.add(comboBox);

        /// FIND BUTTON
        JButton button = new JButton("Find");
        button.setActionCommand("Find");
        button.addActionListener(listener);
        searchPanel.add(button);

        container.add(searchPanel);

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

        container.add(updatePanel, BorderLayout.LINE_END);

        //// SEARCH RESULT PANEL
        JPanel searchResultPanel = new JPanel();
        searchResultPanel.setBorder(BorderFactory.createTitledBorder("Search result"));
        searchResultPanel.setBackground(Color.WHITE);

        /// RESULT LABEL
        searchResult = new JList<String>();
        searchResult.setListData(new String[] {""});
        searchResultPanel.add(searchResult, BorderLayout.CENTER);

        /// SCROLL PANE
        JScrollPane scrollPane = new JScrollPane(searchResult);
        searchResultPanel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        /// PADDING
        paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(searchResultPanel);

        container.add(paddingPanel);

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

        container.add(bottomPanel, BorderLayout.PAGE_END);
    }

    public static JFrame createFrame() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Search");
        frame.setMinimumSize(new Dimension(400, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args){
    }

}
