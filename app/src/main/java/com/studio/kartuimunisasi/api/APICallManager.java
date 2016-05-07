package com.studio.kartuimunisasi.api;

import com.studio.kartuimunisasi.utils.Constants;

import retrofit2.Retrofit;

/**
 * Created by NwP.
 */
public class APICallManager {
    public String mEndPoint = Constants.Path.ENDPOINT_RELEASE;
    public static APICallManager mInstance;
    private static Retrofit mRetrofit;

    private final String mContentType = "application/json";
    private String authorizationKey;

    /**
     * singleton class instance
     *
     * @return APICallManager
     */
    public static APICallManager getInstance() {
        if (mInstance == null) {
            synchronized (APICallManager.class) {
                if (mInstance == null) {
                    mInstance = new APICallManager();
                }
            }
        }
        return mInstance;
    }


}
