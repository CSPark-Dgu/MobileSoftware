class Box<T extends Number>{
    T[] values;
    public Box(T[] value){
        this.values=value;
    }

    public int add(){
        int sum;
        for(T value : values){
            sum += values.intValue();
        }

        return sum;
    }

}

public class Test {

}
