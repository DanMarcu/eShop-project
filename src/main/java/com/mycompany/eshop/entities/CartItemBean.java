/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eshop.entities;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dan
 */
@Entity
@Table(name = "cart")
public class CartItemBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int intId;

   
    @Column(name = "id_user")
    private int intIdUser;
    @Column(name = "id_prod")
    private int intIdProduct;
    @Transient
    private String strName;
    @Transient
    private String strDescription;
    @Transient
    private double dblUnitCost;
    @Column(name = "quantity")
    private int iQuantity;
    @Transient
    private double dblTotalCost;

    public CartItemBean(int intIdUser, int intIdProduct, String strName, String strDescription, double dblUnitCost, int iQuantity) {
        this.intIdUser = intIdUser;
        this.intIdProduct = intIdProduct;
        this.strName = strName;
        this.strDescription = strDescription;
        this.dblUnitCost = dblUnitCost;
        this.iQuantity = iQuantity;
        this.dblTotalCost = dblTotalCost;
    }

    public CartItemBean() {
    }

     public int getIntId() {
        return intId;
    }

    public void setIntId(int intId) {
        this.intId = intId;
    }

//    public int getIntIdUser() {
//        return intIdUser;
//    }
//
//    public void setIntIdUser(int intIdUser) {
//        this.intIdUser = intIdUser;
//    }
//
//    public int getIntIdProduct() {
//        return intIdProduct;
//    }
//
//    public void setIntIdProduct(int intIdProduct) {
//        this.intIdProduct = intIdProduct;
//    }
//
//    public int getiQuantity() {
//        return iQuantity;
//    }
//
//    public void setiQuantity(int iQuantity) {
//        this.iQuantity = iQuantity;
//    }
    public double getDblUnitCost() {
        return dblUnitCost;
    }

    public void setDblUnitCost(double dblUnitCost) {
        this.dblUnitCost = dblUnitCost;
    }

    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getDescription() {
        return strDescription;
    }

    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public int getIdUser() {
        return intIdUser;
    }

    public void setIdUser(int intIdUser) {
        this.intIdUser = intIdUser;
    }

    public int getIdProduct() {
        return intIdProduct;
    }

    public void setIdProduct(int intIdProduct) {
        this.intIdProduct = intIdProduct;
    }

    public double getUnitCost() {
        return dblUnitCost;
    }

    public void setUnitCost(double dblUnitCost) {
        this.dblUnitCost = dblUnitCost;
    }

    public int getQuantity() {
        return iQuantity;
    }

    public void setQuantity(int quantity) {
        iQuantity = quantity;
    }

    public double getTotalCost() {
        return dblTotalCost;
    }

    public void setTotalCost(double dblTotalCost) {
        this.dblTotalCost = dblTotalCost;
    }
}
