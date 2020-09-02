package com.custom.utils;

import com.custom.utils.Common.Common;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


public class ParsePosition extends UDF {
    public static ArrayList<String[]> keyWorkList;
    public static ArrayList<HashSet<String>> positionSet;
    static {
        keyWorkList = new ArrayList<String[]>() {{
            add(new String[]{"Chief", "Human", "Resources", "Officer"});
            add(new String[]{"Senior", "Executive", "Vice", "President"});
            add(new String[]{"Interim", "Chief", "Financial", "Officer"});
            add(new String[]{"Co", "Chief", "Executive", "Officer"});
            add(new String[]{"Interim", "Chief", "Executive", "Officer"});
            add(new String[]{"Chief", "Supply", "Chain", "Officer"});
            add(new String[]{"Chief", "Human", "Resource", "Officer"});
            add(new String[]{"Deputy", "Chief", "Executive", "Officer"});
            add(new String[]{"Co", "Chief", "Operating", "Officer"});
            add(new String[]{"Acting", "Chief", "Financial", "Officer"});
            add(new String[]{"Executive", "Vice", "President"});
            add(new String[]{"Chief", "Executive", "Officer"});
            add(new String[]{"Senior", "Vice", "President"});
            add(new String[]{"Chief", "Financial", "Officer"});
            add(new String[]{"Principal", "Accounting", "Officer"});
            add(new String[]{"Chief", "Operating", "Officer"});
            add(new String[]{"Chief", "Accounting", "Officer"});
            add(new String[]{"Chief", "Human", "Resources"});
            add(new String[]{"Human", "Resources", "Officer"});
            add(new String[]{"Chief", "Legal", "Officer"});
            add(new String[]{"Chief", "Technology", "Officer"});
            add(new String[]{"Chief", "Medical", "Officer"});
            add(new String[]{"Chief", "Information", "Officer"});
            add(new String[]{"Senior", "Executive", "Vice"});
            add(new String[]{"Chief", "Commercial", "Officer"});
            add(new String[]{"Chief", "Risk", "Officer"});
            add(new String[]{"Chief", "Administrative", "Officer"});
            add(new String[]{"Chief", "Compliance", "Officer"});
            add(new String[]{"Chief", "Marketing", "Officer"});
            add(new String[]{"Chief", "Scientific", "Officer"});
            add(new String[]{"Chief", "Credit", "Officer"});
            add(new String[]{"Chief", "Investment", "Officer"});
            add(new String[]{"Chief", "Strategy", "Officer"});
            add(new String[]{"Principal", "Financial", "Officer"});
            add(new String[]{"Chief", "Business", "Officer"});
            add(new String[]{"Chief", "People", "Officer"});
            add(new String[]{"Corporate", "Vice", "President"});
            add(new String[]{"Interim", "Chief", "Financial"});
            add(new String[]{"Co", "Chief", "Executive"});
            add(new String[]{"Chief", "Revenue", "Officer"});
            add(new String[]{"Chief", "Lending", "Officer"});
            add(new String[]{"Chief", "Development", "Officer"});
            add(new String[]{"Chief", "Operations", "Officer"});
            add(new String[]{"Chief", "Product", "Officer"});
            add(new String[]{"Senior", "Managing", "Director"});
            add(new String[]{"Chief", "Customer", "Officer"});
            add(new String[]{"Interim", "Chief", "Executive"});
            add(new String[]{"Chief", "Banking", "Officer"});
            add(new String[]{"Chief", "Technical", "Officer"});
            add(new String[]{"Supply", "Chain", "Officer"});
            add(new String[]{"Principal", "Executive", "Officer"});
            add(new String[]{"Chief", "Supply", "Chain"});
            add(new String[]{"Managing", "Executive", "Officer"});
            add(new String[]{"Chief", "Digital", "Officer"});
            add(new String[]{"Human", "Resource", "Officer"});
            add(new String[]{"Chief", "Human", "Resource"});
            add(new String[]{"Group", "Vice", "President"});
            add(new String[]{"Chief", "Sales", "Officer"});
            add(new String[]{"Chief", "Innovation", "Officer"});
            add(new String[]{"Deputy", "Chief", "Executive"});
            add(new String[]{"Assistant", "Vice", "President"});
            add(new String[]{"Chief", "Growth", "Officer"});
            add(new String[]{"Global", "Human", "Resources"});
            add(new String[]{"Investor", "Relations", "Officer"});
            add(new String[]{"Co", "Chief", "Operating"});
            add(new String[]{"Business", "Development", "Officer"});
            add(new String[]{"Chief", "Transformation", "Officer"});
            add(new String[]{"Group", "Chief", "Executive"});
            add(new String[]{"Corporate", "Development", "Officer"});
            add(new String[]{"Acting", "Chief", "Financial"});
            add(new String[]{"Global", "Supply", "Chain"});
            add(new String[]{"Managing", "Corporate", "Executive"});
            add(new String[]{"Vice", "President"});
            add(new String[]{"Executive", "Vice"});
            add(new String[]{"Executive", "Officer"});
            add(new String[]{"Chief", "Executive"});
            add(new String[]{"Senior", "Vice"});
            add(new String[]{"Financial", "Officer"});
            add(new String[]{"Chief", "Financial"});
            add(new String[]{"Accounting", "Officer"});
            add(new String[]{"Principal", "Accounting"});
            add(new String[]{"General", "Counsel"});
            add(new String[]{"Chief", "Operating"});
            add(new String[]{"Operating", "Officer"});
            add(new String[]{"Chief", "Accounting"});
            add(new String[]{"Chief", "Human"});
            add(new String[]{"Resources", "Officer"});
            add(new String[]{"Chief", "Legal"});
            add(new String[]{"Technology", "Officer"});
            add(new String[]{"Chief", "Technology"});
            add(new String[]{"Legal", "Officer"});
            add(new String[]{"Chief", "Information"});
            add(new String[]{"General", "Manager"});
            add(new String[]{"Chief", "Medical"});
            add(new String[]{"Medical", "Officer"});
            add(new String[]{"Information", "Officer"});
            add(new String[]{"Chief", "Commercial"});
            add(new String[]{"Senior", "Executive"});
            add(new String[]{"Commercial", "Officer"});
            add(new String[]{"Compliance", "Officer"});
            add(new String[]{"Corporate", "Controller"});
            add(new String[]{"Administrative", "Officer"});
            add(new String[]{"Risk", "Officer"});
            add(new String[]{"Chief", "Risk"});
            add(new String[]{"Chief", "Administrative"});
            add(new String[]{"Managing", "Director"});
            add(new String[]{"Chief", "Marketing"});
            add(new String[]{"Marketing", "Officer"});
            add(new String[]{"Chief", "Compliance"});
            add(new String[]{"Vice", "Chairman"});
            add(new String[]{"Chief", "Scientific"});
            add(new String[]{"Scientific", "Officer"});
            add(new String[]{"Chief", "Credit"});
            add(new String[]{"Credit", "Officer"});
            add(new String[]{"Interim", "Chief"});
            add(new String[]{"Chief", "Strategy"});
            add(new String[]{"Strategy", "Officer"});
            add(new String[]{"Chief", "Investment"});
            add(new String[]{"Investment", "Officer"});
            add(new String[]{"Executive", "Director"});
            add(new String[]{"Development", "Officer"});
            add(new String[]{"Principal", "Financial"});
            add(new String[]{"Co", "Chief"});
            add(new String[]{"Chief", "Business"});
            add(new String[]{"Chief", "People"});
            add(new String[]{"Business", "Officer"});
            add(new String[]{"Operations", "Officer"});
            add(new String[]{"Group", "President"});
            add(new String[]{"People", "Officer"});
            add(new String[]{"Executive", "Chairman"});
            add(new String[]{"Co", "President"});
            add(new String[]{"Senior", "Managing"});
            add(new String[]{"Lending", "Officer"});
            add(new String[]{"Chief", "Operations"});
            add(new String[]{"Chief", "Development"});
            add(new String[]{"Revenue", "Officer"});
            add(new String[]{"Chief", "Revenue"});
            add(new String[]{"Chief", "Lending"});
            add(new String[]{"Chief", "Product"});
            add(new String[]{"Product", "Officer"});
            add(new String[]{"Banking", "Officer"});
            add(new String[]{"Global", "Operations"});
            add(new String[]{"Chief", "Customer"});
            add(new String[]{"Group", "Chief"});
            add(new String[]{"Management", "Board"});
            add(new String[]{"Chief", "Digital"});
            add(new String[]{"Global", "Sales"});
            add(new String[]{"Deputy", "Chief"});
            add(new String[]{"Customer", "Officer"});
            add(new String[]{"Chief", "Technical"});
            add(new String[]{"Digital", "Officer"});
            add(new String[]{"Innovation", "Officer"});
            add(new String[]{"Global", "Chief"});
            add(new String[]{"Chief", "Banking"});
            add(new String[]{"Technical", "Officer"});
            add(new String[]{"Corporate", "Executive"});
            add(new String[]{"Chain", "Officer"});
            add(new String[]{"Chief", "Sales"});
            add(new String[]{"Chief", "Supply"});
            add(new String[]{"Global", "Head"});
            add(new String[]{"Principal", "Executive"});
            add(new String[]{"Chief", "Corporate"});
            add(new String[]{"Chief", "Innovation"});
            add(new String[]{"Group", "Executive"});
            add(new String[]{"Managing", "Executive"});
            add(new String[]{"Global", "Business"});
            add(new String[]{"Regional", "President"});
            add(new String[]{"Resource", "Officer"});
            add(new String[]{"Sales", "Officer"});
            add(new String[]{"Chief", "Merch"});
            add(new String[]{"Relations", "Officer"});
            add(new String[]{"Co", "Chairman"});
            add(new String[]{"Communications", "Officer"});
            add(new String[]{"Affairs", "Officer"});
            add(new String[]{"Chief", "Growth"});
            add(new String[]{"ising", "Officer"});
            add(new String[]{"Acting", "Chief"});
            add(new String[]{"Officer", "for"});
            add(new String[]{"Deputy", "President"});
            add(new String[]{"Interim", "President"});
            add(new String[]{"Transformation", "Officer"});
            add(new String[]{"Global", "Human"});
            add(new String[]{"Growth", "Officer"});
            add(new String[]{"Chief", "Ethics"});
            add(new String[]{"Chief", "Retail"});
            add(new String[]{"Chief", "Transformation"});
            add(new String[]{"Global", "Supply"});
            add(new String[]{"Independent", "Director"});
            add(new String[]{"Interim", "Principal"});
            add(new String[]{"Chief", "Communications"});
            add(new String[]{"Experience", "Officer"});
            add(new String[]{"Global", "Controller"});
            add(new String[]{"Division", "President"});
            add(new String[]{"Managing", "Corporate"});
            add(new String[]{"Administration", "Officer"});
            add(new String[]{"Chief", "Br"});
            add(new String[]{"Global", "Marketing"});
            add(new String[]{"Deputy", "General"});
            add(new String[]{"Group", "General"});
            add(new String[]{"Management", "Officer"});
            add(new String[]{"Regulatory", "Officer"});
            add(new String[]{"Senior", "Advisor"});
            add(new String[]{"Officer"});
            add(new String[]{"President"});
            add(new String[]{"Chief"});
            add(new String[]{"Executive"});
            add(new String[]{"Senior"});
            add(new String[]{"Director"});
            add(new String[]{"General"});
            add(new String[]{"Principal"});
            add(new String[]{"Chairman"});
            add(new String[]{"Board"});
            add(new String[]{"Controller"});
            add(new String[]{"Global"});
            add(new String[]{"Manager"});
            add(new String[]{"Managing"});
        }};
        positionSet = new ArrayList<>();
        for(String[] desc : keyWorkList) {
            positionSet.add(new HashSet<>(Arrays.asList(desc)));
        }
    }

    public static ArrayList<String> TitleStandard(String s) {
        s = s.toUpperCase();
        s = s.replace("-", " ");
        s = s.replace(" the ", " ");
        s = s.replace("&", " ");
        String[] splitNames = Common.MultiSplit(s, new String[]{",", "and", ";", "of the", " of the ", " of ", " the "}).toArray(new String[0]);
        return (ArrayList<String>) Arrays.stream(splitNames).filter(x -> !x.equals("")).collect(Collectors.toList());
    }

    public static ArrayList<String> GetPosition(String s) {
        ArrayList<String> positionList = new ArrayList<>();
        ArrayList<String[]> wordsList = (ArrayList<String[]>) TitleStandard(s).stream().map(x -> x.split(" "))
            .collect(Collectors.toList());
        for (String[] words : wordsList) {
            HashSet<String> wordDescSet = new HashSet<>(Arrays.asList(words));
            for (String[] keyList : keyWorkList) {
                HashSet<String> position = Arrays.stream(keyList).map(String::toUpperCase).collect(Collectors.toCollection(HashSet::new));
                if (wordDescSet.containsAll(position)) {
                    positionList.add(String.join(" ", Arrays.asList(keyList)));
                    break;
                }
            }
        }
        return positionList;
    }

    public Text evaluate(Text s) {
        String name = s.toString();
        ArrayList<String> posList = GetPosition(name);
        return new Text(String.join("|", posList));
    }
}
