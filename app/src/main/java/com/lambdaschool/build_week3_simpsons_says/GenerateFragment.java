package com.lambdaschool.build_week3_simpsons_says;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GenerateFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    static final String ARG_PARAM = "generate";
    private Character character;
    private OnFragmentInteractionListener mListener;

    public GenerateFragment() {
        // Required empty public constructor
    }

    public static GenerateFragment newInstance(String character) {
        GenerateFragment fragment = new GenerateFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, character);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            character = (Character) getArguments().getSerializable(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_generate, container, false);

        if (character != null) {
            DataAccessObject dao = new DataAccessObject();
            ArrayList<String> stringArrayList = dao.generateQuotesByCharacter(character.getName().toLowerCase());

            ImageView imageViewQuote = rootView.findViewById(R.id.image_view_generate_portrait);
            imageViewQuote.setImageResource(character.getImage());
            TextView textViewQuote = rootView.findViewById(R.id.text_view_generate_script);
            StringBuilder stringBuilder = new StringBuilder();
            for (String eachGeneratedQuote : stringArrayList) {
                stringBuilder.append(eachGeneratedQuote);
                stringBuilder.append("\n\n");
            }
            textViewQuote.setText(stringBuilder);
        }
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Character character) {
        if (mListener != null) {
            mListener.onFragmentInteraction(character);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Character character);
    }
}
