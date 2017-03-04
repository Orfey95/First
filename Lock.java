package com.company;

public class Lock {
    String INIT = "00110";
    String WAIT = "11000";
    String IDLE = "10101";
    String LOGIN_REQ = "11011";
    String PASS_REQ = "01110";
    String UNLOCK = "00111";
    String LOGOUT = "11111";
    private String y = Variables.startState;

    public void setY(String y) {
        this.y = y;
    }


    String  LockAlgorithm(String x){
        if (y.compareTo("00001") == 0 && x.compareTo("000001") == 0) y = "00010";
        if (y.compareTo("00010") == 0 && x.compareTo("000010") == 0) y = "00011";
        if (y.compareTo("00011") == 0 && x.compareTo("000011") == 0) y = "00100";
        if (y.compareTo("00100") == 0 && x.compareTo("000100") == 0) y = "00101";
        if (y.compareTo("00100") == 0 && x.compareTo("000101") == 0) y = "00110";
        if (y.compareTo("00101") == 0 && x.compareTo("000110") == 0) y = "00011";
        if (y.compareTo("00101") == 0 && x.compareTo("000111") == 0) y = "00010";
        if (y.compareTo("00100") == 0 && x.compareTo("001000") == 0) y = "00001";
        if (y.compareTo("00011") == 0 && x.compareTo("001001") == 0) y = "00010";
        if (y.compareTo("00010") == 0 && x.compareTo("001011") == 0) y = "00001";
        if (y.compareTo("00101") == 0 && x.compareTo("101111") == 0) y = "01000";
//        if (y.compareTo("00001") == 0 && x.compareTo("000001") == 0) y = "00010";
//        if (y.compareTo("00001") == 0 && x.compareTo("000010") == 0) y = "00011";
//        if (y.compareTo("00011") == 0 && x.compareTo("000011") == 0) y = "00001";
//        if (y.compareTo("00011") == 0 && x.compareTo("000100") == 0) y = "00101";
//        if (y.compareTo("00011") == 0 && x.compareTo("000101") == 0) y = "00100";
//        if (y.compareTo("00010") == 0 && x.compareTo("000110") == 0) y = "00101";
//        if (y.compareTo("00101") == 0 && x.compareTo("000111") == 0) y = "00111";
//        if (y.compareTo("00101") == 0 && x.compareTo("001000") == 0) y = "01000";
//        if (y.compareTo("01000") == 0 && x.compareTo("001001") == 0) y = "00100";
//        if (y.compareTo("00100") == 0 && x.compareTo("001010") == 0) y = "00110";
//        if (y.compareTo("01000") == 0 && x.compareTo("001011") == 0) y = "01001";
//        if (y.compareTo("01000") == 0 && x.compareTo("001100") == 0) y = "01010";
//        if (y.compareTo("00001") == 0 && x.compareTo("000001") == 0) {y = "00010"; return y;}
//        if (y.compareTo("00001") == 0 && x.compareTo("000010") == 0) {y = "00011"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000011") == 0) {y = "00001"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000100") == 0) {y = "00101"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000101") == 0) {y = "00100"; return y;}
//        if (y.compareTo("00010") == 0 && x.compareTo("000110") == 0) {y = "00101"; return y;}
//        if (y.compareTo("00100") == 0 && x.compareTo("010110") == 0) {y = "00001"; return y;}
//        if (y.compareTo("00101") == 0 && x.compareTo("000111") == 0) {y = "00111"; return y;}
//        if (y.compareTo("00101") == 0 && x.compareTo("001000") == 0) {y = "01000"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("001001") == 0) {y = "00100"; return y;}
//        if (y.compareTo("00100") == 0 && x.compareTo("001010") == 0) {y = "00110"; return y;}
//       if (y.compareTo("01000") == 0 && x.compareTo("001011") == 0)  {y = "00011"; return y;}
//       if (y.compareTo("01000") == 0 && x.compareTo("001100") == 0)  {y = "01001"; return y;}
//       if (y.compareTo("01001") == 0 && x.compareTo("101101") == 0)  {y = "00011"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("111101") == 0) {y = "01010"; return y;}
        //if(Main.fileOrNot.compareTo("N") == 0 || Main.fileOrNot.compareTo("n") == 0) {
            // Jumps
//            if (y.compareTo(INIT) == 0 && x.compareTo("000001") == 0) y = WAIT; // INIT -> WAIT
//            if (y.compareTo(WAIT) == 0 && x.compareTo("100010") == 0) y = IDLE; // WAIT -> IDLE
//            if (y.compareTo(WAIT) == 0 && x.compareTo("100011") == 0) y = LOGIN_REQ; // WAIT -> LOGIN_REQ
//            if (y.compareTo(LOGIN_REQ) == 0 && x.compareTo("000100") == 0) y = PASS_REQ; // LOGIN_REQ -> PASS_REQ
//            if (y.compareTo(PASS_REQ) == 0 && x.compareTo("000101") == 0) y = WAIT; // PASS_REQ -> WAIT
//            if (y.compareTo(PASS_REQ) == 0 && x.compareTo("000110") == 0) y = UNLOCK; // PASS_REQ -> UNLOCK
//            if (y.compareTo(UNLOCK) == 0 && x.compareTo("000111") == 0) y = LOGOUT; // UNLOCK -> LOGOUT
//            if (y.compareTo(LOGOUT) == 0 && x.compareTo("001000") == 0) y = WAIT; // LOGOUT -> WAIT
//            if (y.compareTo(IDLE) == 0 && x.compareTo("001001") == 0) y = WAIT; // IDLE -> WAIT
//            if (y.compareTo(LOGIN_REQ) == 0 && x.compareTo("001010") == 0) y = WAIT; // LOGIN_REQ -> WAIT
//            if (y.compareTo(PASS_REQ) == 0 && x.compareTo("001011") == 0) y = LOGIN_REQ; // PASS_REQ -> LOGIN_REQ
//            // Backdoors
//            if (y.compareTo(LOGIN_REQ) == 0 && x.compareTo("001100") == 0) y = "01010"; // LOGIN_REQ -> BD1
//            if (y.compareTo("01010") == 0 && x.compareTo("001101") == 0) y = LOGOUT; // BD1 -> LOGOUT
//            if (y.compareTo(WAIT) == 0 && x.compareTo("001110") == 0) y = "10100"; // WAIT -> DEADSTATE
//            if (y.compareTo(PASS_REQ) == 0 && x.compareTo("000001") == 0) y = INIT; // PASS_REQ -> INIT
//            00001->00010:000001
//            00010->00011:000010
//            00011->00100:000011
//            00100->00101:000100
//            00100->00110:000101
//            00101->00011:000110
//            00101->00010:000111
//            00100->00001:001000
//            00011->00010:001001
//            00010->00001:001011
//            00101->01000:100000
//        if (y.compareTo("00001") == 0 && x.compareTo("000001") == 0) y = "00010";
//        if (y.compareTo("00010") == 0 && x.compareTo("000010") == 0) y = "00011";
//        if (y.compareTo("00011") == 0 && x.compareTo("000011") == 0) y = "00100";
//        if (y.compareTo("00100") == 0 && x.compareTo("000100") == 0) y = "00101";
//        if (y.compareTo("00100") == 0 && x.compareTo("000101") == 0) y = "00110";
//        if (y.compareTo("00101") == 0 && x.compareTo("000110") == 0) y = "00011";
//        if (y.compareTo("00101") == 0 && x.compareTo("000111") == 0) y = "00010";
//        if (y.compareTo("00100") == 0 && x.compareTo("001000") == 0) y = "00001";
//        if (y.compareTo("00011") == 0 && x.compareTo("001001") == 0) y = "00010";
//        if (y.compareTo("00010") == 0 && x.compareTo("001011") == 0) y = "00001";
//        if (y.compareTo("00101") == 0 && x.compareTo("101111") == 0) y = "01000";
//        if (y.compareTo("00001") == 0 && x.compareTo("000001") == 0){ y = "00010"; return y;}
//        if (y.compareTo("00001") == 0 && x.compareTo("000010") == 0) {y = "00011"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000011") == 0) {y = "00001"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000100") == 0) {y = "00101"; return y;}
//        if (y.compareTo("00011") == 0 && x.compareTo("000101") == 0) {y = "00100"; return y;}
//        if (y.compareTo("00010") == 0 && x.compareTo("000110") == 0) {y = "00101"; return y;}
//        if (y.compareTo("00101") == 0 && x.compareTo("000111") == 0) {y = "00111"; return y;}
//        if (y.compareTo("00101") == 0 && x.compareTo("001000") == 0) {y = "01000"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("001001") == 0) {y = "00100"; return y;}
//        if (y.compareTo("00100") == 0 && x.compareTo("001010") == 0) {y = "00110"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("001011") == 0) {y = "00011"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("001100") == 0) {y = "01001"; return y;}
//        if (y.compareTo("01000") == 0 && x.compareTo("001101") == 0) {y = "01010"; return y;}
//        }
//        // Work with file
//        if(Main.fileOrNot.compareTo("Y") == 0 || Main.fileOrNot.compareTo("y") == 0) {
//            for(int i = 0; i < LockFromFile.countState; i++){
//                if (y.compareTo(LockFromFile.masInY[i]) == 0 && x.compareTo(LockFromFile.masXIn[i]) == 0) {
//                    y = LockFromFile.masOutY[i];
//                    return y;
//                }
//            }
//        }
        return y;
    }
}