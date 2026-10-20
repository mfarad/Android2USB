package ch.xs3.usbphoto;
import android.content.Context;import android.graphics.*;import android.view.View;
/** Native vector artwork. XS3 wordmark follows the public site's HTML/CSS. */
public final class BrandView extends View {
 public enum Kind { LOGO, COFFEE }
 final Kind kind;final Paint p=new Paint(3); Typeface face;
 public BrandView(Context c,Kind k){super(c);kind=k;try{face=Typeface.createFromAsset(c.getAssets(),"SpaceGrotesk.ttf");}catch(Exception e){face=Typeface.create("sans-serif",Typeface.BOLD);}setLayerType(View.LAYER_TYPE_SOFTWARE,null);}
 protected void onDraw(Canvas original){super.onDraw(original);Canvas c=original;float w=kind==Kind.LOGO?100:310,h=kind==Kind.LOGO?65:60;c.save();float scale=Math.min(getWidth()/w,getHeight()/h);c.translate((getWidth()-w*scale)/2,(getHeight()-h*scale)/2);c.scale(scale,scale);
 if(kind==Kind.LOGO){p.setTypeface(Typeface.create(face,Typeface.BOLD));p.setColor(0xffeff9ff);p.setTextSize(54);c.drawText("xs",4,49,p);p.setTextSize(27);p.setColor(0xff26caff);c.drawText("3",58,29,p);p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(2);c.save();c.rotate(-9,42,53);c.drawArc(new RectF(0,48,78,60),180,180,false,p);c.restore();p.setStyle(Paint.Style.FILL);}
 else {p.setColor(0xff153049);c.drawRoundRect(1,1,309,59,10,10,p);p.setColor(0xff46bfff);p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(1.5f);c.drawRoundRect(1,1,309,59,10,10,p);p.setStrokeWidth(2.4f);c.drawRoundRect(20,22,45,42,4,4,p);c.drawArc(new RectF(39,23,54,36),270,180,false,p);c.drawLine(17,47,49,47,p);c.drawLine(26,12,26,17,p);c.drawLine(35,10,35,16,p);p.setStyle(Paint.Style.FILL);p.setColor(0xffe7f4ff);p.setTypeface(Typeface.create(face,Typeface.BOLD));p.setTextSize(20);c.drawText("Buy me a coffee",68,37,p);}
 c.restore();}
}
