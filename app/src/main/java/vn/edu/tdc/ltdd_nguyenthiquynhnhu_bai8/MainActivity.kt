package vn.edu.tdc.ltdd_nguyenthiquynhnhu_bai8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var edtNhapHoTen: EditText
    private lateinit var btnTach: Button
    private lateinit var tvKetQua: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setControl()
        setEvent()
        }
    private fun setControl(){
        edtNhapHoTen = findViewById(R.id.edtNhapHoTen)
        btnTach = findViewById(R.id.btnTach)
        tvKetQua = findViewById(R.id.tvKetQua)
    }
    private fun setEvent(){
        btnTach.setOnClickListener{TachTen()}
    }
    private fun TachTen(){
        val fullname = edtNhapHoTen.text.trim()
        if(fullname.isBlank()){
            tvKetQua.setText("Họ tên không hợp lệ!")
            return
        }
        val nameParts = fullname.trim().split("\\s+".toRegex())
        if(nameParts.size <2){
            tvKetQua.setText("Vui lòng nhập họ và tên đầy đủ.")
        }else{
            val firstName = nameParts.last()
            tvKetQua.setText("Kết quá: $firstName")
        }
    }
}