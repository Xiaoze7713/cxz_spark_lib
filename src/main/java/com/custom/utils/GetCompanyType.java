package com.custom.utils;

import com.custom.utils.Company.CompanyCode;

import java.util.HashMap;

public class GetCompanyType {
    public static HashMap<String, String> companyTypeDict;
    static {
        companyTypeDict = new HashMap<String, String>() {{
            put("", "");
        }};
    }
    public int Type2Id(String type){
        return 0;
    }
    public String GetCompanyType( String s){
        String typeName = companyTypeDict.get(s);
        if (typeName == null) {
            return CompanyCode.Code.COMPANY_NONE.name();
        }
        return typeName;
    }

}
