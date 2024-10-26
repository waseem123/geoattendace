package com.infostack.geoattendance.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


import com.infostack.geoattendance.ui.MainActivity;

import java.util.HashMap;

public class UserSessionManager {

    //    Shared Preferences reference
    SharedPreferences preferences;

    //Editor reference for shared preferences
    Editor editor;

    //    context
    Context mContext;

    //    shared preference mode
    int PRIVATE_MODE = 0;

    private static final String PREFER_NAME = "GeoAttendancePref";

    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    public static final String KEY_UserId = "userid";

    public static final String KEY_NAME = "name";

    public static final String KEY_EMAIL = "email";

//    public static final String KEY_RoleId = "roleid";
//
//    public static final String KEY_RoleName = "rolename";
//
//    public static final String KEY_ProfileImage = "No Image";
//
//    public static final String KEY_CompanyId = "companyid";
//    public static final String KEY_CompanyName = "companyname";



    //    Constructor
    public UserSessionManager(Context context) {
        this.mContext = context;
        preferences = mContext.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    //    Create Login Session
    public void createUserLoginSession(String userid, String name, String email){//, String roleid, String rolename, String profileimage, String companyid, String companyname, String siteid, String sitename) {
        editor.putBoolean(IS_USER_LOGIN, true);

        editor.putString(KEY_UserId, userid);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
//        editor.putString(KEY_RoleId, roleid);
//        editor.putString(KEY_RoleName, rolename);
//        editor.putString(KEY_ProfileImage, profileimage);
//        editor.putString(KEY_CompanyId, companyid);
//        editor.putString(KEY_CompanyName, companyname);
//        editor.putString(KEY_SiteId, siteid);
//        editor.putString(KEY_SiteName, sitename);

        editor.commit();
    }

    /**
     * checkLogin method will check user login status
     * If false it will redirect the user to login page
     * Else do anything
     */
    public boolean checkLogin() {
        if (!(this.isUserLoggedIn())) {
//            user is not logged in redirect to login activity
            Intent intent = new Intent(mContext, MainActivity.class);

//            Close all activities from stack
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

//            Add new flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

//            Starting login activity
            mContext.startActivity(intent);

            return true;
        }
        return false;
    }

    /**
     * Check For Login
     *
     * @return
     */
    public boolean isUserLoggedIn() {
        return preferences.getBoolean(IS_USER_LOGIN, false);
    }

    /**
     * Get Stored Session Data
     */
    public HashMap<String, String> getUserDetails() {
//        Use Hashmap to store user credentials
        HashMap<String, String> user = new HashMap<String, String>();

//        User Id
        user.put(KEY_UserId, preferences.getString(KEY_UserId, null));

//        User Name
        user.put(KEY_NAME, preferences.getString(KEY_NAME, null));
//        Email
        user.put(KEY_EMAIL, preferences.getString(KEY_EMAIL, null));
//        Role Id
//        user.put(KEY_RoleId, preferences.getString(KEY_RoleId, null));
////        Role Name
//        user.put(KEY_RoleName, preferences.getString(KEY_RoleName, null));
//
////        Profile Image
//        user.put(KEY_ProfileImage, preferences.getString(KEY_ProfileImage, null));
//
////        Company Id
//        user.put(KEY_CompanyId, preferences.getString(KEY_CompanyId, null));
//
////        Company Name
//        user.put(KEY_CompanyName, preferences.getString(KEY_CompanyName, null));
//
////        Site Id
//        user.put(KEY_SiteId, preferences.getString(KEY_SiteId, null));
//
////        Site Name
//        user.put(KEY_SiteName, preferences.getString(KEY_SiteName, null));

//        return user
        return user;
    }

    public void logoutUser() {
        /**
         * Clearing all data from shared preferrences
         */
        editor.clear();
        editor.commit();

        /**
         * After logout redirect user to LoginActivity
         */
        Intent intent = new Intent(mContext, MainActivity.class);

        /**
         * Closing all activities
         */
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        /**
         * Add new flag to start new activity
         */
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        /**
         * Starting Login Activity
         */
        mContext.startActivity(intent);
    }
}
