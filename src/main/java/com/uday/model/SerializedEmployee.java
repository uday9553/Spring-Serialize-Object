package com.uday.model;

import javax.persistence.*;

@Entity
@Table
public class SerializedEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private byte[] serializedEmployee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getSerializedEmployee() {
        return serializedEmployee;
    }

    public void setSerializedEmployee(byte[] serializedEmployee) {
        this.serializedEmployee = serializedEmployee;
    }

    public SerializedEmployee(byte[] serializedEmployee) {
        this.serializedEmployee = serializedEmployee;
    }

    public SerializedEmployee() {
    }
}
