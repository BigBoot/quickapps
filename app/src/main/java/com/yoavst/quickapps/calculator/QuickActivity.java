package com.yoavst.quickapps.calculator;

import android.content.Intent;

import com.yoavst.quickapps.BaseQuickCircleActivity;
import com.yoavst.quickapps.Preferences_;
import com.yoavst.quickapps.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Yoav.
 */
@EActivity
public class QuickActivity extends BaseQuickCircleActivity {
	boolean forceFloating = false;
	@AfterViews
	void init() {
		getFragmentManager().beginTransaction().replace(R.id.quick_circle_fragment, CalculatorFragment_.builder().build()).commit();
		forceFloating = new Preferences_(this).calculatorForceFloating().get();
	}

	@Override
	protected Intent getIntentForOpenCase() {
		return new Intent().setClassName("com.android.calculator2",
				"com.android.calculator2.Calculator").putExtra("com.lge.app.floating.launchAsFloating", forceFloating);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.calculator_activity;
	}

	@Override
	protected int getMainCircleLayoutId() {
		return R.id.cover_main_view;
	}

	@Click(R.id.quick_circle_back_btn)
	void onBackClicked() {
		finish();
	}
}
