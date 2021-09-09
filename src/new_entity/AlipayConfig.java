package new_entity;

import java.io.FileWriter;
import java.io.IOException;


public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id =  "2021000117680591";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDMPzyfq3yVGCYDNAXNpPnwivnMqb3kPcUeBh+1sK8GdaJXA/GtSu7h2E4cbV87HBhjeK4IQOXtqPozvbrNEebXHPAcAs34lZ2GVGAVoa9nHVzmfCFs92aUcGu6o+5lMgxDdU/Ucw3Nv6T6aHnvGOHCKJFR3sjh3X/22B+bSscqQh5gNTAFYWhwzhaAivOm/8fz2oiNmU9exr79uyxOJJEz0djky9Co/LMKXzBOxG6qQryG4m+//tmWj3fr2fnxtTZ2H1FCta2G1DtGGhOS7UKg6F3OYrYWjcFvvqmD1nOQeDTUKUl4NYJCkK1qvteSRfOqBv/W3YdxaIrQbPRJP4ETAgMBAAECggEAcZwDNrWGuNAT5Ng9GiRYOqqzRFpum9SYHpk9biz3TlqEkG5LMh9qPQm6eSmFPTXlgv8PntuqicXiVoGEtKjuhF0+WfZdZ5ahZqTsRVwIWw0ELdiCJ0B+OLdH1St2YaezFprcasoMtZOSSw9uM8bdXMh//NA1YR16Hm4dNp4jpqbdBbiN4oxGkWBrxJ96rr4QJTo0WsbXDnXZl7TVp+wrMvWejAWogJQ4yYjOnntklMXn5BSdU7fvFmCt/ynX6tD8siwec+XKcQLsezJ+uAcAFwc4Gvd6ELLxBXaKyjSdfB+E9zXg38PBkZLWYhT+vg8ggSdm8z7GRqQZic/ppxAh0QKBgQD7ShemO/GwLeajIZj5JasU6V1a25+SmiBJEZ3oTrKyPyCr1T02uPRiTg26dzpZQGUiGnbA3Evq5i6uFuETm5iJ5dULWfSNPH30irCyOUwOjUT5aG8M8bY+iQa7qWff9BW8TMqeFSZZoaEjxgNdyMsLNVv0UDkEh9YecfOe5cPClQKBgQDQE2TDgSUpGiNmseMGf4chDBLYkzVYj7GgSRNpElKZQZG37VsUiR50dDpBub/pOfuDvaPPwKz4uqH0fOy3DlI3qHvuogHthphOTTFiEBA+PsL1JU4eMcxju3oH1NieiGQ0a0J3YWXAXNBp/lD64dXRZ9+r2KAz8N9ua5T2ybuzBwKBgAiYtkpnjpMaXuOByLvtP/cNLLZpAQKA503YnnBOEOrsIe/+8YMnvKSISwvv/D0FaPBLu3hJkQdOLJakDbsf/Y3qIOmsgCM8yIpPHFBciW+OAagOnI3yzutAwMw2tWkB7qRsdBoIWzGByANzSLYyok+V2bl37RtskjSkbVMoRRQpAoGAA6kjr7DY94UnNEpS5S1fMjylJDxKxvkYNeqzNbkFzP5zUtoRLSZQa9oToE5lSvQjMakndaM9J88YxFViUMImviXvsD4XbJdenJoNEV2Y+49dHLUAT9Wuc967geHDwd5CbQ2qCLGk+aJoZET+JbvNaDa8n6hbAS7ur2GjKEhaTgcCgYEA27pnRCP5brzVkA5oCuwGVR/gZ36tIjJRafREpNMaoriqcfMvQv+3GK0MlGaEaZnYVxWanxTzW/7h5LtNY/TuVTwVXJTfW6Pl4gMr5HJy20QaRE4gM8l3egKoMGZT9HSf0Cf9KKKG8ereHj07HuG72ms/BKZu5kzN9nIf2kXnTiA=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzD88n6t8lRgmAzQFzaT58Ir5zKm95D3FHgYftbCvBnWiVwPxrUru4dhOHG1fOxwYY3iuCEDl7aj6M726zRHm1xzwHALN+JWdhlRgFaGvZx1c5nwhbPdmlHBruqPuZTIMQ3VP1HMNzb+k+mh57xjhwiiRUd7I4d1/9tgfm0rHKkIeYDUwBWFocM4WgIrzpv/H89qIjZlPXsa+/bssTiSRM9HY5MvQqPyzCl8wTsRuqkK8huJvv/7Zlo9369n58bU2dh9RQrWthtQ7RhoTku1CoOhdzmK2Fo3Bb76pg9ZzkHg01ClJeDWCQpCtar7XkkXzqgb/1t2HcWiK0Gz0ST+BEwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/BookStore/Npayment.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/BookStore/PayFinishServlet";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

