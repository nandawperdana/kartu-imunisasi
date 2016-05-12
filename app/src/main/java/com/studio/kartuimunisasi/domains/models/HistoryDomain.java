package com.studio.kartuimunisasi.domains.models;

import com.studio.kartuimunisasi.api.v1.history.VaccineHistoriesModel;

/**
 * Created by nandawperdana on 5/12/2016.
 */
public class HistoryDomain {
    VaccineHistoriesModel vaccineHistoriesModel;

    public VaccineHistoriesModel getVaccineHistoriesModel() {
        return vaccineHistoriesModel;
    }

    public void setVaccineHistoriesModel(VaccineHistoriesModel vaccineHistoriesModel) {
        this.vaccineHistoriesModel = vaccineHistoriesModel;
    }
}
