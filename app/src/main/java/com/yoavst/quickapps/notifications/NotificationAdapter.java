package com.yoavst.quickapps.notifications;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by Yoav.
 */
public class NotificationAdapter extends FragmentStatePagerAdapter {
    private SparseArray<Fragment> activeFragments = new SparseArray<>(3);

	public NotificationAdapter(FragmentManager fm) {
		super(fm);
	}

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
	public Fragment getItem(int i) {
        Fragment fragment = NotificationsFragment_.builder().mNotification(NotificationsManager.getNotifications().get(i)).build();
        activeFragments.put(i, fragment);
		return fragment;
	}

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        activeFragments.remove(position);
    }

    @Override
	public int getCount() {
		return NotificationsManager.getNotifications() == null ? 0 : NotificationsManager.getNotifications().size();
	}
    public Fragment getActiveFragment(int index) {
        return activeFragments.get(index);
    }
}
