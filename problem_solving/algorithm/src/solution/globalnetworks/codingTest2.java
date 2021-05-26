package solution.globalnetworks;

public class codingTest2 {
    public static void main(String[] args) {


        int n1, n2, n3;
        int sum = Integer.parseInt("2");
        n1 = 1;
        n2 = 1;

        for(int i =3; i<=20; i++){
            n3 = n1 + n2;
            sum += n3;
            n1 = n2;
            n2 = n3;

        }
        System.out.println(sum);
    }
}
