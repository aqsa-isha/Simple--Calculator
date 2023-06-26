package com.example.practical5task2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends Activity implements View.OnClickListener {
    EditText num1, num2, output;
    Button add_btn, sub_btn, mul_btn, div_btn, clear_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.input1);
        num2 = findViewById(R.id.input2);
        output = findViewById(R.id.resultbox);
        add_btn = findViewById(R.id.add_btn);
        sub_btn = findViewById(R.id.sub_btn);
        mul_btn = findViewById(R.id.mul_btn);
        div_btn = findViewById(R.id.div_btn);
        add_btn.setOnClickListener(this);
        sub_btn.setOnClickListener(this);
        mul_btn.setOnClickListener(this);
        div_btn.setOnClickListener(this);
//        clear_btn.setOnClickListener(this);
      }
    @Override
    public void onClick(View v) {
        double a, b;
        double ans=0;
        try {
            a = Double.parseDouble(num1.getText().toString());
            b = Double.parseDouble(num2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getId()) {
            case R.id.add_btn:
                ans = a + b;
                break;
            case R.id.sub_btn:
                ans = a - b;
                break;
            case R.id.mul_btn:
                ans = a * b;
                break;
            case R.id.div_btn:
                if (b == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                ans = a / b;
                break;
        }
        output.setText(String.valueOf(ans));
    }
}
