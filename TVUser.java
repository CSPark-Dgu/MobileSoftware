public class TVUser {
    public static void main(String[] args) {
        TV myTV = new TV();

        myTV.turnOn();
        myTV.increaseChannel();
        myTV.increaseVolume();
        myTV.increaseChannel();
        myTV.decreaseChannel();
        myTV.decreaseVolume();
        myTV.turnOff();
    }
}
