package ninja.knowone.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import ninja.knowone.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Michael Winebarger")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nickname_edit.visibility = View.GONE
            view.visibility = View.GONE
            text_nickname.visibility = View.VISIBLE
            val hideKeys = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideKeys.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
