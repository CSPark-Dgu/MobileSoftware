public class FirstProblem {
    static int T,O,G,D;

    public static void main(String[] args){
        for(T=0;T<=9;T++){
            for(O=0;O<=9;O++){
                for(G=0;G<=9;G++){
                    for(D=0;D<=9;D++){
                        if(isCheck(T,O,G,D))
                            System.out.println("T = " + T + ", O = " + O + ", G = " + G + ", D = " + D);
                    }
                }
            }
        }
    }

    static boolean isCheck(int T, int O, int G, int D){
        int too = T*100+O*11;
        int good = G*1000+O*110+D;

        return (4*too==good);
    }
}
