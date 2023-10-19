public class PowCalculate {
    public static void main(String[] args) {
        int base = 3;
        int exponent = 5;
        int result = pow(base, exponent);
        System.out.println("pow("+base+","+exponent+")="+result);
    }

    public static int pow(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        
        else if (exponent == 1) {
            return base;
        }

        else {
            return base * pow(base,exponent-1);
        }
    }
}
