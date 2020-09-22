package com.custom.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPeopleName extends UDF {
    public Text evaluate(Text s) {
        String[] pattens = {
            "[a-zA-Z]+[ ]+[A-Z][.]?[ ]+[a-zA-Z]+",
            "[A-Z][.]?[ ]+[a-zA-Z]+",
            "[a-zA-Z]+[ ]+[a-zA-Z]+",
        };
        String res = "";
        for (String pStr: pattens) {
            Pattern p = Pattern.compile(pStr);
            Matcher m = p.matcher(s.toString());
            if (m.find()) {
                res = m.group();
                break;
            }
        }
        return new Text(res);
    }
}
