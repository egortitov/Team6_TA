package com.company;

public class Main {

    public static void main(String[] args) {
        delenie(10100101, 100001);
    }

    public static int binaryToDecimal(int binary){
        int decimal = 0;
        String stringBinary = Integer.toString(binary);
        int binaryLength = stringBinary.length();
        if (binaryLength<=8){
            char [] binaryArray = stringBinary.toCharArray();
            for(int i=0;i<binaryLength;i++){
                if(binaryArray[i]=='1'){
                    decimal+=Math.pow(2,binaryLength-i-1);
                }
            }
        }else {
            throw new IllegalArgumentException("Довжина одного з чисел більше 64-х розрядів");
        }
        return decimal;
    }

    public static void delenie(int binaryX, int binaryY){
        try {
            System.out.println("x="+binaryX+", y="+binaryY);
            int x = binaryToDecimal(binaryX);
            int y = binaryToDecimal(binaryY);
            System.out.println("x="+x+", y="+y);
            if(x%y==0) System.out.println("Числа х та у діляться націло");
            else System.out.println("Числа х та у не діляться націло");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
