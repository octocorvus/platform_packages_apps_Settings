package com.android.settings.applications

import android.content.Context
import android.content.pm.ApplicationInfo
import android.ext.settings.ExtSettings
import android.ext.settings.app.AppSwitch
import android.ext.settings.app.AswAllowClipboardRead
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.preference.PreferenceScreen
import com.android.settings.R
import com.android.settings.ext.BoolSettingFragment
import com.android.settings.ext.BoolSettingFragmentPrefController
import com.android.settings.ext.ExtSettingControllerHelper
import com.android.settings.spa.app.appinfo.AswPreference
import com.android.settingslib.widget.FooterPreference

object AswAdapterClipboardRead : AswAdapter<AswAllowClipboardRead>() {

    override fun getAppSwitch() = AswAllowClipboardRead.I

    override fun getAswTitle(ctx: Context) = ctx.getText(R.string.app_clipboard_read_title)
    override fun getOnTitle(ctx: Context) = ctx.getText(R.string.app_clipboard_read_allowed)
    override fun getOffTitle(ctx: Context) = ctx.getText(R.string.app_clipboard_read_blocked)

    override fun getDetailFragmentClass() = AppClipboardReadFragment::class
}

@Composable
fun AppClipboardReadPreference(app: ApplicationInfo) {
    AswPreference(LocalContext.current, app, AswAdapterClipboardRead)
}

class AppClipboardReadFragment : AswAppInfoFragment<AswAllowClipboardRead>() {

    override fun getAswAdapter() = AswAdapterClipboardRead

    override fun getSummaryForDefaultValueReason(dvr: Int): CharSequence? {
        val id = when (dvr) {
            AppSwitch.DVR_DEFAULT_SETTING -> R.string.app_clipboard_read_dvr_default_setting
            else -> return null
        }
        return getText(id)
    }

    override fun getSummaryForImmutabilityReason(ir: Int): CharSequence? {
        val id = when (ir) {
            AppSwitch.IR_IS_SYSTEM_APP -> R.string.app_clipboard_read_ir_is_system_app
            AppSwitch.IR_IS_DEFAULT_IME -> R.string.app_clipboard_read_ir_is_default_ime
            else -> return null
        }
        return getText(id)
    }

    override fun updateFooter(fp: FooterPreference) {
        fp.setTitle(R.string.app_clipboard_read_footer)
    }
}

class AppDefaultClipboardReadPrefController(ctx: Context, key: String) :
    BoolSettingFragmentPrefController(ctx, key, ExtSettings.ALLOW_CLIPBOARD_READ_BY_DEFAULT) {

    override fun getSummaryOn() = resText(R.string.app_default_clipboard_read_summary_allowed)
    override fun getSummaryOff() = resText(R.string.app_default_clipboard_read_summary_blocked)
}

class AppDefaultClipboardReadFragment : BoolSettingFragment() {

    override fun getSetting() = ExtSettings.ALLOW_CLIPBOARD_READ_BY_DEFAULT

    override fun getTitle() = resText(R.string.app_clipboard_read_title)

    override fun getMainSwitchTitle() = resText(R.string.app_default_clipboard_read_main_switch_title)
    override fun getMainSwitchSummary() = resText(R.string.app_default_clipboard_read_main_switch_summary)

    override fun addExtraPrefs(screen: PreferenceScreen) {
        AswAdapterClipboardRead.addAppListPageLink(screen)
    }

    override fun makeFooterPref(builder: FooterPreference.Builder): FooterPreference? {
        return builder.setTitle(resText(R.string.app_default_clipboard_read_footer)).build()
    }
}

class ClipboardReadAppListPrefController(context: Context, preferenceKey: String) :
    AswAppListPrefController(context, preferenceKey, AswAdapterClipboardRead) {

    override fun getAvailabilityStatus(): Int {
        return ExtSettingControllerHelper.getSecondaryUserOnlySettingAvailability(mContext)
    }
}
