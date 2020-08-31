package com.custom.utils.Company;

import com.custom.utils.Common.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CompanyName {
    public static HashMap<String, String> replaceDict;
    static {
        replaceDict = new HashMap<>();
        replaceDict.put(",", " ");
        replaceDict.put(")", " ");
        replaceDict.put("(", " ");
        replaceDict.put("-", " ");
        replaceDict.put(";", " ");
        replaceDict.put("\"", " ");
    }
    public static String FormatCompanyName(String oriName) {
        String formatName = Common.Replace(oriName, replaceDict).toUpperCase();
        String[] nameWords = Common.MultiSplit(formatName, ", ");
        ArrayList<String> n = (ArrayList<String>) Arrays.stream(nameWords).filter(x -> !x.equals("")).collect(Collectors.toList());
        return String.join(" ", n);
    }
}
