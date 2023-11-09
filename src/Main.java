import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

class EventListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);

        switch (actionCommand){
            case "Search":
                Main.frame.dispose();
                Main.frame = UI_Search.createFrame();
                break;
            case "Find": {
                String text = UI_Search.textInput.getText().toUpperCase();

                if (text.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Input is empty!");
                    break;
                }

                String result = "";

                if (UI_Search.comboBox.getSelectedItem().equals("Find by word")) {
                    result = DictionaryManager.findWordDefinition(text);
                } else {
                    result = DictionaryManager.findDefinitionWord(text);
                }

                if (result.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No result");
                    break;
                }
//                System.out.println(result);
                String[] results = result.split("`");

                UI_Search.searchResult.setListData(results);

                break;
            }
            case "History":
                Main.frame.dispose();
                Main.frame = UI_History.createFrame();
                break;
            case "Add": {
                String text = UI_Search.textInput.getText().toUpperCase();

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
                String text = UI_Search.textInput.getText().toUpperCase();

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
                String text = UI_Search.textInput.getText().toUpperCase();

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
                Main.frame.dispose();
                Main.frame = UI_Quiz.createFrame();

                UI_Quiz.setQuiz();

                String word = DictionaryManager.randomWord();
                String result = word + ":" + DictionaryManager.dictionary.get(word);
                UI_Quiz.wordDisplay.setText(result);

                break;
            }
            case "New": {
                String word = DictionaryManager.randomWord();
                String result = word + ":" + DictionaryManager.dictionary.get(word);
                UI_Quiz.wordDisplay.setText(result);
                break;
            }
            case "Switch Mode":
                UI_Quiz.setQuiz();
                break;
            case "Choose":
                int choice = UI_Quiz.getChoice();
                if (choice - 1 == UI_Quiz.answer){
                    JOptionPane.showMessageDialog(null,"Right answer!");
                } else{
                    JOptionPane.showMessageDialog(null,"Wrong answer!");
                }
                UI_Quiz.setQuiz();
                break;
            case "Back":
                Main.frame.dispose();
                Main.frame = UI_Default.createFrame();
                break;
            default:
                break;
        }
    }
}

public class Main {
    public static JFrame frame;

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
