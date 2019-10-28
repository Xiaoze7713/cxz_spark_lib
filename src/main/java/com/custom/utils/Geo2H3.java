package com.custom.utils;

/**
 * Hello world!
 *
 */


import com.uber.h3core.H3Core;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;


public class Geo2H3 extends UDF{
    static private H3Core h3;
    public Text evaluate(Text lng, Text lat, Text deep) {
        Double dlng = Double.parseDouble(lng.toString());
        Double dlat = Double.parseDouble(lat.toString());
        int ideep = Integer.parseInt(deep.toString());
        Text res = new Text();
        res.set(Long.toHexString(h3.geoToH3(dlat, dlng, ideep)));
        return res;
    }
    public Geo2H3() throws Exception {
        h3 = H3Core.newInstance();
    }

}

