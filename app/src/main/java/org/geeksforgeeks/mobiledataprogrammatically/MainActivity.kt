package org.geeksforgeeks.mobiledataprogrammatically

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.Check)
        btn.setOnClickListener {
            if(Settings.System.getInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) == 0){
                Toast.makeText(applicationContext,"Off",Toast.LENGTH_SHORT).show()
                Settings.System.putInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 1)
            } else {
                Toast.makeText(applicationContext,"On",Toast.LENGTH_SHORT).show()
                Settings.System.putInt(contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0)
            }
        }
    }

}