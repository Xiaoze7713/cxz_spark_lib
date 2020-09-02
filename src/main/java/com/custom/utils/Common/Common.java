package com.custom.utils.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Common {
    public static String[] MultiSplit(String s , String sepListStr) {
        for (int i = 0 ; i < sepListStr.length(); i ++) {
            s = s.replace(sepListStr.charAt(i), ' ');
        }
        return s.split(" ");
    }
    public static ArrayList<String> MultiSplit(String input , String[] sepList) {
        ArrayList<String> res = new ArrayList<String>(){{
            add(input);
        }};
        for (String value : sepList) {
            ArrayList<String> tmpRes = new ArrayList<>();
            for (String s : res) {
                tmpRes.addAll(Arrays.asList(s.split(value)));
            }
            res = tmpRes;
        }
        return res;
    }
    public static String Replace(String s, HashMap<String, String> k2v) {
        for (String key : k2v.keySet()) {
            String val = k2v.get(key);
            s = s.replace(key, val);
        }
        return s;
    }
}
