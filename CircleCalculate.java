public class CircleCalculate{
    public static void main(String[] args){
        double rad = 5.0;
        double circumference = 2*rad*Math.PI;
        double area = Math.PI * Math.pow(rad,2);

        System.out.println("Circumference :"+circumference);
        System.out.println("Area : "+area);
    }
}