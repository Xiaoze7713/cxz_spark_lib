package com.custom.util;

import com.custom.utils.Algorithm.EditDistance;
import com.custom.utils.Company.CompanyCode;
import com.custom.utils.CompanyRecognize;
import com.custom.utils.NameLike;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.hadoop.io.Text;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
//        assertTrue( true );
    }
    public void testEditDistance()  {
        int dis = EditDistance.GetEditDistance("ababab", "caababab");
        System.out.println(dis);
        //System.out.println("??");
    }

    public void testNameLikeVal() {
        NameLike n = new NameLike();
        String s1 = "Aaron Zhu Director";
        String s2 = "Aaron what thu Director";
        String sep = "?!-+*()\\|";
        int dis = n.NameLikeVal(s1, s2, sep);
        System.out.println(dis);
        dis = n.NameLikeVal(s1, s2, sep);
        System.out.println(dis);
    }
    public void testCompanyType() {
        System.out.println(CompanyCode.Code.valueOf("CO").ordinal());

    }
    public void testCompany() {
        String[] names = {
                "Allied Esports Entertainment, Inc.",
                "American Renal Associates Holdings, Inc.",
                "Stoddard Hill Media Holdings, LLC",
                "MPC Hudson LLC",
                "Makena Developed Markets Master Fund B, L.P.",
                "Daeg Partners, L.P.",
                "Tekne Capital Management, LLC",
                "Gemridge Technologies Inc",
                "PCCP CAPITAL II, L.P.",
                "Medical Engineering Innovations, Inc.",
                "ESPORTSUNITED LLC",
                "REDBACK NETWORKS INC",
                "RND Capital Systematic Alpha Fund, LP",
                "Tyson Prepared Foods, Inc.",
                "South Florida Secure Fund, LLC",
                "PACIFIC NORTHWEST HOLDING Co LLC",
                "Cambridge Rockwall MOB II, Ltd.",
                "ASAP Environmental Inc.",
                "EXTRAORDINARIES, INC.",
                "CRC Single Investor Fund XII, LP",
                "Prellis Biologics, Inc",
                "CREDIT SUISSE REAL ESTATE SECURITIES CORE FUND L P",
                "Natures Sunshine Products Inc",
                "FAST MODEL TECHNOLOGIES, LLC",
                "ADEN SOLUTIONS INC.",
                "Bulletproof Brands Co Inc",
                "China Skyrise Digital Service Inc.",
                "ULTRA URANIUM CORP /FI",
                "CHG HOLDINGS, INC.",
                "Bering Growth CORP",
                "MORNINGSIDE PARK CLO, LTD"
        };
        CompanyRecognize crz = new CompanyRecognize();
        for (String name : names) {
            System.out.println(name + " || " + crz.evaluate(new Text(name)).toString());
        }
    }
}

