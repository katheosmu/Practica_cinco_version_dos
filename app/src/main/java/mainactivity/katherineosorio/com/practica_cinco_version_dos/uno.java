package mainactivity.katherineosorio.com.practica_cinco_version_dos;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 11/06/2015.
 */
public class uno extends Fragment {

    private GoogleMap map;
    private CameraUpdate cameraUpdate;

    private final LatLng LOCATION_SANRAFAEL = new LatLng(6.293544, -75.028577);
    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent i = new Intent();
        startActivity(i);

        rootView = inflater.inflate(R.layout.frag_map, container, false);

        return rootView;
    }
}
