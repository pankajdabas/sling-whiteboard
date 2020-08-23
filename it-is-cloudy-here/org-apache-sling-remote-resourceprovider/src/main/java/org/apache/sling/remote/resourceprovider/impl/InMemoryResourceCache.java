/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Licensed to the Apache Software Foundation (ASF) under one
 ~ or more contributor license agreements.  See the NOTICE file
 ~ distributed with this work for additional information
 ~ regarding copyright ownership.  The ASF licenses this file
 ~ to you under the Apache License, Version 2.0 (the
 ~ "License"); you may not use this file except in compliance
 ~ with the License.  You may obtain a copy of the License at
 ~
 ~   http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing,
 ~ software distributed under the License is distributed on an
 ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 ~ KIND, either express or implied.  See the License for the
 ~ specific language governing permissions and limitations
 ~ under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package org.apache.sling.remote.resourceprovider.impl;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;


class InMemoryResourceCache {

    private final Cache<String, CacheableResource> internalCache;

    InMemoryResourceCache(int size, int lruMinutesExpiration) {
        internalCache = Caffeine.newBuilder()
                .maximumSize(size)
                .expireAfterAccess(lruMinutesExpiration, TimeUnit.MINUTES)
                .build();
    }

    CacheableResource get(String key) {
        return internalCache.getIfPresent(key);
    }

    void put(String key, CacheableResource value) {
        internalCache.put(key, value);
    }

    void clear() {
        internalCache.invalidateAll();
        internalCache.cleanUp();
    }

    void remove(String key) {
        internalCache.invalidate(key);
    }

}
