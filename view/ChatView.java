import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ChatView {

    private JPanel mPanel;
    private JTextField mMsgTxt;
    private JTextArea mChatArea;
    private JButton mSndBtn;
    private JLabel mCipherType;
    private JButton mECBSetBtn;
    private JButton mCBCSetBtn;
    public ChatView() {
        mPanel = new JPanel();
        mChatArea = new JTextArea(20,45);
        mMsgTxt = new JTextField("", 45);
        mSndBtn = new JButton("Send");
        mSndBtn.setPreferredSize(new Dimension(500,20));

        // Chat Area
        mChatArea.setEditable(false);
        mChatArea.append(new Date() + ": Chat APP");

        // Encryption Settings
        mCipherType = new JLabel("Selected Cipher-> ECB");
        mECBSetBtn = new JButton("Cipher: ECB");
        mCBCSetBtn = new JButton("Cipher: CBC");

        // Panel
        mPanel.setBackground(Color.GRAY);
        mPanel.add(mChatArea);
        mPanel.add(mMsgTxt);
        mPanel.add(mSndBtn);
        mPanel.add(mCipherType);
        mPanel.add(mECBSetBtn);
        mPanel.add(mCBCSetBtn);
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

    public JButton getSendButton(){
        return mSndBtn;
    }

    public JButton getECBSetBtn(){
        return mECBSetBtn;
    }

    public JButton getCBCSetBtn(){
        return mCBCSetBtn;
    }


}
