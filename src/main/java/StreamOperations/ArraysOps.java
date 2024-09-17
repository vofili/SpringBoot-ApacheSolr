package StreamOperations;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraysOps {

    static void doFrequencyArray(int[] arrayItems){
        Set<Integer> LinkedHashSet;
        Set<Integer> numSet = new LinkedHashSet();

    }




    //function to perform a reversal of the cipher text to derive original text
    static String decryptCaesarCipher(String cipherText, int shift){
        //split ciphertext in
        StringBuilder result = new StringBuilder();
        for(int i =0; i< cipherText.length();i++){
            char c = cipherText.charAt(i);
            int unshifted;
            if(Character.isLetter(c)){

                if(Character.isLowerCase(c)){
                    unshifted = (int) c - shift ;
                    if( unshifted < 'a'){
                        unshifted = unshifted +26;
                    }
                    result.append((char)unshifted);

                }else if(Character.isUpperCase(c)){
                    unshifted = (int)c -shift;
                    if(unshifted < 'A'){
                        unshifted=unshifted+26;
                    }
                    result.append((char)unshifted);
                }
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }


    static String encryptCaesarCipher(String cipherText,int shift){

        StringBuilder result=new StringBuilder();

        for(int x = 0; x < cipherText.length();x++){
            char c = cipherText.charAt(x);

            if(Character.isLetter(c)){
                int shiftedc;
                if(Character.isLowerCase(c)){
                    shiftedc = c + shift;
                    if(shiftedc > 'z'){
                        shiftedc = shiftedc - 26;
                    }
                    result.append((char)shiftedc);
                }else if (Character.isUpperCase(c)){
                    shiftedc = c + shift;
                    if(shiftedc > 'Z'){
                        shiftedc = shiftedc - 26;
                    }
                    result.append((char)shiftedc);
                }
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
    static String shiftCharsDecryption(String text, int shift){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); i++){

            Character c = text.charAt(i);
            if(Character.isLetter(c)){
                char base = Character.isLowerCase(c)?'a':'A';
                int shiftedc = (int)((c - shift) + base) % 26;
                result.append((char)(shiftedc + base));
            }else{
                result.append(c);
            }

        }

        System.out.println(result.toString());

        return result.toString();
    }


    static void doRemoveDuplicates(){
        int num [] = {9,3,6,1,7,3,1,5};

        Set<Integer> newSet  = new HashSet<Integer>();

        for(int i = 0; i < num.length;i++){
            newSet.add(num[i]);
        }
        Object result [] = newSet.toArray();

        for(int i =0;i < result.length;i++){
            System.out.println(result[i]);
        };
    }

    static String shiftCharsEncryption(String text, int shift){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); i++){

            Character c = text.toUpperCase().charAt(i);
            if(Character.isLetter(c)){
                char base ='A';
                int shiftedc = (int)(c + shift - base) % 26;
                result.append((char)(shiftedc +base));
            }else{
                result.append(c);
            }

        }

        System.out.println(result.toString());

        return result.toString();
    }

    static String shiftCharsByNumInverse(String text, int shift){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            Character c = text.charAt(i);
            if(Character.isLetter(c)){
                char base = Character.isLowerCase(c) ? 'a': 'A';
                int shiftedc = (int)(c - shift - base) % 26;
                result.append((char)(shiftedc +base));
            }else{
                result.append(c);
            }

        }
        System.out.println(result.toString());
        return result.toString();
    }

    static void shiftCharByNumOld(String input, int shift){
        //A=65 Z=90 a= 97? z=122
        char[] strToCharArray = input.toCharArray();
        int[] charShifted = new int[strToCharArray.length];
        StringBuilder result = new StringBuilder("");
        for (int x =0;x < strToCharArray.length;x++){
            charShifted[x]= (int)strToCharArray[x]+shift > 90 ? 64 + (((int)strToCharArray[x]+shift) - 90)  : (int)strToCharArray[x]+shift;
            result.append((char)charShifted[x]);
        }
        System.out.println(result);

    }

    static int[][] doMatrixReverseColumns(int[][] input){

        int cols = input[0].length;

        for(int i = 0; i < cols;i++){
            for(int j = 0, k = input.length-1; j < k;  j++,k--){
                int temo = input[j][i];
                input[j][i]= input[k][i];
                input[k][i]=temo;
            }
        }

        return input;
    }

    static String doDecipher(String cipher, String known){
        String cipherArray[] = cipher.split(" ");
        StringBuilder result = new StringBuilder();
        int shiftedKey=0;
        for(int i = 0; i < cipherArray.length;i++){
            for(int j = 1; j < 26; j++){
                System.out.println("Encrypt: "+known+ " with: "+j + encryptCaesarCipher(known,j));
                if(shiftCharsEncryption(known,j).equalsIgnoreCase(cipherArray[i])){
                    System.out.println("Shifted by : "+j);
                    shiftedKey=j;
                    break;
                }
            }
        }

       System.out.println("the known word "+known+" was shifted by "+shiftedKey);
        for(int i =  0; i < cipher.length();i++){
            result.append(decryptCaesarCipher(String.valueOf(cipher.charAt(i)),shiftedKey));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decryptCaesarCipher("Mjqqt",5));
        System.out.println(encryptCaesarCipher("Hello Bomber!", 5));
        System.out.println(doDecipher("Mjqqt Gtrgjw!","Hello"));
    }
}
