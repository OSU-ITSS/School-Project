package cz.osu;

import java.util.HashMap;
import java.util.Locale;

public class Localizer {
    private Language language;
    private HashMap<Language, HashMap<String,String>> map;

    public Localizer() {
        Locale currentLocale = Locale.getDefault();
        String language = currentLocale.getISO3Language();
        //language = "rus";
        try {
            this.language = Language.valueOf(language);
        }catch (IllegalArgumentException ex){
            this.language = Language.eng;
        }

        this.map = initMap();
    }

    private HashMap<Language, HashMap<String, String>> initMap() {
        HashMap<Language, HashMap<String, String>> ret = new HashMap();
        HashMap<String, String> ces = new HashMap();
        ces.put("btnLogin", "Přihlásit se");
        ces.put("btnShop", "Obchod");
        ces.put("btnLibrary", "Knihovna");
        ces.put("btnCommunity", "Komunita");
        ces.put("btnProfile", "Profil");
        ces.put("btnLogout", "Odhlásit se");
        HashMap<String, String> eng = new HashMap();
        eng.put("btnLogin", "Log in");
        eng.put("btnShop", "Shop");
        eng.put("btnLibrary", "Library");
        eng.put("btnCommunity", "Community");
        eng.put("btnProfile", "Profile");
        eng.put("btnLogout", "Log out");
        ret.put(Language.ces, ces);
        ret.put(Language.eng, eng);
        return ret;
    }

    public String get(String key){
        String ret = this.map.get(this.language).get(key);
        if(ret == null){
            ret = key;
        }
        return ret;
    }
}









