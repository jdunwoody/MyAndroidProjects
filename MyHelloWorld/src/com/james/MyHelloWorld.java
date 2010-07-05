package com.james;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyHelloWorld extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		define_buttons();

		define_spinner();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		TextView footer = (TextView) findViewById(R.id.text_footer);

		switch (item.getItemId()) {
		case R.id.new_game:
			footer.setText(R.string.new_game_pressed);
			break;
		case R.id.quit:
			footer.setText(R.string.quit_pressed);
			break;
		}
		return false;
	}

	private void define_spinner() {
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, getResources()
						.getStringArray(R.array.planets));
		adapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				showToast("Spinner: position=" + position + " id=" + id);
			}

			public void onNothingSelected(AdapterView<?> parent) {
				showToast("Spinner: unselected");
			}
		});
	}

	private void showToast(String text) {
		Context context = getApplicationContext();

		Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		toast.show();
	}

	private void define_buttons() {
		Button normalButton = (Button) findViewById(R.id.button_normal);
		Button smallButton = (Button) findViewById(R.id.button_small);
		Button toggleButton = (Button) findViewById(R.id.button_toggle);

		final TextView footer = (TextView) findViewById(R.id.text_footer);

		normalButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				footer.setText(R.string.normal_pressed);
			}
		});

		smallButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				footer.setText(R.string.small_pressed);
			}
		});

		toggleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				footer.setText(R.string.toggle_pressed);
			}
		});
	}
}
