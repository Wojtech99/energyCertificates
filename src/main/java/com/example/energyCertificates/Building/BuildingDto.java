package com.example.energyCertificates.Building;

import com.example.energyCertificates.Building.Enums.BuildingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDto implements Comparable<BuildingDto>{
    private Date date;
    private String city;
    private String street;
    private int houseNumber;
    private int flatNumber;
    private String postalCode;
    private BuildingType buildingType;



    @Override 
    public int compareTo(BuildingDto o) {
        int buildingSendForm = this.date.compareTo(o.date);
        int cityCompare = this.city.compareTo(o.city);
        int streetCompare = this.street.compareTo(o.street);
        int postalCodeCompare = this.postalCode.compareTo(o.postalCode);
        int dateCompare = this.date.compareTo(o.date);

        if (dateCompare != 0) {
            return -dateCompare;
        } else if (buildingSendForm != 0) {
            return buildingSendForm;
        } else if ( cityCompare != 0) {
            return cityCompare;
        } else if (streetCompare != 0) {
            return streetCompare;
        } else if (postalCodeCompare != 0) {
            return postalCodeCompare;
        }

        if (this.houseNumber > o.houseNumber) {
            return 1;
        } else {
            return 0;
        }
    }
}
