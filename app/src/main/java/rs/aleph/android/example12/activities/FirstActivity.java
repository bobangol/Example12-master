package rs.aleph.android.example12.activities;

	import 	android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
	import android.content.res.Configuration;
	import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
	import android.support.design.widget.Snackbar;
	import android.support.v4.view.GravityCompat;
	import android.support.v4.widget.DrawerLayout;
	import android.support.v7.app.ActionBarDrawerToggle;
	import android.support.v7.app.AlertDialog;
	import android.support.v7.app.AppCompatActivity;
	import android.support.v7.widget.Toolbar;
	import android.view.Menu;
	import android.view.MenuItem;
	import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
	import android.widget.RelativeLayout;
	import android.widget.Toast;

	import java.util.ArrayList;
	import java.util.List;

import rs.aleph.android.example12.R;
	import rs.aleph.android.example12.activities.adapters.DrawerAdapter;
	import rs.aleph.android.example12.activities.dialogs.AboutDialog;
    import rs.aleph.android.example12.activities.fragments.DetailFragment;
import rs.aleph.android.example12.activities.fragments.ListFragment;
    import rs.aleph.android.example12.activities.model.NavigationItem;
    import rs.aleph.android.example12.activities.provider.JeloProvider;


// Each activity extends Activity class
public class FirstActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

	// Screen orientation
	private boolean landscape = false;

	// Position of the item to be displayed in the detail fragment
	private int position = 0;

	// Master fragment
	private ListFragment masterFragment = null;

	// Detail fragment
	private DetailFragment detailFragment = null;

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if (position == 0) {
				// TODO
				// FirstActivity is already shown
			} else if (position == 1) {
				Intent settings = new Intent(FirstActivity.this,SettingsActivity.class);
				startActivity(settings);
			} else if (position == 2) {
				if (dialog == null){
					dialog = new AboutDialog(FirstActivity.this).prepareDialog();
				} else {
					if (dialog.isShowing()) {
						dialog.dismiss();
					}
				}
				// TODO: SImplify
				// To not create dialog class
				// call it from here.

				dialog.show();
			}

			drawerList.setItemChecked(position, true);
			setTitle(drawerItems.get(position).getTitle());
			drawerLayout.closeDrawer(drawerPane);

		}
	}

	// Attributes used by NavigationDrawer
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;
	private RelativeLayout drawerPane;
	private CharSequence drawerTitle;
	private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();

	// Attributes used by Dialog
	private AlertDialog dialog;

	// Attributes representing the activity's state
	private boolean landscapeMode = false; // Is the device in the landscape mode?
	private boolean masterShown = false; // Is the MasterFragment fragment shown?
	private boolean detailShown = false; // Is the DetailFragment fragment shown?

	private int itemId = 0; // Selected item ID

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);

		// Shows a toast message (a pop-up message)
		//Toast.makeText(getBaseContext(), "FirstActivity.onCreate()", Toast.LENGTH_SHORT).show();

		// Draws layout
		setContentView(R.layout.activity_first);

		// Manages ActionBar

		// Enables ActionBar app icon to behave as action to toggle NavigationDrawer
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
			actionBar.setHomeButtonEnabled(true);
			actionBar.show();
		}


		// Manages NavigationDrawer

		// Populates a list of NavigationDrawer items
		drawerItems.add(new NavigationItem(getString(R.string.drawer_home), getString(R.string.drawer_home_long), R.drawable.ic_action_product));
		drawerItems.add(new NavigationItem(getString(R.string.drawer_home1), getString(R.string.drawer_home_long1), R.drawable.ic_action_product));
		drawerItems.add(new NavigationItem(getString(R.string.drawer_settings), getString(R.string.drawer_settings_long), R.drawable.ic_action_settings));
		drawerItems.add(new NavigationItem(getString(R.string.drawer_about), getString(R.string.drawer_about_long), R.drawable.ic_action_about));

		drawerTitle = getTitle();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerList = (ListView) findViewById(R.id.navList);

		// Populates NavigtionDrawer with options
		drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
		DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

		// Sets a custom shadow that overlays the main content when NavigationDrawer opens
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		drawerList.setAdapter(adapter);

		drawerToggle = new ActionBarDrawerToggle(
				this,                           /* host Activity */
				drawerLayout,                   /* DrawerLayout object */
				toolbar,                        /* nav drawer image to replace 'Up' caret */
				R.string.drawer_open,           /* "open drawer" description for accessibility */
				R.string.drawer_close           /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getSupportActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
			}
		};

		// Manages fragments

		// If the activity is started for the first time create master fragment
		if (savedInstanceState == null) {
			// FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ListFragment masterFragment = new ListFragment();
			ft.add(R.id.master_view, masterFragment, "List_Fragment_1");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}

		// If the device is in the landscape mode and the detail fragment is null create detail fragment
		if (findViewById(R.id.detail_view) != null) {
			landscapeMode = true;
			getFragmentManager().popBackStack();

			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			if (detailFragment == null) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				detailFragment = new DetailFragment();
				ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
				detailShown = true;
			}
		}

		masterShown = true;
		detailShown = false;
		itemId = 0;
	}



	// Method(s) that manage Fragments.

	// onItemSelected method handles selection of items in the MasterFragment fragment
	public void onItemSelected(int id) {

		itemId = id;

		// Shows a toast message (a pop-up message)
		//Toast.makeText(getBaseContext(), "FirstActivity.onItemSelected()", Toast.LENGTH_SHORT).show();

		if (landscapeMode) {
			// If the device is in the landscape mode updates detail fragment's content.
			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			detailFragment.updateContent(id);
		} else {
			// If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
			DetailFragment detailFragment = new DetailFragment();
			detailFragment.setContent(id);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();

			masterShown = false;
			detailShown = true;
		}
	}

	// onBackPressed method is called when the activity has detected the user's press of the back key (it has to be overrided because fragment's behavior has to be implemented manualy).
	@Override
	public void onBackPressed() {

		if (landscapeMode) {
			finish();
		} else if (masterShown == true) {
			finish();
		} else if (detailShown == true) {
			getFragmentManager().popBackStack();
			ListFragment masterFragment = new ListFragment();
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.master_view, masterFragment, "Master_Fragment");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			masterShown = true;
			detailShown = false;
		}

	}



	// Method(s) that manage Toolbar.

	// onCreateOptionsMenu method initialize the contents of the Activity's Toolbar.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_create:
				Toast.makeText(this, "Action " + getString(R.string.fragment_master_action_create) + " executed.", Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_update:
				Toast.makeText(this, "Action " + getString(R.string.fragment_detal_action_update) + " executed.", Toast.LENGTH_SHORT).show();
				break;
			case R.id.action_delete:
				Toast.makeText(this, "Action " + getString(R.string.fragment_detal_action_delete) + " executed.", Toast.LENGTH_SHORT).show();
				Snackbar.make(findViewById(R.id.master_view), "test snackbar-a", Snackbar.LENGTH_SHORT).show();
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	// Overrides setTitle method to support older api levels
	@Override
	public void setTitle(CharSequence title) {
		getSupportActionBar().setTitle(title);
	}



	// Method(s) that manage NavigationDrawer.

	// onPostCreate method is called ofthen onRestoreInstanceState to synchronize toggle state
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	// onConfigurationChanged method is called when the device configuration changes to pass configuration change to the drawer toggle
	@Override
	public void onConfigurationChanged(Configuration configuration) {
		super.onConfigurationChanged(configuration);

		// Pass any configuration change to the drawer toggle
		drawerToggle.onConfigurationChanged(configuration);
	}

}