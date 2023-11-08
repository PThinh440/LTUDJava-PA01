import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import java.util.TreeMap;

public class DictionaryManager {
    public static TreeMap<String, String> dictionary;
    public static Random rand = new Random();


    public static void loadDictionary() throws IOException {
        dictionary = FileLoader.loadDictionary();
    }

    public static boolean addNewWord(String word){

        if (dictionary.containsKey(word)){
            String[] options = new String[]{"Overwrite", "Add meaning", "Cancel"};
            int option = JOptionPane.showOptionDialog(null,
                    "The word has already had meaning.","Warning",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[2]);

            if (option != 1 && option != 0){
                return false;
            }

            String newDefintion = JOptionPane.showInputDialog("New definition: ");

            if (option == 1) {
                newDefintion = dictionary.get(word) + "| " + newDefintion;
            }

            dictionary.replace(word, dictionary.get(word), newDefintion);

        } else {
            String definition = JOptionPane.showInputDialog("Definition: ");
            dictionary.put(word, definition);
        }

        return true;
    }

    public static boolean deleteExistingWord(String word){
        if (dictionary.containsKey(word)){
            // Confirm trc khi xoa
            int option = JOptionPane.showConfirmDialog(null, "Delete?");
            if (option == JOptionPane.YES_OPTION){
                dictionary.remove(word);
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "This word is not in dictionary");
        }

        return false;
    }

    public static String findWordDefinition(String word){
        String definition = "";

        definition = dictionary.get(word);
        if  (definition == null) {
//            System.out.println("This word is not in dictionary");
            return "";
        }

        // add to history
        HistoryTable.addToHistory(word + ": " + dictionary.get(word));

        return definition;
    }

    public static String findDefinitionWord (String definition){
        StringBuilder word = new StringBuilder();

        for (String key : dictionary.keySet()) {
            if (dictionary.get(key).toUpperCase().contains(definition.toUpperCase())){
                if (!word.isEmpty()){
                    word.append("`");
                }
                word.append(key + ": " + dictionary.get(key));

            }
        }

        // TODO: add to history

        return word.toString();
    }

    public static boolean editExistingWord(String word){
        if (dictionary.containsKey(word)){
            // parse definitions
            String newDefinition = JOptionPane.showInputDialog("Definition:");
            dictionary.replace(word, newDefinition);
        } else {
            return false;
        }
        return true;
    }

    public static String[] getWordMeaning(){
        String[] meaning = new String[0];

        return meaning;
    }

    public static String randomWord(){
        String word = "", definition = "";
        int chosenWordIndex = rand.nextInt(dictionary.size());
        word = (String) dictionary.keySet().toArray()[chosenWordIndex];
        definition = dictionary.get(word);

        return word + ": " + definition;
    }

    public static String randomDefinition(){
        String definition = "";

        return definition;
    }

    public static void main (String[] args){

    }
}
