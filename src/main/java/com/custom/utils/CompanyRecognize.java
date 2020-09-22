package com.custom.utils;

import com.custom.utils.Company.CompanyKeyWord;
import com.custom.utils.Company.CompanyName;
import com.custom.utils.Company.CompanyType;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;

public class CompanyRecognize extends UDF {
    public Text evaluate(Text companyText) {
        String companyName = CompanyName.FormatCompanyName(companyText.toString());
        ArrayList<String> typeInfo = CompanyType.GetCompanyType(companyName);
        if (typeInfo.size() == 2){
            return new Text(typeInfo.get(0) + "," + typeInfo.get(1));
        }
        ArrayList<String> matchInfo = CompanyKeyWord.MatchCompanyKeyWord(companyName);
        if (matchInfo.size() == 2) {
            return new Text(matchInfo.get(0) + "," + matchInfo.get(1));
        }
        return new Text(companyName + ",");
    }
}
