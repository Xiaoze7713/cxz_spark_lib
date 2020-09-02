package com.custom.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


public class Standard extends UDF {
    public Standard() {
    }
    private static int[] standardList = {1800, 2700, 3800, 4200, 5000, 6200, 6800, 7700, 8200, 8700, 9600, 11700, 12500, 13000, 15000, 16000, 17500, 19000, 19500, 20000, 21000};
    public Text evaluate(Text lengthText) {
        int length = Integer.parseInt(lengthText.toString());
        int standrad = standardList[0];
        for (int i = 1; i < standardList.length; i ++) {
            if (Math.abs(standrad - length) > Math.abs(standardList[i] - length)) {
                standrad = standardList[i];
            }
        }
        Text res = new Text();
        res.set(String.valueOf(standrad));
        return res;
    }
}
