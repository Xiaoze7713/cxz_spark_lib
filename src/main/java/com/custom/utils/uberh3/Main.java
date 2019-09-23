package com.custom.utils.uberh3;
import com.custom.utils.uberh3.InPolygonArea;
import com.uber.h3core.H3Core;
import org.apache.hadoop.io.Text;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        H3Core h3 =  H3Core.newInstance();
        Text ts = new Text();
        ts.set(new String("116.336632,39.948306|116.461344,39.951069|116.463404,39.868246|116.326075,39.867719"));
        Text tlng = new Text();
        tlng.set(new String("116.393795"));
        Text tlat = new Text();
        tlat.set(new String("39.90493"));
        InPolygonArea udf = new InPolygonArea();
        System.out.println(udf.evaluate(ts, tlng, tlat).toString());
        String s = udf.evaluate(ts, tlng, tlat).toString();
        List<String> h3List = h3.getH3IndexesFromUnidirectionalEdge(s);
        for (int i = 0; i < h3List.size(); i++) {
            System.out.printf("%s\n", h3List.get(i));
        }
        return;
    }
}
