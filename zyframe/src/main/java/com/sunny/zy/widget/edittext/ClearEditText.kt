package com.sunny.zy.widget.edittext

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.sunny.zy.R

/**
 * Desc
 * Author 张野
 * Mail zhangye98@foxmail.com
 * Date 2020/6/4 18:35
 */
class ClearEditText : AppCompatEditText, View.OnFocusChangeListener, TextWatcher {
    /**
     * 删除按钮的引用
     */
    var mClearDrawable: Drawable? = null

    /**
     * 控件是否有焦点
     */
    var hasFoucs = false

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs,
        R.attr.editTextStyle
    )


    fun init() {
        // 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片
        mClearDrawable = compoundDrawables[2]
        if (mClearDrawable == null) {
            // throw new
            // NullPointerException("You can add drawableRight attribute in XML");
            mClearDrawable = ContextCompat.getDrawable(
                context,
                R.drawable.sel_edit_clear
            )
        }
        mClearDrawable!!.setBounds(
            0, 0, mClearDrawable!!.intrinsicWidth,
            mClearDrawable!!.intrinsicHeight
        )
        // 默认设置隐藏图标
        setClearIconVisible(false)
        // 设置焦点改变的监听
        setOnFocusChangeListener(this)
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(this)
    }

    /**
     * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件 当我们按下的位置 在 EditText的宽度 -
     * 图标到控件右边的间距 - 图标的宽度 和 EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向就没有考虑
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            if (compoundDrawables[2] != null) {
                val touchable =
                    (event.x > width - totalPaddingRight
                            && event.x < width - paddingRight)
                if (touchable) {
                    this.setText("")
                }
            }
        }
        return super.onTouchEvent(event)
    }

    /**
     * 当ClearEditText焦点发生变化的时候，判断里面字符串长度设置清除图标的显示与隐藏
     */
    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        this.hasFoucs = hasFocus
        if (hasFocus) {
            setClearIconVisible(text?.isNotEmpty() == true)
        } else {
            setClearIconVisible(false)
        }
    }

    /**
     * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
     */
    fun setClearIconVisible(visible: Boolean) {
        val right = if (visible) mClearDrawable else null
        setCompoundDrawables(
            getCompoundDrawables().get(0),
            getCompoundDrawables().get(1), right, getCompoundDrawables().get(3)
        )
    }

    /**
     * 当输入框里面内容发生变化的时候回调的方法
     */
    override fun onTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) {
        if (hasFoucs) {
            setClearIconVisible(s.isNotEmpty())
        }
    }

    override fun beforeTextChanged(
        s: CharSequence?, start: Int, count: Int,
        after: Int
    ) {
    }

    override fun afterTextChanged(s: Editable?) {}

    /**
     * 设置晃动动画
     */
    fun setShakeAnimation() {
        this.startAnimation(shakeAnimation(5))
    }

    /**
     * 晃动动画
     *
     * @param counts 1秒钟晃动多少下
     */
    fun shakeAnimation(counts: Int): Animation? {
        val translateAnimation: Animation = TranslateAnimation(0f, 10f, 0f, 0f)
        translateAnimation.interpolator = CycleInterpolator(counts.toFloat())
        translateAnimation.duration = 1000
        // translateAnimation.setFillAfter(true);
        return translateAnimation
    }
}
