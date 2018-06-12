/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Licensed to the Apache Software Foundation (ASF) under one
 ~ or more contributor license agreements.  See the NOTICE file
 ~ distributed with this work for additional information
 ~ regarding copyright ownership.  The ASF licenses this file
 ~ to you under the Apache License, Version 2.0 (the
 ~ "License"); you may not use this file except in compliance
 ~ with the License.  You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing,
 ~ software distributed under the License is distributed on an
 ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 ~ KIND, either express or implied.  See the License for the
 ~ specific language governing permissions and limitations
 ~ under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package org.apache.sling.capabilities.internal;

import java.util.HashMap;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.capabilities.CapabilitiesSource;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;

/**
 * Builds Probes that provide basic JVM information, as an example.
 */
@Component(
    service = CapabilitiesSource.class,
    property = {
        CapabilitiesSource.PREFIX_SERVICE_PROPERTY + "=org.apache.sling.capabilities.examples.OsgiFrameworkCapabilitiesSource"
})
public class OsgiFrameworkCapabilitiesSource implements CapabilitiesSource {
    
    private BundleContext bundleContext;

    @Activate
    public void activate(ComponentContext ctx) {
        bundleContext = ctx.getBundleContext();
    }

    @Override
    public Map<String, String> getCapabilities() throws Exception {
        final Map<String, String> result = new HashMap<>();
        
        final Bundle frameworkBundle = bundleContext.getBundle(0);
        
        result.put("framework.bundle.symbolic.name", frameworkBundle.getSymbolicName());
        result.put("framework.bundle.version", frameworkBundle.getHeaders(Constants.BUNDLE_VERSION).get(Constants.BUNDLE_VERSION).toString());


        return result;
    }
}