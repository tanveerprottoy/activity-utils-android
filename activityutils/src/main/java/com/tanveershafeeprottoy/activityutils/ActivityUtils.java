package com.tanveershafeeprottoy.activityutils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class ActivityUtils {
    private static FragmentTransaction fragmentTransaction;
    private static ActionBar actionBar;

    public static void addFragmentOnActivity(FragmentManager fragmentManager,
                                             Fragment fragment, int frameId) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment);
        fragmentTransaction.commit();
    }

    public static void addFragmentOnActivity(FragmentManager fragmentManager,
                                             Fragment fragment, int frameId,
                                             int enterAnim, int exitAnim,
                                             int popEnterAnim, int popExitAnim) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        fragmentTransaction.add(frameId, fragment);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(FragmentManager fragmentManager,
                                                 Fragment fragment, int frameId,
                                                 String name) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId, fragment);
        if(!name.equals("")) {
            fragmentTransaction.addToBackStack(name);
        }
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(FragmentManager fragmentManager,
                                                 Fragment fragment, int frameId, String name,
                                                 int enterAnim, int exitAnim, int popEnterAnim,
                                                 int popExitAnim) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        fragmentTransaction.replace(frameId, fragment);
        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(FragmentManager fragmentManager,
                                                 Fragment fragment, int frameId,
                                                 String name, View view,
                                                 String transitionName, int enterAnim, int exitAnim,
                                                 int popEnterAnim, int popExitAnim) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        fragmentTransaction.addSharedElement(view, transitionName);
        fragmentTransaction.replace(frameId, fragment);
        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }

    public static void setToolbarTitle(AppCompatActivity appCompatActivity, String title) {
        actionBar = appCompatActivity.getSupportActionBar();
        if(actionBar.getTitle() != title) {
            actionBar.setTitle(title);
        }
    }

    public static void setToolbarTitle(FragmentActivity fragmentActivity, String title) {
        actionBar = ((AppCompatActivity) fragmentActivity).getSupportActionBar();
        if(actionBar.getTitle() != title) {
            actionBar.setTitle(title);
        }
    }
}
