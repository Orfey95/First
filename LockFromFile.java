package com.company;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LockFromFile {

    String inY = "";
    String outY = "";
    String xIn = "";
    static int countState = 0;

    ArrayList<String> lines = new ArrayList<>();

    static String[] masInY = new String[100];
    static String[] masOutY = new String[100];
    static String[] masXIn = new String[100];

    public void ReadFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src\\com\\company\\LockIN.txt"));
        String line;
        InputMas();
        while((line = reader.readLine()) != null){
            if(CheckStr(line)) {
                lines.add(line);
                ConvertToLock(line);
                countState++;
            }
            else{
                int tempCount = countState + 1;
                System.out.println("Incorrect input in " + tempCount + " line");
                System.exit(0);
            }
        }
        reader.close();
    }

    boolean CheckStr(String xIn){
        Pattern p = Pattern.compile("^[0-1]{5}\\->[0-1]{5}\\:[0-1]{6}$");
        Matcher m = p.matcher(xIn);
        return m.matches();
    }

    void ConvertToLock(String inputStr){
        String[] tempMasStr = inputStr.split("->|:");
        inY = tempMasStr[0];
        outY = tempMasStr[1];
        xIn = tempMasStr[2];
        for(int i = 0; i < 100; i++){
            if(masInY[i].compareTo(" ") == 0)
                masInY[i] = inY;
            if(masOutY[i].compareTo(" ") == 0)
                masOutY[i] = outY;
            if(masXIn[i].compareTo(" ") == 0) {
                masXIn[i] = xIn;
                break;
            }
        }
    }

    void InputMas(){
        for(int i=0; i < 100; i++) {
            masInY[i] = " ";
            masOutY[i] = " ";
            masXIn[i] = " ";
        }
    }
}