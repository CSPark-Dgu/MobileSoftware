abstract class Color{
    int myColor;

    public Color(){
        myColor=0;
    }

    public Color(int color){
        myColor=color;
    }

    abstract void setColor(int color);
    abstract String getColor();
}

class RainbowColor extends Color{
    static String[] colors = {"red","orange","yellow","green","blue","indigo","purple"};

    public RainbowColor(){
        super(0);
    }

    public RainbowColor(int color){
        super(0);
        setColor(color);
    }

    void setColor(int color){
        if(color<0){
            myColor = 0;
        }
        else if(color>6){
            myColor = 6;
        }
        else{
            myColor=color;
        }
    }

    String getColor(){
        
        return colors[myColor];
    }

    String nextColor(){
        if(myColor==6) {
            return "no color";
        }
        else {
            return colors[myColor+1];
        }
    }
}

class CarColor extends Color{
    public CarColor(){
        super(0);
    }

    public CarColor(int color){
        super(0);
        setColor(color);
    }

    void setColor(int color){
        if(color<0) myColor=0;
        else if(color>1) myColor=1;
        else myColor=color;
    }

    String getColor(){
        if(myColor==0) return "black";
        else return "white";
    }

    String otherColor(){
        if(myColor==1) return "black";
        else return "white";
    }
}

public class SecondProblem {
    public static void main(String[] args){
        Color[] colors = new Color[8];
        colors[0] = new RainbowColor();
        colors[1] = new RainbowColor(2);
        colors[2] = new RainbowColor(4);
        colors[3] = new RainbowColor();
        colors[4] = new CarColor();
        colors[5] = new CarColor(1);
        colors[6] = new CarColor(-2);
        colors[7] = new CarColor();

        for(Color c : colors){
            System.out.println("my color is" + c.getColor());
        }

        RainbowColor c1 = new RainbowColor(-1);
        CarColor c2 = new CarColor(3);
        System.out.println("the next color of c1 is "+ c1.nextColor());
        System.out.println("the other color of c2 is "+c2.otherColor());
    }
}
