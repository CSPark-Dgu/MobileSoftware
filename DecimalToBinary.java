public class DecimalToBinary {
    public static void main(String[] args) {
        int decimalNumber = 123;
        int binaryNumber = 0;
        int base = 1;

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binaryNumber = binaryNumber + remainder * base;
            decimalNumber = decimalNumber / 2;
            base = base * 10;
        }

        System.out.println("123의 이진수 표현: " + binaryNumber);
    }
}