import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends Frame {
    ServerPanel serverPanel;
    final int X = 8;
    final int Y = 31;
    public MainWindow() {
        Panel mainPanel = new Panel();
        mainPanel.setPreferredSize(new Dimension(720,480));
        mainPanel.setLayout(null);
        serverPanel = new ServerPanel();
        serverPanel.setBackground(Color.gray);

        mainPanel.add(serverPanel);
        mainPanel.add(new ChatPanel());
        add(mainPanel);
        setLocationRelativeTo(null);
        pack();
        setPreferredSize(new Dimension(720,480));
        setTitle("JIRC");
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}
