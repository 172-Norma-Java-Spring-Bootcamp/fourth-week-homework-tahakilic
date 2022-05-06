package com.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseExtendModel extends BaseModel {
    @Temporal(TemporalType.TIMESTAMP)  //Date anotasyonu zaman ve gün.
    public Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    public Date deletedAt;

    @Column(length = 50)
    public String createdBy;
    @Column(length = 50)
    public String updatedBy;
    @Column(length = 50)
    public String deletedBy;
}
