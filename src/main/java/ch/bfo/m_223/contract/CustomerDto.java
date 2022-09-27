package ch.bfo.m_223.contract;

/***
 * DTO welche die nötigen Informationen für einen Kunden enthält
 */
public class CustomerDto {
    private String name;
    private String prename;
    private int customerId;


    // Getter Methods
    public String getName() {
        return name;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}