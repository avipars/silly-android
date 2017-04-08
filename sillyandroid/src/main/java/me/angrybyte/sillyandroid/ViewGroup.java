
package me.angrybyte.sillyandroid;

import android.content.Context;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.util.AttributeSet;

/**
 * An extension of {@link android.view.ViewGroup} with applied extensions from {@link SillyAndroid} extension set.
 */
@UiThread
@SuppressWarnings("unused")
public abstract class ViewGroup extends android.view.ViewGroup {

    /**
     * @inheritDoc
     */
    public ViewGroup(final Context context) {
        super(context);
    }

    /**
     * @inheritDoc
     */
    public ViewGroup(final Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @inheritDoc
     */
    public ViewGroup(final Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @inheritDoc
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewGroup(final Context context, @NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Returns the result from {@link SillyAndroid#findViewById(android.view.View, int)}.
     */
    public <ViewType extends android.view.View> ViewType findView(@IdRes int viewId) {
        return SillyAndroid.findViewById(this, viewId);
    }

}
