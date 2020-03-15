package com.example.questionarioimpacto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionHolder> {

    List<String> listSection;

   public SectionAdapter(List<String> mListSection){
        this.listSection = mListSection;
    }

    @NonNull
    @Override
    public SectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionHolder holder, int position) {
        holder.button.setText(listSection.get(position));
    }

    @Override
    public int getItemCount() {
        return listSection.size();
    }

    public class SectionHolder extends RecyclerView.ViewHolder{

        public Button button;

        public SectionHolder(View itemView){
            super(itemView);
            button = (Button) itemView.findViewById(R.id.button_section);
        }
    }
}
