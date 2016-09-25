package com.companio.speech;

import android.app.Activity;

import com.ibm.watson.developer_cloud.android.speech_to_text.v1.ISpeechDelegate;
import com.ibm.watson.developer_cloud.android.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.android.speech_to_text.v1.dto.SpeechConfiguration;
import com.ibm.watson.developer_cloud.android.text_to_speech.v1.TextToSpeech;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Kiwi on 9/24/16.
 */
public class CompanioSpeechToText implements ISpeechDelegate {

    private static final String USERNAME = "379fb266-1a2d-4a09-9aaa-31be2153a8ec";
    private static final String PASSWORD = "Gh8GDPpzVuEP";

    private OnMessageCallback callback;

    public CompanioSpeechToText(Activity activity, OnMessageCallback callback) {
        try {
            SpeechToText.sharedInstance().initWithContext(new URI("wss://stream.watsonplatform.net/speech-to-text/api"), activity.getApplicationContext(), new SpeechConfiguration());
            SpeechToText.sharedInstance().setCredentials(USERNAME,PASSWORD);
            SpeechToText.sharedInstance().setDelegate(this);
            SpeechToText.sharedInstance().setModel("en-US_BroadbandModel");

            TextToSpeech.sharedInstance().initWithContext(new URI("https://stream.watsonplatform.net/text-to-speech/api"));
            TextToSpeech.sharedInstance().setCredentials(USERNAME,PASSWORD);
            TextToSpeech.sharedInstance().setVoice("en-US_AllisonVoice");

            this.callback = callback;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        //SpeechToText.sharedInstance().recognize();
    }

    @Override
    public void onOpen() {
        System.out.println("Open Connection");
    }

    @Override
    public void onError(String s) {
        System.out.println("Error with connection");
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onMessage(String s) {
        try {
            JSONObject response = new JSONObject(s);
            JSONObject results = response.getJSONArray("results").getJSONObject(0);
            boolean isFinal = results.getBoolean("final");
            JSONArray alternatives = results.getJSONArray("alternatives");
            if (isFinal) {
                callback.onMessage(alternatives.getJSONObject(0).getString("transcript"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAmplitude(double v, double v1) {

    }
}


