package com.aman.pinlockdialog;
/**
 * The MIT License (MIT)

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
 */
import java.security.InvalidParameterException;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PinLockDialog extends Dialog implements
		android.view.View.OnClickListener {
	private Context context;
	private ImageView smallcircle_1, smallcircle_2, smallcircle_3,
			smallcircle_4;
	private Button bigcircel_1, bigcircel_2, bigcircel_3, bigcircel_4,
			bigcircel_5, bigcircel_6, bigcircel_7, bigcircel_8, bigcircel_9,
			bigcircel_0;
	private String pin;
	private StringBuilder mBuilder;
	private int count = 0;
	String OnPinMatchMessage, onPinMismatchedMessage;

	public PinLockDialog(Context CurrentClassContext, String pin, String OnPinMatchMessage,
			String onPinMismatchedMessage) {
		super(CurrentClassContext, R.style.Theme_AppCompat_DialogWhenLarge);
		this.pin = pin;
		this.context = CurrentClassContext;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.pinlockdialog);
		this.OnPinMatchMessage = OnPinMatchMessage;
		this.onPinMismatchedMessage = onPinMismatchedMessage;
		init();
		if (pin.length() != 4 || TextUtils.isEmpty(pin)
				|| !TextUtils.isDigitsOnly(pin))
			throw new InvalidParameterException(
					"Provided Pin is Not Valid or null, a valid pin Should be only in Integer ONLY with minimum and maximum lenght of 4. Provided pin is "
							+ pin + " and its lenght is " + pin.length());
		Log.d("Pin", pin);
	}

	void init() {
		smallcircle_1 = (ImageView) this.findViewById(R.id.img_small_circle_1);
		smallcircle_2 = (ImageView) this.findViewById(R.id.img_small_circle_2);
		smallcircle_3 = (ImageView) this.findViewById(R.id.img_small_circle_3);
		smallcircle_4 = (ImageView) this.findViewById(R.id.img_small_circle_4);
		bigcircel_0 = (Button) this.findViewById(R.id.img_big_circle_0);
		bigcircel_1 = (Button) this.findViewById(R.id.img_big_circle_1);
		bigcircel_2 = (Button) this.findViewById(R.id.img_big_circle_2);
		bigcircel_3 = (Button) this.findViewById(R.id.img_big_circle_3);
		bigcircel_4 = (Button) this.findViewById(R.id.img_big_circle_4);
		bigcircel_5 = (Button) this.findViewById(R.id.img_big_circle_5);
		bigcircel_6 = (Button) this.findViewById(R.id.img_big_circle_6);
		bigcircel_7 = (Button) this.findViewById(R.id.img_big_circle_7);
		bigcircel_8 = (Button) this.findViewById(R.id.img_big_circle_8);
		bigcircel_9 = (Button) this.findViewById(R.id.img_big_circle_9);
		bigcircel_0.setOnClickListener(this);
		bigcircel_1.setOnClickListener(this);
		bigcircel_2.setOnClickListener(this);
		bigcircel_3.setOnClickListener(this);
		bigcircel_4.setOnClickListener(this);
		bigcircel_5.setOnClickListener(this);
		bigcircel_6.setOnClickListener(this);
		bigcircel_7.setOnClickListener(this);
		bigcircel_8.setOnClickListener(this);
		bigcircel_9.setOnClickListener(this);
		mBuilder = new StringBuilder();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.img_big_circle_0)
			mBuilder.append("0");
		else if (id == R.id.img_big_circle_1)
			mBuilder.append("1");
		else if (id == R.id.img_big_circle_2)
			mBuilder.append("2");
		else if (id == R.id.img_big_circle_3)
			mBuilder.append("3");
		else if (id == R.id.img_big_circle_4)
			mBuilder.append("4");
		else if (id == R.id.img_big_circle_5)
			mBuilder.append("5");
		else if (id == R.id.img_big_circle_6)
			mBuilder.append("6");
		else if (id == R.id.img_big_circle_7)
			mBuilder.append("7");
		else if (id == R.id.img_big_circle_8)
			mBuilder.append("8");
		else if (id == R.id.img_big_circle_9)
			mBuilder.append("9");
		dovalidation();

	}

	private void dovalidation() {
		count++;
		if (count == 1) {
			smallcircle_1.setBackgroundResource(R.drawable.small_circle_filled);
		} else if (count == 2) {
			smallcircle_2.setBackgroundResource(R.drawable.small_circle_filled);
		} else if (count == 3) {
			smallcircle_3.setBackgroundResource(R.drawable.small_circle_filled);
		} else if (count == 4) {
			smallcircle_4.setBackgroundResource(R.drawable.small_circle_filled);
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					Log.d("pin", mBuilder.toString() + ":" + pin);
					if (mBuilder.toString().equals(pin)) {
						Toast.makeText(context, OnPinMatchMessage,
								Toast.LENGTH_SHORT).show();
						PinLockDialog.this.dismiss();
					} else {
						Toast.makeText(context, onPinMismatchedMessage,
								Toast.LENGTH_SHORT).show();
					}
					count = 0;
					mBuilder = new StringBuilder();
					smallcircle_1
							.setBackgroundResource(R.drawable.small_circle);
					smallcircle_2
							.setBackgroundResource(R.drawable.small_circle);
					smallcircle_3
							.setBackgroundResource(R.drawable.small_circle);
					smallcircle_4
							.setBackgroundResource(R.drawable.small_circle);
				}

			}, 250);

		}
	}

	@Override
	public void onBackPressed() {
		System.exit(0);
		super.onBackPressed();
	}
}
