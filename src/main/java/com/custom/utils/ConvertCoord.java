package com.custom.utils;

import com.custom.utils.GeoUtils.GeoConvertUtils;
import com.custom.utils.GeoUtils.CoordType;
import com.custom.utils.GeoUtils.Point;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class ConvertCoord extends UDF {
    public Text evaluate(Text lng, Text lat, Text from, Text to) {
        Point point = new Point(Double.parseDouble(lng.toString()), Double.parseDouble(lat.toString()));
        CoordType coordFrom = CoordType.codeOf(from.toString());
        CoordType coordTo = CoordType.codeOf(to.toString());
        Point newPoint =  GeoConvertUtils.convertCoord(point, coordFrom, coordTo);
        StringBuffer sb = new StringBuffer();
        sb.append(newPoint.getLon());
        sb.append(",");
        sb.append(newPoint.getLat());
        return new Text(sb.toString());
    }
}
