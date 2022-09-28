package com.example.quizz.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.R
import com.example.quizz.data.model.QuestionEntity

class QuestionAdapter(var questions: List<QuestionEntity>): RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    var processAnswer: ((QuestionEntity, String, Int) -> Unit)? = null

    class QuestionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val reponse: EditText = itemView.findViewById(R.id.answerInput)
        val valider: TextView = itemView.findViewById(R.id.valider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false)
        return QuestionViewHolder(v)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.title.text = questions[position].text
        holder.valider.setOnClickListener { processAnswer?.invoke(questions[position], holder.reponse.text.toString(), position) }
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}