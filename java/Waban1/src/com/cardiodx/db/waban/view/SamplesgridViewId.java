package com.cardiodx.db.waban.view;
// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;

/**
 * SamplesgridViewId generated by hbm2java
 */
public class SamplesgridViewId  implements java.io.Serializable {


     private String sampleTube;
     private String location;
     private BigDecimal dnaConcentration;
     private String %Cv;
     private BigDecimal 260/280;
     private String qcStatus;
     private Character lastCol;
     private String containerId;
     private BigDecimal checklistId;
     private BigDecimal sampleId;
     private String sampleTubeId;

    public SamplesgridViewId() {
    }

	
    public SamplesgridViewId(BigDecimal checklistId, BigDecimal sampleId) {
        this.checklistId = checklistId;
        this.sampleId = sampleId;
    }
    public SamplesgridViewId(String sampleTube, String location, BigDecimal dnaConcentration, String %Cv, BigDecimal 260/280, String qcStatus, Character lastCol, String containerId, BigDecimal checklistId, BigDecimal sampleId, String sampleTubeId) {
       this.sampleTube = sampleTube;
       this.location = location;
       this.dnaConcentration = dnaConcentration;
       this.%Cv = %Cv;
       this.260/280 = 260/280;
       this.qcStatus = qcStatus;
       this.lastCol = lastCol;
       this.containerId = containerId;
       this.checklistId = checklistId;
       this.sampleId = sampleId;
       this.sampleTubeId = sampleTubeId;
    }
   
    public String getSampleTube() {
        return this.sampleTube;
    }
    
    public void setSampleTube(String sampleTube) {
        this.sampleTube = sampleTube;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public BigDecimal getDnaConcentration() {
        return this.dnaConcentration;
    }
    
    public void setDnaConcentration(BigDecimal dnaConcentration) {
        this.dnaConcentration = dnaConcentration;
    }
    public String get%Cv() {
        return this.%Cv;
    }
    
    public void set%Cv(String %Cv) {
        this.%Cv = %Cv;
    }
    public BigDecimal get260/280() {
        return this.260/280;
    }
    
    public void set260/280(BigDecimal 260/280) {
        this.260/280 = 260/280;
    }
    public String getQcStatus() {
        return this.qcStatus;
    }
    
    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }
    public Character getLastCol() {
        return this.lastCol;
    }
    
    public void setLastCol(Character lastCol) {
        this.lastCol = lastCol;
    }
    public String getContainerId() {
        return this.containerId;
    }
    
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }
    public BigDecimal getChecklistId() {
        return this.checklistId;
    }
    
    public void setChecklistId(BigDecimal checklistId) {
        this.checklistId = checklistId;
    }
    public BigDecimal getSampleId() {
        return this.sampleId;
    }
    
    public void setSampleId(BigDecimal sampleId) {
        this.sampleId = sampleId;
    }
    public String getSampleTubeId() {
        return this.sampleTubeId;
    }
    
    public void setSampleTubeId(String sampleTubeId) {
        this.sampleTubeId = sampleTubeId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SamplesgridViewId) ) return false;
		 SamplesgridViewId castOther = ( SamplesgridViewId ) other; 
         
		 return ( (this.getSampleTube()==castOther.getSampleTube()) || ( this.getSampleTube()!=null && castOther.getSampleTube()!=null && this.getSampleTube().equals(castOther.getSampleTube()) ) )
 && ( (this.getLocation()==castOther.getLocation()) || ( this.getLocation()!=null && castOther.getLocation()!=null && this.getLocation().equals(castOther.getLocation()) ) )
 && ( (this.getDnaConcentration()==castOther.getDnaConcentration()) || ( this.getDnaConcentration()!=null && castOther.getDnaConcentration()!=null && this.getDnaConcentration().equals(castOther.getDnaConcentration()) ) )
 && ( (this.get%Cv()==castOther.get%Cv()) || ( this.get%Cv()!=null && castOther.get%Cv()!=null && this.get%Cv().equals(castOther.get%Cv()) ) )
 && ( (this.get260/280()==castOther.get260/280()) || ( this.get260/280()!=null && castOther.get260/280()!=null && this.get260/280().equals(castOther.get260/280()) ) )
 && ( (this.getQcStatus()==castOther.getQcStatus()) || ( this.getQcStatus()!=null && castOther.getQcStatus()!=null && this.getQcStatus().equals(castOther.getQcStatus()) ) )
 && ( (this.getLastCol()==castOther.getLastCol()) || ( this.getLastCol()!=null && castOther.getLastCol()!=null && this.getLastCol().equals(castOther.getLastCol()) ) )
 && ( (this.getContainerId()==castOther.getContainerId()) || ( this.getContainerId()!=null && castOther.getContainerId()!=null && this.getContainerId().equals(castOther.getContainerId()) ) )
 && ( (this.getChecklistId()==castOther.getChecklistId()) || ( this.getChecklistId()!=null && castOther.getChecklistId()!=null && this.getChecklistId().equals(castOther.getChecklistId()) ) )
 && ( (this.getSampleId()==castOther.getSampleId()) || ( this.getSampleId()!=null && castOther.getSampleId()!=null && this.getSampleId().equals(castOther.getSampleId()) ) )
 && ( (this.getSampleTubeId()==castOther.getSampleTubeId()) || ( this.getSampleTubeId()!=null && castOther.getSampleTubeId()!=null && this.getSampleTubeId().equals(castOther.getSampleTubeId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSampleTube() == null ? 0 : this.getSampleTube().hashCode() );
         result = 37 * result + ( getLocation() == null ? 0 : this.getLocation().hashCode() );
         result = 37 * result + ( getDnaConcentration() == null ? 0 : this.getDnaConcentration().hashCode() );
         result = 37 * result + ( get%Cv() == null ? 0 : this.get%Cv().hashCode() );
         result = 37 * result + ( get260/280() == null ? 0 : this.get260/280().hashCode() );
         result = 37 * result + ( getQcStatus() == null ? 0 : this.getQcStatus().hashCode() );
         result = 37 * result + ( getLastCol() == null ? 0 : this.getLastCol().hashCode() );
         result = 37 * result + ( getContainerId() == null ? 0 : this.getContainerId().hashCode() );
         result = 37 * result + ( getChecklistId() == null ? 0 : this.getChecklistId().hashCode() );
         result = 37 * result + ( getSampleId() == null ? 0 : this.getSampleId().hashCode() );
         result = 37 * result + ( getSampleTubeId() == null ? 0 : this.getSampleTubeId().hashCode() );
         return result;
   }   


}

