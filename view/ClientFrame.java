import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ClientFrame extends JFrame {

    public ClientFrame(){
        this.setTitle("Chat App - AES with CBC and ECB");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(500,400));
        this.setLocationRelativeTo(null);
    }

    public JFrame getFrame(){
        return this;
    }
}
