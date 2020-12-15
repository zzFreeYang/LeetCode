package Test.Study.Base;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class A20201215 {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject data1 = new JSONObject();
        JSONObject data = new JSONObject();


        System.out.println("现在演示JsonObject的输出格式");
        jsonObject.put("kh","B20869321");
        jsonObject.put("sbm","330781D1560000050008316AA083CDB1");
        System.out.println(jsonObject.toString());    //{"kh":"B20869321","sbm":"330781D1560000050008316AA083CDB1"}
        System.out.println("现在演示JsonArray的输出格式");
        jsonArray.add(jsonObject);
        System.out.println(jsonArray.toString());    //[{"kh":"B20869321","sbm":"330781D1560000050008316AA083CDB1"}]

        data1.put("kxx",jsonArray);
        data.put("data",data1);
        System.out.println("现在有"+data.toString());

        //=======================================
        System.out.println("现在有了一个 JsonObject，如何解析到Kh+sbm输出呢？"); //JsonArray的复杂解析

        JSONObject dataget = data.getJSONObject("data");
        System.out.println("得到一个JSONObject"+dataget.toString());
        /**JSONObject dataget2 = dataget.getJSONObject("kxx"); //这样解析会报错，报错:JSONObject["kxx"] is not a JSONObject.*/
         JSONArray dataget2  =   dataget.getJSONArray("kxx");
        System.out.println("用getJSONArray解析，此时kxx中的数据为"+dataget2); //[{"kh":"B20869321","sbm":"330781D1560000050008316AA083CDB1"}]

        //做法1: []括起来的就是JsonArray，在这里是[{"kh":"B20869321","sbm":"330781D1560000050008316AA083CDB1"}]，
        //也可能是[{"kh":"B20869321","sbm":"330781D1560000050008316AA083CDB1"},{"kh":"11","sbm":"11"}]
        List<String> dataList3 = new ArrayList<>();
        for(int i = 0 ; i < dataget2.size(); i++){
            JSONObject dataTemp4 = dataget2.getJSONObject(i);
            String kh = dataTemp4.getString("kh");
            String sbm = dataTemp4.getString("sbm");
            dataList3.add(kh);
            dataList3.add(sbm);
//            System.out.println(dataList3);   //将第一个大类中的kxx的数据放在dataList中输出
            System.out.println("输出我们要的kh+sbm = " + kh + sbm);
        }





    }
}
