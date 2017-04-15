package me.angrybyte.sillyandroid.parsable.components;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import me.angrybyte.sillyandroid.components.EasyActivity;
import me.angrybyte.sillyandroid.parsable.AnnotationParser;

/**
 * An extension from {@link EasyActivity} with included {@link AnnotationParser} capabilities.
 */
public class ParsableActivity extends EasyActivity implements View.OnClickListener, View.OnLongClickListener {

    @LayoutRes
    @SuppressWarnings("unused")
    private int mLayoutId;

    @MenuRes
    @SuppressWarnings("unused")
    private int mMenuId;

    @Override
    @CallSuper
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnnotationParser.parseType(this, this);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
    }

    @Override
    public void setContentView(@LayoutRes final int layoutResID) {
        super.setContentView(layoutResID);
        AnnotationParser.parseFields(this, this, this);
    }

    @Override
    public void setContentView(@NonNull final View view) {
        super.setContentView(view);
        AnnotationParser.parseFields(this, this, this);
    }

    @Override
    public void setContentView(@NonNull final View view, @Nullable final ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        AnnotationParser.parseFields(this, this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (getMenuId() > 0) {
            getMenuInflater().inflate(getMenuId(), menu);
            return true;
        }
        return false;
    }

    @Override
    public void onClick(final View v) {}

    @Override
    public boolean onLongClick(final View v) {
        return false;
    }

    @LayoutRes
    protected final int getLayoutId() {
        return mLayoutId;
    }

    @MenuRes
    protected final int getMenuId() {
        return mMenuId;
    }

}
