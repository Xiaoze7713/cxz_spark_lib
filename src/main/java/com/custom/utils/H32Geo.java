package com.custom.utils;

import com.uber.h3core.H3Core;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class H32Geo extends  UDF{
    static private H3Core h3;
    public Text evaluate(Text h3grid) {
        String h3str = h3grid.toString();
        Text res = new Text();
        double lng = h3.h3ToGeo(h3str).lng;
        double lat = h3.h3ToGeo(h3str).lat;
        String formatString = String.format("%f,%f", lng, lat);
        res.set(formatString);
        return res;
    }
    public H32Geo() throws Exception {
        h3 = H3Core.newInstance();
    }
}

