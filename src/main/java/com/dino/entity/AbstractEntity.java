package com.dino.entity;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class AbstractEntity {

    @Id
    private BigInteger id;

    /**
     * Returns the identifier of the document.
     *
     * @return the id
     */
    public BigInteger getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return this.id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}
