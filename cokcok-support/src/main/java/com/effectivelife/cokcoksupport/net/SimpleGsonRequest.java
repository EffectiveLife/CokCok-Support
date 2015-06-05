package com.effectivelife.cokcoksupport.net;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.effectivelife.cokcoksupport.api.ApiInfo;
import com.effectivelife.cokcoksupport.api.ApiResult;

/**
 * @author JayD
 */
public class SimpleGsonRequest<T extends ApiResult> extends GsonRequest<T> {

    public SimpleGsonRequest(ApiInfo paramApiInfo, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(paramApiInfo, listener, errListener);
        setShouldCache(false);
        setRetryPolicy(new DefaultRetryPolicy(paramApiInfo.connectionTimeout, paramApiInfo.retryCount, 1.0F));
        addParam("srv_type", "SMART114");
        addParam("api_key", "8bf7b6fd4ca943f");
    }

}
