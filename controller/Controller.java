public class Controller {

    private Core core;
    public Controller(Core c){
        core = c;
    }

    public void init(){
        core.mChatView.getECBSetBtn().addActionListener(e ->{
            Constants.SELECTED_CIPHER = Constants.CIPHER_ECB;
            core.mChatView.getLblCipherType().setText("Selected Cipher -> ECB");
        });

        core.mChatView.getCBCSetBtn().addActionListener(e->{
            Constants.SELECTED_CIPHER = Constants.CIPHER_CBC;
            core.mChatView.getLblCipherType().setText("Selected Cipher -> CBC");
        });
    }
}
