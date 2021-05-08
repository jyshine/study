package generic;

public class BoxExam {

    public static void main(String[] args) {
//        Box box = new Box();
//        box.setObject(new Object());
//        Object obj = box.getObject();
//
//        box.setObject("Hello");
//        String str = (String) box.getObject();
//        System.out.println(str);
//
//        box.setObject(1);
//        int valueInt = (int) box.getObject();
//        System.out.println(valueInt);


        Box<Object> box = new Box<>();
        box.setObject(new Object());
        box.getObject();

        Box<String> box2 = new Box<>();
        box2.setObject("Test");
        System.out.println(box2.getObject());

        Box<Integer> box3 = new Box<>();
        box3.setObject(5);
        System.out.println(box3.getObject());


    }
}
