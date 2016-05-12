package com.studio.kartuimunisasi.domains.models;

import com.studio.kartuimunisasi.api.v1.children.ChildrenModel;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class ChildDomain {
    ChildrenModel childrenModel;

    public ChildrenModel getChildrenModel() {
        return childrenModel;
    }

    public void setChildrenModel(ChildrenModel childrenModel) {
        this.childrenModel = childrenModel;
    }
}
