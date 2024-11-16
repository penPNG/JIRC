import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    ServerPanel serverPanel;
    ChatPanel chatPanel;

    public MainWindow() {
        // Set color and constraints and layout
        getContentPane().setBackground(new Color(0x2C282A));
        GridBagConstraints wc = new GridBagConstraints();
        GridBagConstraints mc = new GridBagConstraints();
        setLayout(new GridBagLayout());

        // Underlying main panel because I thought it'd make more sense
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setPreferredSize(new Dimension(720,480));
        mainPanel.setBackground(new Color(0x2C282A));

        // Create and manage content panels
        serverPanel = new ServerPanel();
        chatPanel = new ChatPanel();
        mc.insets = new Insets(0,0,0,5);mc.gridx = 0; mc.weighty = 1; mc.weightx = 0; mc.fill = GridBagConstraints.BOTH;
        mainPanel.add(serverPanel,mc);
        mc.weighty = 1; mc.weightx = 1; mc.gridx = 1;
        mainPanel.add(chatPanel, mc);

        // Make a border, so pretty!
        wc.insets = new Insets(5,5,5,5);
        add(mainPanel, wc);

        // Remember where it was?
        setLocationRelativeTo(null);
        // Not allowed to resize, it's perfect as is!
        setMinimumSize(new Dimension(746,529));
        setResizable(false);
        setTitle("JIRC");
        setVisible(true);

        // It has to close somehow!
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}
