package com.android.settings.applications.specialaccess;

import android.content.Context;
import android.ext.settings.ExtSettings;

import com.android.settings.ext.BoolSettingPrefController;

public class GoogleSpecialDeviceIdentifiersAccessPrefController extends BoolSettingPrefController {

    private static final String TAG =
            GoogleSpecialDeviceIdentifiersAccessPrefController.class.getSimpleName();

    public GoogleSpecialDeviceIdentifiersAccessPrefController(Context ctx, String key) {
        super(ctx, key, ExtSettings.ALLOW_GOOGLE_APPS_SPECIAL_ACCESS_TO_DEVICE_IDENTIFIERS);
    }

//    @Override
//    protected void getEntries(Entries entries) {
//        entries.add("USER_NULL", UserHandle.USER_NULL);
//
//        var um = mContext.getSystemService(UserManager.class);
//
//        addUserAndProfilesToEntry(um.getUserInfo(um.getMainUser().getIdentifier()), um, entries);
//
//        for (UserInfo ui : um.getAliveUsers()) {
//            if (ui.isMain()) continue;
//            addUserAndProfilesToEntry(ui, um, entries);
//        }
//    }
//
//    private void addUserAndProfilesToEntry(UserInfo ui, UserManager um, Entries entries) {
//        Log.d(TAG, "user: " + ui.toFullString());
//        if (!ui.isFull() || !ui.isEnabled() || ui.isGuest()) {
//            return;
//        }
//        entries.add(ui.name, ui.id);
//        for (UserInfo subUi : um.getProfiles(ui.id)) {
//            Log.d(TAG, "sub user: " + ui.toFullString());
//            if (subUi.id == ui.id || !subUi.isEnabled()) {
//                continue;
//            }
//            entries.add(subUi.name + " (" + ui.name + ")", subUi.id);
//        }
//    }

//    @Override
//    protected boolean isCredentialConfirmationRequired() {
//        return true;
//    }
}
