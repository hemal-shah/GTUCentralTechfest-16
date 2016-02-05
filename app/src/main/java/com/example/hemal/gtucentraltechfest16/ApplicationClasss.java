package com.example.hemal.gtucentraltechfest16;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;

/**
 * Created by hemal on 5/2/16.
 */
public class ApplicationClasss extends Application {
    public ApplicationClasss(){
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "eTU2iFv25WnJqMP9oTcQftgLiXTFNAKRHrlTbfPg", "Joemswc4Gv7lg3JjTqMeungV9uunD0EGl97ug2Tx");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParsePush.subscribeInBackground("Test1");
    }
}