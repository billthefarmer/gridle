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
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

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

import java.util.concurrent.TimeUnit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.xml.KonfettiView;

@SuppressWarnings("deprecation")
public class Large extends Activity
    implements PopupMenu.OnMenuItemClickListener
{
    public static final String TAG = "Large";

    public static final int SIZE = 7;

    public static final String PUZZLE_0 = "puzzle_0";
    public static final String PUZZLE_1 = "puzzle_1";
    public static final String PUZZLE_2 = "puzzle_2";
    public static final String PUZZLE_3 = "puzzle_3";
    public static final String PUZZLE_4 = "puzzle_4";
    public static final String PUZZLE_5 = "puzzle_5";
    public static final String PUZZLE_6 = "puzzle_6";

    public static final String GRIDLE_0 = "gridle_0";
    public static final String GRIDLE_1 = "gridle_1";
    public static final String GRIDLE_2 = "gridle_2";
    public static final String GRIDLE_3 = "gridle_3";
    public static final String GRIDLE_4 = "gridle_4";
    public static final String GRIDLE_5 = "gridle_5";
    public static final String GRIDLE_6 = "gridle_6";

    private ActionMode.Callback actionModeCallback;
    private ActionMode actionMode;

    private KonfettiView konfettiView;
    private TextView display[][];
    private TextView customView;
    private TextView actionView;
    private Toolbar toolbar;

    private Toast toast;
    private Party party;

    private MediaPlayer mediaPlayer;

    private boolean scored[][];
    private boolean used[][];

    private char gridle[][];
    private char puzzle[][];

    private boolean confetti;
    private boolean fanfare;
    private boolean solved;

    private int language;
    private int contains;
    private int correct;
    private int wrong;
    private int count;
    private int theme;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        theme = preferences.getInt(Gridle.PREF_THEME, Gridle.DARK);
        wrong = preferences.getInt(Gridle.PREF_WRONG,
                                   Gridle.getColour(Gridle.GREY));
        language = preferences.getInt(Gridle.PREF_LANG, Gridle.ENGLISH);
        contains = preferences.getInt(Gridle.PREF_CONT,
                                      Gridle.getColour(Gridle.YELLOW));
        correct = preferences.getInt(Gridle.PREF_CORR,
                                     Gridle.getColour(Gridle.GREEN));
        confetti = preferences.getBoolean(Gridle.PREF_CONF, true);
        fanfare = preferences.getBoolean(Gridle.PREF_FARE, true);

        switch (theme)
        {
        default:
        case Gridle.DARK:
            setTheme(R.style.AppTheme);
            break;

        case Gridle.CYAN:
            setTheme(R.style.AppCyanTheme);
            break;

        case Gridle.BLUE:
            setTheme(R.style.AppBlueTheme);
            break;

        case Gridle.ORANGE:
            setTheme(R.style.AppOrangeTheme);
            break;

        case Gridle.PURPLE:
            setTheme(R.style.AppPurpleTheme);
            break;

        case Gridle.RED:
            setTheme(R.style.AppRedTheme);
            break;

        case Gridle.BLACK:
            setTheme(R.style.AppBlackTheme);
            break;

        case Gridle.LIGHT:
            setTheme(R.style.AppLightTheme);
            break;
        }

        setContentView(R.layout.large);

        setLanguage();

        View.OnTouchListener listener = new View.OnTouchListener()
        {
            private float x;
            private float y;
            private float dX;
            private float dY;
            private View tv = null;

            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                if (solved)
                    return false;

                // Save current view
                if (tv == null)
                    tv = view;

                // Check multi touch and ignore
                if (view != tv)
                    return true;

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
                    // Move the proxy view, make it visible, and copy the
                    // text.
                    item.setX(x + grid.getX());
                    item.setY(y + grid.getY());
                    view.setVisibility(View.INVISIBLE);
                    item.setVisibility(View.VISIBLE);
                    ((TextView) item).setText(((TextView) view).getText());
                    ((TextView) item).setTextColor(((TextView)
                                                    view).getTextColors());
                    break;

                case MotionEvent.ACTION_MOVE:
                    // Move the selected view and the proxy above it
                    view.setX(event.getRawX() + dX);
                    view.setY(event.getRawY() + dY);
                    item.setX(event.getRawX() + grid.getX() + dX);
                    item.setY(event.getRawY() + grid.getY() + dY);
                    break;

                case MotionEvent.ACTION_UP:
                    view.setVisibility(View.VISIBLE);
                    item.setVisibility(View.INVISIBLE);
                    // Swap texts and colour letters
                    if (Math.hypot(view.getX() - x, view.getY() - y) >
                        Math.hypot(view.getWidth() / 2, view.getHeight() / 2))
                        scorePuzzle(view);

                    else
                        showToast(R.string.finish);

                    // Put the selected view back, move proxy into the
                    // top corner, and make it invisible
                    view.setX(x);
                    view.setY(y);
                    item.setX(0);
                    item.setY(0);
                    tv = null;
                    break;

                default:
                    return false;
                }

                return true;
            };
        };

        actionModeCallback = new ActionMode.Callback()
        {
            // Called when the action mode is created;
            // startActionMode() was called
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu)
            {
                Gridle.addAccents(actionView, menu);
                return true;
            }

            // Called each time the action mode is shown. Always
            // called after onCreateActionMode, but may be called
            // multiple times if the mode is invalidated.
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu)
            {
                return false; // Return false if nothing is done
            }

            // Called when the user selects a contextual menu item
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item)
            {
                actionView.setText(item.getTitle());
                ViewGroup parent = (ViewGroup) actionView.getParent();
                int index = parent.indexOfChild(actionView);
                int r = index / SIZE;
                int c = index % SIZE;

                puzzle[r][c] = item.getTitle().toString()
                    .toLowerCase(Locale.getDefault()).charAt(0);

                mode.finish(); // Action picked, so close the CAB
                return true;
            }

            // Called when the user exits the action mode
            @Override
            public void onDestroyActionMode(ActionMode mode)
            {
                actionMode = null;
            }
        };

        View content = findViewById(android.R.id.content);
        content.setOnClickListener((v) ->
        {
            if (actionMode != null)
                actionMode.finish();
        });

        // Find toolbar
        ViewGroup root = (ViewGroup) getWindow().getDecorView();
        toolbar = findToolbar(root);

        // Set up navigation
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_36dp);
        toolbar.setNavigationOnClickListener((v) ->
        {
            PopupMenu popup = new PopupMenu(this, v);
            popup.inflate(R.menu.navigation);
            popup.setOnMenuItemClickListener(this);
            popup.show();
        });

        konfettiView = findViewById(R.id.konfettiView);
        EmitterConfig emitterConfig = new
            Emitter(5, TimeUnit.SECONDS).perSecond(50);
        party = new PartyFactory(emitterConfig)
            .angle(Angle.TOP)
            .spread(Spread.WIDE)
            .setSpeedBetween(10, 30)
            .build();

        display = new TextView[SIZE][];
        for (int i = 0; i < display.length; i++)
            display[i] = new TextView[SIZE];

        ViewGroup grid = (ViewGroup) findViewById(R.id.puzzle);
        for (int i = 0; i < grid.getChildCount(); i++)
        {
            display[i / SIZE][i % SIZE] = (TextView) grid.getChildAt(i);
            display[i / SIZE][i % SIZE].setOnTouchListener(listener);
            display[i / SIZE][i % SIZE].setOnClickListener((v) -> search(v));
            display[i / SIZE][i % SIZE].setOnLongClickListener((v) ->
                                                               accents(v));
            registerForContextMenu(display[i / SIZE][i % SIZE]);
        }

        // Delay resizing
        grid.postDelayed(() ->
        {
            View layout = findViewById(R.id.layout);
            float scaleX = (float) layout.getWidth() / grid.getWidth();
            float scaleY = (float) layout.getHeight() / grid.getHeight();
            float scale = Math.min(scaleX, scaleY);
            for (int i = 0; i < grid.getChildCount(); i++)
            {
                TextView v = (TextView) grid.getChildAt(i);
                v.setMinimumWidth(Math.round(v.getMinimumWidth() * scale));
                v.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                              v.getTextSize() * scale);
            }
            TextView item = findViewById(R.id.item);
            item.setMinimumWidth(Math.round(item.getMinimumWidth() * scale));
            item.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                             item.getTextSize() * scale);
        }, Gridle.DELAY);

        getActionBar().setCustomView(R.layout.custom);
        getActionBar().setDisplayShowCustomEnabled(true);
        customView = (TextView) getActionBar().getCustomView();

        used = new boolean[SIZE][];
        scored = new boolean[SIZE][];
        for (int row = 0; row < SIZE; row++)
        {
            used[row] = new boolean[SIZE];
            scored[row] = new boolean[SIZE];
        }

        if (savedInstanceState != null)
        {
            count = savedInstanceState.getInt(Gridle.COUNT);
            solved = savedInstanceState.getBoolean(Gridle.SOLVED);

            if (savedInstanceState.getCharArray(GRIDLE_0) == null)
                return;

            gridle = new char[SIZE][];

            gridle[0] = savedInstanceState.getCharArray(GRIDLE_0);
            gridle[1] = savedInstanceState.getCharArray(GRIDLE_1);
            gridle[2] = savedInstanceState.getCharArray(GRIDLE_2);
            gridle[3] = savedInstanceState.getCharArray(GRIDLE_3);
            gridle[4] = savedInstanceState.getCharArray(GRIDLE_4);
            gridle[5] = savedInstanceState.getCharArray(GRIDLE_5);
            gridle[6] = savedInstanceState.getCharArray(GRIDLE_6);

            puzzle = new char[SIZE][];

            puzzle[0] = savedInstanceState.getCharArray(PUZZLE_0);
            puzzle[1] = savedInstanceState.getCharArray(PUZZLE_1);
            puzzle[2] = savedInstanceState.getCharArray(PUZZLE_2);
            puzzle[3] = savedInstanceState.getCharArray(PUZZLE_3);
            puzzle[4] = savedInstanceState.getCharArray(PUZZLE_4);
            puzzle[5] = savedInstanceState.getCharArray(PUZZLE_5);
            puzzle[6] = savedInstanceState.getCharArray(PUZZLE_6);

            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {
                    display[i][j].setText
                        (new String(new char[] {puzzle[i][j]})
                         .toUpperCase(Locale.getDefault()));
                    if (solved)
                        display[i][j].setTextColor(correct);
                }
            }

            if (solved)
                customView.setText(Integer.toString(count));

            else
                scorePuzzle();
        }

        else
        {
            View progress = findViewById(R.id.progress);
            progress.setVisibility(View.VISIBLE);

            LargeWords.WordsTask task = new LargeWords.WordsTask(this);
            task.execute();
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

        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt(Gridle.COUNT, count);
        outState.putBoolean(Gridle.SOLVED, solved);

        if (puzzle == null)
            return;

        outState.putCharArray(PUZZLE_0, puzzle[0]);
        outState.putCharArray(PUZZLE_1, puzzle[1]);
        outState.putCharArray(PUZZLE_2, puzzle[2]);
        outState.putCharArray(PUZZLE_3, puzzle[3]);
        outState.putCharArray(PUZZLE_4, puzzle[4]);
        outState.putCharArray(PUZZLE_5, puzzle[5]);
        outState.putCharArray(PUZZLE_6, puzzle[6]);

        outState.putCharArray(GRIDLE_0, gridle[0]);
        outState.putCharArray(GRIDLE_1, gridle[1]);
        outState.putCharArray(GRIDLE_2, gridle[2]);
        outState.putCharArray(GRIDLE_3, gridle[3]);
        outState.putCharArray(GRIDLE_4, gridle[4]);
        outState.putCharArray(GRIDLE_5, gridle[5]);
        outState.putCharArray(GRIDLE_6, gridle[6]);
    }

    // On create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it
        // is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.large, menu);

        return true;
    }

    // onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        // Inflate a menu resource providing context menu items
        Gridle.addAccents((TextView) v, menu);
    }

    // On options item selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Get id
        int id = item.getItemId();
        switch (id)
        {
        case android.R.id.home:
            finish();
            break;

        case R.id.refresh:
            refresh();
            break;

        case R.id.share:
            shareImage();
            break;

        case R.id.help:
            help();
            break;

        default:
            return false;
        }

        return true;
    }

    // onContextItemSelected
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        actionView.setText(item.getTitle());

        ViewGroup parent = (ViewGroup) actionView.getParent();
        int index = parent.indexOfChild(actionView);
        int r = index / SIZE;
        int c = index % SIZE;

        puzzle[r][c] = item.getTitle().toString()
            .toLowerCase(Locale.getDefault()).charAt(0);

        return true;
    }

    // onMenuItemClick
    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
        // Get id
        int id = item.getItemId();
        switch (id)
        {
        // Gridle
        case R.id.gridle:
            finish();
            break;

        // Help
        case R.id.help:
            help();

        default:
            return false;
        }

        return true;
    }

    // findToolbar
    private Toolbar findToolbar(ViewGroup group)
    {
        View result = null;
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++)
        {
            View view = group.getChildAt(i);
            if (view instanceof Toolbar)
                return (Toolbar) view;

            if (view instanceof ViewGroup)
                result = findToolbar((ViewGroup) view);

            if (result != null)
                break;
        }

        return (Toolbar) result;
    }

    public void setGridle(char gridle[][])
    {
        this.gridle = gridle;
    }

    public void setPuzzle(char puzzle[][])
    {
        this.puzzle = puzzle;

        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                display[i][j].setText
                    (new String(new char[] {puzzle[i][j]})
                     .toUpperCase(Locale.getDefault()));
            }
        }

        count = 0;
        solved = false;
        scorePuzzle();

        View progress = findViewById(R.id.progress);
        progress.setVisibility(View.GONE);
    }

    // shareImage
    @SuppressWarnings("deprecation")
    private void shareImage()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String title = getString(R.string.appName);
        intent.putExtra(Intent.EXTRA_TITLE, title);
        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.setType(Gridle.IMAGE_PNG);

        View root = findViewById(android.R.id.content).getRootView();
        root.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
        root.setDrawingCacheEnabled(false);

        File image = new File(getCacheDir(), Gridle.GRIDLE_IMAGE);
        try (BufferedOutputStream out = new
             BufferedOutputStream(new FileOutputStream(image)))
        {
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        }

        catch (Exception e) {}

        Uri imageUri = FileProvider
            .getUriForFile(this, Gridle.FILE_PROVIDER, image);
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
                display[row][col].setTextColor(wrong);
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
                case 6:
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
                case 6:
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

        customView.setText(Integer.toString(count));

        if (solved)
            return;

        if (maybe)
        {
            if (fanfare)
            {
                mediaPlayer = MediaPlayer.create(this, R.raw.fanfare);
                mediaPlayer.start();
            }

            if (confetti)
                konfettiView.start(party);

            showToast(R.string.congratulations);
            solved = true;
        }
    }

    // scorePuzzle
    private void scorePuzzle(View view)
    {
        if (puzzle == null)
            return;

        if (solved)
        {
            showToast(R.string.solved);
            return;
        }

        if (swapLetters(view) == false)
            return;

        count++;
        scorePuzzle();
    }

    // swapLetters
    private boolean swapLetters(View view)
    {
        View v = Gridle.findNearestView(view);

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

    // refresh
    private void refresh()
    {
        View progress = findViewById(R.id.progress);
        progress.setVisibility(View.VISIBLE);

        LargeWords.WordsTask task = new LargeWords.WordsTask(this);
        task.execute();
    }

    // accents
    private boolean accents(View view)
    {
        actionView = (TextView) view;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return false;

        actionMode = view.startActionMode(actionModeCallback,
                                          ActionMode.TYPE_FLOATING);
        return true;
    }

    // setLanguage
    private void setLanguage()
    {
        LargeWords.setLanguage(this, language);

        switch (language)
        {
        default:
        case Gridle.ENGLISH:
            getActionBar().setSubtitle(R.string.english);
            break;

        case Gridle.ITALIAN:
            getActionBar().setSubtitle(R.string.italian);
            break;

        case Gridle.SPANISH:
            getActionBar().setSubtitle(R.string.spanish);
            break;

        case Gridle.CATALAN:
            getActionBar().setSubtitle(R.string.catalan);
            break;

        case Gridle.FRENCH:
            getActionBar().setSubtitle(R.string.french);
            break;

        case Gridle.PORTUGUESE:
            getActionBar().setSubtitle(R.string.portuguese);
            break;

        case Gridle.GERMAN:
            getActionBar().setSubtitle(R.string.german);
            break;

        case Gridle.DUTCH:
            getActionBar().setSubtitle(R.string.dutch);
            break;

        case Gridle.AFRIKAANS:
            getActionBar().setSubtitle(R.string.afrikaans);
            break;
        }
    }

    // search
    private void search(View view)
    {
        if (actionMode != null)
            actionMode.finish();

        if (!solved)
        {
            showToast(R.string.finish);
            return;
        }

        ViewGroup parent = (ViewGroup) view.getParent();
        int index = parent.indexOfChild(view);
        int row = index / SIZE;
        int col = index % SIZE;

        StringBuilder builder = new StringBuilder();
        switch(row)
        {
        case 1:
        case 3:
        case 5:
            for (int i = 0; i < SIZE; i++)
                builder.append(puzzle[i][col]);
        }

        switch(col)
        {
        case 1:
        case 3:
        case 5:
            for (int i = 0; i < SIZE; i++)
                builder.append(puzzle[row][i]);
        }

        if (builder.length() == 0)
        {
            showToast(R.string.which);
            return;
        }

        // Start the web search
        Intent intent = new Intent(this, Search.class);
        intent.putExtra(Gridle.WORD, builder.toString());
        intent.putExtra(Gridle.LANG, Gridle.languageToString(language));
        startActivity(intent);
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
        // Fix for android 13
        View view = toast.getView();
        if (view != null && Build.VERSION.SDK_INT > Gridle.VERSION_CODE_S_V2)
            view.setBackgroundResource(R.drawable.toast_frame);
        toast.show();
    }
}
