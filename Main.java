package com.company;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
   // static String fileOrNot;
    public static void main(String[] args) throws IOException {
        //String strFile = "";

//        LockFromFile lockFromFile = new LockFromFile();
//        System.out.println("Are you want to read from file? Input Y or N");
//        Scanner scanner = new Scanner(System.in);
//        fileOrNot = scanner.nextLine();
//
//        if (fileOrNot.compareTo("Y") == 0 || fileOrNot.compareTo("y") == 0) {
//
//            lockFromFile.ReadFile();
//            Variables.startState = lockFromFile.masInY[0];
//            Variables.endState = lockFromFile.masOutY[lockFromFile.countState-1];
//        }
//        if (fileOrNot.compareTo("Y") != 0 && fileOrNot.compareTo("y") != 0 && fileOrNot.compareTo("N") != 0 && fileOrNot.compareTo("n") != 0) {
//            System.out.println("Incorrect input! Input Y or N");
//            System.exit(0);
//        }
        Counter brForce = new Counter();
        brForce.InputState();
        brForce.InputForbiddenCombinations(brForce.forbiddenCombinations);
        brForce.InputForbiddenCombinations(brForce.deadlockList);
        brForce.InputCountCombinations();
        long startTime = System.currentTimeMillis();
       // LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
//            String log;
//            log = brForce.getTempState() + "->";

           System.out.print(i+1 + " " + brForce.getTempState() + "->");
            brForce.BruteForce();
//            log += brForce.getTempState() + ":" + brForce.getTempX() + "\n";
//            set.add(log);
           System.out.println(brForce.getTempState() + ":" + brForce.tempX);
            if (brForce.getTempState().compareTo(Variables.endState) == 0) {
                System.out.println("Lock is unlock! Congratulations!");
                System.out.println(Counter.countPodborov);
               // String[] tempStr = set.toArray(new String[set.size()]);
//                for(int k = 0; k < set.size(); k++) {
//                    if(tempStr[k].indexOf(":111111") == -1)
//                    strFile += tempStr[k];
//                }
               // SaveInFile(strFile);
                break;
            }
        }
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Time: " + timeSpent + " millisecond");

    }

//    static void SaveInFile(String strFile) {
//        String fileName = "src\\com\\company\\LockOUT.txt";
//        File file = new File(fileName);
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
//            try {
//                out.print(strFile);
//            } finally {
//                out.close();
//            }
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
