package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;


public class PKIconFontView extends TextView {

    public PKIconFontView(Context context) {
        super(context);

        if (isInEditMode())
            setText("X");

    }

    public PKIconFontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            readAttrs(context, attrs);
        else
            setText("X");
    }

    public PKIconFontView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode())
            readAttrs(context, attrs);
        else
            setText("X");

    }

    private void readAttrs(Context context ,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PKTextView);
        String customFont = a.getString(R.styleable.PKTextView_customFont);
        if (PKFontUtils.getFontsMap().containsKey(customFont)){
            setTypeface(PKFontUtils.getFontsMap().get(customFont));
        }
    }


}