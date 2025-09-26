package com.android.settings.applications.specialaccess;

import android.content.Context;
import android.ext.settings.ExtSettings;

import com.android.settings.R;
import com.android.settings.ext.BoolSettingFragmentPrefController;

public class GoogleSpecialDeviceIdentifiersAccessPrefController extends
        BoolSettingFragmentPrefController {

    public GoogleSpecialDeviceIdentifiersAccessPrefController(Context ctx, String key) {
        super(ctx, key, ExtSettings.ALLOW_GOOGLE_APPS_SPECIAL_ACCESS_TO_DEVICE_IDENTIFIERS);
    }

    @Override
    protected CharSequence getSummaryOn() {
        return resText(R.string.Google_apps_special_device_identifiers_access_summary_granted);
    }

    @Override
    protected CharSequence getSummaryOff() {
        return resText(R.string.Google_apps_special_device_identifiers_access_summary_not_granted);
    }
}
