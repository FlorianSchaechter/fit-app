package com.example.fit_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    Button startButton, stopButton;
    int secondsPassed;
    Timer timer;
    TextView secondsTextField;
    private Handler handler = new Handler();

    View.OnClickListener startButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            secondsPassed = 0;
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {
                            secondsTextField.setText(String.format("%d",secondsPassed));
                        }
                    });
                    secondsPassed += 1;
                }
            }, 0, 1000);

        }
    };

    View.OnClickListener stopButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            timer.cancel();
            secondsTextField.setText("0");
        }
    };


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        v =  inflater.inflate(R.layout.fragment_blank, container, false);

        startButton = (Button) v.findViewById(R.id.startButton);
        startButton.setOnClickListener(startButtonListener);
        stopButton = (Button) v.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(stopButtonListener);

        secondsTextField = v.findViewById(R.id.secondsTextField);

        return v;
    }
}