package com.custom.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class GetHashId extends UDF {
    public Text evaluate(Text s) {
        MessageDigest msd;
        String str = s.toString();
        String encodeStr = "";
        try {
            msd = MessageDigest.getInstance("SHA-256");
            msd.update(str.getBytes(StandardCharsets.UTF_8));
            String hex  = byte2Hex(msd.digest());
            BigInteger b = new BigInteger(hex, 16);
            BigInteger p = BigInteger.valueOf(10).pow(18);
            //System.out.print(b.mod(p));
            encodeStr = b.mod(p).toString(10);
        } catch (NoSuchAlgorithmException ignored) {
        }
        return new Text(encodeStr);
    }
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++) {
          temp = Integer.toHexString(bytes[i] & 0xFF);
          if (temp.length()==1){
            //1得到一位的进行补0操作
            stringBuffer.append("0");
          }
          stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
