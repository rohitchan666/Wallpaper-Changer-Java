// Wallpaper Code taken from 
// https://stackoverflow.com/questions/4750372/can-i-change-my-windows-desktop-wallpaper-programmatically-in-java-groovy
//
// Info on JNA
// https://www.baeldung.com/java-jna-dynamic-libraries
//

package com.mycompany.wallchangej;

import java.util.Scanner;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.PVOID;
import com.sun.jna.win32.W32APIOptions;

public class WallChangeJ {

public static void main(String[] args) 
{

    String strWallpaperImage;
    Scanner myscan = new Scanner(System.in);

    System.out.println("Enter Wallpaper Filename (.jpg), (Provide full path or Blank input to remove wallpaper)" );  

    strWallpaperImage = myscan.nextLine();

    ChangeWallMethod(strWallpaperImage);

    System.out.println("Wallpaper Changed! Press any key to exit." ); 
    myscan.nextLine();
    myscan.close();
}

public static void ChangeWallMethod(String args) {
    //supply your own path instead of using this one
    String strImagePath = args;

    User32.INSTANCE.SystemParametersInfo(0x0014, 0, strImagePath , 1);
}

 public static interface User32 extends Library {
     User32 INSTANCE = (User32) Native.loadLibrary("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);
     boolean SystemParametersInfo (int one, int two, String s ,int three);         
 }
    
}
