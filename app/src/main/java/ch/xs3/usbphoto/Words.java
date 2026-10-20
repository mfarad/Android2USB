package ch.xs3.usbphoto;
import android.content.Context;
final class Words {
 static String t(Context c,String en,String fr){return "fr".equals(c.getSharedPreferences("config",0).getString("language","en"))?fr:en;}
}
