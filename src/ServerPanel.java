import java.awt.*;
import javax.swing.*;

public class ServerPanel extends JPanel {
    JList<String> serverList;

    public ServerPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints serverListContstraints = new GridBagConstraints();

        // Create an empty list then add stuff to it :)
        DefaultListModel<String> serverListModel  = new DefaultListModel<>();
        serverList = new JList<>(serverListModel);
        serverListModel.addElement("Server");
        serverListModel.addElement("├ #Channel");
        serverListModel.addElement("└ #Other");

        // Make it pretty
        serverList.setVisible(true);
        serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serverList.setBackground(new Color(0x2C282A));
        serverList.setForeground(new Color(0xe97263));
        serverList.setFont(new Font("Consolas", Font.PLAIN, 14));
        serverList.setSelectionForeground(new Color(0x201d1e));
        serverList.setSelectionBackground(new Color(0xf18c7e));
        serverList.setBorder(null);

        // Put it in the panel
        serverListContstraints.weightx = 1; serverListContstraints.weighty = 1;
        serverListContstraints.fill = GridBagConstraints.BOTH;
        serverListContstraints.ipadx = 50;
        add(serverList, serverListContstraints);
        setBackground(Color.GRAY); // Should never see this color, would be a bug
        setVisible(true);
    }
}
