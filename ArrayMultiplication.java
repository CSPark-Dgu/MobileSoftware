public class ArrayMultiplication {
    public static void main(String[] args) {
        int[] A = {3, 2, 5, 7, 8, 9, 10, 2, 7, 8};
        int[] B = {4, 3, 7, 3, 2, 6, 1, 0, 1, -2};
        int[] C = new int[A.length];

        //배열의 인덱스 수 만큼 쓰레드 생성
        Thread[] threads = new Thread[A.length];

        //생성한 각 쓰레드에 각각의 연산 task 부여
        for (int i = 0; i < A.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                C[index] = A[index] * B[index];
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();  //모든 스레드가 종료될 때 까지 기다린다.
            }
        } 
        catch (InterruptedException e) {  //예외처리
            e.printStackTrace();
        }
        finally{
            System.out.println("MultiThreading Process successfully done!");
        }

        for (int result : C) {
            System.out.print(result + " ");
        }
    }
}
