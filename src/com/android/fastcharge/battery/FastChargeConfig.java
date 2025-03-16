/*
 * Copyright (C) 2023-2024 cyberknight777
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

package com.android.fastcharge.battery;

import android.content.Context;
import android.content.res.Resources;

import com.android.fastcharge.utils.FileUtils;

public class FastChargeConfig {

    private static FastChargeConfig instance = null;

    public static FastChargeConfig getInstance(Context context) {

        if (instance == null) {
            instance = new FastChargeConfig(context.getApplicationContext());
        }

        return instance;
    }

    public static final String FASTCHARGE_KEY = "fast_charging";

    private final String config_FastChargePath;

    public static final String ACTION_FAST_CHARGE_SERVICE_CHANGED = "com.android.fastcharge.battery.FAST_CHARGE_SERVICE_CHANGED";
    public static final String EXTRA_FAST_CHARGE_STATE = "fastchargingenabled";

    private FastChargeConfig(Context context) {

	Resources res = context.getResources();

	config_FastChargePath = res.getString(com.android.fastcharge.R.string.config_FastChargePath);
    }

    public String getFastChargePath() {
        return config_FastChargePath;
    }

    public boolean isCurrentlyEnabled(String node) {
        return FileUtils.getNodeValueAsBoolean(node, false);
    }
 }
