import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Quiz {
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

//        container.getAlignmentX()
        JPanel dailyWordPanel = new JPanel();
        dailyWordPanel.setLayout(new BoxLayout(dailyWordPanel, BoxLayout.Y_AXIS));

        JPanel wordBoxPannel = new JPanel();
        JLabel wordDisplay = new JLabel("Hello");
        wordDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        wordBoxPannel.add(wordDisplay);
        wordBoxPannel.setBackground(Color.WHITE);

        dailyWordPanel.add(wordBoxPannel);
        dailyWordPanel.add(Box.createRigidArea(new Dimension(200, 10)));

        JButton button = new JButton("New word");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("New");
        button.addActionListener(listener);
        dailyWordPanel.add(button);
        dailyWordPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        container.add(dailyWordPanel);

        JPanel quizPanel = new JPanel();
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));
        JLabel quiz = new JLabel("Quiz");
        quiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        quizPanel.add(quiz);

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new FlowLayout());
        button = new JButton("Option 1");
        button.setActionCommand("Opt1");
        button.addActionListener(listener);
        choicePanel.add(button);

        button = new JButton("Option 2");
        button.setActionCommand("Opt2");
        button.addActionListener(listener);
        choicePanel.add(button);

        button = new JButton("Option 3");
        button.setActionCommand("Opt3");
        button.addActionListener(listener);
        choicePanel.add(button);

        button = new JButton("Option 4");
        button.setActionCommand("Opt4");
        button.addActionListener(listener);
        choicePanel.add(button);

        quizPanel.add(choicePanel);
        quizPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        container.add(quizPanel);

        JPanel returnPanel = new JPanel();
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
