package com.cindodcindy.nitippembeli.view.frgament;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cindodcindy.nitippembeli.R;
import com.cindodcindy.nitippembeli.model.pojo_jasa.pojo_get_jasa.Content;
import com.cindodcindy.nitippembeli.model.pojo_jasa.pojo_get_jasa.NitipGetAllLuggageAscRespon;
import com.cindodcindy.nitippembeli.retrofit.MethodsFactory;
import com.cindodcindy.nitippembeli.retrofit.RetrofitHandle;
import com.cindodcindy.nitippembeli.shared_pref.SpHandle;
import com.cindodcindy.nitippembeli.view.adapter.LuggAvAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CariJasaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CariJasaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private LuggAvAdapter luggAvAdapter;
    private List<Content> contentList = new ArrayList<>();
    private MethodsFactory methodsFactory;
    private SpHandle spHandle;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CariJasaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CariJasaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CariJasaFragment newInstance(String param1, String param2) {
        CariJasaFragment fragment = new CariJasaFragment();
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
         View view = inflater.inflate(R.layout.fragment_cari_jasa, container, false);

        spHandle = new SpHandle(getContext());

        recyclerView = view.findViewById(R.id.rv_lugg_av);
        luggAvAdapter = new LuggAvAdapter( contentList, getContext());
        recyclerView.setAdapter(luggAvAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        sellerGetOwnLuggageList();

        return view;


    }

    public void sellerGetOwnLuggageList(){

        Long id = spHandle.getIdSeller();



        methodsFactory = RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipGetAllLuggageAscRespon> getAllLuggageAscResponCall= methodsFactory.buyerGetAscLuggage();
        getAllLuggageAscResponCall.enqueue(new Callback<NitipGetAllLuggageAscRespon>() {
            @Override
            public void onResponse(Call<NitipGetAllLuggageAscRespon> call, Response<NitipGetAllLuggageAscRespon> response) {

                if (response.isSuccessful()) {
                    List<Content> content = response.body().getContent();
                    luggAvAdapter = new LuggAvAdapter(content, getContext());
                    recyclerView.setAdapter(luggAvAdapter);
                    luggAvAdapter.notifyDataSetChanged();
                }
                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(getContext(), "404 not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(getContext(), "500 internal server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(getContext(), "401 unauthorized", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(getContext(), "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<NitipGetAllLuggageAscRespon> call, Throwable t) {
                Toast.makeText(getContext(), "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}