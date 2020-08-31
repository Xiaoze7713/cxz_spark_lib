package com.custom.utils.Common;

import java.util.HashMap;

public class Common {
    public static String[] MultiSplit(String s , String sepListStr) {
        for (int i = 0 ; i < sepListStr.length(); i ++) {
            s = s.replace(sepListStr.charAt(i), ' ');
        }
        return s.split(" ");
    }
    public static String Replace(String s, HashMap<String, String> k2v) {
        for (String key : k2v.keySet()) {
            String val = k2v.get(key);
            s = s.replace(key, val);
        }
        return s;
    }
}
