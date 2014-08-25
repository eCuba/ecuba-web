package com.ecuba.domain;

import java.io.Serializable;

/**
 * Created by rolando on 2014-08-22.
 */
public abstract class PersistentObject<ID extends Serializable> implements Serializable {

    protected ID id;
    protected String label;
    protected String description;

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistentObject that = (PersistentObject) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
