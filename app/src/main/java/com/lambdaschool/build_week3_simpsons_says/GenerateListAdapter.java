package com.lambdaschool.build_week3_simpsons_says;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenerateListAdapter extends RecyclerView.Adapter<GenerateListAdapter.ViewHolder> {
    private ArrayList<Character> characterArrayList;
    private GenerateFragment.OnFragmentInteractionListener interactionListener;
    private int lastPositionAnimated = -1;

    public GenerateListAdapter(ArrayList<Character> characterArrayList, GenerateFragment.OnFragmentInteractionListener interactionListener) {
        this.characterArrayList = characterArrayList;
        this.interactionListener = interactionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_element_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Character character = characterArrayList.get(position);
        viewHolder.imageViewCharacter.setImageResource(character.getImage());
        viewHolder.textViewCharacter.setText(character.toString());
        viewHolder.textViewCharacter.setTextSize(30);
        viewHolder.textViewCharacter.setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.textViewCharacter.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        viewHolder.viewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interactionListener != null)
                    interactionListener.onFragmentInteraction(character);
            }
        });

        if (position > lastPositionAnimated) {
            Animation animation = AnimationUtils.loadAnimation(viewHolder.viewParent.getContext(), android.R.anim.fade_in);
            viewHolder.viewParent.startAnimation(animation);
            lastPositionAnimated = position;
        }
    }

    @Override
    public int getItemCount() {
        return characterArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCharacter;
        TextView textViewCharacter;
        View viewParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCharacter = itemView.findViewById(R.id.image_view_element_portrait);
            textViewCharacter = itemView.findViewById(R.id.text_view_element_quote);
            viewParent = itemView.findViewById(R.id.card_view_parent);
        }
    }
}
