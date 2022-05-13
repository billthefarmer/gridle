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

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LargeWords
{
    private static char gridle[][];

    private static List<String> wordList;

    private static List<String> aList;
    private static List<String> bList;
    private static List<String> cList;
    private static List<String> dList;
    private static List<String> eList;
    private static List<String> fList;
    private static List<String> gList;
    private static List<String> hList;
    private static List<String> iList;
    private static List<String> jList;
    private static List<String> kList;
    private static List<String> lList;
    private static List<String> mList;
    private static List<String> nList;
    private static List<String> oList;
    private static List<String> pList;
    private static List<String> qList;
    private static List<String> rList;
    private static List<String> sList;
    private static List<String> tList;
    private static List<String> uList;
    private static List<String> vList;
    private static List<String> wList;
    private static List<String> xList;
    private static List<String> yList;
    private static List<String> zList;

    private static Iterator<String> aIterator;
    private static Iterator<String> bIterator;
    private static Iterator<String> cIterator;
    private static Iterator<String> dIterator;
    private static Iterator<String> eIterator;
    private static Iterator<String> fIterator;
    private static Iterator<String> gIterator;
    private static Iterator<String> hIterator;
    private static Iterator<String> iIterator;
    private static Iterator<String> jIterator;
    private static Iterator<String> kIterator;
    private static Iterator<String> lIterator;
    private static Iterator<String> mIterator;
    private static Iterator<String> nIterator;
    private static Iterator<String> oIterator;
    private static Iterator<String> pIterator;
    private static Iterator<String> qIterator;
    private static Iterator<String> rIterator;
    private static Iterator<String> sIterator;
    private static Iterator<String> tIterator;
    private static Iterator<String> uIterator;
    private static Iterator<String> vIterator;
    private static Iterator<String> wIterator;
    private static Iterator<String> xIterator;
    private static Iterator<String> yIterator;
    private static Iterator<String> zIterator;

    private static Set<String> usedSet;

    private static Random random;

    // getGridle
    public static char[][] getGridle()
    {
        if (random == null)
            random = new Random(new Date().getTime());

        wordList = new ArrayList<String>(Arrays.asList(WORDS));
        wordList.addAll(Arrays.asList(MoreWords.WORDS));

        randomise(wordList);

        aList = new ArrayList<String>();
        bList = new ArrayList<String>();
        cList = new ArrayList<String>();
        dList = new ArrayList<String>();
        eList = new ArrayList<String>();
        fList = new ArrayList<String>();
        gList = new ArrayList<String>();
        hList = new ArrayList<String>();
        iList = new ArrayList<String>();
        jList = new ArrayList<String>();
        kList = new ArrayList<String>();
        lList = new ArrayList<String>();
        mList = new ArrayList<String>();
        nList = new ArrayList<String>();
        oList = new ArrayList<String>();
        pList = new ArrayList<String>();
        qList = new ArrayList<String>();
        rList = new ArrayList<String>();
        sList = new ArrayList<String>();
        tList = new ArrayList<String>();
        uList = new ArrayList<String>();
        vList = new ArrayList<String>();
        wList = new ArrayList<String>();
        xList = new ArrayList<String>();
        yList = new ArrayList<String>();
        zList = new ArrayList<String>();

        for (String word: wordList.toArray(new String[0]))
        {
            switch (word.charAt(0))
            {
            case 'a': aList.add(word); break;
            case 'b': bList.add(word); break;
            case 'c': cList.add(word); break;
            case 'd': dList.add(word); break;
            case 'e': eList.add(word); break;
            case 'f': fList.add(word); break;
            case 'g': gList.add(word); break;
            case 'h': hList.add(word); break;
            case 'i': iList.add(word); break;
            case 'j': jList.add(word); break;
            case 'k': kList.add(word); break;
            case 'l': lList.add(word); break;
            case 'm': mList.add(word); break;
            case 'n': nList.add(word); break;
            case 'o': oList.add(word); break;
            case 'p': pList.add(word); break;
            case 'q': qList.add(word); break;
            case 'r': rList.add(word); break;
            case 's': sList.add(word); break;
            case 't': tList.add(word); break;
            case 'u': uList.add(word); break;
            case 'v': vList.add(word); break;
            case 'w': wList.add(word); break;
            case 'x': xList.add(word); break;
            case 'y': yList.add(word); break;
            case 'z': zList.add(word); break;
            }
        }

        gridle = new char[Large.SIZE][];

        for (String word: wordList.toArray(new String[0]))
        {
            aIterator = aList.iterator();
            bIterator = bList.iterator();
            cIterator = cList.iterator();
            dIterator = dList.iterator();
            eIterator = eList.iterator();
            fIterator = fList.iterator();
            gIterator = gList.iterator();
            hIterator = hList.iterator();
            iIterator = iList.iterator();
            jIterator = jList.iterator();
            kIterator = kList.iterator();
            lIterator = lList.iterator();
            mIterator = mList.iterator();
            nIterator = nList.iterator();
            oIterator = oList.iterator();
            pIterator = pList.iterator();
            qIterator = qList.iterator();
            rIterator = rList.iterator();
            sIterator = sList.iterator();
            tIterator = tList.iterator();
            uIterator = uList.iterator();
            vIterator = vList.iterator();
            wIterator = wList.iterator();
            xIterator = xList.iterator();
            yIterator = yList.iterator();
            zIterator = zList.iterator();

            usedSet = new HashSet<String>();
            usedSet.add(word);

            String s = getWord(word.charAt(0));
            if (s == null)
                continue;

            gridle[0] = s.toCharArray();
            gridle[1] = new char[Large.SIZE];
            Arrays.fill(gridle[1], ' ');
            s = getWord(word.charAt(2));
            if (s == null)
                continue;

            gridle[2] = s.toCharArray();
            gridle[3] = new char[Large.SIZE];
            Arrays.fill(gridle[3], ' ');
            s = getWord(word.charAt(4));
            if (s == null)
                continue;

            gridle[4] = s.toCharArray();
            gridle[5] = new char[7];
            Arrays.fill(gridle[5], ' ');
            s = getWord(word.charAt(6));
            if (s == null)
                continue;
            gridle[6] = s.toCharArray();

            gridle[1][0] = word.charAt(1);
            gridle[3][0] = word.charAt(3);
            gridle[5][0] = word.charAt(5);

            word = getWord(gridle[0][2], gridle[2][2], gridle[4][2],
                           gridle[6][2]);
            if (word == null)
                continue;

            gridle[1][2] = word.charAt(1);
            gridle[3][2] = word.charAt(3);
            gridle[5][2] = word.charAt(5);

            word = getWord(gridle[0][4], gridle[2][4], gridle[4][4],
                           gridle[6][4]);
            if (word == null)
                continue;

            gridle[1][4] = word.charAt(1);
            gridle[3][4] = word.charAt(3);
            gridle[5][4] = word.charAt(5);

            word = getWord(gridle[0][6], gridle[2][6], gridle[4][6],
                           gridle[6][6]);
            if (word == null)
                continue;

            gridle[1][6] = word.charAt(1);
            gridle[3][6] = word.charAt(3);
            gridle[5][6] = word.charAt(5);

            return gridle;
        }

        return null;
    }

    // randomise
    private static void randomise(List<String> list)
    {
        int index = 0;
        for (String w: list.toArray(new String[0]))
        {
            int r = random.nextInt(list.size());
            list.set(index++, list.get(r));
            list.set(r, w);
        }
    }

    // randomise
    public static char[][] randomise(char gridle[][])
    {
        char puzzle[][] = new char[Large.SIZE][];
        for (int i = 0; i < Large.SIZE; i++)
            puzzle[i] = Arrays.copyOf(gridle[i], Large.SIZE);

        for (int row = 0; row < Large.SIZE; row++)
        {
            for (int col = 0; col < Large.SIZE; col++)
            {
                if ((puzzle[row][col] == ' ') ||
                    (row == 0 && col == 0) ||
                    (row == 0 && col == 6) ||
                    (row == 2 && col == 2) ||
                    (row == 2 && col == 4) ||
                    (row == 4 && col == 2) ||
                    (row == 4 && col == 4) ||
                    (row == 6 && col == 0) ||
                    (row == 6 && col == 6))
                    continue;

                int r = random.nextInt(Large.SIZE);
                int c = random.nextInt(Large.SIZE);

                while ((puzzle[r][c] == ' ') ||
                       (r == 0 && c == 0) ||
                       (r == 0 && c == 6) ||
                       (r == 2 && c == 2) ||
                       (r == 2 && c == 4) ||
                       (r == 4 && c == 2) ||
                       (r == 4 && c == 4) ||
                       (r == 6 && c == 0) ||
                       (r == 6 && c == 6))
                {
                    r = random.nextInt(Large.SIZE);
                    c = random.nextInt(Large.SIZE);
                }

                char ch = puzzle[row][col];
                puzzle[row][col] = puzzle[r][c];
                puzzle[r][c] = ch;
            }
        }

        return puzzle;
    }

    // getWord
    private static String getWord(char a, char b, char c, char d)
    {
        Iterator<String> iterator = getIterator(a);
        while (iterator.hasNext())
        {
            String word = iterator.next();
            if (usedSet.contains(word))
                continue;
            if (word.charAt(2) == b &&
                word.charAt(4) == c &&
                word.charAt(6) == d)
            {
                usedSet.add(word);
                return word;
            }
        }

        return null;
    }

    // getWord
    private static String getWord(char c)
    {
        Iterator<String> iterator = getIterator(c);
        while (iterator.hasNext())
        {
            String word = iterator.next();
            if (usedSet.contains(word))
                continue;

            usedSet.add(word);
            return word;
        }

        return null;
    }

    // getIterator
    private static Iterator<String> getIterator(char c)
    {
        switch (c)
        {
        case 'a': return aIterator;
        case 'b': return bIterator;
        case 'c': return cIterator;
        case 'd': return dIterator;
        case 'e': return eIterator;
        case 'f': return fIterator;
        case 'g': return gIterator;
        case 'h': return hIterator;
        case 'i': return iIterator;
        case 'j': return jIterator;
        case 'k': return kIterator;
        case 'l': return lIterator;
        case 'm': return mIterator;
        case 'n': return nIterator;
        case 'o': return oIterator;
        case 'p': return pIterator;
        case 'q': return qIterator;
        case 'r': return rIterator;
        case 's': return sIterator;
        case 't': return tIterator;
        case 'u': return uIterator;
        case 'v': return vIterator;
        case 'w': return wIterator;
        case 'x': return xIterator;
        case 'y': return yIterator;
        case 'z': return zIterator;
        }

        return null;
    }

    // WordsTask
    public static class WordsTask
            extends AsyncTask<Void, char[][], char[][]>
    {
        private WeakReference<Large> largeWeakReference;

        // WordsTask
        public WordsTask(Large large)
        {
            largeWeakReference = new WeakReference<>(large);
        }

        // doInBackground
        @Override
        protected char[][] doInBackground(Void... params)
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return null;

            char gridle[][] = getGridle();
            while (gridle == null)
                gridle = getGridle();
            publishProgress(gridle);

            return randomise(gridle);
        }

        // onProgressUpdate
        protected void onProgressUpdate(char[][]... gridles)
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return;

            large.setGridle(gridles[0]);
        }

        // onPostExecute
        @Override
        protected void onPostExecute(char puzzle[][])
        {
            final Large large = largeWeakReference.get();
            if (large == null)
                return;

            large.setPuzzle(puzzle);
        }
    }

    public static final String WORDS[] =
    {
        "abalone", "abandon", "abashed", "abashes", "abasing", "abating",
        "abbrevs", "abdomen", "abducts", "abetted", "abetter", "abiding",
        "ability", "abjured", "abjurer", "abjures", "ablated", "ablates",
        "abolish", "aborted", "abounds", "abraded", "abrades", "abreast",
        "abridge", "abscess", "abscond", "abseils", "absence", "absents",
        "absinth", "absolve", "absorbs", "abstain", "abusers", "abusing",
        "abusive", "abutted", "abysmal", "abyssal", "abysses", "acacias",
        "academe", "academy", "acceded", "accedes", "accents", "accepts",
        "acclaim", "accords", "accosts", "account", "accrual", "accrued",
        "accrues", "accused", "accuser", "accuses", "acerbic", "acetate",
        "acetone", "achenes", "achiest", "achieve", "acidify", "acidity",
        "acolyte", "aconite", "acquire", "acquits", "acreage", "acrider",
        "acridly", "acrobat", "acronym", "acrylic", "actions", "actives",
        "actress", "actuary", "actuate", "acutely", "acutest", "adagios",
        "adamant", "adapted", "adaptor", "addable", "addenda", "addends",
        "addicts", "addling", "address", "adduced", "adduces", "adenine",
        "adenoid", "adeptly", "adhered", "adheres", "adipose", "adjoins",
        "adjourn", "adjudge", "adjunct", "adjured", "adjures", "adjusts",
        "admiral", "admired", "admirer", "admires", "admixed", "admixes",
        "adopted", "adopter", "adorers", "adoring", "adorned", "adrenal",
        "adsorbs", "adulate", "advance", "advents", "adverbs", "adverse",
        "adverts", "advised", "adviser", "advises", "advisor", "aerated",
        "aerates", "aerator", "aerials", "aerobic", "aerosol", "affable",
        "affably", "affairs", "affects", "affirms", "affixed", "affixes",
        "afflict", "affords", "affrays", "affront", "afghans", "against",
        "ageings", "ageists", "ageless", "agendas", "agilely", "agility",
        "agitate", "agonies", "agonise", "agonist", "aground", "aileron",
        "ailment", "aimless", "airbags", "airbase", "airbeds", "aircrew",
        "airdrop", "airfare", "airflow", "airguns", "airhead", "airiest",
        "airings", "airless", "airlift", "airline", "airlock", "airmail",
        "airplay", "airport", "airship", "airshow", "airsick", "airtime",
        "airways", "aitches", "alarmed", "albinos", "albumen", "albumin",
        "alchemy", "alcohol", "alcoves", "alembic", "alerted", "alertly",
        "alewife", "alfalfa", "algebra", "aliased", "aliases", "alibied",
        "aliened", "alights", "aligned", "aligner", "aliment", "alimony",
        "aliyahs", "allayed", "alleged", "alleges", "allegro", "alleles",
        "allergy", "allover", "allowed", "alloyed", "alluded", "alludes",
        "allured", "allures", "allying", "almanac", "almonds", "almoner",
        "aloofly", "alpacas", "alpines", "already", "alright", "altered",
        "alumina", "alumnae", "alumnus", "amalgam", "amassed", "amasses",
        "amateur", "amatory", "amazing", "amazons", "ambient", "amblers",
        "ambling", "amended", "amenity", "amerced", "amerces", "amiable",
        "amiably", "ammeter", "ammonia", "amnesia", "amnesic", "amnesty",
        "amnions", "amoebae", "amoebas", "amoebic", "amongst", "amorous",
        "amounts", "amperes", "amphora", "amplest", "amplify", "ampules",
        "amputee", "amulets", "amusing", "amylase", "amyloid", "anaemia",
        "anaemic", "anagram", "analogy", "analyse", "analyst", "anapest",
        "anarchy", "anatomy", "anchors", "anchovy", "ancient", "andante",
        "andiron", "android", "anemone", "angelic", "angered", "anglers",
        "angling", "angoras", "angrier", "angrily", "anguish", "angular",
        "aniline", "animals", "animate", "animism", "animist", "anionic",
        "aniseed", "anklets", "anneals", "annelid", "annexed", "annexes",
        "annoyed", "annuals", "annuity", "annular", "anodise", "anodyne",
        "anoints", "anomaly", "anoraks", "another", "answers", "antacid",
        "anteing", "antenna", "anthems", "anthers", "anthill", "anthrax",
        "antigen", "antique", "antiwar", "antlers", "antonym", "antsier",
        "anxiety", "anxious", "anybody", "anymore", "anytime", "anyways",
        "anywise", "apatite", "apelike", "aphasia", "aphasic", "aphelia",
        "apishly", "aplenty", "apogees", "apology", "apostle", "apparel",
        "appeals", "appears", "appease", "appends", "applaud", "applets",
        "applied", "applier", "applies", "appoint", "apposed", "apposes",
        "apprise", "approve", "apricot", "apropos", "aptness", "aquatic",
        "aquavit", "aqueous", "aquifer", "arbiter", "arbours", "arbutus",
        "arcades", "archaic", "archers", "archery", "archest", "arching",
        "archive", "archway", "arctics", "ardours", "arduous", "arguers",
        "arguing", "argyles", "aridity", "arising", "armadas", "armband",
        "armfuls", "armhole", "armlets", "armload", "armours", "armoury",
        "armpits", "armrest", "arousal", "aroused", "arouses", "arraign",
        "arrange", "arrases", "arrayed", "arrears", "arrests", "arrival",
        "arrived", "arrives", "arroyos", "arsenal", "arsenic", "article",
        "artiest", "artisan", "artiste", "artists", "artless", "artsier",
        "artwork", "arugula", "ascends", "ascents", "ascetic", "ascribe",
        "aseptic", "asexual", "ashamed", "ashcans", "ashiest", "ashlars",
        "ashrams", "ashtray", "asinine", "askance", "asocial", "aspects",
        "asphalt", "aspired", "aspires", "aspirin", "assails", "assault",
        "assayed", "assayer", "assents", "asserts", "assigns", "assists",
        "assizes", "assorts", "assuage", "assumed", "assumes", "assured",
        "assures", "astound", "astride", "astuter", "asunder", "asylums",
        "atavism", "atavist", "ataxics", "atelier", "atheism", "atheist",
        "athirst", "athlete", "athwart", "atishoo", "atlases", "atomise",
        "atoning", "atrophy", "attache", "attacks", "attains", "attempt",
        "attends", "attests", "attired", "attires", "attract", "attuned",
        "attunes", "auction", "audible", "audibly", "audited", "auditor",
        "augment", "augured", "aunties", "aurally", "aureole", "auricle",
        "auroras", "auspice", "austere", "austral", "authors", "autopsy",
        "autumns", "availed", "avarice", "avatars", "avenged", "avenger",
        "avenges", "avenues", "average", "averred", "averted", "aviator",
        "avidity", "avionic", "avocado", "avoided", "avowals", "avowing",
        "awaited", "awakens", "awaking", "awarded", "awardee", "awesome",
        "awfully", "awkward", "awnings", "axially", "axolotl", "azaleas",
        "azimuth", "babbled", "babbler", "babbles", "babiest", "baboons",
        "babying", "babyish", "babysat", "babysit", "bacilli", "backbit",
        "backers", "backhoe", "backing", "backlog", "backups", "baddest",
        "baddies", "badgers", "badness", "baffled", "baffler", "baffles",
        "bagfuls", "baggage", "baggier", "baggies", "baggily", "bagging",
        "bagpipe", "baileys", "bailiff", "bailing", "bailout", "baiting",
        "baklava", "balance", "balboas", "balcony", "baldest", "baldies",
        "balding", "baldric", "baleful", "balkier", "ballads", "ballast",
        "ballets", "balling", "balloon", "ballots", "ballsed", "ballses",
        "balmier", "baloney", "balsams", "bamboos", "banally", "bananas",
        "bandage", "bandbox", "bandeau", "bandied", "bandier", "bandies",
        "banding", "bandits", "baneful", "banging", "bangles", "bankers",
        "banking", "banners", "banning", "bannock", "banquet", "banshee",
        "bantams", "banters", "banyans", "banzais", "baobabs", "baptise",
        "baptism", "baptist", "barbell", "barbels", "barbers", "barbies",
        "barbing", "barfing", "bargain", "barging", "barhops", "barista",
        "barkeep", "barkers", "barking", "barmaid", "barmier", "barneys",
        "baronet", "baroque", "barques", "barrack", "barrage", "barrels",
        "barrens", "barrier", "barring", "barrios", "barroom", "barrows",
        "barters", "baryons", "basally", "baseman", "basemen", "bashful",
        "bashing", "baskets", "basking", "basques", "bassets", "bassist",
        "bassoon", "bastard", "basters", "basting", "bastion", "batched",
        "batches", "bathers", "bathing", "bathmat", "bathtub", "batiste",
        "batsman", "batsmen", "battens", "batters", "battery", "battier",
        "batting", "battled", "battler", "battles", "baubles", "baulked",
        "bauxite", "bawdier", "bawdily", "bawling", "bayonet", "bazaars",
        "bazooka", "beached", "beaches", "beacons", "beadier", "beading",
        "beadles", "beagles", "beakers", "beaming", "beanbag", "beanies",
        "beaning", "bearded", "bearers", "bearing", "bearish", "beastly",
        "beaters", "beatify", "beating", "beatnik", "beavers", "becalms",
        "because", "beckons", "becloud", "becomes", "bedaubs", "bedbugs",
        "bedding", "bedecks", "bedevil", "bedhead", "bedizen", "bedlams",
        "bedpans", "bedpost", "bedrock", "bedroll", "bedroom", "bedside",
        "bedsits", "bedsore", "bedtime", "beeches", "beefier", "beefing",
        "beehive", "beeline", "beepers", "beeping", "beerier", "beeswax",
        "beetled", "beetles", "befalls", "befouls", "beggars", "beggary",
        "begging", "begonia", "begrime", "beguile", "beguine", "behaved",
        "behaves", "beheads", "behests", "behinds", "beholds", "behoved",
        "behoves", "bejewel", "belated", "belayed", "belched", "belches",
        "beliefs", "believe", "bellboy", "bellhop", "bellied", "bellies",
        "belling", "bellman", "bellmen", "bellows", "belongs", "beloved",
        "belting", "beltway", "belugas", "belying", "bemired", "bemires",
        "bemoans", "bemused", "bemuses", "benched", "benches", "benders",
        "bendier", "bending", "beneath", "benefit", "benumbs", "benzene",
        "benzine", "bequest", "berated", "berates", "bereave", "berried",
        "berries", "berserk", "berthed", "beseech", "beseems", "besides",
        "besiege", "besmear", "bespeak", "bespoke", "bestial", "besting",
        "bestirs", "bestows", "bestrew", "betaken", "betakes", "bethink",
        "betided", "betides", "betimes", "betoken", "betrays", "betroth",
        "betters", "betting", "bettors", "between", "betwixt", "bevvies",
        "bewails", "bewared", "bewares", "bewitch", "biasing", "bicarbs",
        "bickers", "bicycle", "bidders", "biddies", "bidding", "biffing",
        "bifocal", "biggest", "biggies", "biggish", "bighead", "bighorn",
        "bigness", "bigoted", "bigotry", "bigwigs", "bikinis", "bilious",
        "bilkers", "bilking", "billets", "billies", "billing", "billion",
        "billows", "billowy", "binders", "bindery", "binding", "binning",
        "biology", "biomass", "bionics", "biopics", "biotech", "bipedal",
        "biplane", "bipolar", "birched", "birches", "birders", "birdied",
        "birdies", "birding", "biretta", "birthed", "birther", "biscuit",
        "bisects", "bishops", "bismuth", "bistros", "bitched", "bitches",
        "bitcoin", "bitmaps", "bittern", "bitters", "bittier", "bitumen",
        "bivalve", "bivouac", "bizarre", "blabbed", "blabber", "blacked",
        "blacken", "blacker", "blackly", "bladder", "blagged", "blaming",
        "blander", "blandly", "blanked", "blanker", "blanket", "blankly",
        "blaring", "blarney", "blasted", "blaster", "blatant", "blather",
        "blazers", "blazing", "blazons", "bleaker", "bleakly", "bleated",
        "bleeder", "bleeped", "bleeper", "blemish", "blended", "blender",
        "blessed", "blesses", "blights", "blinded", "blinder", "blindly",
        "blinked", "blinker", "blintze", "blister", "blither", "blitzed",
        "blitzes", "blivets", "bloated", "bloater", "blobbed", "blocked",
        "blocker", "blogged", "blogger", "blokish", "blonder", "blondes",
        "blooded", "bloomed", "bloomer", "blooped", "blooper", "blossom",
        "blotchy", "blotted", "blotter", "bloused", "blouses", "blowers",
        "blowfly", "blowgun", "blowier", "blowing", "blowjob", "blowout",
        "blowups", "blubber", "blueish", "bluffed", "bluffer", "bluffly",
        "blunder", "blunted", "blunter", "bluntly", "blurred", "blurted",
        "blushed", "blusher", "blushes", "bluster", "boarded", "boarder",
        "boasted", "boaster", "boaters", "boating", "boatman", "boatmen",
        "bobbies", "bobbing", "bobbins", "bobbled", "bobbles", "bobcats",
        "bobsled", "bobtail", "bodegas", "bodging", "bodices", "bodkins",
        "boffins", "bogeyed", "boggier", "bogging", "boggled", "boggles",
        "bogyman", "bogymen", "boilers", "boiling", "boinked", "boldest",
        "boleros", "bolivar", "bollard", "bologna", "bolshie", "bolster",
        "bolting", "boluses", "bombard", "bombast", "bombers", "bombing",
        "bonanza", "bonbons", "bondage", "bonding", "bondman", "bondmen",
        "bonfire", "bonging", "boniest", "bonitos", "bonkers", "bonking",
        "bonnets", "bonnier", "bonobos", "bonuses", "boobies", "boobing",
        "boodles", "boogers", "boogied", "boogies", "boohoos", "bookend",
        "bookies", "booking", "bookish", "booklet", "boombox", "boomers",
        "booming", "boonies", "boorish", "boosted", "booster", "bootees",
        "booties", "booting", "bootleg", "boozers", "boozier", "boozing",
        "bopping", "borders", "boredom", "borough", "borrows", "borscht",
        "borstal", "borzois", "bossier", "bossily", "bossing", "bossism",
        "botanic", "botched", "botcher", "botches", "bothers", "botnets",
        "bottled", "bottler", "bottles", "bottoms", "boudoir", "boulder",
        "bounced", "bouncer", "bounces", "bounded", "bounden", "bounder",
        "bouquet", "bourbon", "bovines", "bowlegs", "bowlers", "bowlful",
        "bowline", "bowling", "bowwows", "boxcars", "boxiest", "boxlike",
        "boxroom", "boxwood", "boycott", "boyhood", "bracero", "bracers",
        "bracing", "bracken", "bracket", "bradawl", "bragged", "bragger",
        "braided", "braille", "brained", "braised", "braises", "braking",
        "bramble", "brambly", "branded", "brander", "brasher", "brashly",
        "brasses", "bravado", "bravely", "bravery", "bravest", "braving",
        "bravura", "brawled", "brawler", "braying", "brazens", "brazers",
        "brazier", "brazing", "breaded", "breadth", "breaker", "breakup",
        "breasts", "breathe", "breaths", "breathy", "breeder", "breezed",
        "breezes", "brevets", "brevity", "brewers", "brewery", "brewing",
        "brewpub", "bribers", "bribery", "bribing", "bricked", "brickie",
        "bridals", "bridged", "bridges", "bridled", "bridles", "briefed",
        "briefer", "briefly", "brigade", "brigand", "brights", "brimful",
        "brimmed", "brindle", "bringer", "brinier", "brioche", "brisked",
        "brisker", "brisket", "briskly", "bristle", "bristly", "brittle",
        "broaden", "broader", "broadly", "brocade", "brogans", "brogues",
        "broiled", "broiler", "brokers", "bromide", "bromine", "bronchi",
        "broncos", "bronzed", "bronzes", "brooded", "brooder", "brooked",
        "brothel", "brother", "brought", "browned", "browner", "brownie",
        "browsed", "browser", "browses", "bruised", "bruiser", "bruises",
        "bruited", "brunets", "brushed", "brushes", "brusque", "brutish",
        "bubbled", "bubbles", "buckets", "buckeye", "bucking", "buckled",
        "buckler", "buckles", "buckram", "bucksaw", "bucolic", "buddies",
        "budding", "budgets", "budgies", "budging", "buffalo", "buffers",
        "buffets", "buffing", "buffoon", "bugaboo", "bugbear", "buggers",
        "buggery", "buggier", "buggies", "bugging", "buglers", "bugling",
        "builder", "buildup", "builtin", "bulbous", "bulgier", "bulging",
        "bulimia", "bulimic", "bulkier", "bulking", "bulldog", "bullets",
        "bullied", "bullies", "bulling", "bullion", "bullish", "bullock",
        "bullpen", "bulrush", "bulwark", "bumbags", "bumbled", "bumbler",
        "bumbles", "bummers", "bummest", "bumming", "bumpers", "bumpier",
        "bumping", "bumpkin", "bunched", "bunches", "buncoed", "bundled",
        "bundles", "bungees", "bunging", "bungled", "bungler", "bungles",
        "bunions", "bunkers", "bunking", "bunnies", "bunting", "buoyant",
        "buoying", "burbled", "burbles", "burdens", "burdock", "bureaus",
        "burgeon", "burgers", "burgher", "burglar", "burgled", "burgles",
        "burials", "burlier", "burners", "burning", "burnish", "burnout",
        "burping", "burring", "burrito", "burrows", "bursars", "bursary",
        "burying", "busbies", "busboys", "busgirl", "bushels", "bushier",
        "bushing", "bushman", "bushmen", "busiest", "buskers", "busking",
        "buskins", "busload", "bussing", "busters", "bustier", "busting",
        "bustled", "bustles", "busying", "butcher", "butches", "butlers",
        "butters", "buttery", "butties", "butting", "buttock", "buttons",
        "buyback", "buyouts", "buzzard", "buzzers", "buzzing", "bygones",
        "bylines", "bypaths", "byroads", "bywords", "cabanas", "cabaret",
        "cabbage", "cabbies", "cabbing", "cabinet", "cabling", "caboose",
        "cachets", "caching", "cackled", "cackler", "cackles", "cadaver",
        "caddied", "caddies", "caddish", "cadence", "cadenza", "cadgers",
        "cadging", "cadmium", "caducei", "caesium", "caesura", "cagiest",
        "cagoule", "cahoots", "caimans", "caisson", "caitiff", "cajoled",
        "cajoler", "cajoles", "calcify", "calcine", "calcite", "calcium",
        "calculi", "caldera", "calibre", "caliper", "caliphs", "callers",
        "calling", "callous", "calmest", "calming", "caloric", "calorie",
        "calumet", "calumny", "calving", "calypso", "calyxes", "cambers",
        "cambial", "cambium", "cambric", "cameras", "campers", "camphor",
        "campier", "camping", "canapes", "canards", "canasta", "cancans",
        "cancels", "cancers", "candida", "candied", "candies", "candled",
        "candler", "candles", "candour", "canines", "cankers", "cannery",
        "cannier", "cannily", "canning", "cannons", "cantata", "canteen",
        "canters", "canting", "cantons", "cantors", "canvass", "canyons",
        "capable", "capably", "capered", "capital", "capitol", "caplets",
        "capping", "caprice", "capsize", "capstan", "capsule", "captain",
        "caption", "captive", "captors", "capture", "carafes", "caramel",
        "caravan", "caravel", "caraway", "carbide", "carbine", "carbons",
        "carboys", "carcass", "carders", "cardiac", "cardiae", "cardies",
        "carding", "careens", "careers", "careful", "carfare", "cargoes",
        "carhops", "caribou", "carious", "carjack", "carload", "carmine",
        "carnage", "carnies", "caromed", "carotid", "carouse", "carpals",
        "carpels", "carpers", "carpets", "carping", "carpool", "carport",
        "carrels", "carried", "carrier", "carries", "carrion", "carrots",
        "carroty", "carsick", "cartage", "cartels", "carters", "carting",
        "cartons", "cartoon", "carvers", "carvery", "carving", "casabas",
        "cascade", "cascara", "cashews", "cashier", "cashing", "casings",
        "casinos", "caskets", "cassava", "cassias", "cassock", "casters",
        "casting", "castled", "castles", "castoff", "castors", "casuals",
        "casuist", "catalpa", "catarrh", "catbird", "catboat", "catcall",
        "catcher", "catches", "catered", "caterer", "catfish", "cathode",
        "cations", "catkins", "catlike", "catnaps", "catsuit", "cattail",
        "cattery", "cattier", "cattily", "catting", "catwalk", "caulked",
        "caulker", "causers", "causing", "caustic", "caution", "cavalry",
        "caveats", "caveman", "cavemen", "caverns", "cavorts", "cayenne",
        "cayuses", "ceasing", "cedilla", "ceilidh", "ceiling", "celesta",
        "cellars", "cellist", "cements", "censers", "censors", "censure",
        "centaur", "centavo", "centime", "central", "centred", "centres",
        "century", "ceramic", "cereals", "cerebra", "certain", "certify",
        "cession", "cesspit", "chaffed", "chafing", "chagrin", "chained",
        "chaired", "chaises", "chalets", "chalice", "chalked", "challis",
        "chamber", "chamois", "champed", "chanced", "chancel", "chances",
        "chancre", "changed", "changer", "changes", "channel", "chanson",
        "chanted", "chanter", "chantey", "chaotic", "chapati", "chapeau",
        "chapels", "chaplet", "chapped", "chapter", "charade", "charged",
        "charger", "charges", "charier", "charily", "chariot", "charity",
        "charlie", "charmed", "charmer", "charred", "charted", "charter",
        "chasers", "chasing", "chassis", "chasten", "chaster", "chateau",
        "chatted", "chattel", "chatter", "cheapen", "cheaper", "cheaply",
        "cheated", "cheater", "checked", "checker", "checkup", "cheddar",
        "cheeked", "cheeped", "cheered", "cheerer", "cheerio", "cheesed",
        "cheeses", "cheetah", "chemise", "chemist", "chequer", "cheques",
        "cherish", "cheroot", "cherubs", "chervil", "chested", "cheviot",
        "chevron", "chewers", "chewier", "chewing", "chicane", "chicest",
        "chichis", "chicken", "chicory", "chiding", "chiefer", "chiefly",
        "chiffon", "chigger", "chignon", "chilled", "chiller", "chimera",
        "chimers", "chiming", "chimney", "chinked", "chinned", "chintzy",
        "chinwag", "chipped", "chipper", "chippie", "chirped", "chirrup",
        "chisels", "chivied", "chivies", "chloral", "chocked", "choicer",
        "choices", "chokers", "choking", "cholera", "chomped", "chomper",
        "chooser", "chooses", "chopped", "chopper", "chorale", "chorals",
        "chordal", "choroid", "chortle", "chowder", "chowing", "chromed",
        "chromes", "chronic", "chucked", "chuckle", "chuffed", "chugged",
        "chukkas", "chummed", "chunder", "chunked", "chunter", "churned",
        "churner", "chutney", "cicadas", "cinched", "cinches", "cinders",
        "cinemas", "ciphers", "circled", "circles", "circlet", "circuit",
        "cirques", "cistern", "citadel", "citizen", "citrons", "civilly",
        "civvies", "clacked", "claimed", "claimer", "clamber", "clammed",
        "clamour", "clamped", "clanged", "clanger", "clanked", "clapped",
        "clapper", "claques", "clarets", "clarify", "clarion", "clarity",
        "clashed", "clashes", "clasped", "classed", "classes", "classic",
        "clatter", "clausal", "clauses", "clavier", "clawing", "clayier",
        "cleaned", "cleaner", "cleanly", "cleanse", "cleanup", "cleared",
        "clearer", "clearly", "cleaved", "cleaver", "cleaves", "clement",
        "clerics", "clerked", "clewing", "cliched", "cliches", "clicked",
        "clicker", "clients", "climate", "climbed", "climber", "clinger",
        "clinics", "clinked", "clinker", "clipped", "clipper", "cliques",
        "cliquey", "cloacae", "cloaked", "clobber", "cloches", "clocked",
        "clogged", "clomped", "cloning", "clonked", "clopped", "closely",
        "closest", "closets", "closeup", "closing", "closure", "clothed",
        "clothes", "clotted", "cloture", "clouded", "clouted", "clovers",
        "clowned", "cloying", "clubbed", "clubber", "clucked", "clumped",
        "clunked", "clunker", "cluster", "clutter", "coached", "coaches",
        "coaling", "coarsen", "coarser", "coastal", "coasted", "coaster",
        "coating", "coaxers", "coaxial", "coaxing", "cobbers", "cobbled",
        "cobbler", "cobbles", "cobnuts", "cobwebs", "cocaine", "cochlea",
        "cockade", "cockier", "cockily", "cocking", "cockles", "cockney",
        "cockpit", "coconut", "cocoons", "codding", "coddled", "coddles",
        "codeine", "codfish", "codgers", "codices", "codicil", "coequal",
        "coerced", "coercer", "coerces", "coevals", "coexist", "coffees",
        "coffers", "coffins", "cogency", "cognacs", "cognate", "cohabit",
        "coheirs", "cohered", "coheres", "cohorts", "coiffed", "coiling",
        "coinage", "coiners", "coining", "coldest", "colicky", "colitis",
        "collage", "collard", "collars", "collate", "collect", "colleen",
        "college", "collide", "collier", "collies", "colloid", "collude",
        "cologne", "colonel", "colones", "colossi", "colours", "coltish",
        "columns", "comaker", "combats", "combers", "combine", "combing",
        "combust", "comedic", "comfier", "comfits", "comfort", "comical",
        "comings", "command", "commend", "comment", "commies", "commits",
        "commode", "commons", "commune", "commute", "compact", "company",
        "compare", "compass", "compeer", "compels", "compere", "compete",
        "compile", "comping", "complex", "comport", "compose", "compost",
        "compote", "compute", "comrade", "concave", "conceal", "concede",
        "conceit", "concept", "concern", "concert", "conchie", "concise",
        "concoct", "concord", "concurs", "concuss", "condemn", "condign",
        "condole", "condoms", "condone", "condors", "conduce", "conduct",
        "conduit", "confabs", "confers", "confess", "confide", "confine",
        "confirm", "conform", "confuse", "confute", "congaed", "congeal",
        "congers", "congest", "conical", "conifer", "conjoin", "conjure",
        "conkers", "conking", "connect", "conning", "connive", "connote",
        "conquer", "consent", "consign", "consing", "consist", "console",
        "consort", "consuls", "consult", "consume", "contact", "contain",
        "contemn", "contend", "content", "contest", "context", "contort",
        "contour", "control", "contuse", "convene", "convent", "convert",
        "conveys", "convict", "convoke", "convoys", "cookers", "cookery",
        "cookies", "cooking", "cookout", "coolant", "coolers", "coolest",
        "coolies", "cooling", "coopers", "cooping", "cooties", "copiers",
        "copilot", "copings", "copious", "coppers", "coppery", "copping",
        "copters", "copulas", "copycat", "copying", "copyist", "coracle",
        "corbels", "cordage", "cordial", "cording", "cordite", "cordons",
        "corkage", "corkers", "corking", "corncob", "corneal", "corneas",
        "corners", "cornets", "cornice", "cornier", "cornily", "corning",
        "cornrow", "corolla", "coronal", "coronas", "coroner", "coronet",
        "corpora", "corpses", "corrals", "correct", "corries", "corrode",
        "corrupt", "corsage", "corsair", "corsets", "cortege", "coshing",
        "cosiest", "cosigns", "cosines", "cosplay", "cossets", "costars",
        "costing", "costume", "coterie", "cottage", "cottars", "cotters",
        "cottons", "cottony", "couched", "couches", "cougars", "coughed",
        "coulees", "coulomb", "council", "counsel", "counted", "counter",
        "country", "coupled", "couples", "couplet", "coupons", "courage",
        "courier", "coursed", "courser", "courses", "courted", "courtly",
        "cousins", "couture", "covered", "coverts", "coveted", "cowards",
        "cowbell", "cowbird", "cowboys", "cowered", "cowgirl", "cowhand",
        "cowherd", "cowhide", "cowlick", "cowling", "cowpats", "cowpoke",
        "cowries", "cowshed", "cowslip", "coxcomb", "coyness", "coyotes",
        "cozened", "crabbed", "crabber", "cracked", "cracker", "crackle",
        "crackly", "crackup", "cradled", "cradles", "crafted", "crammed",
        "crammer", "cramped", "crampon", "cranial", "craning", "cranium",
        "cranked", "crapped", "crapper", "crappie", "crashed", "crashes",
        "crasser", "crassly", "craters", "crating", "cravats", "cravens",
        "craving", "crawdad", "crawled", "crawler", "crayons", "crazier",
        "crazies", "crazily", "crazing", "creaked", "creamed", "creamer",
        "creased", "creases", "created", "creates", "creator", "creches",
        "credits", "creeper", "cremate", "creoles", "crested", "cretins",
        "crevice", "crewing", "crewman", "crewmen", "cribbed", "cribber",
        "cricked", "cricket", "crimped", "crimson", "cringed", "cringes",
        "crinkle", "crinkly", "cripple", "crisped", "crisper", "crisply",
        "critics", "critter", "croaked", "crochet", "crocked", "crofter",
        "cronies", "crooked", "crooned", "crooner", "cropped", "cropper",
        "croquet", "crossed", "crosser", "crosses", "crossly", "crouton",
        "crowbar", "crowded", "crowing", "crowned", "crozier", "crucial",
        "crucify", "crudely", "crudest", "crudity", "cruelly", "cruelty",
        "crufted", "cruised", "cruiser", "cruises", "cruller", "crumbed",
        "crumble", "crumbly", "crumpet", "crumple", "crunchy", "crupper",
        "crusade", "crushed", "crusher", "crushes", "crustal", "crusted",
        "crybaby", "cryings", "cryptic", "crystal", "cubical", "cubicle",
        "cubists", "cuboids", "cuckold", "cuckoos", "cuddled", "cuddles",
        "cudgels", "cuffing", "cuisine", "culling", "culotte", "culprit",
        "cultism", "cultist", "culture", "culvert", "cumbers", "cumming",
        "cumulus", "cunning", "cupcake", "cupfuls", "cupolas", "cupping",
        "curable", "curacao", "curated", "curates", "curator", "curbing",
        "curdled", "curdles", "curfews", "curious", "curlers", "curlews",
        "curlier", "curling", "currant", "current", "curried", "curries",
        "cursing", "cursive", "cursors", "cursory", "curtail", "curtain",
        "curtest", "curvier", "curving", "cushier", "cushion", "cuspids",
        "cussing", "custard", "custody", "customs", "cutaway", "cutback",
        "cuticle", "cutlass", "cutlers", "cutlery", "cutlets", "cutoffs",
        "cutouts", "cutters", "cutting", "cutworm", "cyanide", "cyborgs",
        "cycling", "cyclist", "cyclone", "cyclops", "cygnets", "cymbals",
        "cynical", "cypress", "czarina", "czarism", "czarist", "dabbers",
        "dabbing", "dabbled", "dabbler", "dabbles", "dactyls", "dadaism",
        "dadaist", "daddies", "daemons", "daffier", "daftest", "daggers",
        "dahlias", "dailies", "dairies", "daisies", "dallied", "dallier",
        "dallies", "damaged", "damages", "damasks", "damming", "damning",
        "dampens", "dampers", "dampest", "damping", "damsels", "damsons",
        "dancers", "dancing", "dandier", "dandies", "dandify", "dandled",
        "dandles", "dangers", "danging", "dangled", "dangler", "dangles",
        "dankest", "dappled", "dapples", "daresay", "darkens", "darkest",
        "darkies", "darling", "darners", "darning", "darters", "darting",
        "dashers", "dashiki", "dashing", "dastard", "datives", "daubers",
        "daubing", "daunted", "dauphin", "dawdled", "dawdler", "dawdles",
        "dawning", "daybeds", "daycare", "daylong", "daytime", "dazedly",
        "dazzled", "dazzler", "dazzles", "deacons", "deadens", "deadest",
        "deadpan", "deafens", "deafest", "dealers", "dealing", "deanery",
        "dearest", "dearies", "dearths", "deathly", "debacle", "debarks",
        "debased", "debases", "debated", "debater", "debates", "debauch",
        "debited", "debouch", "debrief", "debtors", "debunks", "debuted",
        "decades", "decaffs", "decagon", "decamps", "decants", "decayed",
        "decease", "deceits", "deceive", "decency", "decibel", "decided",
        "decider", "decides", "decimal", "decking", "deckles", "declaim",
        "declare", "declaws", "decline", "decoded", "decoder", "decodes",
        "decorum", "decoyed", "decreed", "decrees", "decried", "decries",
        "deduced", "deduces", "deducts", "deeding", "deejays", "deeming",
        "deepens", "deepest", "defaced", "defacer", "defaces", "defamed",
        "defamer", "defames", "default", "defeats", "defects", "defence",
        "defends", "deffest", "defiant", "deficit", "defiled", "defiler",
        "defiles", "defined", "definer", "defines", "deflate", "deflect",
        "deforms", "defraud", "defrays", "defrock", "defrost", "deftest",
        "defunct", "defused", "defuses", "defying", "degases", "degrade",
        "degrees", "deicers", "deicing", "deified", "deifies", "deigned",
        "deistic", "deities", "dejects", "delayed", "delayer", "deleted",
        "deletes", "delight", "delimit", "deliver", "delouse", "deluded",
        "deludes", "deluged", "deluges", "delvers", "delving", "demands",
        "demeans", "demerit", "demesne", "demigod", "demised", "demises",
        "demists", "demoing", "demonic", "demoted", "demotes", "demotic",
        "demount", "demurer", "denials", "deniers", "denizen", "denoted",
        "denotes", "densely", "densest", "density", "dentine", "denting",
        "dentist", "denture", "denuded", "denudes", "denying", "departs",
        "depends", "depicts", "deplane", "deplete", "deplore", "deploys",
        "deports", "deposed", "deposes", "deposit", "deprave", "depress",
        "deprive", "deputed", "deputes", "derails", "derange", "derbies",
        "derided", "derides", "derived", "derives", "derrick", "dervish",
        "desalts", "descale", "descant", "descend", "descent", "deserts",
        "deserve", "designs", "desired", "desires", "desists", "deskill",
        "desktop", "despair", "despise", "despite", "despoil", "despots",
        "dessert", "destine", "destiny", "destroy", "details", "detains",
        "detects", "detente", "detests", "detours", "detoxed", "detoxes",
        "detract", "devalue", "develop", "deviant", "deviate", "devices",
        "devilry", "devious", "devised", "devises", "devolve", "devoted",
        "devotee", "devotes", "devours", "dewclaw", "dewdrop", "dewiest",
        "dewlaps", "diadems", "diagram", "dialect", "dialled", "diamond",
        "diapers", "diaries", "diarist", "diatoms", "dibbled", "dibbles",
        "diciest", "dickens", "dickers", "dickeys", "dictate", "diction",
        "diddled", "diddler", "diddles", "diddums", "diesels", "dietary",
        "dieters", "dieting", "differs", "diffing", "diffuse", "digests",
        "diggers", "digging", "digicam", "digital", "dignify", "dignity",
        "digraph", "digress", "diktats", "dilated", "dilates", "dilator",
        "dilemma", "dillies", "diluent", "diluted", "dilutes", "dimmers",
        "dimmest", "dimming", "dimness", "dimpled", "dimples", "dimwits",
        "dinette", "dingbat", "dingier", "dingily", "dinging", "dingles",
        "dingoes", "dinkier", "dinkies", "dinners", "dinning", "diocese",
        "diorama", "dioxide", "dioxins", "diploid", "diploma", "dipoles",
        "dippers", "dippier", "dipping", "diptych", "directs", "direful",
        "dirndls", "dirtied", "dirtier", "dirties", "dirtily", "disable",
        "disarms", "disavow", "disband", "disbars", "discard", "discern",
        "discoed", "discord", "discuss", "disdain", "disease", "disgust",
        "dishing", "dishpan", "dishrag", "dislike", "dismays", "dismiss",
        "disobey", "disowns", "dispels", "display", "disport", "dispose",
        "dispute", "disrobe", "disrupt", "dissect", "dissent", "dissing",
        "distaff", "distant", "distend", "distils", "distort", "disturb",
        "disused", "disuses", "ditched", "ditches", "dithers", "ditties",
        "dittoed", "diurnal", "diverge", "diverse", "diverts", "divests",
        "divided", "divider", "divides", "divined", "diviner", "divines",
        "divisor", "divorce", "divulge", "divvied", "divvies", "dizzied",
        "dizzier", "dizzies", "dizzily", "dobbing", "dobbins", "docents",
        "dockers", "dockets", "docking", "doctors", "dodders", "doddery",
        "dodgems", "dodgers", "dodgier", "dodging", "doeskin", "doffing",
        "dogcart", "dogfish", "doggier", "doggies", "dogging", "doggone",
        "doglegs", "doglike", "dogsled", "dogtrot", "dogwood", "doilies",
        "doleful", "dollars", "dollies", "dolling", "dollops", "dolmens",
        "dolphin", "doltish", "domains", "donated", "donates", "donging",
        "dongles", "donkeys", "donning", "donnish", "doodads", "doodahs",
        "doodled", "doodler", "doodles", "dooming", "doorman", "doormat",
        "doormen", "doorway", "dopiest", "dorkier", "dormant", "dormers",
        "dormice", "dosages", "dossers", "dossier", "dossing", "dotards",
        "dotcoms", "dottier", "dotting", "doubled", "doubles", "doublet",
        "doubted", "doubter", "douched", "douches", "doughty", "dourest",
        "dousing", "dovecot", "dowager", "dowdier", "dowdies", "dowdily",
        "dowered", "downers", "downier", "downing", "dowries", "dowsers",
        "dowsing", "doyenne", "dozenth", "doziest", "drabber", "drachma",
        "drafted", "draftee", "drafter", "dragged", "dragnet", "dragons",
        "dragoon", "drained", "drainer", "drapers", "drapery", "draping",
        "drastic", "dratted", "draught", "drawers", "drawing", "drawled",
        "dreaded", "dreamed", "dreamer", "dredged", "dredger", "dredges",
        "dressed", "dresser", "dresses", "dribble", "driblet", "drifted",
        "drifter", "drilled", "driller", "drinker", "dripped", "drivels",
        "drivers", "driving", "drizzle", "drizzly", "drogues", "droller",
        "droning", "drooled", "drooped", "droplet", "dropout", "dropped",
        "dropper", "drought", "drovers", "drowned", "drowsed", "drowses",
        "drubbed", "drubber", "drudged", "drudges", "drugged", "druggie",
        "drumlin", "drummed", "drummer", "drunken", "drunker", "dryness",
        "drywall", "dualism", "duality", "dubbers", "dubbing", "dubiety",
        "dubious", "duchess", "duchies", "duckier", "duckies", "ducking",
        "ductile", "ducting", "dudgeon", "duelled", "dueller", "duennas",
        "duffers", "duffing", "dugouts", "dukedom", "dullard", "dullest",
        "dulling", "dumbest", "dumdums", "dummies", "dumpers", "dumpier",
        "dumping", "dungeon", "dunging", "dunking", "dunnest", "dunning",
        "duodena", "duopoly", "durable", "durably", "durance", "duskier",
        "dustbin", "dusters", "dustier", "dusting", "dustman", "dustmen",
        "dustpan", "duteous", "dutiful", "dwarfed", "dweller", "dwindle",
        "dybbuks", "dynamic", "dynamos", "dynasty", "eagerer", "eagerly",
        "eaglets", "earache", "earbuds", "eardrum", "earfuls", "earldom",
        "earlier", "earlobe", "earmark", "earmuff", "earners", "earnest",
        "earning", "earplug", "earring", "earshot", "earthed", "earthen",
        "earthly", "earwigs", "easiest", "eastern", "eatable", "ebonies",
        "echelon", "echidna", "echoing", "eclairs", "eclipse", "eclogue",
        "ecocide", "ecology", "economy", "ecstasy", "edamame", "eddying",
        "edgiest", "edgings", "edibles", "edifice", "edified", "edifier",
        "edifies", "editing", "edition", "editors", "educate", "educing",
        "eeriest", "effaced", "effaces", "effects", "effendi", "efforts",
        "effused", "effuses", "eggcups", "egghead", "egoists", "egotism",
        "egotist", "eighths", "ejected", "ejector", "elapsed", "elapses",
        "elastic", "elating", "elation", "elbowed", "elderly", "elected",
        "elector", "elegant", "elegiac", "elegies", "element", "elevate",
        "elevens", "elicits", "eliding", "elision", "elitism", "elitist",
        "elixirs", "ellipse", "elodeas", "eloping", "eluding", "elusive",
        "emailed", "emanate", "embalms", "embanks", "embargo", "embarks",
        "embassy", "emblems", "embower", "embrace", "embroil", "embryos",
        "emended", "emerald", "emerged", "emerges", "emerita", "emetics",
        "emigres", "eminent", "emirate", "emitted", "emitter", "emoting",
        "emotion", "emotive", "empathy", "emperor", "empires", "empiric",
        "employs", "empower", "empress", "emptied", "emptier", "empties",
        "emptily", "emulate", "enabled", "enabler", "enables", "enacted",
        "enamels", "enamour", "encamps", "encased", "encases", "enchain",
        "enchant", "enclave", "enclose", "encoded", "encoder", "encodes",
        "encored", "encores", "encrust", "encrypt", "encysts", "endears",
        "endemic", "endgame", "endings", "endives", "endless", "endmost",
        "endorse", "endowed", "enduing", "endured", "endures", "endways",
        "enemies", "enfolds", "enforce", "engaged", "engages", "engines",
        "engorge", "engrams", "engrave", "engross", "engulfs", "enhance",
        "enigmas", "enjoins", "enjoyed", "enlarge", "enlists", "enliven",
        "ennoble", "enplane", "enquire", "enquiry", "enraged", "enrages",
        "ensigns", "enslave", "ensnare", "ensuing", "ensured", "ensurer",
        "ensures", "entails", "entente", "enteral", "entered", "enteric",
        "enthral", "enthuse", "enticed", "entices", "entitle", "entombs",
        "entrant", "entraps", "entreat", "entrees", "entries", "entropy",
        "entrust", "entwine", "envelop", "envenom", "envious", "envying",
        "enzymes", "epicure", "epigram", "episode", "epistle", "epitaph",
        "epithet", "epitome", "epochal", "epoxied", "epoxies", "epsilon",
        "equable", "equably", "equally", "equated", "equates", "equator",
        "equerry", "equines", "equinox", "erasers", "erasing", "erasure",
        "erected", "erectly", "erector", "erelong", "eremite", "ermines",
        "eroding", "erosion", "erosive", "erotica", "erotics", "errands",
        "erratas", "erratic", "erratum", "eructed", "erudite", "erupted",
        "escaped", "escapee", "escapes", "eschews", "escorts", "escrows",
        "escudos", "espouse", "espying", "esquire", "essayed", "essayer",
        "essence", "estates", "esteems", "estuary", "etchers", "etching",
        "eternal", "ethanol", "ethical", "ethnics", "euchred", "euchres",
        "eugenic", "eunuchs", "euphony", "evacuee", "evaders", "evading",
        "evasion", "evasive", "evenest", "evening", "evicted", "evident",
        "evilest", "eviller", "evinced", "evinces", "evoking", "evolved",
        "evolves", "exabyte", "exacted", "exacter", "exactly", "exalted",
        "examine", "example", "exceeds", "excepts", "excerpt", "excised",
        "excises", "excited", "exciter", "excites", "exclaim", "exclude",
        "excreta", "excrete", "excused", "excuses", "execute", "exempts",
        "exerted", "exhaled", "exhales", "exhaust", "exhibit", "exhorts",
        "exhumed", "exhumes", "exigent", "exiling", "existed", "exiting",
        "exotica", "exotics", "expands", "expanse", "expects", "expends",
        "expense", "experts", "expiate", "expired", "expires", "explain",
        "explode", "exploit", "explore", "exports", "exposed", "exposes",
        "expound", "express", "expunge", "extends", "extents", "extinct",
        "extorts", "extract", "extreme", "extrude", "exuding", "exulted",
        "exurban", "exurbia", "eyeball", "eyebrow", "eyefuls", "eyelash",
        "eyeless", "eyelets", "eyelids", "eyesore", "eyewash", "fabrics",
        "facades", "faceted", "facials", "facings", "faction", "factoid",
        "factors", "factory", "factual", "faculty", "faddish", "faddist",
        "faeries", "faffing", "fagging", "faggots", "faience", "failing",
        "failure", "fainest", "fainted", "fainter", "faintly", "fairest",
        "fairies", "fairing", "fairway", "fajitas", "falcons", "fallacy",
        "falling", "falloff", "fallout", "fallows", "falsely", "falsest",
        "falsies", "falsify", "falsity", "falters", "famines", "fanatic",
        "fanboys", "fancied", "fancier", "fancies", "fancily", "fanfare",
        "fannies", "fanning", "fantail", "fantasy", "fanzine", "faraway",
        "farmers", "farming", "farrago", "farrier", "farrows", "farther",
        "farting", "fascias", "fascism", "fascist", "fashion", "fastens",
        "fastest", "fasting", "fatally", "fatback", "fateful", "fathead",
        "fathers", "fathoms", "fatigue", "fatness", "fattens", "fattest",
        "fattier", "fatties", "fatuity", "fatuous", "faucets", "faulted",
        "fauvism", "fauvist", "favours", "fawners", "fawning", "fearful",
        "fearing", "feasted", "feaster", "feather", "feature", "febrile",
        "federal", "fedoras", "feebler", "feedbag", "feeders", "feeding",
        "feedlot", "feelers", "feeling", "feigned", "feinted", "felines",
        "fellers", "fellest", "felling", "fellows", "felting", "females",
        "femoral", "fencers", "fencing", "fenders", "fending", "ferment",
        "fermium", "fernier", "ferrets", "ferried", "ferries", "ferrous",
        "ferrule", "fertile", "ferules", "fervent", "fervour", "fessing",
        "festers", "festive", "festoon", "fetched", "fetcher", "fetches",
        "fetlock", "fetters", "fetuses", "feuding", "fevered", "fewness",
        "fiancee", "fiances", "fibbers", "fibbing", "fibrils", "fibroid",
        "fibrous", "fibulae", "fibular", "fickler", "fiction", "fictive",
        "fiddled", "fiddler", "fiddles", "fidgets", "fidgety", "fiefdom",
        "fielded", "fielder", "fiercer", "fierier", "fiestas", "fifteen",
        "fifthly", "fifties", "fighter", "figment", "figured", "figures",
        "filbert", "filched", "filches", "filings", "fillers", "fillets",
        "fillies", "filling", "fillips", "filmier", "filming", "filters",
        "finagle", "finales", "finally", "finance", "finches", "finders",
        "finding", "finesse", "fingers", "finials", "finical", "finicky",
        "finises", "finking", "firearm", "firebox", "firebug", "firefly",
        "fireman", "firemen", "firings", "firmest", "firming", "firstly",
        "fiscals", "fishers", "fishery", "fishier", "fishily", "fishing",
        "fishnet", "fissile", "fission", "fissure", "fistful", "fistula",
        "fitment", "fitness", "fitters", "fittest", "fitting", "fixable",
        "fixated", "fixates", "fixedly", "fixings", "fixture", "fizzier",
        "fizzing", "fizzled", "fizzles", "flaccid", "flagged", "flagman",
        "flagmen", "flagons", "flailed", "flakier", "flaking", "flamage",
        "flambes", "flamers", "flaming", "flanges", "flanked", "flanker",
        "flannel", "flapped", "flapper", "flareup", "flaring", "flashed",
        "flasher", "flashes", "flatbed", "flatcar", "flatlet", "flatted",
        "flatten", "flatter", "flattop", "flaunts", "flavors", "flavour",
        "flawing", "flaying", "fleabag", "fleapit", "flecked", "fledged",
        "fleeced", "fleecer", "fleeces", "fleeing", "fleeted", "fleeter",
        "fleetly", "fleshed", "fleshes", "fleshly", "flexing", "flexion",
        "flicked", "flicker", "flights", "flighty", "flipped", "flipper",
        "flirted", "flitted", "floated", "floater", "flocked", "flogged",
        "flogger", "flooded", "flooder", "floored", "flopped", "florets",
        "florins", "florist", "flossed", "flosses", "flotsam", "flounce",
        "flouncy", "floured", "flouted", "flouter", "flowers", "flowery",
        "flowing", "flubbed", "fluency", "fluffed", "fluidly", "flukier",
        "flummox", "flunked", "flushed", "flusher", "flushes", "fluster",
        "fluting", "flutter", "fluvial", "fluxing", "flyable", "flyaway",
        "flyleaf", "flyover", "flypast", "flytrap", "flyways", "foaling",
        "foamier", "foaming", "fobbing", "focally", "focused", "focuses",
        "fodders", "foggier", "foggily", "fogging", "foghorn", "fogyish",
        "foibles", "foiling", "foisted", "folders", "folding", "foldout",
        "foliage", "folkway", "follies", "follows", "foments", "fondant",
        "fondest", "fondled", "fondles", "fondues", "foodies", "foolery",
        "fooling", "foolish", "footage", "footers", "footing", "footman",
        "footmen", "footsie", "foppery", "foppish", "foraged", "forager",
        "forages", "forayed", "forbade", "forbear", "forbids", "forbore",
        "forceps", "forcing", "fording", "forearm", "foreign", "foreleg",
        "foreman", "foremen", "foresaw", "foresee", "forests", "forever",
        "forfeit", "forgave", "forgers", "forgery", "forgets", "forging",
        "forgive", "forgoer", "forgoes", "forgone", "forkful", "forking",
        "forlorn", "formals", "formats", "forming", "formula", "forsake",
        "forsook", "forties", "fortify", "fortune", "forward", "forwent",
        "fossils", "fosters", "foulard", "foulest", "fouling", "founded",
        "founder", "foundry", "fourths", "fowling", "foxfire", "foxhole",
        "foxhunt", "foxiest", "foxtrot", "fracked", "fractal", "fragile",
        "frailer", "frailly", "frailty", "framers", "framing", "franked",
        "franker", "frankly", "frantic", "frappes", "fraught", "fraying",
        "frazzle", "freaked", "freckle", "freckly", "freebie", "freedom",
        "freeing", "freeman", "freemen", "freesia", "freeway", "freezer",
        "freezes", "freight", "freshen", "fresher", "freshet", "freshly",
        "fretful", "fretsaw", "fretted", "friable", "fridges", "friends",
        "friezes", "frigate", "frigged", "frights", "frilled", "fringed",
        "fringes", "frisked", "frisson", "fritter", "frizzed", "frizzes",
        "frizzle", "frizzly", "frogman", "frogmen", "frolics", "frontal",
        "fronted", "frosted", "frothed", "froward", "frowned", "fruited",
        "frustum", "fuchsia", "fuckers", "fucking", "fuddled", "fuddles",
        "fudging", "fuehrer", "fuelled", "fuhrers", "fulcrum", "fulfils",
        "fullers", "fullest", "fulling", "fulsome", "fumbled", "fumbler",
        "fumbles", "fumiest", "funding", "funeral", "funfair", "fungoid",
        "fungous", "funkier", "funking", "funnels", "funnest", "funnier",
        "funnies", "funnily", "furbish", "furious", "furling", "furlong",
        "furnace", "furnish", "furores", "furrier", "furring", "furrows",
        "further", "furtive", "fusible", "fusions", "fussier", "fussily",
        "fussing", "fusspot", "fustian", "fustier", "futures", "futzing",
        "fuzzier", "fuzzily", "fuzzing", "gabbier", "gabbing", "gabbled",
        "gabbles", "gabfest", "gadders", "gadding", "gadgets", "gaffers",
        "gaffing", "gagging", "gaggles", "gainers", "gainful", "gaining",
        "gainsay", "gaiters", "gallant", "galleon", "gallery", "galleys",
        "galling", "gallium", "gallons", "gallops", "gallows", "galoots",
        "galumph", "gambits", "gambled", "gambler", "gambles", "gambols",
        "gametes", "gametic", "gamiest", "gamines", "ganders", "ganging",
        "ganglia", "gangsta", "gangway", "gannets", "gantlet", "garaged",
        "garages", "garbage", "garbing", "garbled", "garbles", "garcons",
        "gardens", "garfish", "gargled", "gargles", "garland", "garment",
        "garners", "garnets", "garnish", "garrets", "garrote", "garters",
        "gasbags", "gaseous", "gashing", "gaskets", "gasohol", "gasping",
        "gassier", "gassing", "gastric", "gateaux", "gateway", "gathers",
        "gaucher", "gauchos", "gaudier", "gaudily", "gauging", "gaunter",
        "gauzier", "gavotte", "gawkier", "gawkily", "gawking", "gawping",
        "gayness", "gazebos", "gazelle", "gazette", "gazumps", "gearbox",
        "gearing", "geekier", "geezers", "gelatin", "gelding", "gelling",
        "genders", "general", "generic", "geneses", "genesis", "genetic",
        "genital", "genning", "genomes", "genteel", "gentian", "gentile",
        "gentled", "gentler", "gentles", "genuine", "geodesy", "geology",
        "gerbils", "germane", "gerunds", "gestalt", "gestapo", "gestate",
        "gesture", "getaway", "getting", "gewgaws", "geysers", "ghastly",
        "gherkin", "ghettos", "ghosted", "ghostly", "gibbers", "gibbets",
        "gibbons", "gibbous", "giblets", "giddier", "giddily", "gifting",
        "gigabit", "gigging", "giggled", "giggler", "giggles", "gigolos",
        "gilders", "gilding", "gillies", "gillion", "gimbals", "gimlets",
        "gimmick", "gimping", "gingers", "gingery", "gingham", "ginning",
        "ginseng", "giraffe", "girders", "girding", "girdled", "girdles",
        "girlish", "girting", "givings", "gizzard", "glaceed", "glacial",
        "glacier", "gladden", "gladder", "glamour", "glanced", "glances",
        "glandes", "glaring", "glassed", "glasses", "glazier", "glazing",
        "gleamed", "gleaned", "gleaner", "gleeful", "glenoid", "glibber",
        "gliders", "gliding", "glimmer", "glimpse", "glinted", "glisten",
        "glister", "glitter", "gloated", "globing", "globule", "gloried",
        "glories", "glorify", "glossed", "glosses", "glottal", "glottis",
        "gloving", "glowers", "glowing", "glucose", "gluiest", "glummer",
        "glutted", "glutton", "gnarled", "gnashed", "gnashes", "gnawing",
        "gnocchi", "gnomish", "goading", "goalies", "goatees", "gobbets",
        "gobbing", "gobbled", "gobbler", "gobbles", "goblets", "goblins",
        "goddamn", "goddess", "godhead", "godhood", "godless", "godlier",
        "godlike", "godsend", "godsons", "goggled", "goggles", "goitres",
        "golfers", "golfing", "gollies", "gonadal", "gondola", "gonging",
        "goobers", "goodbye", "goodies", "goodish", "goofier", "goofing",
        "googled", "googles", "gooiest", "goosing", "gophers", "gorging",
        "gorgons", "goriest", "gorilla", "goshawk", "gosling", "gospels",
        "gossips", "gossipy", "gotchas", "gouache", "gougers", "gouging",
        "goulash", "gourdes", "gourmet", "goutier", "governs", "gowning",
        "grabbed", "grabber", "gracing", "grackle", "gradate", "graders",
        "grading", "gradual", "grafted", "grafter", "grahams", "grained",
        "grammar", "grampus", "granary", "grandam", "grandee", "grander",
        "grandly", "grandma", "grandpa", "granges", "granite", "granola",
        "granted", "grantee", "granter", "granule", "graphed", "graphic",
        "grapnel", "grapple", "grasped", "grassed", "grasses", "graters",
        "gratify", "grating", "gratins", "gravels", "gravely", "gravest",
        "gravies", "graving", "gravity", "grazers", "grazing", "greased",
        "greaser", "greases", "greater", "greatly", "greened", "greener",
        "greenly", "greeted", "greeter", "gremlin", "grenade", "grepped",
        "greyest", "greying", "greyish", "gribble", "griddle", "grieved",
        "griever", "grieves", "griffin", "griffon", "grilled", "grilles",
        "grimace", "grimier", "griming", "grimmer", "grinder", "gringos",
        "grinned", "gripers", "griping", "gripped", "gripper", "gristle",
        "gristly", "gritted", "gritter", "grizzle", "grizzly", "groaned",
        "grocers", "grocery", "grokked", "grommet", "groomed", "groomer",
        "grooved", "grooves", "gropers", "groping", "grossed", "grosser",
        "grosses", "grossly", "grouchy", "grounds", "grouped", "grouper",
        "groupie", "groused", "grouser", "grouses", "grouted", "grovels",
        "growers", "growing", "growled", "growler", "grownup", "growths",
        "groynes", "grubbed", "grubber", "grudged", "grudges", "gruffer",
        "gruffly", "grumble", "grunges", "grunion", "grunted", "guanine",
        "guarani", "guarded", "guarder", "guessed", "guesser", "guesses",
        "guested", "guffaws", "guiders", "guiding", "guilder", "guineas",
        "guitars", "gulches", "guldens", "gullets", "gullies", "gulling",
        "gulpers", "gulping", "gumball", "gumboil", "gumboot", "gumdrop",
        "gummier", "gumming", "gumshoe", "gunboat", "gunfire", "gunnels",
        "gunners", "gunnery", "gunning", "gunship", "gunshot", "gunwale",
        "guppies", "gurgled", "gurgles", "gurneys", "gushers", "gushier",
        "gushing", "gussets", "gussied", "gussies", "gustier", "gustily",
        "gusting", "gutless", "gutsier", "gutters", "guttier", "gutting",
        "guvnors", "guzzled", "guzzler", "guzzles", "gymnast", "gymslip",
        "gyppers", "gypping", "gypsies", "gypster", "gyrated", "gyrates",
        "gyrator", "habitat", "habitue", "hackers", "hacking", "hackish",
        "hackles", "hackney", "hacksaw", "haddock", "hafnium", "haggard",
        "haggish", "haggled", "haggler", "haggles", "hahnium", "hailing",
        "haircut", "hairdos", "hairier", "hairnet", "hairpin", "halberd",
        "halcyon", "halfway", "halfwit", "halibut", "halloos", "hallows",
        "hallway", "halogen", "haloing", "halters", "halting", "halving",
        "halyard", "hamburg", "hamlets", "hammers", "hammier", "hamming",
        "hammock", "hampers", "hamster", "handbag", "handcar", "handful",
        "handgun", "handier", "handily", "handing", "handled", "handler",
        "handles", "handout", "handsaw", "handset", "hangars", "hangdog",
        "hangers", "hanging", "hangman", "hangmen", "hangout", "hangups",
        "hankers", "hankies", "hansoms", "hapless", "haploid", "happens",
        "happier", "happily", "harbour", "hardens", "hardest", "hardhat",
        "hardier", "hardily", "hardtop", "harelip", "haricot", "harking",
        "harlots", "harmful", "harming", "harmony", "harness", "harpies",
        "harping", "harpist", "harpoon", "harried", "harrier", "harries",
        "harrows", "harsher", "harshly", "harvest", "hashing", "hashish",
        "hashtag", "hassled", "hassles", "hassock", "hastens", "hastier",
        "hastily", "hasting", "hatband", "hatched", "hatches", "hatchet",
        "hateful", "hatpins", "hatreds", "hatters", "hatting", "hauberk",
        "haughty", "haulage", "haulers", "haulier", "hauling", "haunted",
        "haunter", "hauteur", "hawkers", "hawking", "hawkish", "hawsers",
        "haycock", "hayloft", "haymows", "hayrick", "hayride", "hayseed",
        "haywire", "hazards", "haziest", "hazings", "headers", "headier",
        "headily", "heading", "headman", "headmen", "headpin", "headset",
        "headway", "healers", "healing", "healthy", "heaping", "hearers",
        "hearing", "hearken", "hearsay", "hearses", "hearten", "hearths",
        "heaters", "heathen", "heather", "heating", "heavens", "heavers",
        "heavier", "heavies", "heavily", "heaving", "heckled", "heckler",
        "heckles", "hectare", "hectors", "hedgers", "hedging", "heedful",
        "heeding", "heehaws", "heeling", "heftier", "heftily", "hefting",
        "hegiras", "heifers", "heights", "heinous", "heiress", "heisted",
        "helical", "helices", "helipad", "hellcat", "hellion", "hellish",
        "helluva", "helmets", "helpers", "helpful", "helping", "hemline",
        "hemlock", "hemmers", "hemming", "hennaed", "henpeck", "heparin",
        "hepatic", "heppest", "heralds", "herbage", "herbals", "herders",
        "herding", "heretic", "hermits", "hernial", "hernias", "heroics",
        "heroine", "heroins", "heroism", "herring", "herself", "hessian",
        "heteros", "hexagon", "heydays", "hibachi", "hiccups", "hickeys",
        "hickory", "hideous", "hideout", "hidings", "highboy", "highers",
        "highest", "highway", "hijacks", "hillier", "hillock", "hilltop",
        "himself", "hinders", "hinging", "hinters", "hinting", "hipbone",
        "hipness", "hippest", "hippies", "hipping", "hipster", "hirsute",
        "hissing", "history", "hitched", "hitcher", "hitches", "hitters",
        "hitting", "hoagies", "hoarded", "hoarder", "hoarier", "hoarser",
        "hoaxers", "hoaxing", "hobbies", "hobbits", "hobbled", "hobbler",
        "hobbles", "hobnail", "hobnobs", "hocking", "hoecake", "hoedown",
        "hogback", "hogging", "hoggish", "hogtied", "hogties", "hogwash",
        "hoicked", "hoisted", "hokiest", "holdall", "holders", "holding",
        "holdout", "holdups", "holiday", "holiest", "hollers", "hollies",
        "hollows", "holmium", "holster", "homages", "hombres", "homburg",
        "homeboy", "homered", "homiest", "hominid", "homonym", "honchos",
        "honesty", "honeyed", "honkers", "honkies", "honking", "honours",
        "hoodies", "hooding", "hoodlum", "hoodoos", "hoofers", "hoofing",
        "hookahs", "hookers", "hooking", "hookups", "hooping", "hooters",
        "hooting", "hoovers", "hopeful", "hoppers", "hopping", "hording",
        "horizon", "hormone", "hornets", "hornier", "horrify", "horrors",
        "horsier", "horsing", "hosanna", "hosiers", "hosiery", "hospice",
        "hostage", "hostels", "hostess", "hostile", "hosting", "hostler",
        "hotbeds", "hotcake", "hotfoot", "hothead", "hotkeys", "hotlink",
        "hotness", "hotpots", "hotshot", "hottest", "hotties", "hotting",
        "hounded", "housing", "hovered", "howbeit", "howdahs", "however",
        "howlers", "howling", "hoydens", "hubbies", "hubbubs", "hubcaps",
        "huddled", "huddles", "huffier", "huffily", "huffing", "hugging",
        "hulking", "hullers", "hulling", "humaner", "humanly", "humbled",
        "humbler", "humbles", "humbugs", "humdrum", "humeral", "humerus",
        "humidly", "humidor", "hummers", "humming", "hummock", "humours",
        "humphed", "humping", "hunched", "hunches", "hundred", "hungers",
        "hunkers", "hunkier", "hunters", "hunting", "hurdled", "hurdler",
        "hurdles", "hurlers", "hurling", "hurrahs", "hurried", "hurries",
        "hurtful", "hurting", "hurtled", "hurtles", "husband", "hushing",
        "huskers", "huskier", "huskies", "huskily", "husking", "hussars",
        "hussies", "hustled", "hustler", "hustles", "hutches", "huzzahs",
        "hybrids", "hydrant", "hydrate", "hydrous", "hygiene", "hymnals",
        "hymning", "hyphens", "iambics", "iceberg", "iceboat", "icecaps",
        "icicles", "iciness", "ickiest", "ideally", "idiotic", "idolise",
        "idyllic", "iffiest", "igneous", "ignited", "ignites", "ignoble",
        "ignobly", "ignored", "ignores", "iguanas", "ileitis", "illegal",
        "illicit", "illness", "imagery", "imagine", "imaging", "imagoes",
        "imbibed", "imbiber", "imbibes", "imbuing", "imitate", "immense",
        "immerse", "immoral", "immured", "immures", "impacts", "impairs",
        "impalas", "impaled", "impales", "impanel", "imparts", "impasse",
        "impasto", "impeach", "impeded", "impedes", "impends", "imperil",
        "impetus", "impiety", "impinge", "impious", "implant", "implied",
        "implies", "implode", "implore", "imports", "imposed", "imposer",
        "imposes", "imposts", "impound", "impress", "imprint", "improve",
        "impugns", "impulse", "impurer", "imputed", "imputes", "inanely",
        "inanest", "inanity", "inaptly", "inboard", "inbound", "inboxes",
        "inbreed", "inbuilt", "incense", "inching", "incised", "incises",
        "incisor", "incited", "inciter", "incites", "incline", "include",
        "incomer", "incomes", "incubus", "indents", "indexed", "indexer",
        "indexes", "indices", "indicts", "indited", "indites", "indoors",
        "induced", "inducer", "induces", "inducts", "indulge", "indwell",
        "indwelt", "ineptly", "inertia", "inertly", "inexact", "infancy",
        "infants", "infarct", "infects", "inferno", "infests", "infidel",
        "infield", "infills", "inflame", "inflate", "inflect", "inflict",
        "inflows", "informs", "infused", "infuser", "infuses", "ingenue",
        "ingests", "ingrain", "ingrate", "ingress", "ingrown", "inhabit",
        "inhaled", "inhaler", "inhales", "inhered", "inheres", "inherit",
        "inhibit", "inhuman", "initial", "injects", "injured", "injurer",
        "injures", "inkblot", "inkiest", "inkling", "inkwell", "inmates",
        "innards", "innings", "inquest", "inquire", "inquiry", "inroads",
        "insaner", "inseams", "insects", "inserts", "inshore", "insider",
        "insides", "insight", "insipid", "insists", "insofar", "insoles",
        "inspect", "inspire", "install", "instant", "instate", "instead",
        "insteps", "instils", "insular", "insulin", "insults", "insured",
        "insurer", "insures", "intakes", "integer", "intends", "intense",
        "intents", "interim", "interns", "intoned", "intoner", "intones",
        "introit", "intrude", "intuits", "inuring", "invaded", "invader",
        "invades", "invalid", "inveigh", "invents", "inverse", "inverts",
        "invests", "invited", "invitee", "invites", "invoice", "invoked",
        "invokes", "involve", "inwards", "iodides", "iodised", "iodises",
        "ionised", "ionises", "ionizer", "ipecacs", "irately", "iridium",
        "irksome", "ironies", "ironing", "irrupts", "islands", "isobars",
        "isolate", "isomers", "isotope", "issuers", "issuing", "isthmus",
        "italics", "itchier", "itching", "itemise", "iterate", "ivories",
        "jabbers", "jabbing", "jackals", "jackass", "jackdaw", "jackets",
        "jacking", "jackpot", "jadedly", "jadeite", "jaggies", "jaguars",
        "jailers", "jailing", "jammier", "jamming", "jangled", "jangler",
        "jangles", "janitor", "jarfuls", "jarring", "jasmine", "jaunted",
        "javelin", "jawbone", "jawline", "jaybird", "jaywalk", "jazzier",
        "jazzing", "jealous", "jeering", "jejunum", "jellied", "jellies",
        "jelling", "jemmied", "jemmies", "jennets", "jennies", "jerkier",
        "jerkily", "jerking", "jerkins", "jerseys", "jesters", "jesting",
        "jetport", "jetties", "jetting", "jibbing", "jiffies", "jiggers",
        "jigging", "jiggled", "jiggles", "jigsaws", "jilting", "jimmied",
        "jimmies", "jingled", "jingles", "jinking", "jinxing", "jitneys",
        "jitters", "jittery", "jobbers", "jobbing", "jobless", "jockeys",
        "jocular", "joggers", "jogging", "joggled", "joggles", "joiners",
        "joinery", "joining", "jointed", "jointly", "jokiest", "jollied",
        "jollier", "jollies", "jollily", "jollity", "jolters", "jolting",
        "jonquil", "joshers", "joshing", "jostled", "jostles", "jotters",
        "jotting", "jounced", "jounces", "journal", "journey", "journos",
        "jousted", "jouster", "jowlier", "joyless", "joyride", "joyrode",
        "jubilee", "judders", "judging", "jugfuls", "jugging", "juggled",
        "juggler", "juggles", "jugular", "juicers", "juicier", "juicily",
        "juicing", "jujitsu", "jujubes", "jukebox", "jumbled", "jumbles",
        "jumpers", "jumpier", "jumpily", "jumping", "jungles", "juniors",
        "juniper", "junkers", "junkets", "junkier", "junkies", "junking",
        "juridic", "jurists", "juryman", "jurymen", "justest", "justice",
        "justify", "jutting", "kaddish", "kaftans", "kahunas", "kaisers",
        "karakul", "karaoke", "katydid", "kayaked", "kayoing", "keeling",
        "keenest", "keening", "keepers", "keeping", "kelvins", "kennels",
        "kenning", "keratin", "kerbing", "kernels", "kestrel", "ketches",
        "ketchup", "ketones", "kettles", "keyhole", "keynote", "keypads",
        "keyword", "kibbled", "kibbles", "kibbutz", "kickers", "kickier",
        "kicking", "kickoff", "kidders", "kiddies", "kidding", "kiddish",
        "kidnaps", "kidneys", "kidskin", "killers", "killing", "killjoy",
        "kilning", "kiloton", "kimonos", "kindest", "kindled", "kindles",
        "kindred", "kinetic", "kinfolk", "kingdom", "kingpin", "kinkier",
        "kinkily", "kinking", "kinship", "kinsman", "kinsmen", "kippers",
        "kipping", "kissers", "kissing", "kissoff", "kitchen", "kitschy",
        "kittens", "kitties", "kitting", "klaxons", "kludged", "kludges",
        "klutzes", "knacker", "knavery", "knavish", "kneaded", "kneader",
        "kneecap", "kneeing", "knelled", "knicker", "knifing", "knights",
        "knishes", "knitted", "knitter", "knobbly", "knocked", "knocker",
        "knotted", "knowing", "knuckle", "knurled", "kookier", "kopecks",
        "koshers", "kowtows", "krypton", "kuchens", "kumquat", "labials",
        "labours", "laciest", "lackeys", "lacking", "laconic", "lacquer",
        "lactate", "lacteal", "lactose", "lacunae", "ladders", "laddies",
        "laddish", "ladings", "ladling", "ladybug", "laggard", "lagging",
        "lagoons", "lambada", "lambdas", "lambent", "lambing", "lambkin",
        "laments", "laminae", "laminar", "lamming", "lampoon", "lamprey",
        "lancers", "lancets", "lancing", "landaus", "landing", "languid",
        "languor", "lankest", "lankier", "lanolin", "lantern", "lanyard",
        "lapdogs", "lappets", "lapping", "lapsing", "laptops", "lapwing",
        "larceny", "larches", "larders", "lardier", "larding", "largely",
        "largess", "largest", "largish", "lariats", "larking", "lasagne",
        "lashing", "lassies", "lassoed", "lasting", "latched", "latches",
        "latency", "lateral", "lathers", "lathery", "lathing", "latices",
        "latrine", "lattice", "lauding", "laughed", "launder", "laundry",
        "laurels", "lawless", "lawsuit", "lawyers", "laxness", "layaway",
        "layered", "layette", "layoffs", "layouts", "layover", "laziest",
        "lazying", "leached", "leaches", "leaders", "leading", "leafage",
        "leafier", "leafing", "leaflet", "leagued", "leagues", "leakage",
        "leakier", "leaking", "leanest", "leaning", "leapers", "leaping",
        "learned", "learner", "leasers", "leashed", "leashes", "leasing",
        "leather", "leavens", "leavers", "leaving", "lechers", "lechery",
        "leching", "lectern", "lecture", "ledgers", "leeched", "leeches",
        "leerier", "leering", "leeward", "leftest", "lefties", "leftism",
        "leftist", "legally", "legatee", "legates", "legatos", "legends",
        "leggier", "legging", "leghorn", "legible", "legibly", "legions",
        "legless", "legroom", "legumes", "legwork", "leisure", "lemming",
        "lenders", "lending", "lengths", "lengthy", "lenient", "lentils",
        "leonine", "leopard", "leotard", "leprosy", "leprous", "leptons",
        "lesbian", "lesions", "lessees", "lessens", "lessons", "lessors",
        "letdown", "letters", "letting", "lettuce", "leucine", "levelly",
        "levered", "leviers", "levying", "lewdest", "lexical", "lexicon",
        "liaised", "liaises", "liaison", "libbers", "liberal", "liberty",
        "libidos", "library", "licence", "license", "lichens", "licitly",
        "licking", "lidless", "liefest", "lifters", "lifting", "liftoff",
        "ligated", "ligates", "lighted", "lighten", "lighter", "lightly",
        "lignite", "likened", "lilting", "limbers", "limeade", "limiest",
        "limited", "limiter", "limning", "limpest", "limpets", "limping",
        "lindens", "lineage", "lineman", "linemen", "lineups", "lingers",
        "lingoes", "lingual", "linings", "linkage", "linking", "linkman",
        "linkmen", "linkups", "linnets", "linseed", "lintels", "lintier",
        "linting", "lioness", "lionise", "lipread", "liquefy", "liqueur",
        "liquids", "liquors", "lispers", "lisping", "listens", "listing",
        "litchis", "literal", "lithely", "lithest", "lithium", "litotes",
        "litters", "littler", "liturgy", "livened", "lividly", "livings",
        "lizards", "loaders", "loading", "loafers", "loafing", "loamier",
        "loaners", "loaning", "loathed", "loather", "loathes", "lobbers",
        "lobbied", "lobbies", "lobbing", "lobster", "locales", "locally",
        "located", "locates", "locator", "lockers", "lockets", "locking",
        "lockjaw", "lockout", "lockups", "locusts", "lodgers", "lodging",
        "loftier", "loftily", "lofting", "logbook", "loggers", "loggias",
        "logging", "logical", "logiest", "logjams", "logoffs", "logouts",
        "loiters", "lolcats", "lollies", "lolling", "lollops", "longbow",
        "longest", "longing", "longish", "loofahs", "lookers", "looking",
        "lookout", "looming", "loonier", "loonies", "loopier", "looping",
        "loosely", "loosens", "loosest", "loosing", "looters", "looting",
        "lopping", "lording", "lorises", "lorries", "losings", "lotions",
        "lottery", "lotuses", "loudest", "lounged", "lounger", "lounges",
        "louring", "lousier", "lousily", "lousing", "loutish", "louvred",
        "louvres", "lovable", "lovably", "lowborn", "lowboys", "lowbrow",
        "lowdown", "lowered", "lowland", "lowlier", "lowlife", "lowness",
        "loyaler", "loyally", "loyalty", "lozenge", "lubbers", "lucidly",
        "luckier", "luckily", "lucking", "luffing", "luggage", "luggers",
        "lugging", "lughole", "lugsail", "lullaby", "lulling", "lumbago",
        "lumbers", "lumpier", "lumping", "lumpish", "lunatic", "lunched",
        "lunches", "lungful", "lunging", "lurched", "lurches", "luridly",
        "lurkers", "lurking", "lushest", "lustful", "lustier", "lustily",
        "lusting", "lyceums", "lynched", "lyncher", "lynches", "lyrical"
    };
}
