package com.effectivelife.cokcoksupport.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.effectivelife.cokcoksupport.api.ApiInfoWithSimpleXml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.UnsupportedEncodingException;

/**
 */
public class SimpleXmlRequest<T> extends BaseRequest<T> {

    private final Class<T> mClass;
    private final Response.Listener<T> listener;
    private static final Serializer serializer = new Persister();

    private SimpleXmlRequest(int method, String url, Class<T> paramClass, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(method, url, errListener);
        this.mClass = paramClass;
        this.listener = listener;
        addParam("srv_type", "SMART114");
        addParam("api_key", "8bf7b6fd4ca943f");
    }

    public SimpleXmlRequest(ApiInfoWithSimpleXml apiInfo, Response.Listener<T> listener, Response.ErrorListener errListener) {
        this(apiInfo.method, apiInfo.host+apiInfo.path, apiInfo.bindingClass, listener, errListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String data = new String(response.data, "UTF-8");
            return Response.success(serializer.read(mClass, data), HttpHeaderParser.parseCacheHeaders(response));
        } catch(UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e) {
            return Response.error(new VolleyError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
