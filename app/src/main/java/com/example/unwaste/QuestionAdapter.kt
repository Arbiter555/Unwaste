package com.example.unwaste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter to display questions.
 * Code taken from
 * https://medium.com/android-news/consuming-rest-api-using-retrofit-library-in-android-ed47aef01ecb
 * and https://www.geeksforgeeks.org/android-recyclerview/#
 */

class QuestionAdapter(
    private val questions: List<Question>,
    private val rowLayout: Int,
    private val context: Context
) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionsLayout: RelativeLayout = itemView.findViewById(R.id.question_card)
        val questionText: TextView = itemView.findViewById(R.id.question_text)
        val pubDate: TextView = itemView.findViewById(R.id.pub_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {

        holder.pubDate.text = questions[position].question_text
        holder.questionText.text = questions[position].pub_date
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}
