import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Quiz {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        //// DAILY WORD PANEL
        JPanel dailyWordPanel = new JPanel();
        dailyWordPanel.setLayout(new BoxLayout(dailyWordPanel, BoxLayout.Y_AXIS));
        dailyWordPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        /// WORD BOX PANEL
        JPanel wordBoxPanel = new JPanel();
        wordBoxPanel.setBackground(Color.WHITE);

        // WORD LABEL
        JLabel wordDisplay = new JLabel("Hello");
        wordDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        wordBoxPanel.add(wordDisplay);

        dailyWordPanel.add(wordBoxPanel);

        /// RIGID AREA
        dailyWordPanel.add(Box.createRigidArea(new Dimension(200, 10)));

        /// NEW BUTTON
        JButton button = new JButton("New word");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("New");
        button.addActionListener(listener);
        dailyWordPanel.add(button);

        container.add(dailyWordPanel);

        //// QUIZ PANEL
        JPanel quizPanel = new JPanel();
        quizPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));

        /// LABEL
        JLabel quiz = new JLabel("Quiz");
        quiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        quizPanel.add(quiz);

        /// CHOICE PANEL
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new FlowLayout());

        // OPT 1 BUTTON
        button = new JButton("Option 1");
        button.setActionCommand("Opt1");
        button.addActionListener(listener);
        choicePanel.add(button);

        // OPT 2 BUTTON
        button = new JButton("Option 2");
        button.setActionCommand("Opt2");
        button.addActionListener(listener);
        choicePanel.add(button);

        // OPT 3 BUTTON
        button = new JButton("Option 3");
        button.setActionCommand("Opt3");
        button.addActionListener(listener);
        choicePanel.add(button);

        // OPT 4 BUTTON
        button = new JButton("Option 4");
        button.setActionCommand("Opt4");
        button.addActionListener(listener);
        choicePanel.add(button);

        quizPanel.add(choicePanel);
        container.add(quizPanel);

        //// RETURN PANEL
        JPanel returnPanel = new JPanel();

        /// RETURN BUTTON
        button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        returnPanel.add(button);

        container.add(returnPanel);

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
