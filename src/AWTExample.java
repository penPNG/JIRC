import java.awt.*;
import java.awt.event.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AWTExample extends Frame {
    TextField tf;
    AWTExample() {
        tf = new TextField();
        Label l = new Label();
        l.setBounds(50,100,250,20);
        tf.setBounds(50,50,150,20);
        Button b = new Button("click this!");
        b.setBounds(50,150,60,30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String host = tf.getText();
                    String ip = java.net.InetAddress.getByName(host).getHostAddress();
                    l.setText("IP of "+host+" is "+ip);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        add(b);add(tf);add(l);
        setSize(300,300);
        setTitle("test title");
        setLayout(null);
        setVisible(true);
    }
}
