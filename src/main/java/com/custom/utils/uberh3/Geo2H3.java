package com.custom.utils.uberh3;

/**
 * Hello world!
 *
 */


import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.uber.h3core.H3Core;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
import org.apache.commons.lang.StringUtils;
import org.json.Test;


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

