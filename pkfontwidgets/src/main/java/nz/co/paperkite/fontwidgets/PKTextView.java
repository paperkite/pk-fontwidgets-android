package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class PKTextView extends TextView {

    public PKTextView(Context context) {
        super(context);
        setDefaultFont();
    }

    public PKTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            readAttrs(context, attrs);
    }

    public PKTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode())
            readAttrs(context, attrs);

    }

    private void readAttrs(Context context ,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PKTextView);
        String customFont = a.getString(R.styleable.PKTextView_customFont);
        if(PKFontUtils.getFontsMap().containsKey(customFont)){
            setTypeface(PKFontUtils.getFontsMap().get(customFont));
        }else{
            setDefaultFont();
        }
    }

    /**
     * set defaultTypeFace if exist
     */
    private void setDefaultFont(){
        if(PKFontUtils.getDefaultFont()!=null)
            setTypeface(PKFontUtils.getDefaultFont());
    }
}