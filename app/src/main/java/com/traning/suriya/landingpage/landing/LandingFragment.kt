package com.traning.suriya.landingpage.landing

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.readystatesoftware.systembartint.SystemBarTintManager
import com.traning.suriya.landingpage.R
import com.traning.suriya.landingpage.loadResourceCircle
import kotlinx.android.synthetic.main.fragment_landing.*

class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val statusBarManager = SystemBarTintManager(requireActivity())
        statusBarManager.isStatusBarTintEnabled = true
        statusBarManager.isStatusBarTintEnabled = true
        statusBarManager.setStatusBarTintColor(Color.TRANSPARENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = activity?.window
            w?.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val config = statusBarManager.config
        val parma = imageProfile.layoutParams as ConstraintLayout.LayoutParams
        parma.setMargins(
            0,
            (requireContext().resources.getDimension(R.dimen.margin_16).toInt() + config.getPixelInsetTop(
                false
            )), 0, 0
        )
        imageProfile.layoutParams = parma
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        initTimeline()
    }

    private fun initToolbar() {
        val bankList = List(10) {
            BankAccountView("083 333 3333", "1,000.00")
        }

        bankRecyclerView.apply {
            addItemDecoration(ItemDecoration())
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = BankAccountAdapter(bankList)
        }

        imageProfile.loadResourceCircle(R.drawable.cherprang)
    }

    private fun initTimeline(){
        val timelineList = List(50){
            BankAccountView("083 333 3333", "1,000.00")
        }

        timelineRecyclerView.apply {
            addItemDecoration(DividerItemDecoration(requireContext(),RecyclerView.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = TimeLineAdapter(timelineList)
        }

        var scrollY = 0
        timelineRecyclerView.viewTreeObserver.addOnScrollChangedListener {
            timelineRecyclerView?.let {
                scrollY = it.computeVerticalScrollOffset()
            }
            if(scrollY > 100){
                scrollY = 100
            }
            invalidateToolbarSize(scrollY)
        }
    }

    private fun invalidateToolbarSize(progress: Int) {
        if (progress > 100 || progress < 0) return

        var viewAlpha = ((100 - progress) / 100f)

        imageProfile.alpha = viewAlpha
        textName.alpha = viewAlpha
        textBalance.alpha = viewAlpha
        bankRecyclerView.alpha = viewAlpha
    }
}
