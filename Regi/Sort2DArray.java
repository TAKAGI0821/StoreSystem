
import java.util.Arrays;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Sort2DArray {

    public static void Sort2DArrayBasedOnColumnNumber(String[][] array, final int columnNumber) {
        Arrays.sort(array, new Comparator<String[]>() {
            @Override
            public int compare(String[] first, String[] second) {
                if (first[columnNumber - 1] > second[columnNumber - 1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
}
