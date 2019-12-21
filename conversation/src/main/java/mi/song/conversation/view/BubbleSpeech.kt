package mi.song.conversation.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mi.song.conversation.R

class BubbleSpeech : LinearLayout {

    var bubbleLayout:LinearLayout? = null
    var bubbleContentsLayout:LinearLayout? = null
    var imgView:ImageView? = null

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
        bubbleContentsLayout = view.findViewById(R.id.bubble_view_contents)
        imgView = view.findViewById(R.id.bubble_image_view)
    }

    fun init(attrs: AttributeSet?, defStyle: Int){
        val a = context.obtainStyledAttributes(attrs, R.styleable.BubbleSpeech, defStyle, 0)

        val backColor = a.getColor(R.styleable.BubbleSpeech_backColor, ContextCompat.getColor(context, R.color.default_speech_color))
        val profile = a.getInt(R.styleable.BubbleSpeech_profile_img, R.drawable.profile)

        setBackColor(backColor)
        setProfileImg(profile)

        a.recycle()
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if(bubbleContentsLayout == null) {
            super.addView(child, index, params)
        }else{
            bubbleContentsLayout?.addView(child, index, params)
        }
    }

    fun setBackColor(color:Int){
        bubbleLayout?.backgroundTintList = ColorStateList.valueOf(color)
    }

    fun setProfileImg(img:Int){
        Glide.with(this)
                .load(img)
                .apply(RequestOptions.centerCropTransform().circleCrop())
                .into(imgView!!)
    }
}