public class First{
    static int j=0; //클래스 변수
    boolean test = false;
    public static void hello(){
        int i=3;    //로컬 변수
        System.out.println(i+" "+j);
        j++;
    }

    public static void main(String[] args){
        System.out.println("웅소리 멈춰!");
        hello();
        hello();
        hello();
    }
}