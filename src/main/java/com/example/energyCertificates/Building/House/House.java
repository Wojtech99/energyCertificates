import com.example.energyCertificates.Data.Data;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Basic data of the flat
    private String street;
    private int houseNumber;
    private int flatNumber;
    private String postalCode;
    private String city;
    private double usableArea;
    private double VolumeOfHouse;
    private int yearOfCommissioningOfTheBuilding;
    //Heating
    private HeatingType heatingType;
    private String typeOfHeatingWithFurnaceModel;
    private RadiatorsType radiatorsType;
    private boolean areInstallationCablesInsulted;
    private boolean isThereHeatingCirculation;
    private boolean isThereHeatingBufferOrTank;
    private boolean isThereSecondaryHeatingType;
    private HeatingType secondaryHeatingType;
    private String secondaryTypeOfHeatingWithFurnaceModel;
    private RadiatorsType secondaryRadiatorsType;
    private boolean secondaryAreInstallationCablesInsulted;
    private boolean secondaryIsThereHeatingCirculation;
    private boolean secondaryIsThereHeatingBufferOrTank;
    private int percentOfUsageSecondaryHeatingType;
    //Hot water
    private HeatingOfWaterType heatingOfWaterType;
    private String typeOfHeatingWaterWithFurnaceModel;
    private boolean areWaterInstallationCablesInsulted;
    private boolean isThereHeatWaterCirculation;
    private boolean isThereHeatWaterBufferOrTank;
    private boolean isThereSecondaryHeatingOfWaterType;
    private HeatingOfWaterType secondaryHeatingOfWaterType;
    private String secondaryTypeOfHeatingWaterWithFurnaceModel;
    private boolean secondaryAreWaterInstallationCablesInsulted;
    private boolean secondaryIsThereHeatWaterCirculation;
    private boolean secondaryIsThereHeatWaterBufferOrTank;
    //Ventilation
    private VentilationType ventilationType;
    //Ceiling
    private CeilingOverTheFlatType ceilingOverTheFlatType;
    private CeilingBelowTheFlatType ceilingBelowTheFlatType;
    private FloorNumberInTheBuilding floorNumberInTheBuilding;
    //Windows and entrance door
    private EntranceDoorType entranceDoorType;
    private WindowFrameMaterial windowFrameMaterial;
    private NumberOfGlasses numberOfGlasses;
    //Layout and type of External Walls
    private ExternalMaterialWallsType externalMaterialWallsType;
    private int externalMaterialWallsThicknessInCentimeters;
    private ExternalIsolationWallsType externalIsolationWallsType;
    private int externalIsolationWallsThicknessInCentimeters;
    private boolean areThereAnyUnheatedRoomsInHouse;
    private List<UnheatedRoom> unheatedRoomList;
    private boolean isHouseBuildCorrectly;
    private String HouseNotBuildCorrectlyInformation;
    private boolean hasHouseAirConditioning;
    private int airConditioningPowerInKw;
    private boolean hasInstalledRecuperator;
    private String recuperatorModel;
    //Attachments
    @OneToMany(fetch = FetchType.EAGER)
    private List<Data> attachments;
    private String additionalInformation;
    //Other
    private Date sendFormDate;
    private boolean certificationIsCompleted;



}
