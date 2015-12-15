package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class PKRadioButton extends RadioButton {


    public PKRadioButton(Context context) {
        super(context);
        setDefaultFont();
    }


    public PKRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            readAttrs(context, attrs);
    }

    public PKRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            readAttrs(context, attrs);
    }


    private void readAttrs(Context context ,AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PKRadioButton);
        String customFont = a.getString(R.styleable.PKRadioButton_customFont);
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
