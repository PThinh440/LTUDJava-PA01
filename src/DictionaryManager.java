import javax.swing.*;
import java.io.IOException;
import java.util.TreeMap;

public class DictionaryManager {
    private static TreeMap<String, String> dictionary;

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
            // Confirm before delete
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

        if (definition == null) {
            return "";
        }

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

    public static String randomWord(){
        String word = "";
        int chosenWordIndex = RandomGenerator.getRand().nextInt(dictionary.size());
        word = (String) dictionary.keySet().toArray()[chosenWordIndex];

        return word;
    }

    public static void main (String[] args){

    }
}
