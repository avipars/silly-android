package me.angrybyte.sillyandroid.components;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresPermission;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.View;

import java.io.Closeable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import me.angrybyte.sillyandroid.BuildConfig;
import me.angrybyte.sillyandroid.SillyAndroid;
import me.angrybyte.sillyandroid.parsable.LayoutWrapper;

/**
 * An extension of the {@link Fragment} with applied extensions from the {@link SillyAndroid} extension set.
 */
@UiThread
@SuppressWarnings("unused")
public class EasyFragment extends Fragment implements LayoutWrapper {

    // <editor-fold desc="Public API">

    /**
     * Finds the proper Context from either {@link Fragment#getContext()} or {@link #getActivity()}.
     * Activity comes first if both are not {@code null}.
     *
     * @return A Context instance, or {@code null} if this fragment is not attached to a context yet
     */
    @Nullable
    public final Context getContext() {
        return getActivity() == null ? super.getContext() : getActivity();
    }

    /**
     * Returns the result from {@link SillyAndroid#findViewById(Fragment, int)}.
     */
    public final <ViewType extends View> ViewType findView(@IdRes final int viewId) {
        return SillyAndroid.findViewById(this, viewId);
    }
    // </editor-fold>

    // <editor-fold desc="Internal methods">

    /**
     * Returns the result from {@link SillyAndroid#equal(Object, Object)}.
     */
    protected final boolean equal(@Nullable final Object first, @Nullable final Object second) {
        return SillyAndroid.equal(first, second);
    }

    /**
     * Returns the result from {@link SillyAndroid#countIntentHandlers(Context, Intent)}.
     */
    @IntRange(from = 0)
    protected final int countIntentHandlers(@Nullable final Intent intent) {
        final Context context = getContext();
        return context == null ? 0 : SillyAndroid.countIntentHandlers(context, intent);
    }

    /**
     * Returns the result from {@link SillyAndroid#canHandleIntent(Context, Intent)}.
     */
    protected final boolean canHandleIntent(@Nullable final Intent intent) {
        final Context context = getContext();
        return context != null && SillyAndroid.canHandleIntent(context, intent);
    }

    /**
     * Returns the result from {@link SillyAndroid#isEmpty(String)}.
     */
    protected final boolean isEmpty(@Nullable final String text) {
        return SillyAndroid.isEmpty(text);
    }

    /**
     * Returns the result from {@link SillyAndroid#dismiss(PopupMenu)}.
     */
    protected final boolean dismiss(@Nullable final PopupMenu menu) {
        return SillyAndroid.dismiss(menu);
    }

    /**
     * Returns the result from {@link SillyAndroid#dismiss(Dialog)}.
     */
    protected final boolean dismiss(@Nullable final Dialog dialog) {
        return SillyAndroid.dismiss(dialog);
    }

    /**
     * Returns the result from {@link SillyAndroid#close(Closeable)}.
     */
    protected final boolean close(@Nullable final Closeable closeable) {
        return SillyAndroid.close(closeable);
    }

    /**
     * Returns the result from {@link SillyAndroid#close(Cursor)}.
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    protected final boolean close(@Nullable final Cursor cursor) {
        return SillyAndroid.close(cursor);
    }

    /**
     * Returns the result from {@link ContextCompat#getDrawable(Context, int)}.
     */
    @Nullable
    protected final Drawable getDrawableCompat(@DrawableRes final int drawableId) {
        final Context context = getContext();
        return context == null ? null : ContextCompat.getDrawable(context, drawableId);
    }

    /**
     * Invokes {@link ViewCompat#setBackground(View, Drawable)} with the same arguments.
     */
    protected final void setBackgroundCompat(@NonNull final View view, @Nullable final Drawable drawable) {
        ViewCompat.setBackground(view, drawable);
    }

    /**
     * Invokes {@link SillyAndroid#setPadding(View, int, int, int, int)} with the same arguments.
     */
    protected final void setPadding(@NonNull final View view, @Px final int start, @Px final int top, @Px final int end, @Px final int bottom) {
        SillyAndroid.setPadding(view, start, top, end, bottom);
    }

    /**
     * Invokes the {@link SillyAndroid#setPaddingVertical(View, int)} with the same arguments.
     */
    protected final void setPaddingVertical(@NonNull final View view, @Px final int padding) {
        SillyAndroid.setPaddingVertical(view, padding);
    }

    /**
     * Invokes the {@link SillyAndroid#setPaddingHorizontal(View, int)} with the same arguments.
     */
    protected final void setPaddingHorizontal(@NonNull final View view, @Px final int padding) {
        SillyAndroid.setPaddingHorizontal(view, padding);
    }

    /**
     * Invokes {@link SillyAndroid#setPadding(View, int)} with the same arguments.
     */
    protected final void setPadding(@NonNull final View view, @Px final int padding) {
        SillyAndroid.setPadding(view, padding);
    }

    /**
     * Returns the result from {@link SillyAndroid#isNetworkConnected(Context)}.
     */
    @RequiresPermission(allOf = { Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE })
    protected final boolean isNetworkConnected() {
        final Context context = getContext();
        return context != null && SillyAndroid.isNetworkConnected(context);
    }

    /**
     * Returns the result from {@link SillyAndroid#isVoiceInputAvailable(Context)}.
     */
    protected final boolean isVoiceInputAvailable() {
        final Context context = getContext();
        return context != null && SillyAndroid.isVoiceInputAvailable(context);
    }
    // </editor-fold>

    // <editor-fold desc="Toasts">

    /**
     * Invokes {@link SillyAndroid#toastShort(Context, int)}.
     */
    protected final void toastShort(@StringRes final int stringId) {
        final Context context = getContext();
        if (context != null) {
            SillyAndroid.toastShort(getContext(), stringId);
        }
    }

    /**
     * Invokes {@link SillyAndroid#toastShort(Context, String)}.
     */
    protected final void toastShort(@NonNull final String string) {
        final Context context = getContext();
        if (context != null) {
            SillyAndroid.toastShort(getContext(), string);
        }
    }

    /**
     * Invokes {@link SillyAndroid#toastLong(Context, int)}.
     */
    protected final void toastLong(@StringRes final int stringId) {
        final Context context = getContext();
        if (context != null) {
            SillyAndroid.toastLong(getContext(), stringId);
        }
    }

    /**
     * Invokes {@link SillyAndroid#toastLong(Context, String)}.
     */
    protected final void toastLong(@NonNull final String string) {
        final Context context = getContext();
        if (context != null) {
            SillyAndroid.toastLong(getContext(), string);
        }
    }
    // </editor-fold>

    // <editor-fold desc="Permissions">

    /**
     * Checks if given permission was granted by the user.
     *
     * @param permission Which permission to check
     * @return {@code True} if permission check {@link ContextCompat#checkSelfPermission(Context, String)} returns {@link PackageManager#PERMISSION_GRANTED}
     * for the given permission, {@code false} if it is {@code null} or not granted
     */
    protected boolean hasPermission(@Nullable String permission) {
        final Context context = getContext();
        return context != null && permission != null && ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Requests the given permissions using runtime permission dialogs; if API level is not sufficient, nothing happens.
     *
     * @param code        The code to request the permissions with. It will be sent back to you in {@link #onPermissionsResult(int, Set, Set)}.
     * @param permissions Which permissions to ask for. They will be grouped and sent back to you in {@link #onPermissionsResult(int, Set, Set)}
     * @return {@code True} if the permission request was made, {@code false} otherwise
     */
    protected final boolean requestPermissions(@IntRange(from = 0, to = 127) final int code, @Nullable final String... permissions) {
        if (permissions != null && permissions.length > 0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, code);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Forwards results from {@link #onRequestPermissionsResult(int, String[], int[])}, only in a much prettier and easier to use format.
     *
     * @param code    The original requestCode
     * @param granted The set of granted permissions
     * @param denied  The set of denied permissions
     */
    @CallSuper
    protected void onPermissionsResult(@IntRange(from = 0, to = 127) final int code, @NonNull final Set<String> granted, @NonNull final Set<String> denied) {
        if (BuildConfig.DEBUG) {
            // log results for debug purposes
            final String grantedText = Arrays.toString(granted.toArray());
            final String deniedText = Arrays.toString(denied.toArray());
            final String format = "Permissions request %d = [granted: %s; permissions denied: %s]";
            Log.d(getClass().getSimpleName(), String.format(format, code, grantedText, deniedText));
        }
    }

    @Override
    @CallSuper
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // invalid case?
        if (permissions.length == 0 || grantResults.length == 0) {
            onPermissionsResult(requestCode, Collections.emptySet(), Collections.emptySet());
            return;
        }

        // divide into two piles, it's much cleaner
        final Set<String> granted = new HashSet<>();
        final Set<String> denied = new HashSet<>();
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                granted.add(permissions[i]);
            } else {
                denied.add(permissions[i]);
            }
        }

        // invoke the proper callback
        onPermissionsResult(requestCode, granted, denied);
    }
    // </editor-fold>

}
