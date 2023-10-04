/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author ADMIN
 */
public class Customer
{
  private int ID; 
  private String name,GuardianName,Gender,Phone,City,CLass;

    public Customer(int ID, String name, String GuardianName, String Gender, String Phone, String City, String CLass) {
        this.ID = ID;
        this.name = name;
        this.GuardianName = GuardianName;
        this.Gender = Gender;
        this.Phone = Phone;
        this.City = City;
        this.CLass = CLass;
      
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the GuardianName
     */
    public String getGuardianName() {
        return GuardianName;
    }

    /**
     * @param GuardianName the GuardianName to set
     */
    public void setGuardianName(String GuardianName) {
        this.GuardianName = GuardianName;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     * @return the CLass
     */
    public String getCLass() {
        return CLass;
    }

    /**
     * @param CLass the CLass to set
     */
    public void setCLass(String CLass) {
        this.CLass = CLass;
    }

  

  
}
