package com.example.zebranie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zebranie.R;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.PushService;

public class ZebranieActivity extends Activity {
	private ListView zebraniaList;
	private ZebranieAdapter taskAdapter;

	@Override
	public void onResume() {
		super.onResume();
		updateData();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_to_do);

		// inicjalizacja Parse
		Parse.initialize(this, "KxbAkP9fVFoQVX965kF5ly97pIDc9RsSy7ft32JO",
				"CnocIFbYpf17uHtyLqffsPB1kvVnMle7j5JXUhRC");			
		
		ParseAnalytics.trackAppOpened(getIntent());
		ParseObject.registerSubclass(Zebranie.class);// polaczenie z klasa
		PushService.setDefaultPushCallback(this, ZebranieActivity.class);
		ParseInstallation.getCurrentInstallation().saveInBackground();

	//	context = getApplicationContext();
		zebraniaList = (ListView) findViewById(R.id.taskList);

		taskAdapter = new ZebranieAdapter(this, new ArrayList<Zebranie>());
		zebraniaList.setAdapter(taskAdapter);
	/*	Date data = new Date();
		long time = data.getTime();
		Zebranie zebranie = new Zebranie();
		zebranie.setCompleted(false);
		zebranie.setDescription("localhost:3355");
		zebranie.setDate(new Date(time+200000000));
		zebranie.saveInBackground();*/
		
		zebraniaList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Zebranie zebranie = (Zebranie) zebraniaList.getItemAtPosition(position);
				TextView taskDescription = (TextView) view.findViewById(R.id.task_description);
				taskDescription.setText("Zebranie:"
						+ "\nData: "
						+ zebranie.getDate().toLocaleString()
						+ "\nAdres:port : " 
						+ zebranie.getDescription());

				if (zebranie.isCompleted()) {

					taskAdapter.remove(zebranie);
					zebranie.deleteEventually();

				}

			}
		});
		updateData();
	

	}

	public void updateData() {
		ParseQuery<Zebranie> query = ParseQuery.getQuery(Zebranie.class);
	//	query.setCachePolicy(CachePolicy.CACHE_THEN_NETWORK);// zapamietanie
																// ostatniej
																// pobranej
																// wersji
		query.findInBackground(new FindCallback<Zebranie>() {

			@Override
			public void done(List<Zebranie> zebrania, ParseException error) {
				if (zebrania != null) {
					taskAdapter.clear();
					for (int i = zebrania.size() - 1; i >= 0; i--) {
						taskAdapter.add(zebrania.get(i));
					}
				}
			}
		});
	}

}
