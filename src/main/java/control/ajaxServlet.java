/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import com.google.gson.*;
import ConfigVNP.Config;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author lasin
 */
public class ajaxServlet extends HttpServlet{
    Config Config=new Config();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("hi");
        String vnp_Version = "2.1.0";//ok
        String vnp_Command = "pay";//ok
        String vnp_OrderInfo = req.getParameter("vnp_OrderInfo");//
      //  String vnp_OrderInfo="nap nap";//so ghe 
       // String orderType = req.getParameter("ordertype");
        String orderType="250000";
        String vnp_TxnRef = Config.getRandomNumber(8);//ok
//String vnp_TxnRef=""
        String vnp_IpAddr = Config.getIpAddress(req);//ok
//String vnp
        String vnp_TmnCode = Config.vnp_TmnCode;//ok

       int amount = Integer.parseInt(req.getParameter("amount")) * 100;//   !!!!!!!!!!!!!!!!
        System.out.println(vnp_OrderInfo+" "+amount);
   //     int amount=10000000;//chu y
        Map vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
       // String bank_code = req.getParameter("bankcode");
        String bank_code = "";//ok
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

        //String locate = req.getParameter("language");
        String locate = "";//ok
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);//ok
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());//ok

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());//okS
        //Add Params of 2.1.0 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        //Billing
/// 0456783456
/// lasinhmon1@gmail.com
// // tran hoang  vnp_Params.put("vnp_Bill_Mobile", req.getParameter("txt_billing_mobile"));
    //    vnp_Params.put("vnp_Bill_Email", req.getParameter("txt_billing_email"));
  //      String fullName = (req.getParameter("txt_billing_fullname")).trim();
        vnp_Params.put("vnp_Bill_Mobile", "0328395414");//ok//chu y
        vnp_Params.put("vnp_Bill_Email", "lasinhmon1@gmail.com");//ok//chu y
        String fullName = "Vu Truong";
        if (fullName != null && !fullName.isEmpty()) {
            int idx = fullName.indexOf(' ');
            String firstName = fullName.substring(0, idx);
            String lastName = fullName.substring(fullName.lastIndexOf(' ') + 1);
            vnp_Params.put("vnp_Bill_FirstName", firstName);//ok
            vnp_Params.put("vnp_Bill_LastName", lastName);//ok

        }
//vnp_Params.put("vnp_Bill_Address", req.getParameter("txt_inv_addr1"));
 //       vnp_Params.put("vnp_Bill_City", req.getParameter("txt_bill_city"));
 //       vnp_Params.put("vnp_Bill_Country", req.getParameter("txt_bill_country"));
        vnp_Params.put("vnp_Bill_Address", "quan7");
        vnp_Params.put("vnp_Bill_City", "TPHCM");
        vnp_Params.put("vnp_Bill_Country", "VN");
        if (req.getParameter("txt_bill_state") != null && !req.getParameter("txt_bill_state").isEmpty()) {
            vnp_Params.put("vnp_Bill_State", req.getParameter("txt_bill_state"));
        }
        // Invoice
       /* vnp_Params.put("vnp_Inv_Phone", req.getParameter("txt_inv_mobile"));
        vnp_Params.put("vnp_Inv_Email", req.getParameter("txt_inv_email"));
        vnp_Params.put("vnp_Inv_Customer", req.getParameter("txt_inv_customer"));
        vnp_Params.put("vnp_Inv_Address", req.getParameter("txt_inv_addr1"));
        vnp_Params.put("vnp_Inv_Company", req.getParameter("txt_inv_company"));
        vnp_Params.put("vnp_Inv_Taxcode", req.getParameter("txt_inv_taxcode"));
        vnp_Params.put("vnp_Inv_Type", req.getParameter("cbo_inv_type"));*/
        vnp_Params.put("vnp_Inv_Phone", req.getParameter("txt_inv_mobile"));
        vnp_Params.put("vnp_Inv_Email", "hotro@vnpay.vn");
        vnp_Params.put("vnp_Inv_Customer", req.getParameter("txt_inv_customer"));
        vnp_Params.put("vnp_Inv_Address", "quan3, TPHCM");
        vnp_Params.put("vnp_Inv_Company", "Công ty VNPAY");
        vnp_Params.put("vnp_Inv_Taxcode", "20180924080900");
        vnp_Params.put("vnp_Inv_Type", "I");
        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        com.google.gson.JsonObject job = new com.google.gson.JsonObject();
       
        job.addProperty("code", "00");
        job.addProperty("message", "success");
        job.addProperty("data", paymentUrl);
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(job));
    }
	//vui lòng tham khảo thêm tại code demo
	
}
