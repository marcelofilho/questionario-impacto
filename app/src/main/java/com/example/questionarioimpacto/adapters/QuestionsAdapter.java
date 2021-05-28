package com.example.questionarioimpacto.adapters;

import android.text.Layout;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questionarioimpacto.R;
import com.example.questionarioimpacto.models.QuestionIdModel;
import com.example.questionarioimpacto.models.QuestionListModel;
import com.example.questionarioimpacto.models.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionHolder> {

   private ArrayList<QuestionModel> questions;
   private QuestionListenner questionListenner;

   public QuestionsAdapter(ArrayList<QuestionModel> mList, QuestionListenner mQuestionListenner){
       this.questions = mList;
       this.questionListenner = mQuestionListenner;
   }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new QuestionHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionHolder holder, final int position) {

           holder.question.setText(questions.get(position).getTitle());
           holder.question.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (holder.llUncomfortableEvel.getVisibility() == View.GONE) {
                       TransitionManager.beginDelayedTransition(holder.llUncomfortableEvel, new AutoTransition());
                       holder.llUncomfortableEvel.setVisibility(View.VISIBLE);

                   } else {
                       TransitionManager.beginDelayedTransition(holder.llUncomfortableEvel, new AutoTransition());
                       holder.llUncomfortableEvel.setVisibility(View.GONE);

                   }
               }
           });

           holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup group, int checkedId) {
                   if (checkedId == holder.btnLittle.getId()) {
                       holder.btnLittle.setBackgroundResource(R.drawable.bg_border_round_light_yellow);
                       questionListenner.atualizarStatus(questions.get(position).getId(), "Pouco");
                   } else {
                       holder.btnLittle.setBackgroundResource(R.drawable.bg_border_round_light);
                   }
                   if (checkedId == holder.btnNothing.getId()) {
                       holder.btnNothing.setBackgroundResource(R.drawable.bg_border_round_light_yellow);
                       questionListenner.atualizarStatus(questions.get(position).getId(), "Nenhum");
                   } else {
                       holder.btnNothing.setBackgroundResource(R.drawable.bg_border_round_light);
                   }
                   if (checkedId == holder.btnVery.getId()) {
                       holder.btnVery.setBackgroundResource(R.drawable.bg_border_round_light_yellow);
                       questionListenner.atualizarStatus(questions.get(position).getId(), "Muito");
                   } else {
                       holder.btnVery.setBackgroundResource(R.drawable.bg_border_round_light);
                   }
               }
           });

    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class QuestionHolder extends RecyclerView.ViewHolder {

        private TextView question;
        private LinearLayout llUncomfortableEvel;
        private RadioGroup radioGroup;
        private RadioButton btnVery, btnLittle, btnNothing;


        public QuestionHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.label_question);
            llUncomfortableEvel = (LinearLayout) itemView.findViewById(R.id.ll_uncomfortable_evel);
            btnVery = itemView.findViewById(R.id.btn_very);
            btnLittle = itemView.findViewById(R.id.btnc_little);
            btnNothing = itemView.findViewById(R.id.btn_nothing);
            radioGroup = itemView.findViewById(R.id.radiogroup);

        }
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    public interface QuestionListenner{
        void atualizarStatus(String id, String status);
    }
}
