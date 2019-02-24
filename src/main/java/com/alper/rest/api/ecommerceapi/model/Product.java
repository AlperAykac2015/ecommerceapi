package com.alper.rest.api.ecommerceapi.model;

import com.alper.rest.api.ecommerceapi.serializer.CustomProductDeserializer;
import com.alper.rest.api.ecommerceapi.serializer.CustomProductSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
@JsonDeserialize(using = CustomProductDeserializer.class)
@JsonSerialize(using = CustomProductSerializer.class)
public class Product implements Serializable {

    private static final long serialVersionUID = 6128569811206071380L;

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    private String brandName;

    private String ownerName;

    public Product(String name, String brandName, String ownerName) {
        this.name = name;
        this.brandName = brandName;
        this.ownerName = ownerName;
    }

    public Product(){

    }

    @XmlElement(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "ProductName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="BrandName")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @XmlElement(name="OwnerName")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", brandName='").append(brandName).append('\'');
        sb.append(", ownerName='").append(ownerName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
