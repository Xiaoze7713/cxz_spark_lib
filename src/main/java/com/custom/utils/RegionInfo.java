package com.custom.utils;

import com.custom.utils.GeoUtils.Region;
import com.uber.h3core.util.GeoCoord;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class RegionInfo extends UDF {
    private static Region region;
    public RegionInfo () throws Exception {
        region = Region.getInstance();
    }
    public Text evaluate(Text slng , Text slat) {
        double lng = Double.parseDouble(slng.toString());
        double lat = Double.parseDouble(slat.toString());
        GeoCoord geo = new GeoCoord(lng, lat);
        try {
            InPolygonArea  inPolygonArea = new InPolygonArea();
            for (Region.Info info : region.regionLists ) {
                if (inPolygonArea.InPolygon(info.geoCoords, geo)) {
                    return new Text(info.getInfo());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Text("false");
    }
}
