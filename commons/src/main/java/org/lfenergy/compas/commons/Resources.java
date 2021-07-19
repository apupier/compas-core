// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.commons;

import org.lfenergy.compas.commons.exception.CompasException;

import java.net.URL;
import java.util.Optional;

import static org.lfenergy.compas.commons.exception.CompasErrorCode.NO_CLASS_LOADER_ERROR_CODE;

public class Resources {
    Resources() {
        throw new UnsupportedOperationException("Resources class");
    }

    public static Optional<URL> getResource(String resourceName) {
        ClassLoader loader = getClassLoader();
        URL url = loader.getResource(resourceName);
        return Optional.ofNullable(url);
    }

    private static ClassLoader getClassLoader() {
        // Search for a ClassLoader to return.
        var classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = Resources.class.getClassLoader();
        }
        if (classLoader == null) {
            throw new CompasException(NO_CLASS_LOADER_ERROR_CODE, "Unable to get ClassLoader for loading resouces");
        }
        return classLoader;
    }
}
