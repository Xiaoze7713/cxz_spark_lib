package com.custom.utils;

import com.custom.utils.GeoUtils.CoordType;
import com.custom.utils.GeoUtils.GeoConvertUtils;
import com.custom.utils.GeoUtils.Point;
import com.uber.h3core.H3Core;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class CoordConvertAndGeo2H3 extends UDF {
    static private H3Core h3;
    public Text evaluate(Text lng, Text lat, Text deep, Text from, Text to) {
        Point point = new Point(Double.parseDouble(lng.toString()), Double.parseDouble(lat.toString()));
        CoordType coordFrom = CoordType.codeOf(from.toString());
        CoordType coordTo = CoordType.codeOf(to.toString());
        Point newPoint =  GeoConvertUtils.convertCoord(point, coordFrom, coordTo);
        int ideep = Integer.parseInt(deep.toString());
        Text res = new Text();
        res.set(Long.toHexString(h3.geoToH3(newPoint.getLat(), newPoint.getLon(), ideep)));
        return res;
    }
    public CoordConvertAndGeo2H3() throws Exception {
        h3 = H3Core.newInstance();
    }

}
