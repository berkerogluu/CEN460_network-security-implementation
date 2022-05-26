public class Client {
    public static void main (String[] args){
        Core core = new Core();
        Controller controller = new Controller(core);
        controller.init();
    }
}
