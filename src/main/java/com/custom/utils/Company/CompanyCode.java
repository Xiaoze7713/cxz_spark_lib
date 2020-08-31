package com.custom.utils.Company;

import java.util.HashMap;

public class CompanyCode {
    public enum Code {
        COMPANY_NONE,
        LLC,
        INC,
        LP,
        LLP,
        LLLP,
        LLLC,
        PLLC,
        CO,
        LC,
        PLC,
        SARL,
        FUND_GROUP,
        PA,
        PL,
        SA
    }
    public static HashMap<String, Integer> companyType2Code;
    static {
        companyType2Code = new HashMap<>();
        for (Code c : Code.values()) {
            companyType2Code.put(c.name(), c.ordinal());
        }
    }
    public static HashMap<String, Integer> companyDescribe2Code;
    static {
        companyDescribe2Code = new HashMap<>();
        companyDescribe2Code.put("", Code.CO.ordinal());
    }
    public static int GetCompanyCodeByType(String s) {
        return companyType2Code.get(s);
    }
    public static int GetCompanyCodeByDescribe(String s) {
        return companyDescribe2Code.get(s);
    }
}
