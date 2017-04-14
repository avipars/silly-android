package me.angrybyte.sillyandroid;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresPermission;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.View;

import java.io.Closeable;

/**
 * An extension of {@link AppCompatActivity} with applied extensions from {@link SillyAndroid} extension set.
 */
@UiThread
@SuppressWarnings("unused")
public class Activity extends AppCompatActivity {

    /**
     * Returns the result from {@link SillyAndroid#countIntentHandlers(Context, Intent)}.
     */
    @IntRange(from = 0)
    public int countIntentHandlers(@Nullable final Intent intent) {
        return SillyAndroid.countIntentHandlers(this, intent);
    }

    /**
     * Returns the result from {@link SillyAndroid#canHandleIntent(Context, Intent)}.
     */
    public boolean canHandleIntent(@Nullable final Intent intent) {
        return SillyAndroid.canHandleIntent(this, intent);
    }

    /**
     * Returns the result from {@link SillyAndroid#findViewById(android.app.Activity, int)}.
     */
    public <ViewType extends View> ViewType findView(@IdRes final int viewId) {
        return SillyAndroid.findViewById(this, viewId);
    }

    /**
     * Returns the result from {@link SillyAndroid#isEmpty(String)}.
     */
    public boolean isEmpty(@Nullable final String text) {
        return SillyAndroid.isEmpty(text);
    }

    /**
     * Returns the result from {@link SillyAndroid#dismiss(PopupMenu)}.
     */
    public boolean dismiss(@Nullable final PopupMenu menu) {
        return SillyAndroid.dismiss(menu);
    }

    /**
     * Returns the result from {@link SillyAndroid#dismiss(Dialog)}.
     */
    public boolean dismiss(@Nullable final Dialog dialog) {
        return SillyAndroid.dismiss(dialog);
    }

    /**
     * Returns the result from {@link SillyAndroid#close(Closeable)}.
     */
    public boolean close(@Nullable final Closeable closeable) {
        return SillyAndroid.close(closeable);
    }

    /**
     * Returns the result from {@link SillyAndroid#close(Cursor)}.
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public boolean close(@Nullable final Cursor cursor) {
        return SillyAndroid.close(cursor);
    }

    /**
     * Returns the result from {@link ContextCompat#getDrawable(Context, int)}.
     */
    @Nullable
    public Drawable getDrawableCompat(@DrawableRes final int drawableId) {
        return ContextCompat.getDrawable(this, drawableId);
    }

    /**
     * Invokes {@link ViewCompat#setBackground(View, Drawable)} with the same arguments.
     */
    public void setBackgroundCompat(@NonNull final View view, @Nullable final Drawable drawable) {
        ViewCompat.setBackground(view, drawable);
    }

    /**
     * Invokes {@link SillyAndroid#setPadding(View, int, int, int, int)} with the same arguments.
     */
    public void setPadding(@NonNull final View view, @Px final int start, @Px final int top, @Px final int end, @Px final int bottom) {
        SillyAndroid.setPadding(view, start, top, end, bottom);
    }

    /**
     * Invokes {@link SillyAndroid#setPadding(View, int)} with the same arguments.
     */
    public void setPadding(@NonNull final View view, @Px final int padding) {
        SillyAndroid.setPadding(view, padding);
    }

    /**
     * Returns the result from {@link SillyAndroid#isNetworkConnected(Context)}.
     */
    @RequiresPermission(allOf = { Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE })
    public boolean isNetworkConnected() {
        return SillyAndroid.isNetworkConnected(this);
    }

    /**
     * Returns the result from {@link SillyAndroid#isVoiceInputAvailable(Context)}.
     */
    public boolean isVoiceInputAvailable() {
        return SillyAndroid.isVoiceInputAvailable(this);
    }

}
