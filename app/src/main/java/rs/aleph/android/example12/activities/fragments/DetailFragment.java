package rs.aleph.android.example12.activities.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.provider.JeloProvider;
import rs.aleph.android.example12.activities.provider.KategorijaProvider;

public class DetailFragment extends Fragment {

    // Position of the item to be displayed in the detail fragment
    private int position = 0;

    // onAttach method is a life-cycle method that is called when a fragment is first attached to its context.
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onAttach()", Toast.LENGTH_SHORT).show();
    }

    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onCreate()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
    }

    // onCreateView method is a life-cycle method that is called  to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        // Finds view in the view hierarchy and returns it.
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(JeloProvider.getJeloById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(JeloProvider.getJeloById(position).getOpis());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = KategorijaProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)JeloProvider.getJeloById(position).getKategorija().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
        //RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        //rbRating.setRating(JeloProvider.getJeloById(position).get());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    // onStart method is a life-cycle method that is called when the Fragment is visible to the user.
    @Override
    public void onStart() {
        super.onStart();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onStart()", Toast.LENGTH_SHORT).show();
    }

    // onResume method is a life-cycle method that is called when the fragment is visible to the user and actively running.
    @Override
    public void onResume() {
        super.onResume();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onResume()", Toast.LENGTH_SHORT).show();
    }

    // onPause method is a life-cycle method that is called when the Fragment is no longer resumed.
    @Override
    public void onPause() {
        super.onPause();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onPause()", Toast.LENGTH_SHORT).show();
    }

    // onStop method is a life-cycle method that is called when the Fragment is no longer started.
    @Override
    public void onStop() {
        super.onStop();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onStop()", Toast.LENGTH_SHORT).show();
    }

    // onDestroyView method is a life-cycle method that is called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle) has been detached from the fragment.
    @Override
    public void onDestroyView() {

        super.onDestroyView();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    // onDestroy method is a life-cycle method that is called when the fragment is no longer in use.
    @Override
    public void onDestroy() {
        super.onDestroy();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onDestroy()", Toast.LENGTH_SHORT).show();
    }

    // onDetach method is a life-cycle method that is called when the fragment is no longer attached to its activity.
    @Override
    public void onDetach() {
        super.onDetach();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onDetach()", Toast.LENGTH_SHORT).show();
    }

    // onSaveInstanceState method is a life-cycle method that is called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance of its process is restarted.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "DetailFragment.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }

    // Called to set fragment's content.
    public void setContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "setContent() sets position to " + position);
    }

    // Called to update fragment's content.
    public void updateContent(final int position) {

        this.position = position;

        Log.v("DetailFragment", "updateContent() sets position to " + position);


        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is;
        try {
            is = getActivity().getAssets().open(JeloProvider.getJeloById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "tvName" TextView and sets "text" property
        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(JeloProvider.getJeloById(position).getName());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(JeloProvider.getJeloById(position).getOpis());

        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) getView().findViewById(R.id.sp_category);
        List<String> categories = KategorijaProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)JeloProvider.getJeloById(position).getKategorija().getId());

        // Finds "rbRating" RatingBar and sets "rating" property
       // RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        //rbRating.setRating(JeloProvider.getJeloById(position).getRating());

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getName() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}


