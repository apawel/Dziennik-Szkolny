package com.example.zebranie;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.example.zebranie.R;

import android.content.Context;
import android.graphics.Paint;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ZebranieAdapter extends ArrayAdapter<Zebranie> {
	private Context mContext;
	private List<Zebranie> mTasks;

	public ZebranieAdapter(Context context, List<Zebranie> objects) {
		super(context, R.layout.task_row, objects);
		this.mContext = context;
		this.mTasks = objects;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
			convertView = mLayoutInflater.inflate(R.layout.task_row, null);
		}

		Zebranie zebranie = mTasks.get(position);

		TextView view = (TextView) convertView
				.findViewById(R.id.task_description);
		Date data = new Date();
		view.setText("Zebranie"
				+ "\nData: "
				+ zebranie.getDate());
				

	//	if (new Date(zebranie.getDate()).getTime() <= data.getTime()
	//			&& !zebranie.isCompleted()) {
	//		zebranie.setCompleted(true);
	//	}
		if (zebranie.isCompleted()) {
			view.setPaintFlags(view.getPaintFlags()
					| Paint.STRIKE_THRU_TEXT_FLAG);
		} else {
			view.setPaintFlags(view.getPaintFlags()
					& (~Paint.STRIKE_THRU_TEXT_FLAG));
		}

		return convertView;
	}

}
