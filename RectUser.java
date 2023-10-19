public class RectUser {
    public static void main(String[] args) {
        Rect myRect = new Rect(5.0, 3.0);

        System.out.println("사각형의 너비: " + myRect.getWidth());
        System.out.println("사각형의 높이: " + myRect.getHeight());

        System.out.println("사각형의 넓이: " + myRect.getArea());
        System.out.println("사각형의 둘레: " + myRect.getCircum());

        myRect.setWidth(7.0);
        myRect.setHeight(4.0);

        System.out.println("변경된 사각형의 넓이: " + myRect.getArea());
        System.out.println("변경된 사각형의 둘레: " + myRect.getCircum());
    }
}
