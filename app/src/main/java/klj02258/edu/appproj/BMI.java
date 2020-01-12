package klj02258.edu.appproj;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class BMI extends Fragment {

    EditText    height;
    EditText    weight;
    TextView    result;
    Button      calculate;

    public BMI() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_bmi, container, false);

        height = (EditText) rootview.findViewById(R.id.height);
        weight = (EditText) rootview.findViewById(R.id.weight);
        result = (TextView) rootview.findViewById(R.id.result);
        calculate = (Button) rootview.findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        return rootview;
    }

    private void calculateBMI(){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){
            float heightValue;
            float weightValue;

            //convert from imperial to metric


            heightValue = Float.parseFloat(heightStr) * 2.54f/(100);
            weightValue = Float.parseFloat(weightStr) * 0.45359237f;

            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi){
        String bmiLabel = "";

        if(Float.compare(bmi, 15f) <= 0){
            bmiLabel = "Very severely underweight";
        }else if(Float.compare(bmi, 15f) > 0 && Float.compare(bmi,16f) <= 0){
            bmiLabel = "Severely underweight";
        }else if(Float.compare(bmi, 16f) > 0 && Float.compare(bmi,18.5f) <= 0){
            bmiLabel = "Underweight";
        }else if(Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi,25f) <= 0){
            bmiLabel = "Normal";
        }else if(Float.compare(bmi, 25f) > 0 && Float.compare(bmi,30f) <= 0){
            bmiLabel = "Overweight";
        }else if(Float.compare(bmi, 30f) > 0 && Float.compare(bmi,35f) <= 0){
            bmiLabel = "Obese Class I";
        }else if(Float.compare(bmi, 35f) > 0 && Float.compare(bmi,40f) <= 0){
            bmiLabel = "Obese Class II";
        }else{
            bmiLabel = "Obese Class III";
        }

        bmiLabel = bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);

    }

}






















