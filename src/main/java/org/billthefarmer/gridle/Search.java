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

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;
import java.util.Locale;

// SearchActivity
@SuppressWarnings("deprecation")
public class Search extends Activity
{
    public static final String UTF_8 = "UTF-8";
    public static final String FORMAT =
        "https://%s.wiktionary.org/wiki/%s";

    private WebView webview;

    // Called when the activity is first created
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences =
            PreferenceManager.getDefaultSharedPreferences(this);

        int theme = preferences.getInt(Gridle.PREF_THEME, Gridle.DARK);

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

        // Set content
        setContentView(R.layout.search);

        // Find web view
        webview = findViewById(R.id.webview);

        // Enable back navigation on action bar
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        if (webview != null)
        {
            // Enable javascript, DuckDuckGo doesn't work unless
            // JavaScript is enabled
            WebSettings settings = webview.getSettings();
            settings.setJavaScriptEnabled(true);

            // Enable zoom
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);

            // Follow links and set title
            webview.setWebViewClient(new WebViewClient()
            {
                // onPageFinished
                @Override
                public void onPageFinished(WebView view, String url)
                {
                    // Get page title
                    if (view.getTitle() != null)
                        setTitle(view.getTitle());
                }
            });

            if (savedInstanceState != null)
                // Restore state
                webview.restoreState(savedInstanceState);

            else
            {
                // Get the word from the intent and create url
                Intent intent = getIntent();
                String lang = intent.getStringExtra(Gridle.LANG);
                String word = intent.getStringExtra(Gridle.WORD);

		try
		{
                    word = URLEncoder.encode(word, UTF_8);
		}

		catch (Exception e) {}

                String url = String.format(Locale.getDefault(),
                                           FORMAT, lang, word);

                // Do web search
                webview.loadUrl(url);
            }
        }
    }

    // On save instance state
    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        if (webview != null)
            // Save state
            webview.saveState(outState);
    }

    // On options item selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Get id
        int id = item.getItemId();
        switch (id)
        {
        // Home
        case android.R.id.home:
            // Back navigation
            if (webview != null && webview.canGoBack())
                webview.goBack();

            else
                finish();
            break;

        default:
            return false;
        }

        return true;
    }

    // On back pressed
    @Override
    public void onBackPressed()
    {
        // Back navigation
        if (webview != null && webview.canGoBack())
            webview.goBack();

        else
            finish();
    }
}
