package com.example.pa4fixed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivityTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.my_button);

        button.setOnClickListener(new View.OnClickListener() {
            float neededGrade;

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                EditText letterGradeEditText = (EditText) findViewById(R.id.letter_grade_text);
                EditText minAvgRequiredEditText = (EditText) findViewById(R.id.min_avg);
                EditText curAvgEditText = (EditText) findViewById(R.id.cur_avg);
                EditText finalPercentEditText = (EditText) findViewById(R.id.final_percent);
                TextView userMsg = (TextView) findViewById(R.id.user_msg);
                TextView userGrade = (TextView) findViewById(R.id.user_grade);

                String letterGrade = letterGradeEditText.getText().toString();
                String minAvgRequired = minAvgRequiredEditText.getText().toString();
                String curAvgRequired = curAvgEditText.getText().toString();
                String finalPercent = finalPercentEditText.getText().toString();
                Log.d(TAG, "onClick" + letterGrade + minAvgRequired + curAvgRequired + finalPercent);

                Float minAvg = Float.parseFloat(minAvgRequired);
                Float curAvg = Float.parseFloat(curAvgRequired);
                Float finalPer = Float.parseFloat(finalPercent);

                GradeCalculator calc = new GradeCalculator(minAvg, curAvg, finalPer);
                neededGrade = calc.calculateFinalGrade()*100;
                DecimalFormat df = new DecimalFormat("#.00");
                String outputGrade = df.format(neededGrade);

                String userMsgString = "You need a score of " + outputGrade + " on the final to earn a";
                userMsg.setText(userMsgString);
                userGrade.setText(letterGrade);



            }
        });
    }
}
