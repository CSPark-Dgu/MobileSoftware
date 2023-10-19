class Box<T extends Number> {
    private T[] values;

    public Box(T[] values) {
        this.values = values;
    }

    public int int_sum() {
        int sum = 0;
        for (T value : values) {
            sum += value.intValue();
        }
        return sum;
    }

    public int int_average() {
        int sum = int_sum();
        return sum / values.length;
    }

    public double double_sum(){
        double sum = 0.0;
        for(T value : values){
            sum += value.doubleValue();
        }
        return sum;
    }

    public double double_average(){
        double sum = double_sum();
        return sum / values.length;
    }
}

public class GenericSumAverage {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Double[] doubleArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0};

        Box<Integer> intBox = new Box<>(intArray);
        Box<Double> doubleBox = new Box<>(doubleArray);

        int intSum = intBox.int_sum();
        int intAverage = intBox.int_average();
        System.out.println("Integer Array - Sum: " + intSum + ", Average: " + intAverage);

        double doubleSum = doubleBox.double_sum();
        double doubleAverage = doubleBox.double_average();
        System.out.println("Double Array - Sum: " + doubleSum + ", Average: " + doubleAverage);
    }
}
