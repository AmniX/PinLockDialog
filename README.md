# PinLockDialog
This Library is to use as a app passcode protection implementation, which allows user to protect the app with a four digit code.



When you Implement it into your app, then user have to Enter four Digit Pin Code as Developer implemented it, for e.g.-
onCreate
onResume
onRestart
or More...

This is just a dialog which doesnt need any kind of permission or manifest entry.

just Implement it and use it.

enabled a four-digit passcode needs to be entered any time your mobile app is launched. This way your app is safe even if your smartphone or tablet falls into the wrong hands.

*Note: This library doesn't add any extra protection to your data. App data will not be encrypted, the library just adds a pin lock screen that makes the app safe even if your kids put their hands on the device.

#Implementation

Step1- Download the zip and Import library into your workspace, "Don't Forget to mark on Copy to workspace"

Step2- Refer Library from your App.

Step3 - Make an Object of PinLockDialog Class and show it anywhere you want to.

For E.G.
--- PinLockDialog mLockDialog = new PinLockDialog(CurrentClassContext, pininString, OnPinMatchMessage, onPinMismatchedMessage);
		mLockDialog.show();

#Customization
To Change the Background of Lock, Just replace the dialog_bg.png from res/ to your's png.

Have Fun.
I will post some ScreenShot Soon.

#License
The MIT License (MIT)

Copyright (c) 2015 Aman Tonk

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
