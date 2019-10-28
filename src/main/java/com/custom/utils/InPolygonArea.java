package com.custom.utils;

import com.uber.h3core.util.GeoCoord;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;

public class InPolygonArea extends UDF {
    public InPolygonArea() throws Exception{
    }
    public  boolean InPolygon(ArrayList<GeoCoord> geoList, GeoCoord poi) {
        boolean flag = false;
        int N = geoList.size();
        int j = N - 1;
        for (int i = 0; i < N; i++){
            if (i > 0) j = i - 1;
            GeoCoord ps = geoList.get(i);
            GeoCoord pe = geoList.get(j);
            //System.out.printf("s = %lf %lf\n", ps.lng, ps.lat);
            //System.out.printf("e = %lf %lf\n", pe.lng, pe.lat);
            //System.out.printf("poi = %lf %lf\n", poi.lng, poi.lat);
            if (ps.lat == pe.lat) { //射线与 线段平行 | 重合 | 两点为同一点
                continue;
            }
            if (ps.lat > poi.lat && pe.lat > poi.lat) { // 线段在射线上方
                continue;
            }
            if (ps.lat < poi.lat && pe.lat < poi.lat) { //  射线在线段下方
                continue;
            }
            if (ps.lat == poi.lat && pe.lat >  poi.lat) { // 相同起点纬度 终点在射线上方 不算
                continue;
            }
            if (ps.lat > poi.lat && pe.lat == poi.lat) { // 相同终点纬度 起点在射线上方 不算 (上方或者下方二选一保留)
                continue;
            }
            if (ps.lng< poi.lng && pe.lng < poi.lng ) { //左侧的线段 不理会
                continue;
            }
            double xseg = pe.lng -  (pe.lng - ps.lng ) / (pe.lat - ps.lat) * (pe .lat - poi.lat);  //根据斜率求交点 lng , 判断点的位置
            if (xseg < poi.lng) {
                continue;
            }
            flag = !flag;
        }
        return flag;
    }
    public Text evaluate(Text strGeoList, Text slng, Text slat) {
        Text sep = new Text();
        sep.set(new String("\\|"));
        return evaluate(strGeoList, slng, slat, sep);
    }
    public Text evaluate(Text strGeoList, Text slng, Text slat, Text sep) {
        Text sep2 = new Text();
        sep2.set(new String(","));
        return evaluate(strGeoList, slng, slat, sep, sep2);
    }
    public Text evaluate(Text strGeoList, Text slng, Text slat, Text sep, Text sep2) {
        Text res = new Text();
        double lng = Double.parseDouble(slng.toString());
        double lat = Double.parseDouble(slat.toString());
        GeoCoord poi = new GeoCoord(lat, lng);
        String[] geoListStr = strGeoList.toString().split(sep.toString());
        ArrayList<GeoCoord> geoList = new ArrayList<GeoCoord>();
        for (int i = 0; i < geoListStr.length; i++) {
            String[] items = geoListStr[i].split(sep2.toString());
            System.out.printf("%s", items[0]);
            if (items.length != 2) {
                System.out.printf("length :%d", items.length);
                res.set(String.valueOf(false));
                return res;
            }
            Double tmpLng = Double.parseDouble(items[0]);
            Double tmpLat = Double.parseDouble(items[1]);
            geoList.add(new GeoCoord(tmpLat, tmpLng));
        }

        res.set(String.valueOf(InPolygon(geoList, poi)));
        return res;
    }
}

