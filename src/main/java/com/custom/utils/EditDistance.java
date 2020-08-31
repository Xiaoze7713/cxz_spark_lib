package com.custom.utils;

import org.apache.hadoop.io.Text;

public class EditDistance {
    public static Text evaluate(Text s1, Text s2) {
        int dis = com.custom.utils.Algorithm.EditDistance.GetEditDistance(s1.toString(), s2.toString());
        return new Text(String.valueOf(dis));
    }
}
