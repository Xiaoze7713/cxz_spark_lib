package com.custom.utils.GeoUtils;

import com.uber.h3core.util.GeoCoord;

import java.io.*;
import java.util.ArrayList;

public class Region {
    private static Region region = null;
    public class Info {
        Info() {};
        public ArrayList<GeoCoord> geoCoords = new ArrayList<GeoCoord>();
        String province_name;
        String province_code;
        String city_name;
        String city_code;
        String country_name;
        String country_code;
        public String getInfo()  {
            return province_name
                    + "," + province_code
                    + "," + city_name
                    + "," + city_code
                    + "," + country_name
                    + "," + country_code;

        }
    }

    public static Region getInstance() throws Exception {
        if (region == null) {
            region = new Region();
        }
        return region;
    }

    public ArrayList<Info> regionLists = new ArrayList<Info>();
    private Region() throws Exception {
        try {
            //private static String filePath = "hdfs://zjxl-nameservice/user/h_sunmingze/jar/udf/code_region.txt";
            String filePath = "./code_region.txt";
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String tmp ;
            while ((tmp = reader.readLine()) != null) {
                Info info = new Info();
                String[] items = tmp.split("\t");
                if (items.length != 7) {throw new IOException("items error ");}
                info.province_name = items[0];
                info.province_code = items[1];
                info.city_name = items[2];
                info.city_code = items[3];
                info.country_name = items[4];
                info.country_code = items[5];
                String[] geos = items[6].split("\\|");
                for(String geo : geos) {
                    double lng = Double.parseDouble(geo.split(",")[0]);
                    double lat = Double.parseDouble(geo.split(",")[1]);
                    GeoCoord geoCoord = new GeoCoord(lng, lat);
                    info.geoCoords.add(geoCoord);
                }
                regionLists.add(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
