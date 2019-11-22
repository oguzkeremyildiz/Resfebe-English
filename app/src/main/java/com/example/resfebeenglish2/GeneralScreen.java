package com.example.resfebeenglish2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public abstract class GeneralScreen extends Activity {
    protected PictureDictionary pictureDictionary;
    protected Dictionary dictionary;
    protected QuestionList questionList;
    protected Button controlButton;
    protected Button passButton;
    protected ImageView image1;
    protected ImageView image2;
    protected EditText answerText;
    protected int questionNo = 0;
    protected Context context;
    abstract protected void showQuestion();
    abstract protected void findCandidates();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = this;
        pictureDictionary = new PictureDictionary(this);
        dictionary = new Dictionary(this);
        findCandidates();
        questionList.shuffle();
    }

    protected String getAnswer(){
        QuestionCandidate questionCandidate = questionList.getQuestion(questionNo);
        return questionCandidate.getAnswer();
    }

    protected AlertDialog dialog(String message, final boolean newQuestion){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(message);
        builder1.setPositiveButton(
                "Tamam",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (newQuestion){
                            questionNo++;
                            showQuestion();
                        }
                    }
                });
        return builder1.create();
    }

    protected void showPicture(ImageView imageView, int index){
        try {
            QuestionCandidate questionCandidate = questionList.getQuestion(questionNo);
            AssetManager assets = getAssets();
            InputStream imageInputStream = assets.open(questionCandidate.getImage(index).getFileNo() + ".jpg");
            Bitmap imageDrawable = BitmapFactory.decodeStream(imageInputStream);
            imageView.setImageBitmap(imageDrawable);
        } catch (IOException e) {
            dialog("Hatalı dosya " + e.toString(), false).show();
        }
    }

    protected View.OnClickListener controlClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (getAnswer().equals(answerText.getText().toString())){
                dialog("Correct!!!", true).show();
            }else{
                dialog("Wrong!!!", false).show();
            }
        }
    };

    protected View.OnClickListener passClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog(getAnswer(), true).show();
        }
    };

}
