package presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dmobile.moneyconversor.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import presentation.converter.ConverterActivity

class LoginActivity : AppCompatActivity() {

    val viewModel: LoginViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ConverterActivity::class.java
                )
            )
        }
    }
}
