package com.example.quizz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizz.data.model.QuestionEntity
import com.example.quizz.databinding.QuizzFragmentBinding

class QuizzFragment: Fragment() {

    private lateinit var binding: QuizzFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View {
        binding = QuizzFragmentBinding.inflate(inflater)

        var questions: List<QuestionEntity> = listOf(
            QuestionEntity(0, "Qu'elle est la couleur du cheval blanc d'Henri IV ?", "Blanc"),
            QuestionEntity(0, "Quel framework Front End est développé par Facebook ?", "ReactJS")
        )
        initQuestions(questions)
        return binding.root
    }

    fun initQuestions(questions: List<QuestionEntity>) {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = QuestionAdapter(questions).apply {
                processAnswer = {questions, answer, position -> processInput(questions, answer, position)}
            }
        }
    }

    private fun processInput(questions: QuestionEntity, input: String, position: Int) {
        val isCorrect: Boolean = questions.answer == input
        if (isCorrect) {
            Toast.makeText(context, "Bonne réponse !", Toast.LENGTH_LONG).show()
            binding.recyclerView.smoothScrollToPosition(position + 1)
        } else {
            Toast.makeText(context, "Mauvaise réponse !", Toast.LENGTH_LONG).show()
        }
    }

}