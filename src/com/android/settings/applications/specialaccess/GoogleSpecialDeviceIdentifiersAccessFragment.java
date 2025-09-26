package com.android.settings.applications.specialaccess;

import android.ext.settings.BoolSetting;
import android.ext.settings.ExtSettings;

import com.android.settings.ext.BoolSettingFragment;

public class GoogleSpecialDeviceIdentifiersAccessFragment extends BoolSettingFragment {
    @Override
    protected BoolSetting getSetting() {
        return ExtSettings.ALLOW_GOOGLE_APPS_SPECIAL_ACCESS_TO_DEVICE_IDENTIFIERS;
    }

    @Override
    protected CharSequence getTitle() {
        return "(TODO) " + GoogleSpecialDeviceIdentifiersAccessPrefController.class.getSimpleName();
    }
}
