public class Main {

    public static void main(String[] args) {
        Environment e = new Environment(50,50, 0.01,50, 45);

        while((e.getTickCount() < 10000)) {
            e.tick();
        }
    }
}
