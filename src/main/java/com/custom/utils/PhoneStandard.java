package com.custom.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PhoneStandard extends UDF {


    public Text evaluate(Text text) {
        return text;
    }
    public static String Standard(String s) {
        s = s.replace("/", " ");
        s = s.replace(")", " ");
        s = s.replace("(", " ");
        s = s.replace("-", " ");
        s = s.replace(".", " ");
        ArrayList<ArrayList<String> > splitStrings = (ArrayList<ArrayList<String> > )Arrays.stream(s.split(" "))
                .filter(x -> !x.equals(""))
                .map(x -> {
                    String[] splitStrList = x.length() > 5 && x.length() <=9 ? new String[]{x.substring(0, 4), x.substring(4)}:new String[]{x,};
                    return new ArrayList<String>(Arrays.asList(splitStrList));
                }).collect(Collectors.toList());
        ArrayList<String> f = new ArrayList<>();
        for(ArrayList<String> sL: splitStrings) {
            f.addAll(sL);
        }
        String res = s;
        if (f.size() == 0) {
            res = "";
        } else if (f.size() == 3) {
            res = "+1 " + String.join("", f);
        } else if (f.size() == 4) {
            res = "+" + f.get(0) + " " + String.join("", f.subList(1, f.size()));
        } else if (f.get(0).charAt(0) == '1') {
            res = "+1 " + f.get(0).substring(1,f.size()) + String.join("", f.subList(1,f.size()));
        } else {
            res = "+1 " + String.join("", f);
        }
        return res;
    }
}
