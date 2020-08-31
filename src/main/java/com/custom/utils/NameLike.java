package com.custom.utils;

import com.custom.utils.Algorithm.EditDistance;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.Arrays;


public class NameLike extends UDF {
    public NameLike() {
    }
    public Text evaluate(Text textNameA, Text textNameB, Text sepListText) {
        String nameA = textNameA.toString();
        String nameB = textNameB.toString();
        String sepListStr = sepListText.toString();
        int dis = NameLikeVal(nameA, nameB, sepListStr);
        Text res = new Text();
        res.set(String.valueOf(dis));
        return res;
    }
    public int NameLikeVal(String nameA, String nameB, String sepListStr) {
        ArrayList<String> nameAList = new ArrayList<>();
        ArrayList<String> nameBList = new ArrayList<>();
        for (int i = 0 ; i < sepListStr.length(); i ++) {
            char sep = sepListStr.charAt(i);
            nameA = nameA.replace(sep, ' ');
            nameB = nameB.replace(sep, ' ');
        }
        nameAList.addAll(Arrays.asList(nameA.split(" ")));
        nameBList.addAll(Arrays.asList(nameB.split(" ")));
        Arrays.sort(nameAList.toArray());
        Arrays.sort(nameBList.toArray());
        if (nameAList.size()  < nameBList.size()) {
            ArrayList<String> c ;
            c = nameAList;
            nameAList = nameBList;
            nameBList = c;
        }
        int totalMinDis = 0;
        totalMinDis = EditDistance.GetEditDistance(String.join(" ", nameAList), String.join(" ", nameBList));
//        for (int i = 0; i < nameAList.size(); i ++) {
//            int minWordDis = 9999;
//            for (int j = 0; j < nameBList.size(); j ++) {
//                int dis = EditDistance.GetEditDistance(nameAList.get(i), nameBList.get(j));
//                System.out.printf("%s, %s, %d\n", nameAList.get(i), nameBList.get(j), dis);
//                if (dis < minWordDis) {
//                    minWordDis = dis;
//                }
//            }
//            totalMinDis += minWordDis;
//        }
        return totalMinDis;
    }
}
