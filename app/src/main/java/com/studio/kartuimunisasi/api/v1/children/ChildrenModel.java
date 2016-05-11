package com.studio.kartuimunisasi.api.v1.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.studio.kartuimunisasi.api.RootResponseModel;

import java.io.Serializable;

/**
 * Created by NwP.
 */
public class ChildrenModel extends RootResponseModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("birthplace")
    @Expose
    private String birthplace;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("weight")
    @Expose
    private Double weight;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("FileNameFoto")
    @Expose
    private String FileNameFoto;
    @SerializedName("PathFoto")
    @Expose
    private String PathFoto;
    @SerializedName("gender")
    @Expose
    private String gender;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return The birthplace
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * @param birthplace The birthplace
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * @return The birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday The birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return The weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return The height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * @return The FileNameFoto
     */
    public String getFileNameFoto() {
        return FileNameFoto;
    }

    /**
     * @param FileNameFoto The FileNameFoto
     */
    public void setFileNameFoto(String FileNameFoto) {
        this.FileNameFoto = FileNameFoto;
    }

    /**
     * @return The PathFoto
     */
    public String getPathFoto() {
        return PathFoto;
    }

    /**
     * @param PathFoto The PathFoto
     */
    public void setPathFoto(String PathFoto) {
        this.PathFoto = PathFoto;
    }

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
