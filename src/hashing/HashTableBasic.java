package hashing;

import java.util.Arrays;

/**
 * Created by Ajay on 10/16/16.
 */
public class HashTableBasic {

    int hashArray[];
    int arraySize;

    public HashTableBasic(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new int[arraySize];
        Arrays.fill(hashArray, -1);
    }

    public void hashFunction(int inputArray[]) {

        int arrayIndex;
        int loopCounter;

        for (int i = 0; i < inputArray.length; i++) {
            arrayIndex = inputArray[i] % arraySize;
            System.out.println("Index for " + inputArray[i] + " is " + arrayIndex);
            loopCounter = 0;

            while (hashArray[arrayIndex] != -1 && loopCounter < arraySize) {
                ++arrayIndex;
                System.out.println("Collision: try index " + arrayIndex);
                arrayIndex %= arraySize;
                loopCounter++;
            }
            if(loopCounter != arraySize){
                hashArray[arrayIndex] = inputArray[i];
            }
        }
    }

    public void displayHashTable() {
        for (int i = 0; i < hashArray.length; i++) {
            System.out.println(i + " : " + hashArray[i]);
        }
    }

    public void findElement(int elem){
        int arrayIndex = elem % arraySize;
        int loopCounter = 0;

        while (hashArray[arrayIndex] != -1 && loopCounter < arraySize) {
            if(hashArray[arrayIndex] == elem){
                System.out.println("Key found at :"+ arrayIndex);
                break;
            }
            ++arrayIndex;
            arrayIndex %= arraySize;
            loopCounter++;
        }

        if(loopCounter == arraySize){
            System.out.println("Element not found.");
        }
    }

    public static void main(String[] args) {
        HashTableBasic ht = new HashTableBasic(10);
        int inputArray[] = {444, 555, 343, 656, 544, 234, 4, 645, 222, 888, 855};
        ht.hashFunction(inputArray);
        ht.displayHashTable();
        ht.findElement(855);
    }
}
