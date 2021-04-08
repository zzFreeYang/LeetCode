package Test.Study.Base;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class A20210322httpURLConnection {


    public static void main(String[] args) throws IOException {
        try{
            final Logger rootLogger = Logger.getLogger("sun.util.logging.PlatformLogger");
            rootLogger.setLevel(Level.ALL);
            rootLogger.info("111111111111111");
            String result = "";
        BufferedReader br = null;
        BufferedWriter bw = null;
        HttpURLConnection httpURLConnection = null;
        URL realUrl = new URL("http://127.0.0.1:8080");
        // 打开和URL之间的连接
        httpURLConnection = (HttpURLConnection) realUrl.openConnection();
        // 设置通用的请求属性
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // 指示应用程序要将数据写入URL连接,其值默认为false
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(30000); // 30秒连接超时
        httpURLConnection.setReadTimeout(30000); // 30秒读取超时

        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            // 建立实际的连接
        System.out.println("!!!!!!!!!!!!!!  to connect !!!!!!!!!!!!!!!!!!!");
        httpURLConnection.connect();
        System.out.println("~~~~~~~~~~~~~~    connected ~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1111");
        bw = new BufferedWriter(new OutputStreamWriter(
                httpURLConnection.getOutputStream(), "GBK"));
        bw.write("body");
        bw.flush();
        br = new BufferedReader(new InputStreamReader(
                httpURLConnection.getInputStream(), "GBK"));
        String line;
        StringBuffer resultBF = new StringBuffer();
        resultBF.setLength(0);
        System.out.println(" ￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥  reday to ￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
        while (true) {
            line = br.readLine();
            if (null == line) {
                break;
            }
            resultBF.append(line);
            if ("".equals(line)) {
                break;
            }
        }
        result = resultBF.toString();
        System.out.println("result = "+ result);
    } catch (Exception e) {
        System.out.println("交易连接出错"+e.getMessage());
    }
    }}


