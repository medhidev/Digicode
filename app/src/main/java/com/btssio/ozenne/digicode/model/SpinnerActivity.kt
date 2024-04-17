package com.btssio.ozenne.digicode.model

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.AdapterView

class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item is selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos).
        Log.d("pos-date", parent.getItemAtPosition(pos).toString())
    }
    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback.
    }
}