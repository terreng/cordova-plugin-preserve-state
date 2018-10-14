package com.terrenprogramming.plugin;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.os.Process;

public class Preservestate extends CordovaPlugin {

	static final String STATE_HASH = "hash";
	private String save_hash = "#";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("setState")) {

			String state_string = data.getString(0);
			save_hash = state_string;
			preferences.set("saved_hash", save_hash);
            callbackContext.success(save_hash);

            return true;

        } else {
            
        if (action.equals("getState")) {
			
			save_hash = preferences.getString("saved_hash", "#");
			
            callbackContext.success(save_hash);

            return true;

        } else {
			
			return false;
			
		}

        }
    }
	
}