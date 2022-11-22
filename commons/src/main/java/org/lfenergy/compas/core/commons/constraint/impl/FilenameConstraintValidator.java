// SPDX-FileCopyrightText: 2021 Alliander N.V.
//
// SPDX-License-Identifier: Apache-2.0
package org.lfenergy.compas.core.commons.constraint.impl;

import org.lfenergy.compas.core.commons.constraint.FilenameValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator to check if a String can be used as filename on an OS.
 */
public class FilenameConstraintValidator implements ConstraintValidator<FilenameValid, String> {
    // Used a RegEx from Internet to check the strict one (Old Windows) to see if all matches.
    private final Pattern pattern = Pattern.compile(
            """
                    # Match a valid Windows filename (unspecified file system).
                    ^                                # Anchor to start of string.
                    (?!                              # Assert filename is not: CON, PRN,
                      (?:                            # AUX, NUL, COM1, COM2, COM3, COM4,
                        CON|PRN|AUX|NUL|             # COM5, COM6, COM7, COM8, COM9,
                        COM[1-9]|LPT[1-9]            # LPT1, LPT2, LPT3, LPT4, LPT5,
                      )                              # LPT6, LPT7, LPT8, and LPT9...
                      (?:\\.[^.]*)?                  # followed by optional extension
                      $                              # and end of string
                    )                                # End negative lookahead assertion.
                    [^<>:\"/\\\\|?*\\x00-\\x1F]*     # Zero or more valid filename chars.
                    [^<>:\"/\\\\|?*\\x00-\\x1F\\ .]  # Last char is not a space or dot.
                    $                                # Anchor to end of string.""",
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
        // Blank or null is always a wrong filename.
        return false;
    }
}
