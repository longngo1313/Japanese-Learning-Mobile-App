package com.example.longnv.n3test.adapter;



import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.longnv.n3test.models.Question;

import java.util.ArrayList;


/**
 * Created by NGUYEN VU LONG on 8/21/2017.
 * FPT Sofware Company Limited
 */

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.CustomViewHolder> {

    private Activity mActivity;

    private LayoutInflater mInflater;

    public static final String TAG = "QuestionListAdapter";

    private ArrayList<Question> mListData = new ArrayList<>();

    public QuestionListAdapter(ArrayList<Question> personContact, Activity activity) {
        this.mListData = personContact;
        this.mInflater = LayoutInflater.from(activity);
        this.mActivity = activity;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.question_item, parent, false);
        return new QuestionListAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        if(mListData==null || mActivity==null){
            return;
        }

        Question question = mListData.get(position);

        if(question == null){
            return;
        }

        holder.mShortText.setText(question.getShortText());
        holder.mTitle.setText(question.getText());

    }

    @Override
    public int getItemCount() {
        return (mListData!=null && !mListData.isEmpty()) ? mListData.size() : 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgIcon;
        private TextView mTitle;
        private TextView mShortText;

        public CustomViewHolder(View view) {
            super(view);
            this.mImgIcon = (ImageView) view.findViewById(R.id.img_question);
            this.mTitle = (TextView) view.findViewById(R.id.text_question);
            this.mShortText = (TextView) view.findViewById(R.id.short_text_question);
        }
    }
}