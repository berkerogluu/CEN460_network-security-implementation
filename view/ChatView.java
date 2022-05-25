import javax.swing.*;
import java.awt.*;

public class ChatView {

    private JPanel mPanel;
    private JTextField mMsgTxt;
    private JTextArea mChatArea;
    public ChatView(){
        mPanel = new JPanel();
        mChatArea = new JTextArea(20,45);
        mMsgTxt = new JTextField("", 45);

        // mChatArea
        mChatArea.setEditable(false);


        //


        // Panel
        mPanel.setBackground(Color.GRAY);
        mPanel.add(mChatArea);
        mPanel.add(mMsgTxt);

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
