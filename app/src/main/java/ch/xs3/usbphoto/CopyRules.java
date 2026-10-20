package ch.xs3.usbphoto;
final class CopyRules {
 static boolean overlap(String a,String b){return a.equals(b)||a.startsWith(b+"/")||b.startsWith(a+"/");}
 static String safeName(String name) {
  if(name==null||name.isEmpty()||name.equals(".")||name.equals("..")||name.indexOf('/')>=0)throw new IllegalArgumentException("Invalid file name");
  return name;
 }
}
