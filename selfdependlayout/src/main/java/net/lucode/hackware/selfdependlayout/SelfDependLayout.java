package net.lucode.hackware.selfdependlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 宽度按一定比例依赖高度，或者高度按一定比例依赖宽度的layout，仅包含一个子元素
 * 可轻松实现View自身的比例布局
 * Created by hackware on 2016/9/15.
 */

public class SelfDependLayout extends FrameLayout {

    /**
     * true：高度依赖宽度
     * false：宽度依赖高度
     */
    private boolean mDependWidth;

    private float mDependencyRatio = 1.0f;

    public SelfDependLayout(Context context) {
        this(context, null);
    }

    public SelfDependLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.DependencyLayout);
        mDependWidth = t.getBoolean(R.styleable.DependencyLayout_dependWidth, mDependWidth);
        mDependencyRatio = t.getFloat(R.styleable.DependencyLayout_dependencyRatio, mDependencyRatio);
        t.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (getChildCount() > 1) {  // 只允许有一个子元素
            throw new IllegalStateException("EqualSideLayout can only have one child.");
        }

        int measuredWidth, measuredHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredWidth = getMeasuredWidth();
        measuredHeight = getMeasuredHeight();
        if (mDependWidth) {
            measuredHeight = Math.round(measuredWidth * mDependencyRatio);
        } else {
            measuredWidth = Math.round(measuredHeight * mDependencyRatio);
        }

        View child = getChildAt(0);
        if (child != null) {
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, MeasureSpec.EXACTLY);
            int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, MeasureSpec.EXACTLY);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        }

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View child = getChildAt(0);
        if (child != null) {
            child.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }
}
