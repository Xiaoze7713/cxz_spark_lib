package com.custom.utils.GeoUtils;
import java.util.HashMap;
import java.util.Map;

public class GeoConvertUtils {

    private final static double PI = CoordinateConverter.PI;   // 圆周率
    public final static double R  = CoordinateConverter.AXIS;  // 地球的半径


    /**
     * 坐标之间的距离
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 单位米
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        lat1 = Math.toRadians(lat1);
        lng1 = Math.toRadians(lng1);
        lat2 = Math.toRadians(lat2);
        lng2 = Math.toRadians(lng2);
        double d1 = Math.abs(lat1 - lat2);
        double d2 = Math.abs(lng1 - lng2);
        double p = Math.pow(Math.sin(d1 / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(d2 / 2), 2);
        double dis = R * 2 * Math.asin(Math.sqrt(p));
        return dis;
    }

    /**
     *
     * @param p1
     * @param p2
     * @return
     */
    public static double getDistinct(Point p1, Point  p2) {
        return getDistance(p1.getLat(), p1.getLon(), p2.getLat(), p2.getLon());
    }

    /**
     * 坐标半径raidus米范围的角点坐标
     *
     * @param lat
     * @param lon
     * @param raidus 单位 米
     * @return {minLat:xx,minLng:xx,maxLat:xx,maxLng:xx}
     */
    public static Map<String, Double> getAround(double lat, double lon, int raidus) {

        Double latitude = lat;
        Double longitude = lon;

        double degree = (24901 * 1609) / 360.0;

        double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * (double) raidus;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;

        double mpdLng = degree * Math.cos(latitude * (PI / 180));
        double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * (double) raidus;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("minLat", minLat);
        map.put("minLng", minLng);
        map.put("maxLat", maxLat);
        map.put("maxLng", maxLng);
        return map;
    }

    // -----------------------------------------------------------------------
    // -------转换坐标 开始-----------------------------------------------------

    /**
     * 从火星坐标系转换为地球坐标系
     *
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertGCJ02toWGSExactly(double Lat, double Lon) {
        double[] p = CoordinateConverter.gcj2WGSExactly(Lat, Lon);
        return new Point(p[1], p[0]);
    }

    /**
     * 从火星坐标系转换为地球坐标系
     * @param point
     * @return
     */
    public static Point convertGCJ02toWGSExactly(Point point) {
        return convertGCJ02toWGSExactly(point.getLat(),point.getLon());
    }

    /**
     * 从地球坐标转换为火星坐标,例如:苹果坐标转高德坐标
     *
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertWGS84ToGCJ02(double Lat, double Lon) {
        double[] p = CoordinateConverter.wgs2GCJ(Lat, Lon);
        return new Point(p[1], p[0]);
    }



    /**
     * 从地球坐标转换为火星坐标,例如:苹果坐标转高德坐标
     *
     * @param point
     * @return
     */
    public static Point convertWGS84ToGCJ02(Point point) {
        return convertWGS84ToGCJ02(point.getLat(), point.getLon());
    }

    /**
     * 百度坐标转火星坐标
     *
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertBD09ToGCJ02(double Lat, double Lon) {
        double[] p = CoordinateConverter.bd092GCJ(Lat, Lon);
        return new Point(p[1],p[0]);
    }

    /**
     * 百度坐标转火星坐标
     * @param point
     * @return
     */
    public static Point convertBD09ToGCJ02(Point point) {
        return convertBD09ToGCJ02(point.getLat(), point.getLon());
    }

    /**
     * 火星坐标转百度坐标
     *
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertGCJ02ToBD09(double Lat, double Lon) {
        double[] p = CoordinateConverter.gcj2BD09(Lat, Lon);
        return new Point(p[1],p[0]);
    }

    /**
     * 火星坐标转百度坐标
     * @param point
     * @return
     */
    public static Point convertGCJ02ToBD09(Point point) {
        return convertGCJ02ToBD09(point.getLat(), point.getLon());
    }

    /**
     * 百度坐标转地球坐标
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertBD09ToWGS84(double Lat, double Lon) {
        return convertGCJ02toWGSExactly(convertBD09ToGCJ02(Lat, Lon));
    }

    /**
     * 百度坐标转地球坐标
     * @param point 百度坐标
     * @return
     */
    public static Point convertBD09ToWGS84(Point point) {
        return convertBD09ToWGS84(point.getLat(),point.getLon());
    }

    /**
     * 地球坐标转百度坐标
     * @param Lat
     * @param Lon
     * @return
     */
    public static Point convertWGS84ToBD09(double Lat, double Lon) {
        return convertGCJ02ToBD09(convertWGS84ToGCJ02(Lat, Lon));
    }

    /**
     * 地球坐标转百度坐标
     * @param point
     * @return
     */
    public static Point convertWGS84ToBD09(Point point) {
        return convertWGS84ToBD09(point.getLat(), point.getLon());
    }

    /**
     * 图吧坐标转地球坐标
     * @param point
     * @return
     */
    public static Point convertMapbar2Earth(Point point) {
        return convertMapbar2Earth(point.getLat(), point.getLon());
    }

    /**
     *  图吧坐标转地球坐标
     * @param mapbarLat
     * @param mapbarLon
     * @return
     */
    public static Point convertMapbar2Earth(double mapbarLat,double mapbarLon) {
        double[] p = CoordinateConverter.mapBar2WGS84(mapbarLon, mapbarLat);
        return new Point(p[1], p[0]);
    }

    /**
     * 图吧坐标转火星坐标
     * @param point
     * @return
     */
    public static Point convertMapbar2Mars(Point point) {
        return convertMapbar2Mars(point.getLat(), point.getLon());
    }

    /**
     * 图吧坐标转火星坐标
     * @param mapbarLat
     * @param mapbarLon
     * @return
     */
    public static Point convertMapbar2Mars(double mapbarLat,double mapbarLon) {
        return convertWGS84ToGCJ02(convertMapbar2Earth(mapbarLat, mapbarLon));
    }

    /**
     * 通用转换接口
     * @param lat
     * @param lon
     * @param from
     * @param to
     * @return
     */
    public static Point convertCoord(double lat, double lon,CoordType from,CoordType to){
        Point result = new Point(lon,lat);
        switch(from){
            case BD09:{
                switch(to){
                    case BD09: break;
                    case WGS84: result = convertBD09ToWGS84(result);break;
                    case GCJ02: result = convertBD09ToGCJ02(result);break;
                    default: throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            case WGS84:{
                switch(to){
                    case BD09: result = convertWGS84ToBD09(result);break;
                    case WGS84: break;
                    case GCJ02: result = convertWGS84ToGCJ02(result);break;
                    default: throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            case GCJ02:{
                switch(to){
                    case BD09: result = convertGCJ02ToBD09(result);break;
                    case WGS84: result = convertGCJ02toWGSExactly(result);break;
                    case GCJ02: break;
                    default: throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
                }
                break;
            }
            default:{
                throw new UnsupportedOperationException("Convert From " + from+ " To " + to);
            }
        }
        return result;
    }

    /**
     * 通用转换接口
     * @param point
     * @param from
     * @param to
     * @return
     */
    public static Point convertCoord(Point point,CoordType from,CoordType to){
        return convertCoord(point.getLat(), point.getLon(), from, to);
    }

    // -----------------------------------------------------------------------

}





