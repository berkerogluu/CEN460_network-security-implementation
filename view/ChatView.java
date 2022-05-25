import javax.swing.*;
import java.awt.*;

public class ChatView {

    private JPanel mPanel;
    private JTextField mMsgTxt;
    private JTextArea mChatArea;
    public ChatView(){
        mPanel = new JPanel();
        mMsgTxt = new JTextField();
        mChatArea = new JTextArea();
    }

    public JPanel getPanel(){
        return mPanel;
    }

    public JTextField getMsgTxtField(){
        return mMsgTxt;
    }

    public JTextArea getChatTextArea(){
        return mChatArea;
    }
}
