"""Fetch the site's font and render original vector store graphics. No runtime network use."""
import pathlib, urllib.request, hashlib
from PIL import Image, ImageDraw, ImageFont
root=pathlib.Path(__file__).resolve().parents[1]
assets=root/'app/src/main/assets';assets.mkdir(parents=True,exist_ok=True)
font_url='https://raw.githubusercontent.com/google/fonts/main/ofl/spacegrotesk/SpaceGrotesk%5Bwght%5D.ttf'
for url,name in [(font_url,'SpaceGrotesk.ttf'),('https://raw.githubusercontent.com/google/fonts/main/ofl/spacegrotesk/OFL.txt','SpaceGrotesk-OFL.txt')]:
    target=assets/name
    if not target.exists():
        target.write_bytes(urllib.request.urlopen(url,timeout=45).read())
    print(name,hashlib.sha256(target.read_bytes()).hexdigest())
out=root/'store';out.mkdir(exist_ok=True)
s=4
im=Image.new('RGB',(512*s,512*s),'#080e16');d=ImageDraw.Draw(im)
def line(points,fill,width=3):d.line([(int(x*512*s/108),int(y*512*s/108)) for x,y in points],fill=fill,width=int(width*512*s/108),joint='curve')
line([(27,30),(43,30),(52,39),(52,65),(27,65),(27,30)],'#e7f4ff')
line([(43,30),(43,40),(52,40)],'#e7f4ff')
line([(39,49),(68,49),(60,41)],'#57caff');line([(68,49),(60,57)],'#57caff')
line([(63,62),(81,62),(81,79),(63,79),(63,62)],'#46bfff');line([(67,62),(67,55),(77,55),(77,62)],'#46bfff')
line([(70,57),(70,60)],'#e7f4ff',2);line([(74,57),(74,60)],'#e7f4ff',2)
im.resize((512,512),Image.Resampling.LANCZOS).save(out/'icon-512.png')
banner=Image.new('RGB',(1024,500),'#080e16');b=ImageDraw.Draw(banner)
font=ImageFont.truetype(str(assets/'SpaceGrotesk.ttf'),66)
small=ImageFont.truetype(str(assets/'SpaceGrotesk.ttf'),28)
banner.paste(im.resize((350,350),Image.Resampling.LANCZOS),(620,75))
b.text((64,150),'Android2USB',font=font,fill='#e7f4ff')
b.text((67,242),'Your files. Your USB drive.',font=small,fill='#9cadc2')
b.line((67,306,370,306),fill='#46bfff',width=3)
b.text((67,344),'LOCAL BACKUP / XS3',font=ImageFont.truetype(str(assets/'SpaceGrotesk.ttf'),19),fill='#57caff')
banner.save(out/'feature-graphic-1024x500.png')
