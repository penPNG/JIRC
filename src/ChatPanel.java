import java.awt.*;

public class ChatPanel extends Panel {
    final int X=8, Y=31;
    private int windowWidth, windowHeight;
    TextArea chat;
    TextField message;
    List users;

    public ChatPanel(int x, int y) {}

    public ChatPanel() {
        chat = new TextArea(null, 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        chat.setBounds(0,0,590, 400);
        chat.setEditable(false);
        message = new TextField();
        message.setBounds(0, 400, 590, 30);
        users = new List(3);
        add(chat);
        add(message);
        setBounds(130, 0, 590, 480);
        setBackground(Color.cyan);
        setLayout(new GridBagLayout());
    }

}
