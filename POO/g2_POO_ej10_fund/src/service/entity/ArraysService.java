
package service.entity;

import entity.vector.Arrays;

public class ArraysService {
    public static Arrays crearArrays() {
        Arrays arr = new Arrays();
        double [] arrA = new double [50];
        
        for(int i = 0; i < 50; i++) {
            arrA[i] = Math.random();
        }
        
        System.out.print("Vector A: ");
        for(int i = 0; i < 50; i++) {
                System.out.print(arrA[i] + " ");
            }
        
        System.out.println();
        
        int nums_ord = 0, pos = 0;
        double men;
        
        while(nums_ord < 50) {
            men = arrA[nums_ord];
            for(int i = nums_ord; i < 50; i++) {
                if(men > arrA[i]) {
                    men = arrA[i];
                    pos = i;
                }
            }
            arrA[pos] = arrA[nums_ord];
            arrA[nums_ord] = men;
            nums_ord++;
        }
        
        arr.setArrA(arrA);

        System.out.print("Vector A ordenado de menor a mayor: ");
        for(int i = 0; i < 50; i++) {
                System.out.print(arrA[i] + " ");
            }
        System.out.println();
        
        double [] arrB = new double [20];
        
        for(int i = 0; i < 20; i++) {
            if(i < 10) {
                arrB[i] = arrA[i];
            } else {
                arrB[i] = 0.5;
            }
        }
        
        System.out.println();
        
        System.out.print("Vector B: ");
        for(int i = 0; i < 20; i++) {
                System.out.print(arrB[i] + " ");
            }
        
        arr.setArrB(arrB);
        
        return arr;
    }
}
