import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenManager implements ActionListener {
    public ScreenManager() {

    }

    private static JFrame frame;

    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);

        switch (actionCommand){
            case "Search":
                frame.dispose();
                frame = UI_Search.createFrame();
                break;
            case "History":
                frame.dispose();
                frame = UI_History.createFrame();
                break;
            case "Random Word":
                break;
            case "Quiz":
                frame.dispose();
                frame = UI_Quiz.createFrame();
                break;
            case "Add":
                break;
            case "Edit":
                break;
            case "Delete":
                break;
            case "Reset":
                break;
            case "Back":
                frame.dispose();
                frame = UI_Default.createFrame();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = UI_Default.createFrame();
            }
        });
    }
}
