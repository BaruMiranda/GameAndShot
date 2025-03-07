package com.barcod.juegabebe.ui.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.barcod.juegabebe.databinding.ActivityMainBinding
import com.barcod.juegabebe.ui.container.ContainerFragment
import com.barcod.juegabebe.ui.container.fourgame.ToditoFragment
import com.barcod.juegabebe.ui.container.onegame.YoNuncaNuncaFragment
import com.barcod.juegabebe.ui.container.threegame.SiHaTodoFragment
import com.barcod.juegabebe.ui.container.twogame.AlQueLeTocaTocaFragment
import com.bms.mcconsultcorp.service.FragmentService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentService {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.verContainerFragment()

        supportFragmentManager.popBackStack(
            ContainerFragment::class.java.simpleName,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )

    }

    private fun showFragment(fragment: Fragment) {
        val ft = supportFragmentManager
            .beginTransaction()
            .replace(binding.mainFragmentPlaceholder.id, fragment)
            .addToBackStack(null)
        ft.commit()
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        supportFragmentManager.executePendingTransactions()
        val currentFragment =
            supportFragmentManager.findFragmentById(binding.mainFragmentPlaceholder.id)

        if (currentFragment is ContainerFragment) {
            finishAffinity()
        } else if(currentFragment is YoNuncaNuncaFragment||
            currentFragment is AlQueLeTocaTocaFragment ||
            currentFragment is ToditoFragment ||
            currentFragment is SiHaTodoFragment) {
            this.verContainerFragment()
        }
    }

    override fun verContainerFragment() {
        val showFragment: ContainerFragment = ContainerFragment().newInstance()
        showFragment(showFragment)
    }

    override fun verYoNuncaNuncaFragment() {
        val showFragment: YoNuncaNuncaFragment = YoNuncaNuncaFragment().newInstance()
        showFragment(showFragment)
    }

    override fun verAlQueLeTocaTocaFragment() {
        val showFragment: AlQueLeTocaTocaFragment = AlQueLeTocaTocaFragment().newInstance()
        showFragment(showFragment)
    }

    override fun verSiHaTodoFragment() {
        val showFragment: SiHaTodoFragment = SiHaTodoFragment().newInstance()
        showFragment(showFragment)
    }

    override fun verToditoFragment() {
        val showFragment: ToditoFragment = ToditoFragment().newInstance()
        showFragment(showFragment)
    }

    fun mToolbar(value: Boolean) {
        binding.toolbar.visibility = if (value) View.VISIBLE else View.GONE
    }
}