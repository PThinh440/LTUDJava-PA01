import javax.swing.*;
import java.awt.*;

public class UI_Search {
    private static void addComponentsToPane(Container container) {
        EventListener listener = new EventListener();

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 20));
        searchPanel.add(textField, BorderLayout.CENTER);

        JButton button = new JButton("Find");
        button.setActionCommand("Find");
        button.addActionListener(listener);
        searchPanel.add(button, BorderLayout.LINE_END);

        container.add(searchPanel, BorderLayout.CENTER);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));

        button = new JButton("Add");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("Add");
        button.addActionListener(listener);
        updatePanel.add(button);

        button = new JButton("Edit");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("Edit");
        button.addActionListener(listener);
        updatePanel.add(button);

        button = new JButton("Delete");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("Delete");
        button.addActionListener(listener);
        updatePanel.add(button);

        button = new JButton("Reset");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("Reset");
        button.addActionListener(listener);
        updatePanel.add(button);

        container.add(updatePanel, BorderLayout.LINE_END);

        JPanel returnPanel = new JPanel();

        button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        returnPanel.add(button);

        container.add(returnPanel, BorderLayout.PAGE_END);
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
