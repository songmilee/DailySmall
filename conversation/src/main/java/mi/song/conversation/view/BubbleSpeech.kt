package mi.song.conversation.view

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import mi.song.conversation.R

class BubbleSpeech : LinearLayout {

    var bubbleLayout:LinearLayout? = null

    constructor(context:Context) : super(context){
        initView(context)
        init(null, 0)
    }

    constructor(context:Context, attrs: AttributeSet?) : super(context, attrs){
        initView(context)
        init(attrs, 0)
    }

    constructor(context:Context, attrs: AttributeSet?, defStyle:Int) : super(context, attrs, defStyle){
        initView(context)
        init(attrs, defStyle)
    }

    fun initView(context:Context){
        val view = LayoutInflater.from(context).inflate(R.layout.bubble_view, this, true)

        bubbleLayout = view.findViewById(R.id.bubble_view)
    }

    fun init(attrs: AttributeSet?, defStyle: Int){
        val a = context.obtainStyledAttributes(attrs, R.styleable.BubbleSpeech, defStyle, 0)

        val backColor = a.getColor(R.styleable.BubbleSpeech_backColor, 0)
        setBackColor(backColor)

        a.recycle()
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if(bubbleLayout == null) {
            super.addView(child, index, params)
        }else{
            bubbleLayout?.addView(child, index, params)
        }
    }

    fun setBackColor(color:Int){
        bubbleLayout?.backgroundTintList = ColorStateList.valueOf(color)
    }
}