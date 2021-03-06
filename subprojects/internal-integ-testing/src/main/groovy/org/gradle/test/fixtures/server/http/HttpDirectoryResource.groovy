/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.test.fixtures.server.http

import org.gradle.test.fixtures.file.TestFile

/**
 * TODO - sync up with {@link HttpResource}
 */
class HttpDirectoryResource {
    private final HttpServer server
    private final String path
    private final TestFile directory

    HttpDirectoryResource(HttpServer server, String path, TestFile directory) {
        this.directory = directory
        this.path = path
        this.server = server
    }

    URI getUri() {
        return new URI(server.uri.scheme, server.uri.authority, path, null, null)
    }

    public void expectGet() {
        server.expectGetDirectoryListing(path, directory)
    }

    public void allowGet() {
        server.allowGetDirectoryListing(path, directory)
    }

    public void expectGetMissing() {
        server.expectGetMissing(path)
    }

    public void expectGetBroken() {
        server.expectGetBroken(path)
    }
}
