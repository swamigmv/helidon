/*
 * Copyright (c) 2018, 2021 Oracle and/or its affiliates.
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

/**
 * Google login authentication provider.
 */
module io.helidon.security.providers.google.login {
    requires io.helidon.config;
    requires io.helidon.common;
    requires io.helidon.security;
    requires java.logging;
    requires google.api.client;
    requires com.google.api.client;
    requires com.google.api.client.json.gson;
    requires io.helidon.security.providers.common;
    requires io.helidon.security.util;

    exports io.helidon.security.providers.google.login;

    provides io.helidon.security.spi.SecurityProviderService with io.helidon.security.providers.google.login.GoogleTokenService;
}
