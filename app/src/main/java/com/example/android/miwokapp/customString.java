package com.example.android.miwokapp;

/**
 * Created by Ritam Mallick on 20-12-2016.
 */
public class customString {
    private String[] str = new String[2];
    private int imageId;
    private int audioId;

    public customString(String str1, String str2,int audioId) {
        str[0] = str1;
        str[1] = str2;
        imageId = 0;
        this.audioId=audioId;
    }

    public customString(String str1, String str2, int imageId,int audioId) {
        str[0] = str1;
        str[1] = str2;
        this.imageId = imageId;
        this.audioId=audioId;
    }

    public String getString(int index) {
        //    if(index==0||index==1)
        return str[index];
    }

    public int getImageid() {
        return imageId;
    }
    public int getAudioId(){ return audioId;}
}
