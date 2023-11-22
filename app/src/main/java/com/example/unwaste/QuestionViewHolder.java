package com.example.unwaste;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/** ViewHolder for the Question class.
 *  Code taken from https://www.geeksforgeeks.org/android-recyclerview/# */

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    TextView questionText;
    TextView pubDate;
    View view;

    QuestionViewHolder(View itemView)
    {
        super(itemView);
        questionText
                = (TextView)itemView
                .findViewById(R.id.question_text);
        pubDate
                = (TextView)itemView
                .findViewById(R.id.pub_date);
        view  = itemView;
    }
}
