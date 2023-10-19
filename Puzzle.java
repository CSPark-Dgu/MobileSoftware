public class Puzzle {
    public static void main(String[] args) {
        for (int T = 0; T <= 9; T++) {
            for (int O = 0; O <= 9; O++) {
                for (int G = 0; G <= 9; G++) {
                    for (int D = 0; D <= 9; D++) {
                        if (isCorrect(T, O, G, D)==true) {
                            System.out.println("T = " + T + ", O = " + O + ", G = " + G + ", D = " + D);
                        }
                    }
                }
            }
        }
    }

    static boolean isCorrect(int T, int O, int G, int D) {
        int too = T * 100 + O * 10 + O;
        int good = G * 1000 + O * 100 + O * 10 + D;

        return (too * 4 == good);
    }
}
