package org.coodex.example;

import org.coodex.concrete.api.mockers.VehicleNum;
import org.coodex.pojomocker.annotations.INTEGER;

public class VehicleInfo {
    @VehicleNum
    private String plateCode;

    @INTEGER(range = {1, 2, 3, 4, 5, 9})
    private Integer plateColor;

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }
}
