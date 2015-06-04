package com.effectivelife.cokcoksupport.api;

/**
 * Created by com on 2015-06-03.
 */
public class ApiResult {
    public int code;
    public String message;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApiResult @"+getClass().getSimpleName()+": code="+this.code+", message='"+this.message+"'");
        return sb.toString();
    }

}
