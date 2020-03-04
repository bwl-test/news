package com.example.newsdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {
    private String mTitle;
    private String mContent;

    News(String title, String content) {
        mTitle = title;
        mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mContent);
    }

    public static Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            String title = source.readString();
            String content = source.readString();
            return new News(title, content);
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    };
}
