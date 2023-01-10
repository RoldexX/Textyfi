package com.slava_110.exam;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;

public class Main {

    interface User32 extends StdCallLibrary {
        User32 INSTANCE = Native.load("user32", User32.class);
        int WM_SETTEXT = 0x000c;
        int WM_GETTEXT = 0x000D;

        /**
         * Current window
         * @return window handle
         */
        HWND GetActiveWindow();

        HWND FindWindowA(String lpClassName, String lpWindowName);

        HWND FindWindowExA(HWND hwndParent, HWND hwndChildAfter, String lpClassName, String lpWindowName);

        WinDef.LRESULT SendMessageA(HWND editHwnd, int wmGettext, long l, byte[] lParamStr);

        int GetClassNameA(HWND hWnd, byte[] lpString, int maxCount);


    }

    public static void main(String[] args) {
        User32 user32 = User32.INSTANCE;

        HWND notePadHwnd = user32.FindWindowA(null , "About Calculator");
        HWND editHwnd = user32.FindWindowExA(notePadHwnd, null, "SysLink", null);
        byte[] lParamStr = new byte[512];
        user32.SendMessageA(editHwnd, User32.WM_GETTEXT, 512, lParamStr);

        System.out.println("Text from external window: " + Native.toString(lParamStr));
    }
}
