package com.effectivelife.cokcoksupport.api;

import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;

/**
 * Created by com on 2015-06-03.
 */
public class ApiInfo {
    public Class<? extends ApiResult> bindingClass;
    public int connectionTimeout = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
    public String host;
    public int method = Request.Method.GET;
    public String path;
    public int retryCount = 0;

    public ApiInfo(String host, String path, Class<? extends ApiResult> paramClass) {
        setHost(host);
        setPath(path);
        setBindingClass(paramClass);
    }

    public ApiInfo setBindingClass(Class<? extends ApiResult> paramClass) {
        if(paramClass == null) {
            throw new IllegalArgumentException("'result bindingClass is null.");
        }
        this.bindingClass = paramClass;
        return this;
    }

    public ApiInfo setPath(String path) {
        if(TextUtils.isEmpty(path)) {
            throw new IllegalArgumentException("'path' is empty.");
        }
        this.path = path;
        return this;
    }

    public ApiInfo setHost(String host) {
        if(TextUtils.isEmpty(host)) {
            throw new IllegalArgumentException("'host' is empty.");
        }
        this.host = host;
        return this;
    }

    public ApiInfo setMethod(int method) {
        this.method = method;
        return this;
    }

    public ApiInfo setConnectionTimeout(int timeout) {
        this.connectionTimeout = timeout;
        return this;
    }

    public ApiInfo setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

}
