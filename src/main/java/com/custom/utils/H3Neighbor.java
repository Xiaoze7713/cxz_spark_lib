package com.custom.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import com.uber.h3core.H3Core;
import org.apache.hadoop.io.Text;

import java.util.List;

public class H3Neighbor extends UDF {
    static H3Core h3 ;
    public Text evaluate(Text h3grid) throws Exception {
        Text k = new Text();
        k.set(String.valueOf(1));
        return evaluate(h3grid, k);
    }
    public Text evaluate(Text h3grid, Text k) throws Exception {
        List<String> neighborList = h3.hexRing(h3grid.toString(), Integer.parseInt(k.toString()));
        String neighborStr = StringUtils.join(neighborList.toArray(), ',');
        Text res = new Text();
        res.set(neighborStr);
        return res;
    }
    public H3Neighbor() throws Exception {
        h3 = H3Core.newInstance();
    }
}
