package org.example.candidatapi.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeDocument {
    CV("cv"),
    LM("Lettre de motivation");

    private final String value;

    TypeDocument(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TypeDocument forValue(String value) {
        for (TypeDocument type : TypeDocument.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
