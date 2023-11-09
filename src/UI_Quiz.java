import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Quiz {
    public static JLabel quiz;
    public static JLabel wordDisplay;
    public static JComboBox<String> quizMode;
    public static JRadioButton rb1;
    public static JRadioButton rb2;
    public static JRadioButton rb3;
    public static JRadioButton rb4;

    public static int answer;
    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //// DAILY WORD PANEL
        JPanel dailyWordPanel = new JPanel();
        dailyWordPanel.setLayout(new BoxLayout(dailyWordPanel, BoxLayout.Y_AXIS));
        dailyWordPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        /// WORD BOX PANEL
        JPanel wordBoxPanel = new JPanel();
        wordBoxPanel.setBackground(Color.WHITE);

        // WORD LABEL
        // TODO scrollpane
        wordDisplay = new JLabel();
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

        mainPanel.add(dailyWordPanel);

        //// QUIZ PANEL
        JPanel quizPanel = new JPanel();
        quizPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));

        /// COMBOBOX
        quizMode = new JComboBox<String>(
                new String[] {"Word Quiz", "Definition Quiz"});
        quizMode.setActionCommand("Switch Mode");
        quizMode.addActionListener(listener);
        quizPanel.add(quizMode);

        /// LABEL
        quiz = new JLabel();
        quiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        quiz.setBorder(new EmptyBorder(10, 10, 10, 10));
        quizPanel.add(quiz);

        /// CHOICE PANEL
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));
        choicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        choicePanel.setBackground(Color.WHITE);

        // BUTTON GROUP
        ButtonGroup buttonGroup = new ButtonGroup();

        // OPT 1 BUTTON
        rb1 = new JRadioButton();
        rb1.setSelected(true);
        rb1.setBackground(Color.WHITE);
        buttonGroup.add(rb1);
        choicePanel.add(rb1);

        // OPT 2 BUTTON
        rb2 = new JRadioButton();
        rb2.setBackground(Color.WHITE);
        buttonGroup.add(rb2);
        choicePanel.add(rb2);

        // OPT 3 BUTTON
        rb3 = new JRadioButton();
        rb3.setBackground(Color.WHITE);
        buttonGroup.add(rb3);
        choicePanel.add(rb3);

        // OPT 4 BUTTON
        rb4 = new JRadioButton();
        rb4.setBackground(Color.WHITE);
        buttonGroup.add(rb4);
        choicePanel.add(rb4);

        quizPanel.add(choicePanel);

        // CHOOSE BUTTON
        button = new JButton("Choose");
        button.setActionCommand("Choose");
        button.addActionListener(listener);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        quizPanel.add(button);

        mainPanel.add(quizPanel);

        //// RETURN PANEL
        JPanel returnPanel = new JPanel();

        /// RETURN BUTTON
        button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        returnPanel.add(button);

        mainPanel.add(returnPanel);
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        container.add(scrollPane);
    }

    public static int getChoice(){
        int choice = -1;

        if (rb1.isSelected()){
            choice = 1;
        } else if (rb2.isSelected()){
            choice = 2;
        } else if (rb3.isSelected()){
            choice = 3;
        } else if (rb4.isSelected()){
            choice = 4;
        }
        return choice;
    }

    public static void setQuiz(){
        String question = "";
        String[] options= new String[4];
        int chosenIndex = DictionaryManager.rand.nextInt(4);
        int mode = quizMode.getSelectedIndex();

        for (int i = 0; i < 4; i++){
            String word = DictionaryManager.randomWord();

            if (i == chosenIndex){
                if (mode == 0) {
                    question = word;
                } else{
                    question = DictionaryManager.dictionary.get(word);
                }
            }
            if (mode == 0) {
                options[i] = DictionaryManager.dictionary.get(word);
            } else {
                options[i] = word;
            }
        }

        quiz.setText(question);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        answer = chosenIndex;
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
