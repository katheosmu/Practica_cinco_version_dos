package mainactivity.katherineosorio.com.practica_cinco_version_dos;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.MapsInitializer;

public class Map extends Fragment {

    private MapView mMapView;
    private GoogleMap mMap;
    private Bundle mBundle;
    private final LatLng LOCATION_SANRAFAEL = new LatLng(6.293544, -75.028577);
    private CameraUpdate cameraUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View inflatedView = inflater.inflate(R.layout.frag_map, container, false);

    try {
        MapsInitializer.initialize(getActivity());
    } catch (Exception e) {
        // TODO handle this situation
    }

    mMapView = (MapView) inflatedView.findViewById(R.id.map);
    mMapView.onCreate(mBundle);
    setUpMapIfNeeded(inflatedView);

    return inflatedView;
}

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = savedInstanceState;
    }

    private void setUpMapIfNeeded(View inflatedView) {
        if (mMap == null) {
            // Intenta obtener el mapa del MapView.
            mMap = ((MapView) inflatedView.findViewById(R.id.map)).getMap();
            // Comprueba si hemos tenido Ã©xito en la obtenciÃ³n del mapa.
            if (mMap != null) {
                mMap.addMarker(new MarkerOptions().position(LOCATION_SANRAFAEL).title("San Rafael")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

                cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_SANRAFAEL, 16);
                mMap.animateCamera(cameraUpdate);
            }
        }
    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(8.850170, -76.42671)).title("Arboletes"));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

}
