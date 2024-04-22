package ui.utills;

import java.util.Scanner;

public interface ScanUtil {
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    static String strScanner(String hint) {
        System.out.print(hint);
        return scannerStr.nextLine();
    }

    static Integer intScanner(String hint) {
        System.out.print(hint);
        return scannerInt.nextInt();
    }
}
