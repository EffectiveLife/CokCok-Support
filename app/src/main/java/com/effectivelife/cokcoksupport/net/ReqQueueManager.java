package com.effectivelife.cokcoksupport.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.effectivelife.cokcoksupport.custom.BitmapLruCache;

/**
 * Created by com on 2015-06-03.
 */
public class ReqQueueManager {

    private static volatile ReqQueueManager sInstance;

    private RequestQueue mRequestQueue;
    private static Context mContext;

    private ImageLoader mImageLoader;

    private ReqQueueManager(Context context) {
        mContext = context;
        mRequestQueue = getReqQueue();
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache());
    }

    public static ReqQueueManager getInstance(Context context) {
        if(sInstance == null) {
            sInstance = new ReqQueueManager(context);
        }
        return sInstance;
    }

    public RequestQueue getReqQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        mRequestQueue.add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
