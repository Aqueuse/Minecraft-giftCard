javac.exe -d out --module-path .\libs\ --add-modules spigot .\src\fr\neverenough\giftcard\Main.java .\src\fr\neverenough\giftcard\map\MapRender.java
.\src\fr\neverenough\giftcard\listeners\OnDrawMap.java .\src\fr\neverenough\giftcard\nms\NMSUtil.java ; cd out ; jar -c -f C:\Users\jaima\Desktop\giftcard.jar -c .\fr\ ..\plugin.yml ..\config.yml ; cd ..


