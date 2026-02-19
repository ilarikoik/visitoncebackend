
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ipAddress;
    LocalDateTime visitTime;
    Boolean rickRolled = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", ipAddress=" + ipAddress + ", visitTime=" + visitTime + "]";
    }

    public Boolean getRickRolled() {
        return rickRolled;
    }

    public void setRickRolled(Boolean rickRolled) {
        this.rickRolled = rickRolled;
    }
}
