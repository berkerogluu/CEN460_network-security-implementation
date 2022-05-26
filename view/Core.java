import java.awt.*;

public class Core {

    public FrameView mFrameView;
    public ChatView mChatView;

    public Core() {

        // Initialization
        mFrameView = new FrameView();
        mChatView = new ChatView();

        // Setting up
        mFrameView.add(mChatView.getPanel(), BorderLayout.CENTER);
        mFrameView.setVisible(true);

    }

}
