package ch.xs3.usbphoto;
import android.content.Context;import android.graphics.*;import android.view.View;
/** Native vector artwork. XS3 wordmark follows the public site's HTML/CSS. */
public final class BrandView extends View {
 public enum Kind { LOGO, COFFEE }
 final Kind kind;final Paint p=new Paint(3); Typeface face;
 public BrandView(Context c,Kind k){super(c);kind=k;try{face=Typeface.createFromAsset(c.getAssets(),"SpaceGrotesk.ttf");}catch(Exception e){face=Typeface.create("sans-serif",Typeface.BOLD);}setLayerType(View.LAYER_TYPE_SOFTWARE,null);}
 protected void onDraw(Canvas original){super.onDraw(original);Canvas c=original;float w=kind==Kind.LOGO?100:310,h=kind==Kind.LOGO?65:60;c.save();float scale=Math.min(getWidth()/w,getHeight()/h);c.translate((getWidth()-w*scale)/2,(getHeight()-h*scale)/2);c.scale(scale,scale);
 if(kind==Kind.LOGO){p.setTypeface(Typeface.create(face,Typeface.BOLD));p.setColor(0xffeff9ff);p.setTextSize(54);c.drawText("xs",4,49,p);p.setTextSize(27);p.setColor(0xff26caff);c.drawText("3",58,29,p);p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(2);c.save();c.rotate(-9,42,53);c.drawArc(new RectF(0,48,78,60),180,180,false,p);c.restore();p.setStyle(Paint.Style.FILL);}
 else {
 // Small transparent support mark, matching the reference's cream lettering and blue cup.
 p.setColor(0xfffffce6);p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(2.6f);p.setStrokeJoin(Paint.Join.ROUND);
 c.drawRoundRect(13,8,42,14,4,4,p);c.drawRoundRect(10,15,45,21,3,3,p);
 Path cup=new Path();cup.moveTo(14,24);cup.lineTo(19,51);cup.quadTo(28,55,37,51);cup.lineTo(42,24);cup.close();c.drawPath(cup,p);
 p.setStyle(Paint.Style.FILL);p.setColor(0xff46bfff);Path fill=new Path();fill.moveTo(19,31);fill.lineTo(22,48);fill.quadTo(28,50,34,48);fill.lineTo(37,29);fill.quadTo(27,34,19,31);c.drawPath(fill,p);
 p.setColor(0xfffffce6);p.setTypeface(Typeface.create("cursive",Typeface.BOLD));p.setTextSize(27);
 String label=Words.t(getContext(),"Buy me a coffee","Offrez-moi un café");
 float available=244;float measured=p.measureText(label);if(measured>available)p.setTextSize(27*available/measured);
 c.drawText(label,58,39,p);
 }
 c.restore();}
}
