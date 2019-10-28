package com.custom.utils.GeoUtils;

public enum CoordType {
    /**WGS-84 支持厂商:苹果**/
    WGS84("WGS84", "地球坐标"),
    /**GCJ-02 支持厂商:谷歌、高德**/
    GCJ02("GCJ02", "火星坐标"),
    /**BD-09  支持厂商:百度**/
    BD09("BD09", "百度坐标");
    private String name;
    private String remark;

    private CoordType(String name, String remark){
        this.name = name;
        this.remark = remark;
    }

    public static CoordType codeOf(String name) {
        for (CoordType s : CoordType.values()) {
            if (equalsIgnoreCase(s.getName(), name)) {
                return s;
            }
        }

        return null;
    }

    private static boolean equalsIgnoreCase(String str1, String str2)
    {
        return str1 != null ? str1.equalsIgnoreCase(str2) : str2 == null;
    }


    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args){
    }
}
