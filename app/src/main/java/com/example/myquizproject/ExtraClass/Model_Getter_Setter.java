package com.example.myquizproject.ExtraClass;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Model_Getter_Setter implements Parcelable {


  String ques;
  String cat;

    public Model_Getter_Setter(String cat, String ques, String[] incorrect_ans, String correct_ans) {
        this.ques = ques;
        this.incorrect_ans = incorrect_ans;
        this.correct_ans = correct_ans;
        this.cat = cat;
    }

    String[] incorrect_ans;
    String correct_ans;


    protected Model_Getter_Setter(Parcel in) {
        ques = in.readString();
        cat = in.readString();
        incorrect_ans = in.createStringArray();
        correct_ans = in.readString();
    }

    public static final Creator<Model_Getter_Setter> CREATOR = new Creator<Model_Getter_Setter>() {
        @Override
        public Model_Getter_Setter createFromParcel(Parcel in) {
            return new Model_Getter_Setter(in);
        }

        @Override
        public Model_Getter_Setter[] newArray(int size) {
            return new Model_Getter_Setter[size];
        }
    };

    public String getQues() {
        return ques;
    }

    public String[] getIncorrect_ans() {
        return incorrect_ans;
    }

    public String getCat() {
        return cat;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ques);
        dest.writeString(cat);
        dest.writeStringArray(incorrect_ans);
        dest.writeString(correct_ans);
    }
}




