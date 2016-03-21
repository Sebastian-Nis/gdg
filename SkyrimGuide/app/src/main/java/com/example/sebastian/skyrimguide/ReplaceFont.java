package com.example.sebastian.skyrimguide;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by Sebastian on 21.03.2016.
 */
public class ReplaceFont{
    public static void replaceDefaultFont(Context context, String nameOfFontBeingReplaced, String nameOfFontInAsset){
        Typeface customFontTypeFace = Typeface.createFromAsset(context.getAssets(), nameOfFontInAsset);
        replacefont(nameOfFontBeingReplaced, customFontTypeFace);

    }

    private static void replacefont(String nameOfFontBeingReplaced, Typeface customFontTypeFace) {
        try {
            Field myfield = Typeface.class.getDeclaredField(nameOfFontBeingReplaced);
            myfield.setAccessible(true);
            myfield.set(null, customFontTypeFace);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

