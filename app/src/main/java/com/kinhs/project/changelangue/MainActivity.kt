package com.kinhs.project.changelangue

import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import com.kinhs.project.changelangue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEn.setOnClickListener {
            var language = LocaleHelper.setLocale(this,"en")
            var resource : Resources
            resource = language!!.resources
            binding.tvCheck.text = resource.getString(R.string.language)

        }

        binding.btnVn.setOnClickListener {
            var language = LocaleHelper.setLocale(this,"vi")
            var resource : Resources
            resource = language!!.resources
            binding.tvCheck.text = resource.getString(R.string.language)

        }
        binding.tvEn.setOnClickListener {
            var language = LocaleHelper.setLocale(this,"en")
            var resource : Resources
            resource = language!!.resources
            binding.tvCheck.text = resource.getString(R.string.language)

        }

        binding.tvVi.setOnClickListener {
            var language = LocaleHelper.setLocale(this,"vi")
            var resource : Resources
            resource = language!!.resources
            binding.tvCheck.text = resource.getString(R.string.language)

        }
    }

   /* private fun setLanguage() {
        val lang = LocaleHelper.getLanguage(this) ?: ""
        if (Language.find(lang).code == Language.VIETNAM.code) initSettingLanguage(1)
        else initSettingLanguage(2)
        binding.tvVi.setOnClickListener { initSettingLanguage(1) }
        binding.tvEn.setOnClickListener { initSettingLanguage(2) }
    }

    private fun initSettingLanguage(typeLanguage: Int) {
        when (typeLanguage) {
            1 -> {
                binding.tvVi.typeface =
                    ResourcesCompat.getFont(this, R.font.sf_pro_display_semibold)
                binding.tvEn.typeface =
                    ResourcesCompat.getFont(this, R.font.sf_pro_display_regular)
                binding.tvVi.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sp12))
                binding.tvEn.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sp10))
                LocaleHelper.setLocale(this, Language.VIETNAM.code)
                /*initRecyclerView()
                initBottomNavigation()*/
            }
            2 -> {
                binding.tvEn.typeface =
                    ResourcesCompat.getFont(requireContext(), R.font.sf_pro_display_semibold)
                binding.tvVi.typeface =
                    ResourcesCompat.getFont(requireContext(), R.font.sf_pro_display_regular)
                tvEn.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sp12))
                tvVi.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sp10))
                LocaleHelper.setLocale(requireContext(), Language.ENGLISH.code)
                initRecyclerView()
                initBottomNavigation()
            }
        }
    }*/
}