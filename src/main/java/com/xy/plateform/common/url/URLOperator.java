package com.xy.plateform.common.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author zanhonglei
 * @version V1.0
 * @Description:
 * @date 2020/2/15
 */
public class URLOperator {
    /**
     * 对URL进行编码,只处理中文
     * 例子:
     * http://www.xyblog.vip/您好.jpg
     * http://www.xyblog.vip/%E6%82%A8%E5%A5%BD.jpg
     *
     * @param url
     * @param enc 编码格式
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encode(String url, String enc) throws UnsupportedEncodingException {
        StringBuilder resultUrl = new StringBuilder();
        for (int i = 0; i < url.length(); i++) {
            char charAt = url.charAt(i);
            //只对汉字处理
            if (isChineseChar(charAt)) {
                String encode = URLEncoder.encode(charAt + "", enc);
                resultUrl.append(encode);
            } else {
                resultUrl.append(charAt);
            }
        }
        return resultUrl.toString();
    }

    /**
     * @param url
     * @return
     * @throws UnsupportedEncodingException
     */
    private static String encodeUTF8(String url) throws UnsupportedEncodingException {
        return encode(url, "UTF-8");
    }


    /**
     * 判断汉字的方法,只要编码这个"[\u4e00-\u9fa5]"表达式之间都是汉字
     *
     * @param c
     * @return
     */
    private static boolean isChineseChar(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

    /**
     * 对URL进行解码
     * @param url
     * @param enc
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decode(String url,String enc) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, enc);
    }

    /**
     * 对UTF8解码
     * @param url
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decodeUTF8(String url) throws UnsupportedEncodingException {
        return decode(url, "UTF-8");
    }

}
