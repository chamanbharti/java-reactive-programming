package functional.concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//https://github.com/jptiancai/Java-7-Concurrency-Cookbook/blob/master/toc/1.Thread%20Management.md
public class Calculator implements Runnable{
    private int number;
    public Calculator(int number) {
        this.number=number;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
        }
    }

    public static void main(String[] args) {
        // Thread priority infomation
        System.out.printf("Minimum Priority: %s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n",Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        // Launch 10 threads to do the operation, 5 with the max
        // priority, 5 with the min
        threads=new Thread[10];
        status=new Thread.State[10];
        for (int i=0; i<10; i++){
            threads[i]=new Thread(new Calculator(i));
            if ((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread "+i);
        }


        // Wait for the finalization of the threads. Meanwhile,
        // write the status of those threads in a file
        try (FileWriter file = new FileWriter("E:\\chaman-bharti\\java-works\\log.txt");PrintWriter pw = new PrintWriter(file);){

            for (int i=0; i<10; i++){
                pw.println("Main : Status of Thread "+i+" : "+threads[i].getState());
                status[i]=threads[i].getState();
            }

            for (int i=0; i<10; i++){
                threads[i].start();
            }

            boolean finish=false;
            while (!finish) {
                for (int i=0; i<10; i++){
                    if (threads[i].getState()!=status[i]) {
                        writeThreadInfo(pw, threads[i],status[i]);
                        status[i]=threads[i].getState();
                    }
                }

                finish=true;
                for (int i=0; i<10; i++){
                    finish=finish &&(threads[i].getState()== Thread.State.TERMINATED);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
