package com.yoavst.quickapps.toggles.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.provider.Settings;

import com.yoavst.quickapps.R;
import com.yoavst.quickapps.toggles.Connectivity;
import com.yoavst.quickapps.toggles.ToggleFragment;
import com.yoavst.quickapps.toggles.TogglesActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by Yoav.
 */
@EFragment
public class HotSpotFragment extends ToggleFragment {
	@StringRes(R.string.hotSpot)
	String HOT_SPOT;
	@StringRes(R.string.hotSpot_off)
	String OFF;
	@StringRes(R.string.hotSpot_on)
	String ON;
	Resources mSystemUiResources;
	// resources id of system ui stuff
	static int onIcon = -1;
	static int offIcons = -1;
	boolean enabled;

	@AfterViews
	void init() {
		mToggleTitle.setText(HOT_SPOT);
		mSystemUiResources = ((TogglesActivity) getActivity()).getSystemUiResource();
		if (onIcon == -1 || offIcons == -1) {
			offIcons = mSystemUiResources.getIdentifier("indi_noti_hotspot_off", "drawable", "com.android.systemui");
			onIcon = mSystemUiResources.getIdentifier("indi_noti_hotspot_on", "drawable", "com.android.systemui");
		}
		setToggleData(enabled = Connectivity.isApOn(getActivity()));
	}

	void setToggleData(boolean enabled) {
		mToggleIcon.setImageDrawable(mSystemUiResources.getDrawable(enabled ? onIcon : offIcons));
		mToggleText.setText(enabled ? ON : OFF);

	}

	@Override
	public void onToggleButtonClicked() {
		setToggleData(enabled = !enabled);
		Connectivity.configApState(getActivity());

	}

	@Override
	public Intent getIntentForLaunch() {
		return new Intent(Settings.ACTION_WIFI_SETTINGS);
	}
}
