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
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
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

import android.support.v4.content.FileProvider;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gridle extends Activity
{
    public static final String TAG = "Gridle";

    public static final int SIZE = 5;

    public static final String PREF_THEME = "pref_theme";
    public static final String PREF_CONT = "pref_cont";
    public static final String PREF_CORR = "pref_corr";
    public static final String PREF_FARE = "pref_fare";

    public static final String SOLVED = "solved";

    public static final String PUZZLE_0 = "puzzle_0";
    public static final String PUZZLE_1 = "puzzle_1";
    public static final String PUZZLE_2 = "puzzle_2";
    public static final String PUZZLE_3 = "puzzle_3";
    public static final String PUZZLE_4 = "puzzle_4";

    public static final String GRIDLE_0 = "gridle_0";
    public static final String GRIDLE_1 = "gridle_1";
    public static final String GRIDLE_2 = "gridle_2";
    public static final String GRIDLE_3 = "gridle_3";
    public static final String GRIDLE_4 = "gridle_4";

    public static final String GRIDLE_IMAGE = "Gridle.png";
    public static final String IMAGE_PNG = "image/png";

    public static final String FILE_PROVIDER =
        "org.billthefarmer.gridle.fileprovider";

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

    private TextView display[][];

    private Toast toast;

    private MediaPlayer mediaPlayer;

    private boolean scored[][];
    private boolean used[][];

    private char gridle[][];
    private char puzzle[][];

    private boolean fanfare;
    private boolean solved;

    private float x;
    private float y;
    private float dX;
    private float dY;

    private int contains;
    private int correct;
    private int theme;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        theme = preferences.getInt(PREF_THEME, DARK);
        contains = preferences.getInt(PREF_CONT, getColour(YELLOW));
        correct = preferences.getInt(PREF_CORR, getColour(GREEN));
        fanfare = preferences.getBoolean(PREF_FARE, true);

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
            View item = findViewById(R.id.item);
            View grid = findViewById(R.id.puzzle);

            switch (event.getActionMasked())
            {
                // Because views at the top of the grid will appear to
                // slide under views further down when moved, due to
                // z-order, use another text view outside the grid as
                // a proxy. This view will not be clipped if it is
                // moved outside the grid.
            case MotionEvent.ACTION_DOWN:
                x = view.getX();
                y = view.getY();
                dX = x - event.getRawX();
                dY = y - event.getRawY();
                // Move the proxy view, make it visible, copy the
                // text, and scale it.
                item.setX(x + grid.getX());
                item.setY(y + grid.getY());
                item.setVisibility(View.VISIBLE);
                ((TextView) item).setText(((TextView) view).getText()); 
                ((TextView) item).setTextColor(((TextView)
                                                view).getTextColors()); 
                scale(item, 1.4f);
                break;

            case MotionEvent.ACTION_MOVE:
                // Move the selected view and the proxy above it
                view.setX(event.getRawX() + dX);
                view.setY(event.getRawY() + dY);
                item.setX(event.getRawX() + grid.getX() + dX);
                item.setY(event.getRawY() + grid.getY() + dY);
                break;

            case MotionEvent.ACTION_UP:
                // Swap texts and colour letters
                scorePuzzle(view);
                // Put the selected view back, scale the proxy view,
                // move it into the top corner, and make it invisible
                view.setX(x);
                view.setY(y);
                scale(item, 1.0f);
                item.setX(0);
                item.setY(0);
                item.setVisibility(View.INVISIBLE);
                break;

            default:
                return false;
            }

            return true;
        };

        display = new TextView[SIZE][];
        for (int i = 0; i < display.length; i++)
            display[i] = new TextView[SIZE];

        ViewGroup grid = (ViewGroup) findViewById(R.id.puzzle);
        for (int i = 0; i < grid.getChildCount(); i++)
        {
            display[i / SIZE][i % SIZE] =
                (TextView) grid.getChildAt(i);
            display[i / SIZE][i % SIZE]
                .setOnTouchListener(listener);
        }

        if (savedInstanceState != null)
        {
            solved = savedInstanceState.getBoolean(SOLVED);

            gridle = new char[SIZE][];

            gridle[0] = savedInstanceState.getCharArray(GRIDLE_0);
            gridle[1] = savedInstanceState.getCharArray(GRIDLE_1);
            gridle[2] = savedInstanceState.getCharArray(GRIDLE_2);
            gridle[3] = savedInstanceState.getCharArray(GRIDLE_3);
            gridle[4] = savedInstanceState.getCharArray(GRIDLE_4);

            puzzle = new char[SIZE][];

            puzzle[0] = savedInstanceState.getCharArray(PUZZLE_0);
            puzzle[1] = savedInstanceState.getCharArray(PUZZLE_1);
            puzzle[2] = savedInstanceState.getCharArray(PUZZLE_2);
            puzzle[3] = savedInstanceState.getCharArray(PUZZLE_3);
            puzzle[4] = savedInstanceState.getCharArray(PUZZLE_4);
        }

        else
        {
            gridle = Words.getGridle();

            puzzle = new char[SIZE][];
            for (int i = 0; i < SIZE; i++)
                puzzle[i] = Arrays.copyOf(gridle[i], SIZE);
        
            Words.randomise(puzzle);

            solved = false;
        }

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                display[i][j].setText
                    (new String(new char[] {puzzle[i][j]})
                     .toUpperCase(Locale.getDefault()));
            }
        }

        used = new boolean[SIZE][];
        for (int row = 0; row < SIZE; row++)
        {
            used[row] = new boolean[SIZE];
            Arrays.fill(used[row], false);
        }

        scored = new boolean[SIZE][];
        for (int row = 0; row < SIZE; row++)
        {
            scored[row] = new boolean[SIZE];
            Arrays.fill(scored[row], false);
        }

        scorePuzzle();
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

        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt(PREF_THEME, theme);
        editor.putInt(PREF_CONT, contains);
        editor.putInt(PREF_CORR, correct);
        editor.putBoolean(PREF_FARE, fanfare);
        editor.apply();
    }

    // onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putBoolean(SOLVED, solved);

        outState.putCharArray(PUZZLE_0, puzzle[0]);
        outState.putCharArray(PUZZLE_1, puzzle[1]);
        outState.putCharArray(PUZZLE_2, puzzle[2]);
        outState.putCharArray(PUZZLE_3, puzzle[3]);
        outState.putCharArray(PUZZLE_4, puzzle[4]);

        outState.putCharArray(GRIDLE_0, gridle[0]);
        outState.putCharArray(GRIDLE_1, gridle[1]);
        outState.putCharArray(GRIDLE_2, gridle[2]);
        outState.putCharArray(GRIDLE_3, gridle[3]);
        outState.putCharArray(GRIDLE_4, gridle[4]);
    }

    // scale
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

    // onPrepareOptionsMenu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.findItem(R.id.fanfare).setChecked(fanfare);

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

        case R.id.share:
            shareImage();
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

        case R.id.fanfare:
            fanfare(item);
            break;

        case R.id.highlight:
            highlight();
            break;

        case R.id.help:
            help();
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

    // fanfare
    private void fanfare(MenuItem item)
    {
        fanfare = !fanfare;
        item.setChecked(fanfare);
    }

    // highlight
    private void highlight()
    {
        colourDialog();
    }

    // colourDialog
    private void colourDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectHighlight);
        builder.setIcon(R.drawable.ic_launcher);

        View view = ((LayoutInflater) builder.getContext()
                     .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
            .inflate(R.layout.colours, null);
        builder.setView(view);

        builder.setNeutralButton(R.string.reset, (dialog, id) ->
        {
            contains = getColour(YELLOW);
            correct = getColour(GREEN);
        });

        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(android.R.string.ok, (dialog, id) ->
        {
            ViewGroup those = (ViewGroup) ((Dialog) dialog)
                .findViewById(R.id.those);
            ViewGroup words = (ViewGroup) ((Dialog) dialog)
                .findViewById(R.id.words);
            contains = ((TextView) those.getChildAt(2)).getTextColors()
                .getDefaultColor();
            correct = ((TextView) words.getChildAt(0)).getTextColors()
                .getDefaultColor();
        });

        Dialog dialog = builder.show();

        int grey[] = {0, 1, 4};
        ViewGroup those = (ViewGroup) dialog.findViewById(R.id.those);
        for (int l: grey)
        {
            TextView t = (TextView) those.getChildAt(l);
            t.setTextColor(getColour(GREY));
        }

        int cont[] = {2, 3};
        for (int l: cont)
        {
            TextView t = (TextView) those.getChildAt(l);
            t.setTextColor(contains);
        }

        ViewGroup words = (ViewGroup) dialog.findViewById(R.id.words);
        for (int l = 0; l < words.getChildCount(); l++)
            ((TextView) words.getChildAt(l)).setTextColor(correct);

        View.OnTouchListener listener = (v, event) ->
        {
            int x = (int) event.getX();
            int y = (int) event.getY();

            int width = v.getWidth();
            int height = v.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(width, height,
                                                Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            v.draw(canvas);
            int colour = bitmap.getPixel(x, y);
            switch (v.getId())
            {
            case R.id.contains:
                ((TextView) those.getChildAt(2)).setTextColor(colour);
                ((TextView) those.getChildAt(3)).setTextColor(colour);
                break;

            case R.id.correct:
                for (int l = 0; l < words.getChildCount(); l++)
                    ((TextView) words.getChildAt(l)).setTextColor(colour);
                break;
            }

            return false;
        };

        view = dialog.findViewById(R.id.contains);
        view.setOnTouchListener(listener);
        view = dialog.findViewById(R.id.correct);
        view.setOnTouchListener(listener);
    }

    // shareImage
    @SuppressWarnings("deprecation")
    private void shareImage()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String title = getString(R.string.appName);
        intent.putExtra(Intent.EXTRA_TITLE, title);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.setType(IMAGE_PNG);

        View root = findViewById(android.R.id.content).getRootView();
        root.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
        root.setDrawingCacheEnabled(false);

        File image = new File(getCacheDir(), GRIDLE_IMAGE);
        try (BufferedOutputStream out = new
             BufferedOutputStream(new FileOutputStream(image)))
        {
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        }

        catch (Exception e) {}

        Uri imageUri = FileProvider
            .getUriForFile(this, FILE_PROVIDER, image);
        intent.putExtra(Intent.EXTRA_STREAM, imageUri);

        startActivity(Intent.createChooser(intent, null));
    }

    // scorePuzzle
    private void scorePuzzle()
    {
        for (int row = 0; row < SIZE; row++)
        {
            Arrays.fill(used[row], false);
            Arrays.fill(scored[row], false);
        }

        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                display[row][col].setTextColor(getColour(GREY));
            }
        }

        boolean maybe = true;
        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                if (display[row][col].getVisibility() == View.INVISIBLE)
                    continue;

                if (puzzle[row][col] == gridle[row][col])
                {
                    used[row][col] = true;
                    scored[row][col] = true;
                    display[row][col].setTextColor(correct);
                }

                else
                    maybe = false;
            }
        }

        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                if (display[row][col].getVisibility() == View.INVISIBLE)
                    continue;

                if (scored[row][col])
                    continue;

                switch (row)
                {
                case 0:
                case 2:
                case 4:
                    for (int c = 0; c < SIZE; c++)
                    {
                        if (used[row][c])
                           continue;

                        if (puzzle[row][col] == gridle[row][c])
                        {
                            used[row][c] = true;
                            scored[row][col] = true;
                            display[row][col].setTextColor(contains);
                            break;
                        }
                    }
                }

                switch (col)
                {
                case 0:
                case 2:
                case 4:
                    for (int r = 0; r < SIZE; r++)
                    {
                        if (used[r][col])
                            continue;

                        if (puzzle[row][col] == gridle[r][col])
                        {
                            used[r][col] = true;
                            scored[row][col] = true;
                            display[row][col].setTextColor(contains);
                            break;
                        }
                    }
                }
            }
        }

        if (solved)
            return;

        if (maybe)
        {
            if (fanfare)
            {
                mediaPlayer = MediaPlayer.create(this, R.raw.fanfare);
                mediaPlayer.start();
            }

            showToast(R.string.congratulations);
            solved = true;
        }
    }

    // scorePuzzle
    private void scorePuzzle(View view)
    {
        if (solved)
        {
            showToast(R.string.solved);
            return;
        }

        if (swapLetters(view) == false)
            return;

        scorePuzzle();
    }

    // swapLetters
    private boolean swapLetters(View view)
    {
        View v = findNearestView(view);

        if (v == null)
            return false;

        ViewGroup parent = (ViewGroup) view.getParent();
        int index = parent.indexOfChild(v);
        int r = index / SIZE;
        int c = index % SIZE;

        if (puzzle[r][c] == ' ')
            return false;

        index = parent.indexOfChild(view);
        int row = index / SIZE;
        int col = index % SIZE;

        char ch = puzzle[r][c];
        puzzle[r][c] = puzzle[row][col];
        puzzle[row][col] = ch;

        CharSequence cs = display[r][c].getText();
        display[r][c].setText(display[row][col].getText());
        display[row][col].setText(cs);

        return true;
    }

    // findNearestView
    private View findNearestView(View view)
    {
        ViewGroup parent = (ViewGroup) view.getParent();
        double d = Double.MAX_VALUE;
        View nearest = null;
        for (int i = 0; i < parent.getChildCount(); i++)
        {
            View v = parent.getChildAt(i);
            if (v.equals(view))
                continue;

            if (Math.hypot(view.getX() - v.getX(),
                           view.getY() - v.getY()) < d)
            {
                d = Math.hypot(view.getX() - v.getX(),
                               view.getY() - v.getY());
                nearest = v;
            }
        }

        if (nearest.getVisibility() == View.INVISIBLE)
                return null;

        return nearest;
    }

    // refresh
    private void refresh()
    {
        gridle = Words.getGridle();

        puzzle = new char[SIZE][];
        for (int i = 0; i < SIZE; i++)
            puzzle[i] = Arrays.copyOf(gridle[i], SIZE);
        
        Words.randomise(puzzle);

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                display[i][j].setText
                    (new String(new char[] {puzzle[i][j]})
                     .toUpperCase(Locale.getDefault()));
            }
        }

        solved = false;
        scorePuzzle();
    }

    // getColour
    private int getColour(int c)
    {
        switch (c)
        {
        case WHITE:
            return 0xffffffff;

        case YELLOW:
            return 0xffffff00;

        case GREEN:
            return 0xff00ff00;

        case GREY:
            return 0x7fffffff;
        }

        return 0;
    }

    // help
    private void help()
    {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    // showToast
    void showToast(int key)
    {
        String text = getString(key);
        showToast(text);
    }

    // showToast
    void showToast(String text)
    {
        // Cancel the last one
        if (toast != null)
            toast.cancel();

        // Make a new one
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
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
