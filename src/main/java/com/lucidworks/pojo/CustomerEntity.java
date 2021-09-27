/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucidworks.pojo;

/**
 *
 * @author Jose Maquera
 */
public class CustomerEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String status;
    
    public CustomerEntity(){
    }
    public CustomerEntity(Long id,String first_name,String last_name,String email,String company,String status){
        this.id =  id;
        this.firstName=  first_name;
        this.lastName=  last_name;
        this.email=  email;
        this.company=  company;
        this.status=  status;        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
