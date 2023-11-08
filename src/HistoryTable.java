import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HistoryTable {
    public static List<String> wordHistory;

    public static void addToHistory(String word){
        wordHistory.remove(word);
        wordHistory.add(0, word);
    }

    public static void loadHistory(){
        // should make this in constructor
        wordHistory = new LinkedList<String>();
    }

    public static void main(String[] args){

    }
}
