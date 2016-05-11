package com.studio.kartuimunisasi.api.v1.attributes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.studio.kartuimunisasi.api.RootResponseModel;

import java.io.Serializable;

/**
 * Created by nandawperdana on 5/9/2016.
 */
public class AttributesModel extends RootResponseModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;

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
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }
}
