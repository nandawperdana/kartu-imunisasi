package com.studio.kartuimunisasi.api.history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.studio.kartuimunisasi.api.RootResponseModel;

import java.io.Serializable;

/**
 * Created by nandawperdana on 5/9/2016.
 */
public class VaccineHistoriesModel extends RootResponseModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("child_id")
    @Expose
    private Integer childId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("attribute_id")
    @Expose
    private Integer attributeId;

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
     * @return The childId
     */
    public Integer getChildId() {
        return childId;
    }

    /**
     * @param childId The child_id
     */
    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place The place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return The attributeId
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * @param attributeId The attribute_id
     */
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }
}
