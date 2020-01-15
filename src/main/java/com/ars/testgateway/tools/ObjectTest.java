package com.ars.testgateway.tools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectTest {

    public static Map<String,String> addressResolution(String address){

        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
//        String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)";
        Matcher m=Pattern.compile(regex).matcher(address);
        Map<String,String> row = new LinkedHashMap<>();
        while(m.find()){
            String province=m.group("province");
            row.put("province", province==null?"":province.trim());
            String city=m.group("city");
            row.put("city", city==null?"":city.trim());
            String county=m.group("county");
            row.put("county", county==null?"":county.trim());
        }
        return row;
    }

    public static void main(String[] args) {
//        Map<String,String> addressList = addressResolution("福建省福州市");
//        List<Map<String,String>> addressList = addressResolution("福建省福州市鼓楼区");
//        System.out.println(addressList);

//        List<String> provinceList = new ArrayList<>();
//        provinceList.add("福建省");
//        provinceList.add("福建省");
//        provinceList.add("福建省");
//        provinceList.add("福建省");
//        provinceList.add("福建省");
//
//        List list = provinceList.stream().distinct().collect(Collectors.toList());
//        System.out.println(list);

//        String str = "福建省";
//        String parent = "福建省福州市鼓楼区";
//        if (parent.contains("")){
//            System.out.println("匹配到了");
//        }

        String str = "350000";
        String code = str.substring(0,2);
        System.out.println(code);
    }
}
