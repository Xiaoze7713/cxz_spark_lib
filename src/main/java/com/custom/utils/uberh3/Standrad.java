package com.custom.utils.uberh3;

import org.apache.commons.math3.analysis.function.Abs;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;

public class Standrad extends UDF {
    public Standrad() {
    }
    static int[] standradList = {1800, 2700, 3800, 4200, 5000, 6200, 6800, 7700, 8200, 8700, 9600, 11700, 12500, 13000, 15000, 16000, 17500, 19000, 19500, 20000, 21000};
    public Text evaluate(Text lengthText) {
        int length = Integer.valueOf(lengthText.toString());
        int standrad = standradList[0];
        for (int i = 1; i < standradList.length; i ++) {
            if (Math.abs(standrad - length) > Math.abs(standradList[i] - length)) {
                standrad = standradList[i];
            }
        }
        Text res = new Text();
        res.set(String.valueOf(standrad));
        return res;
    }
}
