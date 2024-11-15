import java.awt.*;
import javax.swing.*;

public class ServerPanel extends Panel {
    List serverList;
    final int X = 8, Y = 31;
    public ServerPanel() {
        serverList = new List(4,false);
        serverList.add("Server");
        serverList.add("#Channel");
        serverList.add("");
        serverList.add("   there's items above this entry");
        serverList.setSize(130,240);
        add(serverList);
        setBounds(0, 0,130,480);
        setBackground(Color.GRAY);
        setLayout(null);
        setVisible(true);
    }
}
