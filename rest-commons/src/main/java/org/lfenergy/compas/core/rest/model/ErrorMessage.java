// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.core.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import static org.lfenergy.compas.core.rest.RestConstants.COMPAS_REST_V1_NS_URI;

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage {
    @XmlElement(name = "Code", namespace = COMPAS_REST_V1_NS_URI, required = true)
    private String code;
    @XmlElement(name = "Message", namespace = COMPAS_REST_V1_NS_URI, required = true)
    private String message;
    @XmlElement(name = "Property", namespace = COMPAS_REST_V1_NS_URI, required = true)
    private String property;

    public ErrorMessage() {
    }

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage(String code, String message, String property) {
        this.code = code;
        this.message = message;
        this.property = property;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
