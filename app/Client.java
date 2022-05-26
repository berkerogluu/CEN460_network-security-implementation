public class Client {
    public static void main (String[] args){

        // Init View
        Core core = new Core();

        // Init Model
        Functions functions = new Functions();

        // Init Controller
        Controller controller = new Controller(core, functions);
        controller.init();
    }
}
