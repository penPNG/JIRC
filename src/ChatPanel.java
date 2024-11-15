import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import static javax.swing.ScrollPaneConstants.*;

public class ChatPanel extends JPanel {
    // private int windowWidth, windowHeight;
    JTextArea chat;
    JTextField message;
    //JList<String> users;

    // public ChatPanel(int x, int y) {}

    public ChatPanel() {
        GridBagConstraints chatConstraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Chat area
        chat = new JTextArea();
        chat.setLineWrap(true);
        chat.setWrapStyleWord(true);
        chat.setEditable(true);
        chat.setFont(new Font("Consolas", Font.PLAIN, 14));
        chat.setBackground(new Color(0x201d1e));
        chat.setForeground(new Color(0xe97263));
        chat.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(10,10,10,10)));
        // For the scrollbar
        JScrollPane chatScroll = new JScrollPane(chat, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        chatScroll.setMinimumSize(new Dimension(300,175));
        chatScroll.setBorder(null);
        chatScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() { // TODO: Create scrollbar UI Class extending
            @Override
            protected void configureScrollBarColors() {
                this.trackColor = new Color(0x373234);
                this.thumbColor = new Color(0x2C282A);
            }
        });

        // Message Box - TODO: Ghost text functionality
        message = new JTextField();
        message.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(7,5,5,5)));
        message.setFont(new Font("Consolas", Font.PLAIN, 14));
        message.setBackground(new Color(0x1B1818));
        message.setForeground(new Color(0xe97263));

        // Add everything to the panel so it's pretty
        chatConstraints.fill = GridBagConstraints.BOTH; chatConstraints.weightx = 1; chatConstraints.weighty = 1;
        add(chatScroll, chatConstraints);
        chatConstraints.gridy = 1; chatConstraints.weighty = 0;
        add(message, chatConstraints);
        setBackground(Color.CYAN); // if this color is seen, something has gone wrong
    }

}
