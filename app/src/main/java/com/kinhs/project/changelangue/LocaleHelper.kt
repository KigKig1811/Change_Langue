@file:Suppress("DEPRECATION")

package com.kinhs.project.changelangue

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.preference.PreferenceManager
import org.intellij.lang.annotations.Language
import java.util.*

object LocaleHelper {
    private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"

    fun onAttach(context: Context): Context? {
        val lang = getPersistedData(
            context,
            com.kinhs.project.changelangue.Language.VIETNAM.code
        )
        return setLocale(context, lang)
    }

    fun getLanguage(context: Context): String? {
        return getPersistedData(
            context,
            com.kinhs.project.changelangue.Language.VIETNAM.code
        )
    }
    // the method is used to set the language at runtime
    fun setLocale(context: Context, language: String?): Context? {
        language ?: return null
        persist(context, language)
        val locale = Locale(language)
        Locale.setDefault(locale)
        // updating the language for devices above android N
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language)
            //for devices having lower version of android os
            } else updateResourcesLegacy(
            context,
            language
        )
    }

    private fun updateLocale(context: Context): Context? {
        return setLocale(
            context,
            getLanguage(context)
        )
    }

    fun getResourcesByContext(context: Context): Resources? {
        return updateLocale(context)?.resources
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String? {
        return try {
            val preferences =
                PreferenceManager.getDefaultSharedPreferences(context)
            preferences.getString(
                SELECTED_LANGUAGE,
                defaultLanguage
            )
        } catch (e: Exception) {
            defaultLanguage
        }
    }

    private fun persist(context: Context, language: String?) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }
    // the method is used update the language of application by creating
    // object of inbuilt Locale class and passing language argument to it
    private fun updateResources(context: Context, language: String?): Context? {
        language ?: return null
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration =
            context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        context.resources
            .updateConfiguration(configuration, context.resources.displayMetrics)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context, language: String?): Context? {
        language ?: return null
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}