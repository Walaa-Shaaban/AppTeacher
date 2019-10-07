package com.selwan.schools365teacher.ui.student_details.student_details_info

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.student_details.recyclerview_student_details.adapter.StudentsDetailsAdapter

class StudentDetailsInfoAdapter: RecyclerView.Adapter<StudentDetailsInfoAdapter.ViewHolder> {

    var context: Context
    var allStudentSection: List<StudentDetails>

    constructor(allStudentSection: List<StudentDetails>, context: Context) : super() {
        this.allStudentSection = allStudentSection
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_details_info_item, parent, false)
        return ViewHolder(inflater)

    }

    override fun getItemCount(): Int {
        return allStudentSection.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var studentResponse = allStudentSection.get(position)
        holder.firstName.text = studentResponse.firstname.toString()
        holder.ret.text = studentResponse.rte
        holder.admission.text = studentResponse.admission_no.toString()



        Glide
            .with(context)
            .load("${ApiUtils.IMG_PATH}${studentResponse.image}")
            .centerCrop()
            .placeholder(R.drawable.st)
            .into(holder.studentImg)

        holder.itemView.setOnClickListener {
            var intent = Intent(this.context, StudentDetailsInfoActivity::class.java)
            intent.putExtra("student_id", studentResponse.id)
            context.startActivity(intent)

        }
    }

    class ViewHolder : RecyclerView.ViewHolder {

        var studentImg: ImageView
        var firstName: TextView
        var roll_num: TextView
        var admission : TextView
        var ret : TextView


        constructor(itemView: View) : super(itemView) {
            studentImg = itemView.findViewById(R.id.aciv_pic)
            firstName = itemView.findViewById(R.id.textstudent)
            roll_num = itemView.findViewById(R.id.actv_roll)
            admission = itemView.findViewById(R.id.actv_admission)
            ret = itemView.findViewById(R.id.actv_ret)
        }


    }
}