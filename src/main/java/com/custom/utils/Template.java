package com.custom.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Template extends UDF {
    public Text evaluate(Text s) {
        return s;
    }
}
