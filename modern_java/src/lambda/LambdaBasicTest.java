package lambda;

public class LambdaBasicTest {
    static Runnable r1 = () -> System.out.println("Hello World ");

    static Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Hello world 2");
        }
    };

    public static void process(Runnable r){
        r.run();
    }


    public static void main(String[] args) {


        process(r1);
        process(r2);
        process(()-> System.out.println("Hello world 3"));


    }

}
