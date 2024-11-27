
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class SeatInfo {

    ArrayList<ArrayList<String>> list = new ArrayList<>(); 
    
    public void Setdata(String x, String y, String... z){
        ArrayList<String> minilist = new ArrayList();
        minilist.add(x);
        minilist.add(y);
        for(int i = 0; i < z.length; i++){
            minilist.add(z[i]);
        }
        list.add(minilist);
    }
    
}


