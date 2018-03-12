package com.android.awareofplaces.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.awareofplaces.Utils.Constants;
import com.android.awareofplaces.R;
import com.android.awareofplaces.data.PlaceDetailDataBase;
import com.android.awareofplaces.network.PlacesSearchService;
import com.android.awareofplaces.network.ApiClient;
import com.android.awareofplaces.network.TouristPlaces;
import com.android.awareofplaces.network.TouristPlacesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlacesDisplayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlacesDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesDisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
//    protected GeoDataClient mGeoDataClient;
    public PlacesDisplayFragment() {
        // Required empty public constructor
        // Construct a GeoDataClient.
//        mGeoDataClient = Places.getGeoDataClient(getActivity(), null);
    }

    // TODO: Rename and change types and number of parameters
    public static PlacesDisplayFragment newInstance(String param1, String param2) {
        PlacesDisplayFragment fragment = new PlacesDisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_places_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_display_data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        setUpUi();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    private void setUpUi() {
        PlacesSearchService apiService =
                ApiClient.getClient().create(PlacesSearchService.class);

        Call<TouristPlacesResponse> call = apiService.getTouristPlacesList("tourists place of india", Constants.GEO_API_KEY);
        call.enqueue(new Callback<TouristPlacesResponse>() {
            @Override
            public void onResponse(@NonNull Call<TouristPlacesResponse>call,@NonNull Response<TouristPlacesResponse> response) {
                if(response.body()!=null){
                    List<TouristPlaces> places = response.body().getResults();
                    if(places != null){

                        PlaceDetailDataBase detailDataBase = PlaceDetailDataBase.getInstance(getContext());

                      //  detailDataBase.placeDetails().insert()
                        // place room library concept for first storing network to database then display in view by
                        // retrieved from db
                        Log.i("PlacesDisplayFragment", "Number of movies received: " + places.size());

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<TouristPlacesResponse> call,@NonNull Throwable t) {
                // Log error here since request failed
                Log.e("PlaceActivity", t.toString());
            }
        });
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
