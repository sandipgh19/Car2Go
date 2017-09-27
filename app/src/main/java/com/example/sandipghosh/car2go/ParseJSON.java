package com.example.sandipghosh.car2go;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sandipghosh on 27/09/17.
 */

public class ParseJSON {

        public static String[] name;
        public static String[] interior;

        private JSONArray users = null;

        private String json;

        public ParseJSON(String json){
            this.json = json;
        }

        protected void parseJSON(){
            JSONObject jsonObject=null;
            try {
                jsonObject = new JSONObject(json);
                users = jsonObject.getJSONArray(Config.JSON_ARRAY);

                name = new String[users.length()];
                interior = new String[users.length()];

                for(int i=0;i<users.length();i++){
                    JSONObject jo = users.getJSONObject(i);
                    name[i] = jo.getString(Config.name_key);
                    interior[i] = jo.getString(Config.interirror_key);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
}

