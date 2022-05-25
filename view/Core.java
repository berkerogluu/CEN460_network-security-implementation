import java.awt.*;

public class Core {

    private FrameView mFrameView;
    private ChatView mChatView;


    public Core() {

        // Initialization
        mFrameView = new FrameView();
        mChatView = new ChatView();

        // Setting up ChatView

        // Setting up FrameView
        mFrameView.add(mChatView.getPanel(), BorderLayout.CENTER);
        mFrameView.setVisible(true);

    }

}
