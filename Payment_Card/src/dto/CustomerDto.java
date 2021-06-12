package dto;

public class CustomerDto {
    private String nic;
    private String customerName;
    private String dob;
    private String address;
    private String contactNo;
    private String email;

    public CustomerDto() {
    }

    public CustomerDto(String nic, String customerName, String dob, String address, String contactNo,String email) {
        this.nic = nic;
        this.customerName = customerName;
        this.dob = dob;
        this.address = address;
        this.contactNo = contactNo;
        this.setEmail(email);
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}