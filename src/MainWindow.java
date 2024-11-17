import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;

public class MainWindow extends JFrame {
    ServerPanel serverPanel;
    ChatPanel chatPanel;
    Socket server;
    PrintWriter sender;
    BufferedReader receiver;
    boolean quit;

    public MainWindow() {
        quit = false;

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
        mc.weighty = 1; mc.weightx = 1; mc.gridx = 1; mc.insets = new Insets(0,0,0,0);
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
                quit = true;
                discconnectServer();
                dispose();
                System.exit(0);
            }
        });

        mainLoop();
    }

    public void dispose() {
        super.dispose();
        try {
            receiver.close();
            server.close();
            sender.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mainLoop() {
        connectToServer();
        while (!quit) {
            try {
                // chatPanel.updateChat(receiver.readLine());
                handleChat(receiver.readLine());

            } catch (IOException e) {
                System.out.println("Connection Lost");
            }
        }
    }

    public void connectToServer() {
        String hostname = "irc.libera.chat";
        try {
            server = new Socket(hostname, 6667);
            sender =
                    new PrintWriter(server.getOutputStream(),true);
            receiver =
                    new BufferedReader(
                            new InputStreamReader(server.getInputStream()));
            sender.println("NICK penTest");
            sender.println("USER pen * * :penpng");
            sender.println("JOIN #test");
        } catch (IOException e) {
            System.out.println("Connection Lost");
        }
        chatPanel.setSender(sender);
    }

    public void discconnectServer() {
        sender.println("PART #test :Closed Client");
        sender.println("QUIT :Closed client");
    }

    public void handleChat(String fullMessage) {
        String[] messageSplit = fullMessage.split(" :");
        String command, message;
        if (messageSplit.length > 1) {
            command = messageSplit[0];
            message = messageSplit[1];
        } else {
            messageSplit = fullMessage.split(":(.*?) ");
            command = messageSplit[0];
            message = messageSplit[1];
        }
        if (command.matches("[0-9]{3} pentest")) {
            switch (Integer.parseInt(command.split("[0-9]{3}")[0])) {
                case 372: chatPanel.updateChat(message);
                            break;
                case 375: chatPanel.updateChat(message);
                            break;
                case 376: chatPanel.updateChat(message);
                            break;
                default: break;

            }
        }
        if (command.contains("PRIVMSG")) {
            chatPanel.updateChat(command.split("!")[0].substring(1)+": "+message);
            return;
        }
        if (command.contains("MODE")) return;
        if (message.contains("JOIN")) return;
        if (command.contains("PING"))  { sender.println("PONG "+command.split(" ")[0].substring(1)); return; }
        chatPanel.updateChat(message);
    }
}
