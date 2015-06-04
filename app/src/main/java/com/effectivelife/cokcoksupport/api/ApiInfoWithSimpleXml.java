package com.effectivelife.cokcoksupport.api;

import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;

/**
 * Created by com on 2015-06-03.
 */
public class ApiInfoWithSimpleXml {
    public Class bindingClass;
    public int connectionTimeout = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
    public String host;
    public int method = Request.Method.GET;
    public String path;
    public int retryCount = 0;

    public ApiInfoWithSimpleXml(String host, String path, Class paramClass) {
        setHost(host);
        setPath(path);
        setBindingClass(paramClass);
    }

    public ApiInfoWithSimpleXml setBindingClass(Class paramClass) {
        if(paramClass == null) {
            throw new IllegalArgumentException("'result bindingClass is null.");
        }
        this.bindingClass = paramClass;
        return this;
    }

    public ApiInfoWithSimpleXml setPath(String path) {
        if(TextUtils.isEmpty(path)) {
            throw new IllegalArgumentException("'path' is empty.");
        }
        this.path = path;
        return this;
    }

    public ApiInfoWithSimpleXml setHost(String host) {
        if(TextUtils.isEmpty(host)) {
            throw new IllegalArgumentException("'host' is empty.");
        }
        this.host = host;
        return this;
    }

    public ApiInfoWithSimpleXml setMethod(int method) {
        this.method = method;
        return this;
    }

    public ApiInfoWithSimpleXml setConnectionTimeout(int timeout) {
        this.connectionTimeout = timeout;
        return this;
    }

    public ApiInfoWithSimpleXml setRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

}
