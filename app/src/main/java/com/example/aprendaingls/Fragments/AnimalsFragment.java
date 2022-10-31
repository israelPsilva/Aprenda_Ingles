package com.example.aprendaingls.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnDog, btnCat, btnLion, btnMonk, btnSheep, btnCow;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalsFragment.
     */
    // TODO: Rename and change types and number of parameters


    public static AnimalsFragment newInstance(String param1, String param2) {
        AnimalsFragment fragment = new AnimalsFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_animals, container, false );

        btnDog   = view.findViewById( R.id.btnDog );
        btnCat   = view.findViewById( R.id.btnCat );
        btnLion  = view.findViewById( R.id.btnLion );
        btnMonk  = view.findViewById( R.id.btnMonk );
        btnSheep = view.findViewById( R.id.btnSheep );
        btnCow   = view.findViewById( R.id.btnCow );

        //Aplica os eventos de click
        btnDog.setOnClickListener( this::onClick );
        btnCat.setOnClickListener( this::onClick );
        btnLion.setOnClickListener( this::onClick );
        btnMonk.setOnClickListener( this::onClick );
        btnSheep.setOnClickListener( this::onClick );
        btnCow.setOnClickListener( this::onClick );

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnDog:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.dog);
                playerSound();
                break;

            case R.id.btnCat:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.cat);
                playerSound();
                break;

            case R.id.btnLion:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.lion);
                playerSound();
                break;

            case R.id.btnMonk:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.monkey);
                playerSound();
                break;

            case R.id.btnSheep:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.sheep);
                playerSound();
                break;

            case R.id.btnCow:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.cow);
                playerSound();
                break;
        }
    }

    public void playerSound(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            } );
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}