package com.bupt.fnl;

import java.util.ArrayList;
import java.util.Random;

public class DotComGame {

    public static void main(String[] args){
        int numOfGuesses = 0;   //定义玩家猜的次数
        GameHelper helper = new GameHelper();

        DotCom theDotCom = new DotCom();
        int randomNum = (int)(Math.random() * 5);   //随机生成DotCom的第一个位置
        Random random = new Random();
        random.nextInt(5);
        //String randomNumStr = Integer.toString(randomNum);

        //int[] locations = {randomNum, randomNum+1, randomNum+2};
        ArrayList<String> locations = new ArrayList<String>();  //确定整个DotCom的位置
        for (int i = 0; i < 3; i++){
            String str = Integer.toString(randomNum);
            locations.add(str);
            randomNum++;
        }

        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive){
            String guess = helper.getUserInput("enter a number");   //获取玩家猜测数字
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("kill")){
                isAlive = false;
                System.out.println("You took "+numOfGuesses+" guesses");
            }
        }
    }
}