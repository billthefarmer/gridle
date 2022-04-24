////////////////////////////////////////////////////////////////////////////////
//
//  Gridle - An android word game.
//
//  Copyright (C) 2022	Bill Farmer
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.
//
//  Bill Farmer	 william j farmer [at] yahoo [dot] co [dot] uk.
//
///////////////////////////////////////////////////////////////////////////////

package org.billthefarmer.gridle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Gridle extends Activity
{
    public static final String TAG = "Gridle";

    public static final int SIZE = 5;

    public static final String PREF_THEME = "pref_theme";
    public static final String PREF_FARE = "pref_fare";

    public static final int GREY    = 0;
    public static final int DARK    = 1;
    public static final int BLUE    = 2;
    public static final int CYAN    = 3;
    public static final int GREEN   = 4;
    public static final int MAGENTA = 5;
    public static final int ORANGE  = 6;
    public static final int PURPLE  = 7;
    public static final int RED     = 8;
    public static final int YELLOW  = 9;
    public static final int BLACK   = 10;
    public static final int WHITE   = 11;

    private char gridle[][];
    private char puzzle[][];

    private TextView display[][];
    private TextView display2[][];

    private float x;
    private float y;
    private float dX;
    private float dY;

    private int theme;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        theme = preferences.getInt(PREF_THEME, DARK);

        switch (theme)
        {
        default:
        case DARK:
            setTheme(R.style.AppTheme);
            break;

        case CYAN:
            setTheme(R.style.AppCyanTheme);
            break;

        case BLUE:
            setTheme(R.style.AppBlueTheme);
            break;

        case ORANGE:
            setTheme(R.style.AppOrangeTheme);
            break;

        case PURPLE:
            setTheme(R.style.AppPurpleTheme);
            break;

        case RED:
            setTheme(R.style.AppRedTheme);
            break;

        case BLACK:
            setTheme(R.style.AppBlackTheme);
            break;
        }

        setContentView(R.layout.main);

        View.OnTouchListener listener = (view, event) ->
        {
            switch (event.getActionMasked())
            {
            case MotionEvent.ACTION_DOWN:
            x = view.getX();
            y = view.getY();
            dX = x - event.getRawX();
            dY = y - event.getRawY();
            scale(view, 1.4f);
            break;

            case MotionEvent.ACTION_MOVE:
            view.setX(event.getRawX() + dX);
            view.setY(event.getRawY() + dY);
            break;

            case MotionEvent.ACTION_UP:
            findNearestView(view);
            view.setX(x);
            view.setY(y);
            scale(view, 1.0f);
            break;

            default:
            return false;
            }

            return true;
        };

        display = new TextView[SIZE][];
        for (int i = 0; i < display.length; i++)
            display[i] = new TextView[SIZE];

        ViewGroup grid = (ViewGroup) findViewById(R.id.grid1);
        for (int i = 0; i < grid.getChildCount(); i++)
        {
            display[i % SIZE][i / SIZE] =
                (TextView) grid.getChildAt(i);
            display[i % SIZE][i / SIZE]
                .setOnTouchListener(listener);
        }

        display2 = new TextView[SIZE][];
        for (int i = 0; i < display2.length; i++)
            display2[i] = new TextView[SIZE];

        ViewGroup grid2 = (ViewGroup) findViewById(R.id.grid2);
        for (int i = 0; i < grid2.getChildCount(); i++)
        {
            display2[i % SIZE][i / SIZE] =
                (TextView) grid2.getChildAt(i);
            display2[i % SIZE][i / SIZE]
                .setOnTouchListener(listener);
        }

        gridle = Words.getGridle();

        for (int i = 0; i < display2.length; i++)
        {
            for (int j = 0; j < display2[i].length; j++)
            {
                display2[i][j].setText(
                    new String(new char[] {gridle[i][j]}).toUpperCase());
            }
        }

        puzzle = new char[SIZE][];
        for (int i = 0; i < puzzle.length; i++)
            puzzle[i] = Arrays.copyOf(gridle[i], gridle[i].length);
        
        Words.randomise(puzzle);

        for (int i = 0; i < display.length; i++)
        {
            for (int j = 0; j < display[i].length; j++)
            {
                display[i][j].setText(
                    new String(new char[] {puzzle[i][j]}).toUpperCase());
            }
        }
    }

    // onResume
    @Override
    protected void onResume()
    {
        super.onResume();
    }

    // onPause
    @Override
    public void onPause()
    {
        super.onPause();

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(PREF_THEME, theme);
    }

    private void scale(View view, float scale)
    {
        view.setScaleX(scale);
        view.setScaleY(scale);
    }

    // On create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it
        // is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    // On options item selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Get id
        int id = item.getItemId();
        switch (id)
        {
        case R.id.refresh:
            refresh();
            break;

        case R.id.image:
            shareImage();
            break;

        case R.id.code:
            showCode();
            break;

        case R.id.dark:
            theme(DARK);
            break;

        case R.id.cyan:
            theme(CYAN);
            break;

        case R.id.blue:
            theme(BLUE);
            break;

        case R.id.orange:
            theme(ORANGE);
            break;

        case R.id.purple:
            theme(PURPLE);
            break;

        case R.id.red:
            theme(RED);
            break;

        case R.id.black:
            theme(BLACK);
            break;

        case R.id.about:
            about();
            break;

        default:
            return false;
        }

        return true;
    }

    // theme
    private void theme(int c)
    {
        theme = c;
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.M)
            recreate();
    }

    private void findNearestView(View view)
    {
        ViewGroup parent = (ViewGroup) view.getParent();
        double d = Double.MAX_VALUE;
        TextView nearest = null;
        for (int i = 0; i < parent.getChildCount(); i++)
        {
            View v = parent.getChildAt(i);
            if (v.equals(view))
                continue;

            if (v.getClipRect().contains(view.getX(), view.getY()))
            {
                nearest = (TextView) v;
                break;
            }
        }

        Log.d(TAG, String.format("Nearest = '%s'",
                                 nearest.getText().toString()));
    }

    // about
    @SuppressWarnings("deprecation")
    private void about()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.appName);
        builder.setIcon(R.drawable.ic_launcher);

        DateFormat dateFormat = DateFormat.getDateTimeInstance();
        SpannableStringBuilder spannable =
            new SpannableStringBuilder(getText(R.string.version));
        Pattern pattern = Pattern.compile("%s");
        Matcher matcher = pattern.matcher(spannable);
        if (matcher.find())
            spannable.replace(matcher.start(), matcher.end(),
                              BuildConfig.VERSION_NAME);
        matcher.reset(spannable);
        if (matcher.find())
            spannable.replace(matcher.start(), matcher.end(),
                              dateFormat.format(BuildConfig.BUILT));
        builder.setMessage(spannable);

        // Add the button
        builder.setPositiveButton(android.R.string.ok, null);

        // Create the AlertDialog
        Dialog dialog = builder.show();

        // Set movement method
        TextView text = dialog.findViewById(android.R.id.message);
        if (text != null)
        {
            text.setTextAppearance(builder.getContext(),
                                   android.R.style.TextAppearance_Small);
            text.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
