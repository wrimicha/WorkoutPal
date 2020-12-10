package sheridan.wrimicha.final_project

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.CalendarView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import sheridan.wrimicha.final_project.R
import sheridan.wrimicha.final_project.databinding.FragmentJogInputBinding
import java.util.*

class MainActivity : AppCompatActivity() {

//    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim)}
//    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim)}
//    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim)}
//    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim)}
//
//    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navController =
            Navigation.findNavController(this, R.id.nav_host)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
//            onFabButtonClicked()
//        }

    }

//    private fun onFabButtonClicked() {
//        setVisibility(clicked)
//        setAnimation(clicked)
//        clicked = !clicked
//    }

//    private fun setAnimation(clicked: Boolean) {
//        if(!clicked){
//            findViewById<FloatingActionButton>(R.id.fab).startAnimation(rotateOpen)
//            findViewById<FloatingActionButton>(R.id.addJog).startAnimation(fromBottom)
//            findViewById<FloatingActionButton>(R.id.addBench).startAnimation(fromBottom)
//        } else {
//            findViewById<FloatingActionButton>(R.id.fab).startAnimation(rotateClose)
//            findViewById<FloatingActionButton>(R.id.addJog).startAnimation(toBottom)
//            findViewById<FloatingActionButton>(R.id.addBench).startAnimation(toBottom)
//        }
//    }
//
//    private fun setVisibility(clicked: Boolean) {
//        if(!clicked){
//            findViewById<FloatingActionButton>(R.id.addJog).visibility = View.VISIBLE
//            findViewById<FloatingActionButton>(R.id.addBench).visibility = View.VISIBLE
//        } else {
//            findViewById<FloatingActionButton>(R.id.addJog).visibility = View.INVISIBLE
//            findViewById<FloatingActionButton>(R.id.addBench).visibility = View.INVISIBLE
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}