package com.example.javaproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn;
    private Button option2Btn;
    private Button option3Btn;
    private Button option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttemped);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestions(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

//        setContentView(R.layout.activity_main);
//
        Button openBottomSheet = findViewById(R.id.open_bottom_sheet);


        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        openBottomSheet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
//                        BottomSheetDialog bottomSheet = new BottomSheetDialog();
                        showBottomSheet();
                    }
                });

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        TextView successTV = bottomSheetView.findViewById(R.id.idTVSuccess);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Score is\n" + currentScore + "/10");
        if (currentScore > 7){
            successTV.setText("Completed successfully");
        }
        else{
            successTV.setText("Failed");
        }
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }




    @SuppressLint("SetTextI18n")
    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Question " + questionAttempted + "/10");
        if (questionAttempted == 10){
            showBottomSheet();
        }
        else {
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }

    }

    private void getQuizQuestions(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("When is Harry Potter’s birthday?", "July 31", "August 22", "February 1", "wwdhhhhh", "July 31"));
        quizModalArrayList.add(new QuizModal("Where do the Dursleys live?", "0_o", "Godric’s Hollow", "Little Whinging", "Diagon Alley", "Little Whinging"));
        quizModalArrayList.add(new QuizModal("How many brothers does Ron have?", "Seven", "Five", "Tree", "Two", "Five"));
        quizModalArrayList.add(new QuizModal("What is one ingredient used to make the Polyjuice Potion?", "Unicorn blood", "o_0", "Frog legs", "Lacewing flies", "Lacewing flies"));
        quizModalArrayList.add(new QuizModal("Which of these is one of the Unforgivable Curses?", "Imperius", "Expelliarmus", "Alohomora", "Petrificus Totalus", "Imperius"));
        quizModalArrayList.add(new QuizModal("What is Hermione’s middle name?", "Jean", "Diane", "Monica", "Victoria", "Jean"));
        quizModalArrayList.add(new QuizModal("What is Harry’s Patronus??", "Capybara", "Otter", "Stag", "Lion", "Stag"));
        quizModalArrayList.add(new QuizModal("How many points is the Golden Snitch worth?", "150", "100", "50", "10", "150"));
        quizModalArrayList.add(new QuizModal("What is the name of Fred’s and George’s joke shop?", "Weasleys’ Joke Emporium", "Weasleys’ Wizard Wheezes", "The Magic Shoppe", "Weasleys’ shop", "Weasleys’ Wizard Wheezes"));
        quizModalArrayList.add(new QuizModal("Who was NOT one of the creators of the Marauder’s Map?", "Peter Pettigrew", "Severus Snape", "Sirius Black", "James Potter", "Severus Snape"));

    }
}