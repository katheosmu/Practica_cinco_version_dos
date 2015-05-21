package mainactivity.katherineosorio.com.practica_cinco_version_dos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import mainactivity.katherineosorio.com.practica_cinco_version_dos.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    public static final String POSICION = "position";
    int position = -1;
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Comprobamos si se recupera de un estado anterior
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            if(mItem.id.equals("1")){
                HotelFragment hotel = new HotelFragment();
                fragmentTransaction.replace(android.R.id.content,hotel).commit();
            }
            if(mItem.id.equals("2")){
                BarFragment bar = new BarFragment();
                fragmentTransaction.replace(android.R.id.content, bar).commit();
            }
            if(mItem.id.equals("3")){
                DemoFragment demo = new DemoFragment();
                fragmentTransaction.replace(android.R.id.content,demo).commit();
            }
            if(mItem.id.equals("4")){
                TurismoFragment turis = new TurismoFragment();
                fragmentTransaction.replace(android.R.id.content,turis).commit();
            }
            if(mItem.id.equals("5")){
                AcercaFragment acerca = new AcercaFragment();
                fragmentTransaction.replace(android.R.id.content,acerca).commit();
            }

        }

        return rootView;
    }
}
