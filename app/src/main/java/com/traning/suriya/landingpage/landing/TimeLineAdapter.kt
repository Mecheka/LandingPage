package com.traning.suriya.landingpage.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.traning.suriya.landingpage.R
import com.traning.suriya.landingpage.loadResourceCircle
import kotlinx.android.synthetic.main.item_bank.view.*

class TimeLineAdapter(private val list: List<BankAccountView>) :
    RecyclerView.Adapter<TimeLineAdapter.BankAccountHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankAccountHolder {
        return BankAccountHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_time_line,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BankAccountHolder, position: Int) {
        holder.bind(list[position])
    }

    class BankAccountHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: BankAccountView) {

            view.imageBank.loadResourceCircle(R.drawable.ic_bank)
            view.textNumber.text = model.number
            view.textBalance.text = model.amount
        }
    }
}