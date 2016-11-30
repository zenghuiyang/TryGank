
package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.view.View;

import com.gypsophila.commonlib.activity.BaseActivity;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;

public class SwipeBackActivity extends BaseActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        mHelper.getSwipeBackLayout().setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {
        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
