package io.hieulam.betest.model;

import java.util.List;

public abstract class AbstractShape  {


    protected List<Attribute> attributes;

    protected long getAttributeValue(String name) {
        long result = 0;
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(name)) {
                result = Long.parseLong(attribute.getValue());
            }
        }
        return result;
    }

    protected void setShapeAttribute(List<Attribute> attributes) {
        this.attributes = attributes;
    }

}
