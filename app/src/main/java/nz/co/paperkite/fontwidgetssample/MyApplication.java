package nz.co.paperkite.fontwidgetssample;

import android.app.Application;
import nz.co.paperkite.fontwidgets.PKFontUtils;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PKFontUtils.createFonts(this, "fonts");
        PKFontUtils.setDefaultFont(this, "fonts", "RightWay");
    }
}
