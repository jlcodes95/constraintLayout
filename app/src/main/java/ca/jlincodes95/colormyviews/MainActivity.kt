package ca.jlincodes95.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import ca.jlincodes95.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.box_one)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(binding.boxOne, binding.boxTwo, binding.boxThree, binding.boxFour, binding.boxFive, binding.constraintLayout, binding.btnRed, binding.btnYellow, binding.btnGreen)

        for (item in clickableViews) {
            item.setOnClickListener{ makeColored(it)}
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one -> view.setBackgroundColor(Color.LTGRAY)

            R.id.box_two -> view.setBackgroundColor(Color.BLUE)

            R.id.box_three -> view.setBackgroundColor(Color.DKGRAY)

            R.id.box_four -> view.setBackgroundColor(Color.CYAN)

            R.id.box_five -> view.setBackgroundColor(Color.MAGENTA)

            R.id.btn_red -> binding.boxThree.setBackgroundResource(R.color.red)
            R.id.btn_green -> binding.boxFour.setBackgroundResource(R.color.green)
            R.id.btn_yellow -> binding.boxFive.setBackgroundResource(R.color.yellow)

            else -> view.setBackgroundColor(Color.GRAY)
        }
    }
}