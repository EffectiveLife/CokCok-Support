package com.effectivelife.cokcoksupport.net;

import com.android.volley.Response;
import com.effectivelife.cokcoksupport.api.ApiInfoWithSimpleXml;

/**
 */
public class SimpleXmlRequest<T> extends XmlRequest<T> {

    public SimpleXmlRequest(ApiInfoWithSimpleXml apiInfo, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(apiInfo, listener, errListener);
        addParam("srv_type", "SMART114");
        addParam("api_key", "8bf7b6fd4ca943f");
    }
}
