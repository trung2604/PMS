package com.project.oop.PMS.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private Integer projectID;
    private String licenceKey;
    private String name;
    private String type;
    private Integer capacity;
    private BigDecimal totalMoney;
    private String newAttribute;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    // Getters và Setters
    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getNewAttribute() {
        return newAttribute;
    }

    public void setNewAttribute(String newAttribute) {
        this.newAttribute = newAttribute;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
