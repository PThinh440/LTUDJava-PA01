import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Quiz {
    private static JLabel quiz;
    private static JLabel wordDisplay;
    private static JComboBox<String> quizMode;
    private static JRadioButton rb1, rb2, rb3, rb4;
    private static int answer;

    public static JLabel getWordDisplay(){
        return wordDisplay;
    }

    private static void createContentPane(Container container) {
        EventListener listener = new EventListener();

        ///// MAIN PANEL
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //// DAILY WORD PANEL
        JPanel dailyWordPanel = new JPanel();
        dailyWordPanel.setBorder(BorderFactory.createTitledBorder("On this day slang word"));
        dailyWordPanel.setLayout(new BoxLayout(dailyWordPanel, BoxLayout.Y_AXIS));
        dailyWordPanel.setPreferredSize(new Dimension(350, 100));
        dailyWordPanel.setBackground(Color.WHITE);

        /// WORD BOX PANEL
        JPanel wordBoxPanel = new JPanel();
        wordBoxPanel.setBackground(Color.WHITE);

        // LABEL for word displaying
        wordDisplay = new JLabel();
        wordDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        wordBoxPanel.add(wordDisplay);

        // SCROLL PANE for word label
        JScrollPane wordScroll = new JScrollPane(wordBoxPanel);
        dailyWordPanel.add(wordScroll);

        /// NEW BUTTON
        JButton button = new JButton("New word");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("New");
        button.addActionListener(listener);
        dailyWordPanel.add(button);

        /// PADDING for daily word panel
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
        paddingPanel.add(dailyWordPanel);

        mainPanel.add(paddingPanel);

        //// QUIZ PANEL
        JPanel quizPanel = new JPanel();
        quizPanel.setBorder(BorderFactory.createTitledBorder("Quiz"));
        quizPanel.setPreferredSize(new Dimension(350, 200));
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));
        quizPanel.setBackground(Color.WHITE);

        /// COMBOBOX for switching between 2 quiz modes
        quizMode = new JComboBox<String>(
                new String[] {"Word Quiz", "Definition Quiz"});
        quizMode.setBackground(Color.WHITE);
        quizMode.setActionCommand("Switch Mode");
        quizMode.addActionListener(listener);
        quizPanel.add(quizMode);

        /// LABEL for question displaying
        quiz = new JLabel();
        quiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        quiz.setBorder(new EmptyBorder(10, 10, 10, 10));
        quizPanel.add(quiz);

        /// CHOICE PANEL
        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));
        choicePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        choicePanel.setBackground(Color.WHITE);

        // BUTTON GROUP for one choice only
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

        /// PADDING for quiz panel
        paddingPanel = new JPanel();
        paddingPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        paddingPanel.add(quizPanel);

        mainPanel.add(paddingPanel);

        //// RETURN PANEL
        JPanel returnPanel = new JPanel();

        /// RETURN BUTTON
        button = new JButton("Back");
        button.setActionCommand("Back");
        button.addActionListener(listener);
        returnPanel.add(button);

        mainPanel.add(returnPanel);

        //// SCROLL PANE for main panel
        JScrollPane mainScroll = new JScrollPane(mainPanel);
        container.add(mainScroll);
    }

    public static int getChoice(){
        int choice = -1;

        if (rb1.isSelected()){
            choice = 0;
        } else if (rb2.isSelected()){
            choice = 1;
        } else if (rb3.isSelected()){
            choice = 2;
        } else if (rb4.isSelected()){
            choice = 3;
        }
        return choice;
    }

    public static boolean choiceValidation(){
        return getChoice() == answer;
    }

    public static void setQuiz(){
        String question = "";
        String[] options= new String[4];
        int chosenIndex = RandomGenerator.getRand().nextInt(4);
        int mode = quizMode.getSelectedIndex();

        for (int i = 0; i < 4; i++){
            String word = DictionaryManager.randomWord();

            if (mode == 0){ // Word quiz mode
                if (i == chosenIndex){
                    question = word;
                }
                options[i] = DictionaryManager.findWordDefinition(word);
            } else { // Definition quiz mode
                if (i == chosenIndex){
                    question = DictionaryManager.findWordDefinition(word);
                }
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
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Quiz");
        frame.setPreferredSize(new Dimension(400, 450));
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
