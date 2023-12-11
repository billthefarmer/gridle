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
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import android.view.SubMenu;
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
import java.text.Normalizer;

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
public class Gridle extends Activity
    implements PopupMenu.OnMenuItemClickListener

{
    public static final String TAG = "Gridle";

    public static final int SIZE = 5;
    public static final int VERSION_CODE_S_V2 = 32;

    public static final String PREF_THEME = "pref_theme";
    public static final String PREF_WRONG = "pref_wrong";
    public static final String PREF_CONF = "pref_conf";
    public static final String PREF_CONT = "pref_cont";
    public static final String PREF_CORR = "pref_corr";
    public static final String PREF_DICT = "pref_dict";
    public static final String PREF_FARE = "pref_fare";
    public static final String PREF_LANG = "pref_lang";

    public static final String SOLVED = "solved";
    public static final String CHEAT = "cheat";
    public static final String COUNT = "count";
    public static final String LANG = "lang";
    public static final String WORD = "word";

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
    public static final String TEXT_PLAIN = "text/plain";

    public static final String EXTRA_TO = "to";
    public static final String EXTRA_FROM = "from";
    public static final String AARD2_LOOKUP = "aard2.lookup";
    public static final String SEARCH_DICT =
        "com.hughes.action.ACTION_SEARCH_DICT";

    public static final String FILE_PROVIDER =
        "org.billthefarmer.gridle.fileprovider";

    public static final String A_ACCENTS[] = {"A", "À", "Á", "Â"};
    public static final String C_ACCENTS[] = {"C", "Ç"};
    public static final String E_ACCENTS[] = {"E", "È", "É", "Ê"};
    public static final String I_ACCENTS[] = {"I", "Ì", "Í", "Î"};
    public static final String N_ACCENTS[] = {"N", "Ñ"};
    public static final String O_ACCENTS[] = {"O", "Ò", "Ó", "Ô", "Ö", "Ő"};
    public static final String U_ACCENTS[] = {"U", "Ù", "Ú", "Û", "Ü", "Ű"};

    public static final int ENGLISH    = 0;
    public static final int ITALIAN    = 1;
    public static final int SPANISH    = 2;
    public static final int CATALAN    = 3;
    public static final int FRENCH     = 4;
    public static final int PORTUGUESE = 5;
    public static final int GERMAN     = 6;
    public static final int DUTCH      = 7;
    public static final int AFRIKAANS  = 8;

    public static final int WIKTIONARY = 0;
    public static final int AARD2      = 1;
    public static final int QUICKDIC   = 2;

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
    public static final int LIGHT   = 12;

    public static final int DELAY = 100;
    public static final int LONG_DELAY = 5000;

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
    private boolean select;
    private boolean solved;
    private boolean cheat;

    private int language;
    private int contains;
    private int correct;
    private int wrong;
    private int count;
    private int theme;
    private int dict;

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        confetti = preferences.getBoolean(PREF_CONF, true);
        contains = preferences.getInt(PREF_CONT, getColour(YELLOW));
        correct = preferences.getInt(PREF_CORR, getColour(GREEN));
        dict = preferences.getInt(PREF_DICT, WIKTIONARY);
        fanfare = preferences.getBoolean(PREF_FARE, true);
        language = preferences.getInt(PREF_LANG, ENGLISH);
        theme = preferences.getInt(PREF_THEME, DARK);
        wrong = preferences.getInt(PREF_WRONG, getColour(GREY));

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

        case LIGHT:
            setTheme(R.style.AppLightTheme);
            break;
        }

        setContentView(R.layout.main);

        setLanguage();

        View.OnTouchListener listener = new View.OnTouchListener()
        {
            private float x;
            private float y;
            private float dX;
            private float dY;
            private float gridX;
            private float gridY;

            private TextView item;
            private ViewGroup grid;

            @Override
            public boolean onTouch(View view, MotionEvent event)
            {
                // Check if drag allowed
                if (solved || select || cheat)
                    return false;

                item = findViewById(R.id.item);
                grid = findViewById(R.id.puzzle);

                gridX = grid.getX();
                gridY = grid.getY();

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
                    // Move the proxy view, make it visible, and copy
                    // the text and colour.
                    item.setX(x + gridX);
                    item.setY(y + gridY);
                    view.setVisibility(View.INVISIBLE);
                    item.setVisibility(View.VISIBLE);
                    item.setText(((TextView) view).getText());
                    item.setTextColor(((TextView) view).getTextColors());
                    break;

                case MotionEvent.ACTION_MOVE:
                    // Move the selected view and the proxy above it
                    view.setX(event.getRawX() + dX);
                    view.setY(event.getRawY() + dY);
                    item.setX(event.getRawX() + gridX + dX);
                    item.setY(event.getRawY() + gridY + dY);
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
                    break;

                default:
                    return false;
                }

                return true;
            }
        };

        actionModeCallback = new ActionMode.Callback()
        {
            // Called when the action mode is created;
            // startActionMode() was called
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu)
            {
                addAccents(actionView, menu);
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

        // Find toolbar
        toolbar = findViewById(getResources().getIdentifier("action_bar",
                                                            "id", "android"));
        // Set up navigation
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener((v) ->
        {
            PopupMenu popup = new PopupMenu(this, v);
            popup.inflate(R.menu.navigation);
            popup.setOnMenuItemClickListener(this);
            popup.show();
        });

        View layout = findViewById(R.id.layout);
        layout.setOnClickListener((v) ->
        {
            if (actionMode != null)
                actionMode.finish();
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

        ViewGroup grid = findViewById(R.id.puzzle);
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
        }, DELAY);

        // Attempt to disable system gestures for the display grid in
        // portrait
        Configuration config = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            config.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            View content = findViewById(android.R.id.content);
            grid.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) ->
            {
                int top = (int) grid.getY();
                int left = (int) content.getX();
                int right = left + content.getWidth();
                int bottom = top + grid.getHeight();
                Rect rect = new Rect(left, top, right, bottom);
                List<Rect> list = new ArrayList<Rect>();
                list.add(rect);
                content.setSystemGestureExclusionRects(list);
            });
        }

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
            count = savedInstanceState.getInt(COUNT);
            cheat = savedInstanceState.getBoolean(CHEAT);
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
            puzzle = Words.randomise(gridle);
            solved = false;
        }

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

        editor.putInt(PREF_CONT, contains);
        editor.putInt(PREF_CORR, correct);
        editor.putInt(PREF_DICT, dict);
        editor.putInt(PREF_LANG, language);
        editor.putInt(PREF_THEME, theme);
        editor.putInt(PREF_WRONG, wrong);
        editor.putBoolean(PREF_CONF, confetti);
        editor.putBoolean(PREF_FARE, fanfare);
        editor.apply();
    }

    // onSaveInstanceState
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt(COUNT, count);
        outState.putBoolean(CHEAT, cheat);
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
        menu.findItem(R.id.confetti).setChecked(confetti);
        menu.findItem(R.id.fanfare).setChecked(fanfare);

        MenuItem item = menu.findItem(R.id.dict);
        if (item.hasSubMenu())
        {
            SubMenu submenu = item.getSubMenu();
            item = submenu.getItem(dict);
            if (item != null)
                item.setChecked(true);
        }

        return true;
    }

    // onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        // No cheating
        if (cheat)
        {
            showToast(R.string.finish);
            return;
        }

        // Inflate a menu resource providing context menu items
        addAccents((TextView) v, menu);
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

        case R.id.text:
            selectText();
            break;

        case R.id.large:
            large();
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

        case R.id.light:
            theme(LIGHT);
            break;

        case R.id.english:
            setLanguage(ENGLISH);
            break;

        case R.id.italian:
            setLanguage(ITALIAN);
            break;

        case R.id.spanish:
            setLanguage(SPANISH);
            break;

        case R.id.catalan:
            setLanguage(CATALAN);
            break;

        case R.id.french:
           setLanguage(FRENCH);
           break;

       case R.id.portuguese:
           setLanguage(PORTUGUESE);
           break;

        case R.id.german:
           setLanguage(GERMAN);
           break;

        case R.id.dutch:
           setLanguage(DUTCH);
           break;

        case R.id.afrikaans:
           setLanguage(AFRIKAANS);
           break;

        case R.id.confetti:
            confetti(item);
            break;

        case R.id.fanfare:
            fanfare(item);
            break;

        case R.id.aard2:
            aard2(item);
            break;

        case R.id.quickdic:
            quickdic(item);
            break;

        case R.id.wikt:
            wikt(item);
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
        // Large
        case R.id.large:
            large();
            break;

        // Help
        case R.id.help:
            help();
            break;

        default:
            return false;
        }

        return true;
    }

    // onBackPressed
    @Override
    public void onBackPressed()
    {
        // Ignore back gestures if system gestures are enabled and a
        // game is in progress
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            getWindow().getDecorView().getRootWindowInsets()
            .getSystemGestureInsets().left > 0)
        {
            if (count == 0 || solved || cheat)
                finish();

            // Recreate because system gestures break display
            else
                recreate();
        }

        else
            finish();
    }

    // addAccents
    public static void addAccents(TextView textView, Menu menu)
    {
        char c = removeAccents(textView.getText()).charAt(0);

        String items[];
        switch (c)
        {
        case 'A':
            items = A_ACCENTS;
            break;

        case 'C':
            items = C_ACCENTS;
            break;

        case 'E':
            items = E_ACCENTS;
            break;

        case 'I':
            items = I_ACCENTS;
            break;

        case 'N':
            items = N_ACCENTS;
            break;

        case 'O':
            items = O_ACCENTS;
            break;

        case 'U':
            items = U_ACCENTS;
            break;

        default:
            menu.add(textView.getText());
            return;
        }

        for (String item: items)
            menu.add(item);
    }

    // theme
    private void theme(int c)
    {
        theme = c;
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.M)
            recreate();
    }

    // confetti
    private void confetti(MenuItem item)
    {
        confetti = !confetti;
        item.setChecked(confetti);
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
            wrong = getColour(GREY);
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
            wrong = ((TextView) those.getChildAt(0)).getTextColors()
                .getDefaultColor();
        });

        Dialog dialog = builder.show();

        int grey[] = {0, 1, 4};
        ViewGroup those = (ViewGroup) dialog.findViewById(R.id.those);
        for (int l: grey)
        {
            TextView t = (TextView) those.getChildAt(l);
            t.setTextColor(wrong);
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

            case R.id.wrong:
                ((TextView) those.getChildAt(0)).setTextColor(colour);
                ((TextView) those.getChildAt(1)).setTextColor(colour);
                ((TextView) those.getChildAt(4)).setTextColor(colour);
                break;
            }

            return false;
        };

        view = dialog.findViewById(R.id.contains);
        view.setOnTouchListener(listener);
        view = dialog.findViewById(R.id.correct);
        view.setOnTouchListener(listener);
        view = dialog.findViewById(R.id.wrong);
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

    // selectText
    void selectText()
    {
        // Set flag and show toast
        select = true;
        showToast(R.string.select);
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
    public static View findNearestView(View view)
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

        puzzle = Words.randomise(gridle);

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
        select = false;
        solved = false;
        cheat = false;
        scorePuzzle();
    }

    // accents
    private boolean accents(View view)
    {
        // No cheating
        if (cheat)
        {
            showToast(R.string.finish);
            return false;
        }

        actionView = (TextView) view;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return false;

        actionMode = view.startActionMode(actionModeCallback,
                                          ActionMode.TYPE_FLOATING);
        return true;
    }

    // getColour
    public static int getColour(int c)
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
            return 0x3fffffff;
        }

        return 0;
    }

    // languageToString
    public static String languageToString(int l)
    {
        switch (l)
        {
        default:
        case ENGLISH:
		return "en";

        case ITALIAN:
		return "it";

        case SPANISH:
		return "es";

        case CATALAN:
		return "ca";

        case FRENCH:
		return "fr";

        case PORTUGUESE:
		return "pt";

        case GERMAN:
		return "de";

        case DUTCH:
		return "nl";

        case AFRIKAANS:
		return "af";
        }
    }

    // setLanguage
    private void setLanguage(int l)
    {
        language = l;
        setLanguage();
        refresh();
    }

    // setLanguage
    private void setLanguage()
    {
        Words.setLanguage(this, language);

        switch (language)
        {
        default:
        case ENGLISH:
            getActionBar().setSubtitle(R.string.english);
            break;

        case ITALIAN:
            getActionBar().setSubtitle(R.string.italian);
            break;

        case SPANISH:
            getActionBar().setSubtitle(R.string.spanish);
            break;

        case CATALAN:
            getActionBar().setSubtitle(R.string.catalan);
            break;

        case FRENCH:
            getActionBar().setSubtitle(R.string.french);
            break;

        case PORTUGUESE:
            getActionBar().setSubtitle(R.string.portuguese);
            break;

        case GERMAN:
            getActionBar().setSubtitle(R.string.german);
            break;

        case DUTCH:
            getActionBar().setSubtitle(R.string.dutch);
            break;

        case AFRIKAANS:
            getActionBar().setSubtitle(R.string.afrikaans);
            break;
        }
    }

    // large
    private void large()
    {
        Intent intent = new Intent(this, Large.class);
        startActivity(intent);
    }

    // search
    private void search(View view)
    {
        if (actionMode != null)
            actionMode.finish();

        // Check share text
        if (select && !cheat)
        {
            shareText(view);
            return;
        }

        // No cheating
        if (!solved || cheat)
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
            for (int i = 0; i < SIZE; i++)
                builder.append(puzzle[i][col]);
        }

        switch(col)
        {
        case 1:
        case 3:
            for (int i = 0; i < SIZE; i++)
                builder.append(puzzle[row][i]);
        }

        if (builder.length() == 0)
        {
            showToast(R.string.which);
            return;
        }

        // Check dictionary
        Intent intent;
        switch (dict)
        {
        case AARD2:
            // Start Aard2 search
            intent = new Intent(AARD2_LOOKUP);
            intent.putExtra(Intent.EXTRA_TEXT, builder.toString());
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
                break;
            }

        case QUICKDIC:
            // Start quickdic search
            intent = new Intent(SEARCH_DICT);
            intent.putExtra(SearchManager.QUERY, builder.toString());
            intent.putExtra(EXTRA_FROM, languageToString(language));
            intent.putExtra(EXTRA_TO, Locale.getDefault().getLanguage());
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
                break;
            }

        default:
        case WIKTIONARY:
            // Start the web search
            intent = new Intent(this, Search.class);
            intent.putExtra(WORD, builder.toString());
            intent.putExtra(LANG, languageToString(language));
            startActivity(intent);
        }
    }

    // aard2
    private void aard2(MenuItem item)
    {
        dict = AARD2;
        item.setChecked(true);
    }

    // quickdic
    private void quickdic(MenuItem item)
    {
        dict = QUICKDIC;
        item.setChecked(true);
    }

    // wikt
    private void wikt(MenuItem item)
    {
        dict = WIKTIONARY;
        item.setChecked(true);
    }

    // shareText
    private void shareText(View view)
    {
        ViewGroup parent = (ViewGroup) view.getParent();
        int index = parent.indexOfChild(view);
        int row = index / SIZE;
        int col = index % SIZE;

        StringBuilder builder = new StringBuilder();
        switch(row)
        {
        case 1:
        case 3:
            // Get green letters
            for (int i = 0; i < SIZE; i++)
            {
                if (display[i][col].getTextColors()
                    .getDefaultColor() == correct)
                    builder.append(puzzle[i][col]);

                else
                    builder.append(".");
            }
            builder.append(",");

            // Get yellow letters
            for (int i = 0; i < SIZE; i++)
            {
                if (display[i][col].getTextColors()
                    .getDefaultColor() == contains)
                    builder.append(puzzle[i][col]);
            }
        }

        switch(col)
        {
        case 1:
        case 3:
            // Get green letters
            for (int i = 0; i < SIZE; i++)
            {
                if (display[row][i].getTextColors()
                    .getDefaultColor() == correct)
                    builder.append(puzzle[row][i]);

                else
                    builder.append(".");
            }
            builder.append(",");

            // Get yellow letters
            for (int i = 0; i < SIZE; i++)
            {
                if (display[row][i].getTextColors()
                    .getDefaultColor() == contains)
                    builder.append(puzzle[row][i]);
            }
        }

        if (builder.length() == 0)
        {
            showToast(R.string.which);
            return;
        }

        // Clear select
        select = false;

        // Send intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, builder.toString());
        intent.setType(TEXT_PLAIN);
        startActivity(Intent.createChooser(intent, null));
    }

    // help
    private void help()
    {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    // removeAccents
    public static String removeAccents(CharSequence cs)
    {
        return Normalizer.normalize(cs, Normalizer.Form.NFKD)
            .replaceAll("\\p{M}", "");
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
        if (view != null && Build.VERSION.SDK_INT > VERSION_CODE_S_V2)
            view.setBackgroundResource(R.drawable.toast_frame);
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
        builder.setNeutralButton(R.string.help, (d, i) -> cheat());

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

    // cheat
    void cheat()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.appName);
        builder.setIcon(R.drawable.ic_launcher);
        // Build message
        StringBuilder message = new StringBuilder();
        for (char r[]: gridle)
        {
            for (char c: r)
                message.append(" ").append(c);

            message.append("\n");
        }
        builder.setMessage(message.toString().toUpperCase(Locale.getDefault()));

        // No cheating
        cheat = true;
        // Create the AlertDialog
        Dialog dialog = builder.show();
        // Set typeface
        TextView text = dialog.findViewById(android.R.id.message);
        if (text != null)
        {
            text.setTextAppearance(builder.getContext(),
                                   android.R.style.TextAppearance_Large);
            text.setTypeface(Typeface.MONOSPACE);
            text.postDelayed(() -> dialog.dismiss(), LONG_DELAY);
        }
    }
}
