package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

public class PKEditText extends EditText {
    public PKEditText(Context context) {
        super(context);
        setDefaultFont();
    }

    public PKEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            readAttrs(context, attrs);

    }

    public PKEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            readAttrs(context, attrs);

    }

    private void readAttrs(Context context ,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PKEditText);
        String customFont = a.getString(R.styleable.PKEditText_customFont);
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
