package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import rs.aleph.android.example12.R;

// Each activity extends Activity class
public class FirstActivity extends Activity {

	static final int PICK_CONTACT_REQUEST = 0;  // The request code

	// The activity's state
	private int a;
	private float b;
	private String c;
	private int[] d = {0, 1, 2, 3, 4};

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);

		// setContentView method draws UI
		setContentView(R.layout.activity_main);

		// Load instance state from bundle
		if (savedInstanceState != null) {
			this.a = savedInstanceState.getInt("a");
			this.b = savedInstanceState.getFloat("b");
			this.c = savedInstanceState.getString("c");
			this.d = savedInstanceState.getIntArray("d");
		}

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onCreate()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onStart method is a lifecycle method called after onCreate (or after onRestart when the
	// activity had been stopped, but is now again being displayed to the user)
	@Override
	protected void onStart() {

		super.onStart();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStart()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onRestart method is a lifecycle method called after onStop when the current activity is
	// being re-displayed to the user
	@Override
    protected void onRestart() {

		super.onRestart();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onRestart()", Toast.LENGTH_SHORT);
		toast.show();
    }

	// onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
	// onPause, for your activity to start interacting with the user
	@Override
	protected void onResume() {

		super.onResume();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onResume()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onPause method is a lifecycle method called when an activity is going into the background,
	// but has not (yet) been killed
	@Override
	protected void onPause() {

		super.onPause();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onPause()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onStop method is a lifecycle method called when the activity are no longer visible to the user
	@Override
	protected void onStop() {

		super.onStop();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStop()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
	@Override
	protected void onDestroy() {

		super.onDestroy();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onDestroy()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onSaveInstanceState method is a life-cycle method that is called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance of its process is restarted.
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		super.onSaveInstanceState(savedInstanceState);

		// Shows a toast message (a pop-up message)
		Toast.makeText(this, "FirstActivity.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

		savedInstanceState.putInt("a", a);
		savedInstanceState.putFloat("b", b);
		savedInstanceState.putString("c", c);
		savedInstanceState.putIntArray("d", d);
	}

	// Called when btnStart button is clicked
	public void btnStartActivityClicked(View view) {
		// This is an explicit intent (class property is specified)
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
		// startActivity method starts an activity
        startActivity(intent);
	}

	// Called when btnSelectContact button is clicked
    public void btnSelectContactClicked(View view) {
		// This is an implicit intent
        Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
		// Show user only contacts w/ phone numbers
		intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
		// startActivity method starts an activity
		startActivityForResult(intent, PICK_CONTACT_REQUEST);
    }

    // Called when an activity you launched exits, giving you the requestCode you started it with, the resultCode it returned, and any additional data from it.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request it is that we're responding to
		if (requestCode == PICK_CONTACT_REQUEST) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				// Get the URI that points to the selected contact
				Uri contactUri = data.getData();

                // Shows contact URI
                Toast.makeText(this, "Contact URI: " + contactUri, Toast.LENGTH_SHORT).show();
            }
		}
	}
}
