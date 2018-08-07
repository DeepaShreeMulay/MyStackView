package com.vritti.mystackview;

import android.widget.TextView;

public class StackItem2 {
    private String Title;
    private int drawable;
    private String Amount;

    public StackItem2(String amount, String title, int Drawable) {
        this.Amount = amount;
        this.Title = title;
        this.drawable = Drawable;
    }

    public String getAmount() {
        return Amount;
    }
    public String getTitle() {
        return Title;
    }
    public int getDrawable() {
        return drawable;
    }
}
