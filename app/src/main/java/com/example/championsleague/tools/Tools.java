package com.example.championsleague.tools;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.championsleague.R;
import com.squareup.picasso.Picasso;

public class Tools {

    public static void loadImages(String urlImage, ImageView imageView) {
        if (!urlImage.isEmpty()) {
            Picasso.get().load(urlImage)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageView);
        } else {
            imageView.setImageResource(0);
        }
    }

    public static TextView createLink(TextView targetTextView,
                                      String completeString, String partToClick,
                                      ClickableSpan clickableAction, Integer color) {

        SpannableString spannableString = new SpannableString(completeString);
        int startIndex = completeString.indexOf(partToClick);
        int endIndex = completeString.lastIndexOf(partToClick) + partToClick.length();
        int mColor = color != null ? color : ContextCompat.getColor(targetTextView.getContext(), R.color.black);

        spannableString.setSpan(clickableAction, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, 0);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD), startIndex, endIndex, 0);

        spannableString.setSpan(new ForegroundColorSpan(mColor), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        targetTextView.setText(spannableString);
        targetTextView.setMovementMethod(LinkMovementMethod.getInstance());

        return targetTextView;
    }
}
