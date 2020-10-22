package no.store.maast

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment;
    lateinit var shopFragment: ShopFragment;
    lateinit var accountFragment: AccountFragment;
    lateinit var cartFragment: CartFragment;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        makeCurrentFragment(homeFragment)

        btm_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    homeFragment = HomeFragment()
                    makeCurrentFragment(homeFragment)
                }

                R.id.shop -> {
                    shopFragment = ShopFragment()
                    makeCurrentFragment(shopFragment)
                }

                R.id.account -> {
                    accountFragment = AccountFragment()
                    makeCurrentFragment(accountFragment)
                }

                R.id.cart -> {
                    cartFragment = CartFragment()
                    makeCurrentFragment(cartFragment)
                }
            }
            true
        }
    }

    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)                      //open = adds a new fragment to the stack
            .commit()

}

