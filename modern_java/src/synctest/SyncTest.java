class Table {
    void printTable(int n){
        synchronized(this){//synchronized block
            System.out.println(this);
            for(int i=1;i<=5;i++){
                System.out.println(n*i);
                try{
                    Thread.sleep(       400);
                }catch(Exception e){System.out.println(e);}
            }
        }
    }//end of the method
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}

class MyThread3 extends Thread{
    Table t;
    MyThread3(Table t){
        this.t=t;
    }

}

public class SyncTest {
    public static void main(String args[]){
        Table obj = new Table();//only one object
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);
        MyThread3 t3=new MyThread3(obj);
        t1.start();
        t2.start();

        t3.start();

    }
}
