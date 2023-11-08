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
            case "Random Word":
                break;
            case "Quiz":
                Main.frame.dispose();
                Main.frame = UI_Quiz.createFrame();
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
            case "Back":
                Main.frame.dispose();
                Main.frame = UI_Default.createFrame();
                break;
            default:
                break;
        }
    }
}

public class Main { // 5, 8, 9, 10
    public static JFrame frame;
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    DictionaryManager.loadDictionary();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                frame = UI_Default.createFrame();
            }
        });
    }
}
