package com.effectivelife.cokcoksupport.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 */
public abstract class BaseRequest<T> extends Request<T> {

    private Map<String, String> mHeaders = new HashMap<String, String>();
    private Map<String, String> mParams = new HashMap<String, String>();
    private String charset = "UTF-8";

    public BaseRequest(int method, String url, Response.ErrorListener errListener) {
        super(method, url, errListener);
    }

    private String makeGetUrl(String url, Map<String, String> paramMap, String charset) {
        if(paramMap != null && !paramMap.isEmpty()) {
            StringBuilder getUrl = new StringBuilder(url);
            getUrl.append("?");
            try {
                for(Map.Entry<String, String> entry : paramMap.entrySet()) {
                    getUrl.append(URLEncoder.encode(entry.getKey(), charset));
                    getUrl.append("=");
                    getUrl.append(URLEncoder.encode(entry.getValue(), charset));
                    getUrl.append("&");
                }
                return getUrl.toString();

            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Encoding not supported: "+charset, e);
            }

        } else {
            return url;
        }
    }

    public void addHeader(String key, String value) {
        this.mHeaders.put(key, value);
    }

    public void addParam(String key, String value) {
        this.mParams.put(key, value);
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.mHeaders;
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return this.mParams;
    }

    @Override
    public String getUrl() {
        if(getMethod() == Method.GET) {
            try {
                String retUrl = makeGetUrl(super.getUrl(), getParams(), this.charset);
                return retUrl;
            } catch (AuthFailureError authFailureError) {
                return super.getUrl();
            }
        } else {
            return super.getUrl();
        }

    }

}