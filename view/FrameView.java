import javax.swing.*;
import java.awt.*;

public class FrameView extends JFrame {

    public FrameView(){
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
