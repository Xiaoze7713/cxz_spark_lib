package com.custom.utils.Company;

import com.custom.utils.Algorithm.EditDistance;

import java.util.ArrayList;
import java.util.HashMap;

public class CompanyType {
    public static HashMap<String, CompanyCode.Code> companyTypeToCode;
    static {
        companyTypeToCode = new HashMap<>();
        companyTypeToCode.put("LLC", CompanyCode.Code.LLC);
        companyTypeToCode.put("INC.", CompanyCode.Code.INC);
        companyTypeToCode.put("L.P.", CompanyCode.Code.LP);
        companyTypeToCode.put("LLP", CompanyCode.Code.LLP);
        companyTypeToCode.put("LLLP", CompanyCode.Code.LLLP);
        companyTypeToCode.put("LLLC", CompanyCode.Code.LLLC);
        companyTypeToCode.put("PLLC", CompanyCode.Code.PLLC);
        companyTypeToCode.put("CO.", CompanyCode.Code.CO);
        companyTypeToCode.put("LC", CompanyCode.Code.LC);
        companyTypeToCode.put("PLC", CompanyCode.Code.PLC);
        companyTypeToCode.put("S.A.R.L", CompanyCode.Code.SARL);
        companyTypeToCode.put("P.A.", CompanyCode.Code.PA);
        companyTypeToCode.put("PL", CompanyCode.Code.PL);
        companyTypeToCode.put("S.A.", CompanyCode.Code.SA);
    }
    public static final int companyTypeLikeLimit = 3;
    public static HashMap<String, String> companyDescribeDict;
    static {
        companyDescribeDict = new HashMap<>();
    }

    public static ArrayList<String> GetCompanyType(String companyName) {
        ArrayList<String> keyWords = new ArrayList<>();
        ArrayList<String> otherWords = new ArrayList<>();
        String[] wordList = companyName.split(" ");
        for (String w : wordList) {
            String best = "";
            int minDis = 99;
            for (String k : companyTypeToCode.keySet()) {
                int dis = EditDistance.GetEditDistance(k, w);
                if (dis < minDis && dis <= k.length() / 2) {
                    best = k;
                    minDis = dis;
                }
            }
            if(minDis <= companyTypeLikeLimit ) {
                keyWords.add(best);
            } else {
                otherWords.add(w);
            }
        }
        keyWords.sort(String::compareTo);
        ArrayList<String> result = new ArrayList<>();
        result.add(String.join(" ", otherWords));
        if (keyWords.size() > 0) {
            result.add(String.join(";", keyWords));
        }
        return result;
    }
}
