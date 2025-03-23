package com.example.snowflakeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.graphics.Color;

public class SnowflakeFragment extends Fragment
{
    private Button button;
    private LinearLayout snowflakeContainer;
    private int clickCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_snowflake, container, false);
        snowflakeContainer = view.findViewById(R.id.snowflakeContainer);
        Button myButton = view.findViewById(R.id.button);
        if (myButton != null) {
            myButton.setBackgroundColor(Color.parseColor("#FFFAFA"));
            int color = Color.WHITE;
            myButton.setBackgroundColor(color);
        } else {

        }

        myButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                handleButtonClick();
            }
        });
        return view;
    }

    private void handleButtonClick()
    {
        clickCount++;
        snowflakeContainer.removeAllViews();

        switch (clickCount % 5)
        {
            case 1:
                addSnowflake(1);
                break;
            case 2:
                addSnowflake(2);
                break;
            case 3:
                addSnowflake(3);
                break;
            case 4:
                showMessage("Winter has come");
                break;
            case 0:
                addSnowflake(1);
                break;
        }
    }

    private void addSnowflake(int count)
    {
        snowflakeContainer.removeAllViews();
        StringBuilder snowflakes = new StringBuilder();
        for (int i = 0; i < count; i++)
        {
            snowflakes.append("* ");
        }
        for (int i = 0; i < count; i++)
        {
            TextView snowflake = new TextView(getContext());
            snowflake.setText("*");
            snowflake.setTextSize(30);
            snowflake.setTextColor(0xFFFFFFFF);
            snowflake.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            snowflake.setPadding(8, 0, 8, 0);
            snowflakeContainer.addView(snowflake);
        }
    }

    private void showMessage(String message)
    {
        TextView textView = new TextView(getContext());
        textView.setText(getString(R.string.winter_message));
        textView.setTextSize(20);
        textView.setTextColor(0xFFFFFFFF);
        snowflakeContainer.addView(textView);
    }
}