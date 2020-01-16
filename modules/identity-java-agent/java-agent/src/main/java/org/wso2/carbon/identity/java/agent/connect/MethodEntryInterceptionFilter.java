/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.java.agent.connect;

import org.wso2.carbon.identity.java.agent.host.InterceptionEventType;
import org.wso2.carbon.identity.java.agent.host.MethodContext;

/**
 * Filter for method entry.
 */
public class MethodEntryInterceptionFilter implements InterceptionFilter {

    private String className;
    private String methodName;
    private String signature;

    public MethodEntryInterceptionFilter(String className, String methodName, String signature) {

        this.className = className;
        this.methodName = methodName;
        this.signature = signature;
    }

    @Override
    public boolean shouldIntercept(InterceptionEventType type, MethodContext methodContext) {

        if (methodContext == null) {
            return false;
        }
        if (InterceptionEventType.METHOD_ENTRY != type) {
            return false;
        }

        return methodContext.getClassName().equals(className) && methodContext.getMethodName().equals(
                methodName) && methodContext.getMethodSignature().equals(signature);
    }
}
