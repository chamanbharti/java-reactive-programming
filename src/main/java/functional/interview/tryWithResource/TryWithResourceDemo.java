package functional.interview.tryWithResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResourceDemo {
    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "E:\\chaman-bharti\\Company\\Cognizant\\Payslip\\password for pdf.txt";

        firstApproach(filePath);
        secondApproach(filePath);
        thirdApproach_1(filePath);
        thirdApproach_2(filePath);
        fourthApproach();
    }

    private static void firstApproach(String filePath) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }finally {
            if(scanner != null){
                scanner.close();
            }
        }
    }
    private static void secondApproach(String filePath) {
        try( Scanner scanner = new Scanner(new File(filePath))){
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    private static void thirdApproach_1(String filePath) {
        System.out.println("third approach");
        String writePath = "E:\\chaman-bharti\\Company\\Cognizant\\Payslip\\write.txt";
        try(Scanner scanner = new Scanner(new File(filePath));
            PrintWriter printWriter = new PrintWriter(new File(writePath))
        ) {
            while (scanner.hasNext()){
                printWriter.println(scanner.nextLine());
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    private static void thirdApproach_2(String filePath) throws FileNotFoundException {
        System.out.println("third approach");
        String writePath = "E:\\chaman-bharti\\Company\\Cognizant\\Payslip\\write.txt";
        Scanner scanner = new Scanner(new File(filePath));
        PrintWriter printWriter = new PrintWriter(new File(writePath));
        try(scanner;printWriter) {
            while (scanner.hasNext()){
                printWriter.println(scanner.nextLine());
            }
        }
    }
    private static void fourthApproach() {
            try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
                 AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

                af.doSomething();
                as.doSomething();
            }catch (Exception ex){
                ex.printStackTrace();
            }

    }
}
