import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//            case "Add":
//                break;
//            case "Edit":
//                break;
//            case "Delete":
//                break;
//            case "Reset":
//                break;
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
    public Main() {

    }

    public static JFrame frame;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = UI_Default.createFrame();
            }
        });
    }
}
