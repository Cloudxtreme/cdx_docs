package com.cardiodx.db.waban.view;
// Generated Jul 14, 2011 1:33:54 PM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;

/**
 * QcNormalizationViewId generated by hbm2java
 */
public class QcNormalizationViewId  implements java.io.Serializable {


     private String plateId;
     private String layout;
     private BigDecimal #OfSamples;
     private BigDecimal #Pass;
     private Character lastCol;
     private BigDecimal checklistId;

    public QcNormalizationViewId() {
    }

	
    public QcNormalizationViewId(BigDecimal checklistId) {
        this.checklistId = checklistId;
    }
    public QcNormalizationViewId(String plateId, String layout, BigDecimal #OfSamples, BigDecimal #Pass, Character lastCol, BigDecimal checklistId) {
       this.plateId = plateId;
       this.layout = layout;
       this.#OfSamples = #OfSamples;
       this.#Pass = #Pass;
       this.lastCol = lastCol;
       this.checklistId = checklistId;
    }
   
    public String getPlateId() {
        return this.plateId;
    }
    
    public void setPlateId(String plateId) {
        this.plateId = plateId;
    }
    public String getLayout() {
        return this.layout;
    }
    
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public BigDecimal get#OfSamples() {
        return this.#OfSamples;
    }
    
    public void set#OfSamples(BigDecimal #OfSamples) {
        this.#OfSamples = #OfSamples;
    }
    public BigDecimal get#Pass() {
        return this.#Pass;
    }
    
    public void set#Pass(BigDecimal #Pass) {
        this.#Pass = #Pass;
    }
    public Character getLastCol() {
        return this.lastCol;
    }
    
    public void setLastCol(Character lastCol) {
        this.lastCol = lastCol;
    }
    public BigDecimal getChecklistId() {
        return this.checklistId;
    }
    
    public void setChecklistId(BigDecimal checklistId) {
        this.checklistId = checklistId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof QcNormalizationViewId) ) return false;
		 QcNormalizationViewId castOther = ( QcNormalizationViewId ) other; 
         
		 return ( (this.getPlateId()==castOther.getPlateId()) || ( this.getPlateId()!=null && castOther.getPlateId()!=null && this.getPlateId().equals(castOther.getPlateId()) ) )
 && ( (this.getLayout()==castOther.getLayout()) || ( this.getLayout()!=null && castOther.getLayout()!=null && this.getLayout().equals(castOther.getLayout()) ) )
 && ( (this.get#OfSamples()==castOther.get#OfSamples()) || ( this.get#OfSamples()!=null && castOther.get#OfSamples()!=null && this.get#OfSamples().equals(castOther.get#OfSamples()) ) )
 && ( (this.get#Pass()==castOther.get#Pass()) || ( this.get#Pass()!=null && castOther.get#Pass()!=null && this.get#Pass().equals(castOther.get#Pass()) ) )
 && ( (this.getLastCol()==castOther.getLastCol()) || ( this.getLastCol()!=null && castOther.getLastCol()!=null && this.getLastCol().equals(castOther.getLastCol()) ) )
 && ( (this.getChecklistId()==castOther.getChecklistId()) || ( this.getChecklistId()!=null && castOther.getChecklistId()!=null && this.getChecklistId().equals(castOther.getChecklistId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPlateId() == null ? 0 : this.getPlateId().hashCode() );
         result = 37 * result + ( getLayout() == null ? 0 : this.getLayout().hashCode() );
         result = 37 * result + ( get#OfSamples() == null ? 0 : this.get#OfSamples().hashCode() );
         result = 37 * result + ( get#Pass() == null ? 0 : this.get#Pass().hashCode() );
         result = 37 * result + ( getLastCol() == null ? 0 : this.getLastCol().hashCode() );
         result = 37 * result + ( getChecklistId() == null ? 0 : this.getChecklistId().hashCode() );
         return result;
   }   


}


