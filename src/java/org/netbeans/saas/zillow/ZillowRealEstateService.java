/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.saas.zillow;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * ZillowRealEstateService Service
 *
 * @author 1
 */
public class ZillowRealEstateService {

    /**
     * Creates a new instance of ZillowRealEstateService
     */
    public ZillowRealEstateService() {
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Throwable th) {
        }
    }

    /**
     *
     * @param unittype
     * @param city
     * @param state
     * @param zIP
     * @param width
     * @param height
     * @param chartduration
     * @return an instance of RestResponse
     */
    public static RestResponse getRegionChart(String unittype, String city, String state, String zIP, String width, String height, String chartduration) throws IOException {
        String apiKey = ZillowRealEstateServiceAuthenticator.getApiKey();
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"zws-id", "" + apiKey + ""}, {"unit-type", unittype}, {"city", city}, {"state", state}, {"ZIP", zIP}, {"width", width}, {"height", height}, {"Chartduration", chartduration}};
        RestConnection conn = new RestConnection("http://www.zillow.com/webservice/GetRegionChart.htm", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
