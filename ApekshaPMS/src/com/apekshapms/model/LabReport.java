package com.apekshapms.model;


import java.time.LocalDate;

public class LabReport {

    private  String Patient_ID ;
    private String Test_ID;
    private  String Patient_Name ;
    private String Type;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //Begin Liver Profile Variables
    private  String SerB ;
    private  String SGPT;
    private  String SGOT;
    private  String SerAlk;
    private  String SerCre;
    private  String SerCal;
    //End Liver Profile Variables

    // Begin Lipid Profile Variables

    private  String SerChol;
    private  String SerTri;
    private  String HDLChol;
    private  String VLDL;
    private  String LDLChol;
    private  String CHOLHDL;
    private  String LDLHDL;

    //End Lipid Profile Variables

    //Begin UFR Variables

    private  String Appearance;
    private  String Reaction;
    private  String Albumin;
    private  String Suger;
    private  String Bile;
    private  String Urobilin;
    private  String PUSCells;
    private  String RBC;
    private  String EpithelialCells;
    private  String Casts;
    private  String Crystals;
    private  String Organisms;

    //End UFR Variables

    //Begin Urine For Bence Jones Protein Variables

    private String Albumine;
    private String BenceJones;

    //End Urine For Bence Jones Protein Variables


    //Begin Serum Electrolytes Variables

    private String Sodium;
    private String Potassium;

    //End Serum Electrolytes Variables

    //Begin Tyroid Profile Variables

    private String TSH;
    private String FreeT3;
    private String FreeT4;

    //End Tyroid Profile Variables

    //Begin Serum Calcium Variables

    private String FreeCalcium;
    private String TotalCalcium;

    //End Serum CalciumVariables

    //Begin Serum Protein Electrophoresis Variables

    private String Albuminee;
    private String Aplha1;
    private String Alpha2;
    private String Beta;
    private String Gamma;


    //End Serum Protein Electrophoresis Variables

    //Begin C-Reactive protein Variables

    private String creactiveprotein;

    //End C Reactive protein Variables Variables

    //Begin Bone Marrow Report Variables

    private String BMBx;
    private String TrephineBMBx;

    //End Bone Marrow Report Variables

    //Begin Full Blood Count Variables

    private  String WBC;
    private  String NE;
    private  String Hb;
    private  String Platelet;


    //End Full Blood Count Variables

    //Begin  Variables


    //End Variables


    public LabReport(){


    }



    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }

    public String getReference() {
        return Reference;    }

    public void setReference(String reference) {this.Reference = reference;}

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        this.Remarks = remarks;
    }

    //Begin Liver Profile Methods
    public String getSerB() {
        return SerB;
    }

    public void setSerB(String serB) {
        SerB = serB;
    }

    public String getSGPT() {
        return SGPT;
    }

    public void setSGPT(String SGPT) {
        this.SGPT = SGPT;
    }

    public String getSGOT() {
        return SGOT;
    }

    public void setSGOT(String SGOT) {
        this.SGOT = SGOT;
    }

    public String getSerAlk() {
        return SerAlk;
    }

    public void setSerAlk(String serAlk) {
        this.SerAlk = serAlk;
    }

    public String getSerCre() {
        return SerCre;
    }

    public void setSerCre(String serCre) {
        this.SerCre = serCre;
    }

    public String getSerCal() {
        return SerCal;
    }

    public void setSerCal(String serCal) {
        this.SerCal = serCal;
    }

//End  Liver Profile Methods

//Begin Lipid profile Methods
public String getSerChol() {
    return SerChol;
}

    public void setSerChol(String serChol) {
        this.SerChol = serChol;
    }

    public String getSerTri() {
        return SerTri;
    }

    public void setSerTri(String serTri) {
        this.SerTri = serTri;
    }

    public String getHDLChol() {
        return HDLChol;
    }

    public void setHDLChol(String HDLChol) {
        this.HDLChol = HDLChol;
    }

    public String getLDLChol() {
        return LDLChol;
    }

    public void setLDLChol(String LDLChol) {
        this.LDLChol = LDLChol;
    }

    public String getCHOLHDL() {
        return CHOLHDL;
    }

    public void setCHOLHDL(String CHOLHDL) {
        this.CHOLHDL = CHOLHDL;
    }

    public String getLDLHDL() {
        return LDLHDL;
    }

    public void setLDLHDL(String LDLHDL) {
        this.LDLHDL = LDLHDL;
    }

    public String getVLDL() {
        return VLDL;
    }

    public void setVLDL(String LDLHDL) {
        this.VLDL = VLDL;
    }

    // End Lipid Profile Methods

    //Begin UFR Methods

    public String getAppearance() {
        return Appearance;
    }

    public void setAppearance(String appearance) {
        this.Appearance = appearance;
    }

    public String getReaction() {
        return Reaction;
    }

    public void setReaction(String reaction) {
        this.Reaction = reaction;
    }

    public String getAlbumin() {
        return Albumin;
    }

    public void setAlbumin(String albumin) {
        this.Albumin = albumin;
    }

    public String getSuger() {
        return Suger;
    }

    public void setSuger(String suger) {
        this.Suger = suger;
    }

    public String getBile() {
        return Bile;
    }

    public void setBile(String bile) {
        this.Bile = bile;
    }

    public String getUrobilin() {
        return Urobilin;
    }

    public void setUrobilin(String urobilin) {
        this.Urobilin = urobilin;
    }

    public String getPUSCells() {
        return PUSCells;
    }

    public void setPUSCells(String PUSCells) {
        this.PUSCells = PUSCells;
    }

    public String getRBC() {
        return RBC;
    }

    public void setRBC(String RBC) {
        this.RBC = RBC;
    }

    public String getEpithelialCells() {
        return EpithelialCells;
    }

    public void setEpithelialCells(String epithelialCells) {
        this.EpithelialCells = epithelialCells;
    }

    public String getCasts() {
        return Casts;
    }

    public void setCasts(String casts) {
        this.Casts = casts;
    }

    public String getCrystals() {
        return Crystals;
    }

    public void setCrystals(String crystals) {
        this.Crystals = crystals;
    }

    public String getOrganisms() {
        return Organisms;
    }

    public void setOrganisms(String organisms) {
        this.Organisms = organisms;
    }

    //End UFR Methods

    //Begin Urine For Bence Jones Protein Methods

    public String getAlbumine() {
        return Albumine;
    }

    public void setAlbumine(String albumine) {
        this.Albumine = albumine;
    }

    public String getBenceJones() {
        return BenceJones;
    }

    public void setBenceJones(String benceJones) {
        this.BenceJones = benceJones;
    }

    //End Urine For Bence Jones Protein Methods

    //Begin Serum Electrolytes Methods

    public String getSodium() {
        return Sodium;
    }

    public void setSodium(String sodium) {
        this.Sodium = sodium;
    }

    public String getPotassium() {
        return Potassium;
    }

    public void setPotassium(String potassium) {
        this.Potassium = potassium;
    }

    //End Electrolytes Methods

    //Begin Thyroid Profile Methods


    public String getTSH() {
        return TSH;
    }

    public void setTSH(String TSH) {
        this.TSH = TSH;
    }

    public String getFreeT3() {
        return FreeT3;
    }

    public void setFreeT3(String freeT3) {this.FreeT3 = freeT3;}

    public String getFreeT4() {
        return FreeT4;
    }

    public void setFreeT4(String freeT4) {
        this.FreeT4 = freeT4;
    }
    //End Thyroid Profile Methods

    //Begin Serum Calcium Methods

    public String getFreeCalcium() {
        return FreeCalcium;
    }

    public void setFreeCalcium(String freeCalcium) {
        this.FreeCalcium = freeCalcium;
    }

    public String getTotalCalcium() {
        return TotalCalcium;
    }

    public void setTotalCalcium(String totalCalcium) {
        this.TotalCalcium = totalCalcium;
    }

    //End Serum Calcium Methods

    //Begin Serum Protein Electrophoresis Methods
    public String getAlbuminee() {
        return Albuminee;
    }

    public void setAlbuminee(String albuminee) {
        this.Albuminee = albuminee;
    }

    public String getAplha1() {
        return Aplha1;
    }

    public void setAplha1(String aplha1) {
        this.Aplha1 = aplha1;
    }

    public String getAlpha2() {
        return Alpha2;
    }

    public void setAlpha2(String alpha2) {this.Alpha2 = alpha2;}

    public String getBeta() {
        return Beta;
    }

    public void setBeta(String beta) {
        this.Beta = beta;
    }

    public String getGamma() {
        return Gamma;
    }

    public void setGamma(String gamma) {
        this.Gamma = gamma;
    }


    //End Serum Protein Electrophoresis Methods

    //Begin C-Reactive Protein Methods

    public String getCreactiveprotein() {
        return creactiveprotein;
    }

    public void setCreactiveprotein(String creactiveprotein) {
        this.creactiveprotein = creactiveprotein;
    }

    //End C-Reactive Protein Methods

    //Begin Bone Marrow Report Methods

    public String getBMBx() {
        return BMBx;
    }

    public void setBMBx(String BMBx) {
        this.BMBx = BMBx;
    }

    public String getTrephineBMBx() {
        return TrephineBMBx;
    }

    public void setTrephineBMBx(String trephineBMBx) {
        this.TrephineBMBx = trephineBMBx;
    }

    //End Bone Marrow Report Methods

    //Begin Full Blood Count  Methods

    public String getWBC() {
        return WBC;
    }

    public void setWBC(String WBC) {
        this.WBC = WBC;
    }

    public String getNE() {
        return NE;
    }

    public void setNE(String NE) {
        this.NE = NE;
    }

    public String getHb() {
        return Hb;
    }

    public void setHb(String hb) {
        this.Hb = hb;
    }

    public String getPlatelet() {
        return Platelet;
    }

    public void setPlatelet(String platelet) {
        this.Platelet = platelet;
    }

    public String getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(String patient_ID) {
        Patient_ID = patient_ID;
    }

    public String getID() {
        return Test_ID;
    }

    public void setID(String test_ID) {
        Test_ID = test_ID;
    }

    public String getName() {
        return Patient_Name;
    }

    public void setName(String patient_Name) {
        Patient_Name = patient_Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    //End Full Blood Count Methods

    //Begin  Methods
    //End Methods


}












