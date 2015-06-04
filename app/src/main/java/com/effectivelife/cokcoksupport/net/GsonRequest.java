package com.effectivelife.cokcoksupport.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.effectivelife.cokcoksupport.api.ApiResult;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @author JayD
 */
public abstract class GsonRequest<T> extends BaseRequest<T> {

    private Class<? extends ApiResult> mClass;
    private final Gson gson = new Gson();
    private final Response.Listener<T> listener;

    public GsonRequest(int method, String url, Class<? extends ApiResult> paramClass, Response.Listener<T> listener, Response.ErrorListener errListener) {
        super(method, url, errListener);
        this.mClass = paramClass;
        this.listener = listener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String str = new String(response.data);
        try {
            Response res = Response.success(this.gson.fromJson(str, this.mClass), HttpHeaderParser.parseCacheHeaders(response));
            return res;
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

}
