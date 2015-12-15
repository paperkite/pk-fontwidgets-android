package nz.co.paperkite.fontwidgets;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

public class PKFontUtils {

    private static  HashMap<String, Typeface> fonts ;
    private static Typeface defaultTypeFace;

    public static void createFonts(Context context ,String path) {
        fonts = new HashMap<>();
        try {
            String[] listOfFonts = listAssetFiles(path,context);
            for(String s :listOfFonts) {
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), path+"/"+s);
                fonts.put( s.substring(0,s.lastIndexOf(".")),typeface );
                Log.d("PKFontUtils", "fonts" + s.substring(0, s.lastIndexOf(".")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFont(Context context,String path,String fontName ){
        try {
            defaultTypeFace = Typeface.createFromAsset(context.getAssets(), path + "/" + fontName+".ttf");
        }catch (RuntimeException e){
            if(e.getMessage().equals("native typeface cannot be made")){
                try {
                    throw new Exception("the fontName that you use does not exist in the file path!!");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


    public static Typeface getDefaultFont(){
        return defaultTypeFace;
    }


    public static HashMap<String, Typeface> getFontsMap(){
        if(fonts == null) {
            try {
                throw new Exception("You should call createFonts method in your application class before using library");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }else{
            return fonts ;
        }
    }

    private static String[] listAssetFiles(String path, Context applicationContext) throws IOException {
        AssetManager assetManager = applicationContext.getAssets();
        String[] listOfFonts = assetManager.list(path);
        return listOfFonts ;
    }

}