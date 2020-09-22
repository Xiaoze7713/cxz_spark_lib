package com.custom.utils.Company;

import com.custom.utils.Algorithm.EditDistance;

import java.util.ArrayList;
import java.util.Comparator;

public class CompanyKeyWord {
    public static ArrayList<String> companyKey;
    static {
        companyKey = new ArrayList<>();
        companyKey.add("CORPORATION");
        companyKey.add("CORP");
        companyKey.add("COMPANY");
        companyKey.add("PROPERTIES");
        companyKey.add("PROPERTY");
        companyKey.add("PARTNERSHIP");
        companyKey.add("PROFESSIONAL");
        companyKey.add("LIMITED");
        companyKey.add("LIABILITY");
        companyKey.add("ASSOCIATION");
        companyKey.add("FUND");
        companyKey.add("GROUP");
        companyKey.add("CO.");
        companyKey.add("LTD.");
        companyKey.add("GENERAL");
    }
    public static final int keyLikeLimit  = 3;
    public static ArrayList<String> MatchCompanyKeyWord(String companyName) {
        ArrayList<String> keyWords = new ArrayList<>();
        ArrayList<String> otherWords = new ArrayList<>();
        String[] wordList = companyName.split(" ");
        for (String w : wordList) {
            String best = "";
            int minDis = 99;
            for (String k : companyKey) {
                int dis = EditDistance.GetEditDistance(k, w);
                if (dis < minDis && dis <= k.length() / 2) {
                    best = k;
                    minDis = dis;
                }
            }
            if(minDis <= keyLikeLimit) {
                keyWords.add(best);
            } else {
                otherWords.add(w);
            }
        }
        keyWords.sort(Comparator.naturalOrder());
        ArrayList<String> result = new ArrayList<>();
        result.add(String.join(" ", otherWords));
        if (keyWords.size() > 0) {
            result.add(String.join(";", keyWords));
        }
        return result;
    }
}
