package com.android.settings.applications.specialaccess;

import android.ext.settings.BoolSetting;
import android.ext.settings.ExtSettings;

import com.android.settings.R;
import com.android.settings.ext.BoolSettingFragment;
import com.android.settingslib.widget.FooterPreference;

public class GoogleSpecialDeviceIdentifiersAccessFragment extends BoolSettingFragment {

    @Override
    protected BoolSetting getSetting() {
        return ExtSettings.ALLOW_GOOGLE_APPS_SPECIAL_ACCESS_TO_DEVICE_IDENTIFIERS;
    }

    @Override
    protected CharSequence getTitle() {
        return resText(R.string.Google_apps_special_device_identifiers_access_title);
    }

    @Override
    protected CharSequence getMainSwitchTitle() {
        return resText(R.string.Google_apps_special_device_identifiers_access_main_switch);
    }

    @Override
    protected FooterPreference makeFooterPref(FooterPreference.Builder builder) {
        return builder.setTitle(R.string.Google_apps_special_device_identifiers_access_footer)
                .build();
    }
}
