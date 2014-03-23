import java.io.Serializable;

public class Customer implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private Long customerId = null;  
    private String customerName;  
public Long getCustomerId() {  
  return customerId;  
 }  
public void setCustomerId(Long customerId) {  
  this.customerId = customerId;  
 }  
public String getCustomerName() {  
  return customerName;  
 }  
public void setCustomerName(String aCustomerName) {  
  this.customerName = aCustomerName;  
 }  
public static long getSerialVersionUID() {  
  return serialVersionUID;  
 }  
public boolean equals(Object candidate) {  
        if (candidate == this) {  
            return true;  
        }  
        if (candidate instanceof Customer) {  
            if ((this.getCustomerName() != null &&  
              ((Customer)candidate).getCustomerName() != null)) {  
             return (this.getCustomerId()==  
              (((Customer)candidate).getCustomerId())&&  
                 this.getCustomerName().equals(  
                   ((Customer)candidate).getCustomerName()));  
            }  
        }  
        return false;  
    }  
  
public int hashCode() {  
      return this.getCustomerId().intValue();  
    }  
}  
