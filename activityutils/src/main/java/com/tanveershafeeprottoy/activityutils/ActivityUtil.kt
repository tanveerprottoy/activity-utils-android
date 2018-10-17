package com.tanveershafeeprottoy.activityutils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View

object ActivityUtil {
    private var fragmentTransaction: FragmentTransaction? = null

    fun addFragmentOnActivity(fragmentManager: FragmentManager?,
                              fragment: Fragment, frameId: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(frameId, fragment)
        fragmentTransaction?.commit()
    }

    fun addFragmentOnActivity(fragmentManager: FragmentManager?,
                              fragment: Fragment, frameId: Int, enterAnim: Int, exitAnim: Int,
                              popEnterAnim: Int, popExitAnim: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
        fragmentTransaction?.add(frameId, fragment)
        fragmentTransaction?.commit()
    }

    fun replaceFragmentOnActivity(fragmentManager: FragmentManager?,
                                  fragment: Fragment, frameId: Int, name: String = "") {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(frameId, fragment)
        if(name != "") {
            fragmentTransaction?.addToBackStack(name)
        }
        fragmentTransaction?.commit()
    }

    fun replaceFragmentOnActivity(fragmentManager: FragmentManager?,
                                  fragment: Fragment, frameId: Int, name: String,
                                  view: View, transitionName: String) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.addSharedElement(view, transitionName)
        fragmentTransaction?.replace(frameId, fragment)
        fragmentTransaction?.addToBackStack(name)
        fragmentTransaction?.commit()
    }

    fun replaceFragmentOnActivity(fragmentManager: FragmentManager?,
                                  fragment: Fragment, frameId: Int, name: String,
                                  enterAnim: Int, exitAnim: Int, popEnterAnim: Int,
                                  popExitAnim: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
        fragmentTransaction?.replace(frameId, fragment)
        fragmentTransaction?.addToBackStack(name)
        fragmentTransaction?.commit()
    }

    fun setToolbarTitle(appCompatActivity: AppCompatActivity?, title: String) {
        if(appCompatActivity?.supportActionBar?.title != title) {
            appCompatActivity?.supportActionBar?.title = title
        }
    }

    fun setToolbarTitle(fragmentActivity: FragmentActivity?, title: String) {
        if((fragmentActivity as AppCompatActivity).supportActionBar?.title != title) {
            fragmentActivity.supportActionBar?.title = title
        }
    }
}