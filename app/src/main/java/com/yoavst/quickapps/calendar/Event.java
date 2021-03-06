package com.yoavst.quickapps.calendar;

import java.io.Serializable;

/**
 * Created by Yoav.
 */
public class Event implements Serializable {
	private final long id;
	private final String title;
	private final String location;
	private long startDate;
	private long endDate;
	private String date;
	private int color;
	boolean isAllDay = false;

	public Event(long id, String title, long startDate, long endDate, String location) {
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.date = CalendarUtil.getDateFromEvent(this);
	}

	public Event(long id, String title, String date, String location) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.location = location;
	}

	public Event setColor(int color) {
		this.color = color;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public String getLocation() {
		return location;
	}

	public long getStartDate() {
		return startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public String getDate() {
		return date;
	}

	public int getColor() {
		return color;
	}

	public long getId() {
		return id;
	}

	/**
	 * Return true if the event takes the whole day.
	 *
	 * @return true if the event takes the whole day.
	 */
	public boolean isAllDay() {
		return isAllDay;
	}

	public Event isAllDay(boolean isAllDay) {
		this.isAllDay = isAllDay;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Event{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", location='").append(location).append('\'');
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", day='").append(date).append('\'');
		sb.append(", color=").append(color);
		sb.append('}');
		return sb.toString();
	}
}
