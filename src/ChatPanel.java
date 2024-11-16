import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import static javax.swing.ScrollPaneConstants.*;

public class ChatPanel extends JPanel {
    // private int windowWidth, windowHeight;
    JTextArea chat;
    JScrollPane chatScroll;
    JTextField message;
    JList<String> userList;
    Action sendMessage;

    // public ChatPanel(int x, int y) {}

    public ChatPanel() {
        GridBagConstraints cc = new GridBagConstraints();
        DefaultListModel<String> userListModel = new DefaultListModel<>();
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
        chatScroll = new JScrollPane(chat, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
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

        // Send Message :)
        sendMessage = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChat();
            }
        };
        message.addActionListener(sendMessage);

        // User List
        userList = new JList<>(userListModel);
        userListModel.addElement("user1");
        userListModel.addElement("user2");
        userList.setVisible(true);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userList.setFont(new Font("Consolas", Font.PLAIN, 14));
        userList.setBackground(new Color(0x201d1e));
        userList.setForeground(new Color(0xe97263));
        userList.setBorder(null);

        // Add everything to the panel so it's pretty
        cc.fill = GridBagConstraints.BOTH; cc.weightx = 1; cc.weighty = 1;
        add(chatScroll, cc);
        cc.weightx = 0; cc.ipadx = 40;
        add(userList, cc);
        cc.gridy = 1; cc.weighty = 0; cc.weightx = 1; cc.gridwidth = 2;
        cc.ipadx = 0;
        add(message, cc);
        setBackground(Color.CYAN); // if this color is seen, something has gone wrong
    }

    public void updateChat() {
        chat.append(message.getText()+'\n');
        message.setText("");
    }
}