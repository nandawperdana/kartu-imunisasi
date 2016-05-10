package com.studio.kartuimunisasi.api;

import com.studio.kartuimunisasi.BuildConfig;
import com.studio.kartuimunisasi.api.children.ChildrenModel;
import com.studio.kartuimunisasi.api.children.ChildrenService;
import com.studio.kartuimunisasi.api.history.VaccineHistoriesModel;
import com.studio.kartuimunisasi.api.history.VaccineHistoryService;
import com.studio.kartuimunisasi.api.user.UserService;
import com.studio.kartuimunisasi.api.user.UsersModel;
import com.studio.kartuimunisasi.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NwP.
 */
public class APICallManager {
    public String mEndPoint = Constants.Paths.ENDPOINT_RELEASE;
    public static APICallManager mInstance;
    private static Retrofit mRetrofit;

    private final String mContentType = "application/json";
    private String authorizationKey;

    public UserManager userManager;
    public ChildrenManager childrenManager;
    public HistoryManager historyManager;

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

    public APICallManager() {
        if (BuildConfig.BUILD_RELEASE)
            mEndPoint = Constants.Paths.ENDPOINT_RELEASE;

        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(mEndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        // registering API endpoint manager
        this.userManager = new UserManager();
        this.childrenManager = new ChildrenManager();
        this.historyManager = new HistoryManager();
    }

    public static <T> T getService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public String getAuthorizationKey() {
        return authorizationKey;
    }

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    public class UserManager {
        public Call<UsersModel> login(String email, String password) {
            UserService service = getService(UserService.class);
            return service.login(email, password);
        }

        public Call<UsersModel> signUp(String email, String password) {
            UserService service = getService(UserService.class);
            return service.signUp(email, password);
        }

        public Call<UsersModel> getUsers() {
            UserService service = getService(UserService.class);
            return service.getUsers();
        }

        public Call<UsersModel> edit(Integer id, String name, String country, String state,
                                     String address, String phone, String birthPlace,
                                     String birthDate) {
            UserService service = getService(UserService.class);
            return service.putEdit(getAuthorizationKey(), id, name, country, state, address, phone,
                    birthPlace, birthDate);
        }

        public Call<UsersModel> getUser(Integer id) {
            UserService service = getService(UserService.class);
            return service.getUser(getAuthorizationKey(), id);
        }

        public Call<ChildrenModel> getChildren(Integer id) {
            UserService service = getService(UserService.class);
            return service.getChildren(getAuthorizationKey(), id);
        }

        public Call<ChildrenModel> getChildrenById(Integer userId, Integer id) {
            UserService service = getService(UserService.class);
            return service.getChildrenById(getAuthorizationKey(), userId, id);
        }

        public Call<UsersModel> uploadImage(RequestBody image) {
            UserService service = getService(UserService.class);
            return service.postUploadImage(getAuthorizationKey(), image);
        }
    }

    public class ChildrenManager {
        public Call<ChildrenModel> create(String name, Integer userId, String birthPlace,
                                          String birthDay, Double weight, Double height,
                                          String gender) {
            ChildrenService service = getService(ChildrenService.class);
            return service.postCreateChildren(getAuthorizationKey(), name, userId, birthPlace,
                    birthDay, weight, height, gender);
        }

        public Call<ChildrenModel> edit(String name, Integer id, Integer userId, String birthPlace,
                                        String birthDay, Double weight, Double height,
                                        String gender) {
            ChildrenService service = getService(ChildrenService.class);
            return service.putEdit(getAuthorizationKey(), id, name, userId,
                    birthPlace, birthDay, weight, height, gender);
        }

        public Call<ChildrenModel> getChildren() {
            ChildrenService service = getService(ChildrenService.class);
            return service.getChildren();
        }

        public Call<ChildrenModel> getChildrenById(Integer id) {
            ChildrenService service = getService(ChildrenService.class);
            return service.getChildrenById(getAuthorizationKey(), id);
        }

        public Call<VaccineHistoriesModel> getHistories(Integer id) {
            ChildrenService service = getService(ChildrenService.class);
            return service.getHistories(getAuthorizationKey(), id);
        }

        public Call<VaccineHistoriesModel> getHistory(Integer childId, Integer id) {
            ChildrenService service = getService(ChildrenService.class);
            return service.getHistory(getAuthorizationKey(), childId, id);
        }

        public Call<ChildrenModel> uploadImage(RequestBody image) {
            ChildrenService service = getService(ChildrenService.class);
            return service.postUploadImage(getAuthorizationKey(), image);
        }
    }

    public class HistoryManager {
        public Call<VaccineHistoriesModel> getHistories() {
            VaccineHistoryService service = getService(VaccineHistoryService.class);
            return service.getHistories();
        }

        public Call<VaccineHistoriesModel> getHistoryById(Integer id) {
            VaccineHistoryService service = getService(VaccineHistoryService.class);
            return service.getHistory(getAuthorizationKey(), id);
        }

        public Call<VaccineHistoriesModel> edit(Integer id, Integer childId, String date,
                                                String place, Integer attributeId) {
            VaccineHistoryService service = getService(VaccineHistoryService.class);
            return service.putEdit(getAuthorizationKey(), id, childId, date, place, attributeId);
        }
    }
}
