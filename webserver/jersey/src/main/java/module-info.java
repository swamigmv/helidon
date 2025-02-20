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

import org.glassfish.jersey.internal.inject.InjectionManagerFactory;

/**
 * Jersey integration.
 */
module io.helidon.webserver.jersey {
    requires transitive jakarta.annotation;
    requires transitive io.helidon.webserver;
    requires transitive jakarta.ws.rs;
    requires transitive io.opentracing.api;
    requires transitive io.helidon.jersey.server;
    requires transitive io.helidon.jersey.client;

    requires io.helidon.common.context;
    requires io.helidon.common.mapper;
    requires io.helidon.common.reactive;
    requires java.logging;
    requires io.netty.buffer;
    requires jersey.common;

    exports io.helidon.webserver.jersey;

    provides InjectionManagerFactory with io.helidon.webserver.jersey.HelidonHK2InjectionManagerFactory;

    // reflection access from jersey injection
    opens io.helidon.webserver.jersey to hk2.locator,hk2.utils;
}
