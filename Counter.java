package com.company;
import java.util.ArrayList;
import java.util.Randosm;1

public class Counter {
     String tempX = "000000";
    private int nState = 10;
    private int nCombinations = 64;
    String[][] forbiddenCombinations = new String[nState][nCombinations];
    private String[] state = new String[nState];
    private String tempState = Variables.startState;
    private int flagState;
    private String tempY;
    public String getTempState() {
        return tempState;
    }

    public void setTempState(String tempState) {
        this.tempState = tempState;
    }

    void InputState() {
//        if(Main.fileOrNot.compareTo("N") == 0 || Main.fileOrNot.compareTo("n") == 0) {
//            flagState = 7;
//            state[0] = "00001";
//            state[1] = "00010";
//            state[2] = "00011";
//            state[3] = "00100";
//            state[4] = "00101";
//            state[5] = "00110";
//            state[6] = "01000";
//            state[7] = " ";
//            state[8] = " ";
//            state[9] = " ";
//        }
//        if(Main.fileOrNot.compareTo("Y") == 0 || Main.fileOrNot.compareTo("y") == 0) {
            flagState = 1;
            state[0] = Variables.startState;
            for(int i=1; i < nState; i++)
                state[i] = " ";
//        }
    }

    void InputForbiddenCombinations(String[][]mass){
        for(int i=0; i < nState; i++)
            for(int j = 0; j < nCombinations; j++)
                mass[i][j] = " ";
    }

    Lock lock = new Lock();
    ArrayList<String> listY = new ArrayList<>();
    static int countPodborov = 0;
    void BruteForce() {
        for (int i = 0; i < nCombinations; i++) {
            countPodborov++;
            int tempI = i + nCombinations;
            tempX = (Integer.toBinaryString(tempI));
            tempX = tempX.substring(1);
            tempY = lock.LockAlgorithm(tempX);
            if (CheckY()) {
                listY.add(tempState);
                CheckState();
                break;
            }
            else {
                for(int j = 1; j < (nCombinations-1) - i; j++) {
                    if (BanCheck(j)) {
                        i += j;
                    }
                    else
                        break;
                }
                if (i == nCombinations - 1) {
                    int count = 0;
                    for(int k=0; k < nCombinations; k++) {
                        if (forbiddenCombinations[NumberState(getTempState())][k].compareTo(" ") != 0)
                            count++;
                    }
                    if(forbiddenCombinations[NumberState(getTempState())][0].compareTo(" ") == 0 || (forbiddenCombinations[NumberState(tempState)][0].compareTo(deadlockList[NumberState(tempState)][0]) == 0) && count == 1) {
                       //System.out.println("+");
                        DeadlockState();
                        break;
                    }
                   RandForce();
                    //System.out.println("+");
                   //FullForce();
                    tempX = whiteList[NumberState(getTempState())];
                    tempY = lock.LockAlgorithm(tempX);
                    setTempState(tempY);
                    listY.add(tempState);
                   // CheckY();
                    break;
                }
            }


        }

    }

    boolean CheckState() {
        for(int i = 0; i < nState; i++) {
            if (getTempState().compareTo(state[i]) == 0)
                return true;
        }
        state[flagState] = getTempState();
        flagState ++;
        return false;
    }

    boolean CheckY() {
        if (tempY.compareTo(getTempState()) != 0) {
            //if (tempX.compareTo("111111") != 0)
            AddForbiddenCombinations();
             setTempState(tempY) ;
            return true;
        }
        else
            return  false;
    }

    int NumberState(String y){
        for (int i = 0; i < nState; i++){
            if(y.compareTo(state[i]) == 0)
                return i;
        }
        return 1000;
    }

    boolean BanCheck(int num) {
        String strBan = tempX;
        int intTempX;
        intTempX = (Integer.parseInt(strBan, 2));
        intTempX = intTempX + nCombinations + num;
        strBan = (Integer.toBinaryString(intTempX));
        strBan = strBan.substring(1);
        for (int i=0; i< nCombinations; i++) {
            if (forbiddenCombinations[NumberState(getTempState())][i].compareTo(strBan) == 0 ) {
                //System.out.println(strBan);
                return true;
            }
        }
        return false;
    }

    boolean AddForbiddenCombinations(){
        for(int i=0; i < nCombinations; i++) {
            if (forbiddenCombinations[NumberState(getTempState())][i].compareTo(tempX) == 0)
                return  false;
        }
        for(int i=0; i < nCombinations; i++) {
            if (forbiddenCombinations[NumberState(getTempState())][i].compareTo(" ") == 0) {
                forbiddenCombinations[NumberState(getTempState())][i] = tempX;
                //System.out.println(forbiddenCombinations[NumberState(tempState)][i]);
                return true;
            }
        }
        return false;
    }

    String[] whiteList = new String[nState];

    void RandForce(){
        Random rand =  new Random();
        int count = 0;
        for(int i=0; i < nCombinations; i++) {
            if (forbiddenCombinations[NumberState(getTempState())][i].compareTo(" ") != 0)
                count++;
        }
        int randCombination = rand.nextInt(count);
        //System.out.println(randCombination);
        randCombination = CheckDeadlock(randCombination,count,rand);
        String whiteCombination = forbiddenCombinations[NumberState(getTempState())][randCombination];
            whiteList[NumberState(getTempState())] = whiteCombination;
    }
    int[] countCombinations = new int[nCombinations];
    void InputCountCombinations(){
        for (int i=0; i<nCombinations;i++)
            countCombinations[i] = -1;
    }
    void FullForce(){
       // System.out.println("+");
        int count = 0;
        for(int i=0; i < nCombinations; i++) {
            if (forbiddenCombinations[NumberState(getTempState())][i].compareTo(" ") != 0)
                count++;
        }
        countCombinations[NumberState(getTempState())] ++;
        countCombinations[NumberState(getTempState())] %= count;

        if(forbiddenCombinations[NumberState(getTempState())][ countCombinations[NumberState(getTempState())]].compareTo(deadlockList[NumberState(getTempState())][0]) == 0) {
           // System.out.println("+");
            countCombinations[NumberState(getTempState())] ++;
            countCombinations[NumberState(getTempState())] %= count;
        }
        String whiteCombination = forbiddenCombinations[NumberState(getTempState())][ countCombinations[NumberState(getTempState())]];
      //  System.out.println(whiteCombination);
        whiteList[NumberState(getTempState())] = whiteCombination;
    }

    int CheckDeadlock(int randCombination, int count, Random rand){
        //System.out.println("+");
        while (1==1) {
            boolean noDead = false;
            for (int i = 0; i < nCombinations; i++) {
                noDead = true;
                if (forbiddenCombinations[NumberState(getTempState())][randCombination].compareTo(deadlockList[NumberState(getTempState())][i]) == 0) {
                    randCombination = rand.nextInt(count);
                    noDead = false;
                    break;
                }
            }
            if (noDead) {
               // System.out.println(randCombination);
                return randCombination;
            }
        }
    }
    String[][] deadlockList = new String[nState][nCombinations];

    void DeadlockState(){
       // System.out.println(mas[1]);
        for(int i=0; i < nCombinations; i++) {
            if(forbiddenCombinations[NumberState(listY.get(listY.size() - 2))][i].compareTo(" ") == 0){
              // System.out.println(mas[1]);
               //System.out.println(listY.get(listY.size() - 2));
                for (int j = 0; j < nCombinations; j++) {
                    if(deadlockList[NumberState(listY.get(listY.size() - 2))][j].compareTo(" ") == 0) {
                        deadlockList[NumberState(listY.get(listY.size() - 2))][j] = forbiddenCombinations[NumberState(listY.get(listY.size() - 2))][i - 1];
                        break;
                    }
                }
                break;
            }
        }
        tempY = Variables.startState;
        setTempState(Variables.startState);
        lock.setY(Variables.startState);
    }
}
