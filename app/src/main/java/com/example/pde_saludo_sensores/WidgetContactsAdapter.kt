package com.example.pde_saludo_sensores

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class WidgetContactsAdapter : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return ContactsRemoteViewsFactory(applicationContext)
    }

    class ContactsRemoteViewsFactory(private val context: Context) : RemoteViewsFactory {
        private val contacts = mutableListOf<String>()

        override fun onCreate() {
            loadContactsFromPreferences()
        }

        override fun onDataSetChanged() {
            loadContactsFromPreferences()
        }

        private fun loadContactsFromPreferences() {
            val sharedPreferences = context.getSharedPreferences("ContactsWidgetPrefs", Context.MODE_PRIVATE)
            val savedContacts = sharedPreferences.getStringSet("contacts", emptySet()) ?: emptySet()
            contacts.clear()
            contacts.addAll(savedContacts)
        }

        override fun onDestroy() {
            contacts.clear()
        }

        override fun getCount(): Int = contacts.size

        override fun getViewAt(position: Int): RemoteViews {
            val remoteView = RemoteViews(context.packageName, R.layout.widget_contact_item)
            remoteView.setTextViewText(R.id.widget_contact_name, contacts[position])
            return remoteView
        }

        override fun getLoadingView(): RemoteViews? = null
        override fun getViewTypeCount(): Int = 1
        override fun getItemId(position: Int): Long = position.toLong()
        override fun hasStableIds(): Boolean = true
    }
}

