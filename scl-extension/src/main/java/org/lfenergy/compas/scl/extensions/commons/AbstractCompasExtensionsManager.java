// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.scl.extensions.commons;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCompasExtensionsManager {
    protected Optional<JAXBElement> getCompasElement(List<Object> content, CompasExtensionsField field) {
        if (content != null) {
            return content.stream()
                    .filter(JAXBElement.class::isInstance)
                    .map(JAXBElement.class::cast)
                    .filter(element -> element.getName().equals(new QName(CompasExtensionsConstants.COMPAS_EXTENSION_NS_URI, field.getFieldName())))
                    .findFirst();
        }
        return Optional.empty();
    }
}
