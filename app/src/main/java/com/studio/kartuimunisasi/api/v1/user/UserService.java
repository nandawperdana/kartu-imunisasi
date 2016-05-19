package com.studio.kartuimunisasi.api.v1.user;

import com.studio.kartuimunisasi.api.v1.children.ChildrenModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by NwP.
 */
public interface UserService {
    /**
     * register user (POST)
     *
     * @param email
     * @param password
     */
    @POST("/users/signup")
    Call<UsersModel>
    signUp(@Field("email") String email,
           @Field("password") String password);


    /**
     * login user (POST)
     *
     * @param email
     * @param password
     */
    @FormUrlEncoded
    @POST("/users/authenticate")
    Call<UsersModel>
    login(@Field("email") String email,
          @Field("password") String password);


    /**
     * login user (POST)
     *
     * @param token
     */
    @FormUrlEncoded
    @GET("/facebook/{token}")
    Call<UsersModel>
    login(@Field("token") String token);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorization
     * @param Id
     * @param name
     * @param country
     * @param state
     * @param address
     * @param phone
     * @param tempatLahir
     * @param tglLahir
     */
    @FormUrlEncoded
    @PUT("/users/{id}")
    Call<UsersModel> putEdit(@Header("authorization") String authorization,
                             @Path("id") Integer Id,
                             @Field("name") String name,
                             @Field("country") String country,
                             @Field("state") String state,
                             @Field("address") String address,
                             @Field("phone") String phone,
                             @Field("tempatLahir") String tempatLahir,
                             @Field("tglLahir") String tglLahir);

    /**
     * return the user's data (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/users/{id}")
    Call<UsersModel> getUser(@Header("authorization") String authorization,
                             @Path("id") Integer Id);

    /**
     * return the list of users (GET)
     */
    @GET("/users")
    Call<UsersModel> getUsers();

    /**
     * return the list of children by user_id (GET)
     *
     * @param authorization
     * @param Id
     */
    @GET("/users/{id}/children")
    Call<ChildrenModel> getChildren(@Header("authorization") String authorization,
                                    @Path("id") Integer Id);

    /**
     * return the list of child by user_id and child_id (GET)
     *
     * @param authorization
     * @param Id
     * @param Id            child
     */
    @GET("/users/{user_id}/children/{id}")
    Call<ChildrenModel> getChildrenById(@Header("authorization") String authorization,
                                        @Path("user_id") Integer userId,
                                        @Path("id") Integer Id);

    @Multipart
    @POST("/users/{id}/upload")
    Call<UsersModel> postUploadImage(@Header("authorization") String authorization,
                                     @Part("image") RequestBody image);

    /**
     * put the update of user's data (PUT)
     *
     * @param authorizationKey
     * @param snsRegistrationId
     */
    @FormUrlEncoded
    @PUT("/users")
    Call<UsersModel> putUsersSNSRegistrationId(@Header("authorization") String authorizationKey,
                                               @Field("gcm_id") String snsRegistrationId);
}
