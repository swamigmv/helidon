/*
 * Copyright (c) 2021 Oracle and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.helidon.integrations.oci.connect;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

import io.helidon.integrations.common.rest.ApiJsonParser;

import jakarta.json.JsonObject;

/**
 * Utility methods for processing OCI JSON responses.
 */
public abstract class OciResponseParser extends ApiJsonParser {
    private static final DateTimeFormatter INSTANT_PARSER = DateTimeFormatter.ISO_INSTANT;

    /**
     * New instance.
     */
    protected OciResponseParser() {
    }

    /**
     * Get instant from JSON using a parser that understands OCI date time format.
     *
     * @param json JSON object
     * @param name property of the object
     * @return instant parsed from the string value of the property
     */
    protected Instant getInstant(JsonObject json, String name) {
        TemporalAccessor accessor = INSTANT_PARSER.parse(json.getString(name));
        return Instant.from(accessor);
    }

    /**
     * Get instant from JSON using a parser that understands OCI date time format.
     *
     * @param json JSON object
     * @param name property of the object
     * @return instant parsed from the string value of the property, or empty if not present or null
     */
    protected Optional<Instant> toInstant(JsonObject json, String name) {
        return toInstant(json, name, INSTANT_PARSER);
    }
}
