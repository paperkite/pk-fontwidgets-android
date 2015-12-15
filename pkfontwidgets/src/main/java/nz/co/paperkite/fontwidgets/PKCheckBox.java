package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class PKCheckBox extends CheckBox {
    public PKCheckBox(Context context) {
        super(context);
        setDefaultFont();
    }

    public PKCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttrs(context,attrs);
    }

    public PKCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttrs(context, attrs);
    }


    private void readAttrs(Context context ,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PKCheckBox);
        String customFont = a.getString(R.styleable.PKButton_customFont);
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
