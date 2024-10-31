import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AWTExample extends Frame {
    AWTExample() {
        Button b = new Button("click this!");
        b.setBounds(30,100,80,30);
        add(b);
        setSize(300,300);
        setTitle("test title");
        setLayout(null);
        setVisible(true);
    }
}
