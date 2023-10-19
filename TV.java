public class TV {
    private boolean isOn;
    private int channel;
    private int volume;

    public TV() {
        isOn = false;
        channel = 1;
        volume = 10;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("TV를 켭니다.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV를 끕니다.");
    }

    public void increaseChannel() {
        if (isOn) {
            channel++;
            System.out.println("채널을 하나 올립니다. 현재 채널: " + channel);
        } else {
            System.out.println("TV가 꺼져 있습니다. 먼저 TV를 켜야 합니다.");
        }
    }

    public void decreaseChannel() {
        if (isOn) {
            channel--;
            System.out.println("채널을 하나 내립니다. 현재 채널: " + channel);
        } else {
            System.out.println("TV가 꺼져 있습니다. 먼저 TV를 켜야 합니다.");
        }
    }

    public void increaseVolume() {
        if (isOn) {
            volume++;
            System.out.println("볼륨을 높입니다. 현재 볼륨: " + volume);
        } else {
            System.out.println("TV가 꺼져 있습니다. 먼저 TV를 켜야 합니다.");
        }
    }

    public void decreaseVolume() {
        if (isOn) {
            volume--;
            System.out.println("볼륨을 낮춥니다. 현재 볼륨: " + volume);
        } else {
            System.out.println("TV가 꺼져 있습니다. 먼저 TV를 켜야 합니다.");
        }
    }
}
