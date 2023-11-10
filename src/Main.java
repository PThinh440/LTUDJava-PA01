import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class EventListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
//        System.out.println(actionCommand);

        switch (actionCommand){
            case "Search":
                Main.getFrame().dispose();
                Main.setFrame(UI_Search.createFrame());
                break;
            case "Find": {
                String text = UI_Search.getTextInput().getText().toUpperCase();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input is empty!");
                    break;
                }

                String result = "";

                if (UI_Search.getComboBox().getSelectedItem().equals("Find by word")) {
                    result = DictionaryManager.findWordDefinition(text);

                    if (!result.isEmpty()) {
                        HistoryTable.addToHistory(text);
                    }
                } else {
                    result = DictionaryManager.findDefinitionWord(text);
                }

                if (result.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No result");
                    break;
                }

                String[] results = result.split("`");
                UI_Search.setSearchResult(results);
                break;
            }
            case "History":
                Main.getFrame().dispose();
                Main.setFrame(UI_History.createFrame());
                break;
            case "Add": {
                String text = UI_Search.getTextInput().getText().toUpperCase();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input is empty!");
                    break;
                }

                if (DictionaryManager.addNewWord(text)){
                    JOptionPane.showMessageDialog(null, "Add successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "This word is not in dictionary");
                }

                break;
            }
            case "Edit": {
                String text = UI_Search.getTextInput().getText().toUpperCase();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input is empty!");
                    break;
                }
                if (DictionaryManager.editExistingWord(text)){
                    JOptionPane.showMessageDialog(null, "Edit successfully!");
                } else{
                    JOptionPane.showMessageDialog(null, "This word is not in dictionary");
                }
                break;
            }
            case "Delete": {
                String text = UI_Search.getTextInput().getText().toUpperCase();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input is empty!");
                    break;
                }
                if (DictionaryManager.deleteExistingWord(text)){
                    JOptionPane.showMessageDialog(null, "Delete successfully!");
                }

                break;
            }
            case "Reset":
                try {
                    DictionaryManager.loadDictionary();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null,"Reset successfully!");
                break;
            case "Quiz":{
                Main.getFrame().dispose();
                Main.setFrame(UI_Quiz.createFrame());

                UI_Quiz.setQuiz();

                String word = DictionaryManager.randomWord();
                String result = word + ": " + DictionaryManager.findWordDefinition(word);
                UI_Quiz.getWordDisplay().setText(result);

                break;
            }
            case "New": {
                String word = DictionaryManager.randomWord();
                String result = word + ": " + DictionaryManager.findWordDefinition(word);
                UI_Quiz.getWordDisplay().setText(result);
                break;
            }
            case "Switch Mode":
                UI_Quiz.setQuiz();
                break;
            case "Choose":
                if (UI_Quiz.choiceValidation()){
                    JOptionPane.showMessageDialog(null,"Right answer!");
                } else{
                    JOptionPane.showMessageDialog(null,"Wrong answer!");
                }
                UI_Quiz.setQuiz();
                break;
            case "Back":
                Main.getFrame().dispose();
                Main.setFrame(UI_Default.createFrame());
                break;
            default:
                break;
        }
    }
}

public class Main {
    private static JFrame frame;

    public static JFrame getFrame(){
        return frame;
    }
    public static void setFrame(JFrame newFrame){
        frame = newFrame;
    }

    private static void setUp(){
        HistoryTable.loadHistory();
        try {
            DictionaryManager.loadDictionary();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame = UI_Default.createFrame();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setUp();
            }
        });
    }
}
