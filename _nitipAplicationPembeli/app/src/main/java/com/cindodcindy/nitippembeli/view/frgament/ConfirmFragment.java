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
import com.cindodcindy.nitippembeli.model.pojo_booking.pojo_get_booking.NitipGetBookingRespon;
import com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.Content;
import com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.NitipGetConfirmRespon;
import com.cindodcindy.nitippembeli.retrofit.MethodsFactory;
import com.cindodcindy.nitippembeli.retrofit.RetrofitHandle;
import com.cindodcindy.nitippembeli.shared_pref.SpHandle;
import com.cindodcindy.nitippembeli.view.adapter.BookingAdapter;
import com.cindodcindy.nitippembeli.view.adapter.ConfirmationAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfirmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ConfirmationAdapter confirmationAdapter;
    private List<com.cindodcindy.nitippembeli.model.pojo_konfirm.pojo_get_konfirm.Content> contentList = new ArrayList<>();
    private MethodsFactory methodsFactory;
    private SpHandle spHandle;



    public ConfirmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmFragment newInstance(String param1, String param2) {
        ConfirmFragment fragment = new ConfirmFragment();
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
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        spHandle = new SpHandle(getContext());

        recyclerView = view.findViewById(R.id.rv_confirm);
        confirmationAdapter = new ConfirmationAdapter( contentList, getContext());
        recyclerView.setAdapter(confirmationAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        buyerConfirmationList();

        return view;
    }

    public void buyerConfirmationList(){

        Long id = spHandle.getIdBuyer();



        methodsFactory = RetrofitHandle.getRetrofitLink().create(MethodsFactory.class);
        Call<NitipGetConfirmRespon> confirmResponCall= methodsFactory.buyerGetConfirmList(id);
        confirmResponCall.enqueue(new Callback<NitipGetConfirmRespon>() {
            @Override
            public void onResponse(Call<NitipGetConfirmRespon> call, Response<NitipGetConfirmRespon> response) {

                if (response.isSuccessful()) {
                    List<Content> content = response.body().getContent();
                    confirmationAdapter = new ConfirmationAdapter(content, getContext());
                    recyclerView.setAdapter(confirmationAdapter);
                    confirmationAdapter.notifyDataSetChanged();
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
            public void onFailure(Call<NitipGetConfirmRespon> call, Throwable t) {
                Toast.makeText(getContext(), "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}