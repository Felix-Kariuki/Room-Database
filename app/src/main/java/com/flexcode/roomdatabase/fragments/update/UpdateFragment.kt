package com.flexcode.roomdatabase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.flexcode.roomdatabase.Model.User
import com.flexcode.roomdatabase.R
import com.flexcode.roomdatabase.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.etUpdateFirstName.setText(args.currentUser.FirstName)
        view.etUpdateLastName.setText(args.currentUser.lastName)
        view.etUpdateAge.setText(args.currentUser.age.toString())

        view.btnUpdateAdd.setOnClickListener {
            updateItem()
        }

        //add menu
        setHasOptionsMenu(true)


        return view
    }

    private fun updateItem() {
       val firstName = etUpdateFirstName.text.toString()
       val lastName = etUpdateLastName.text.toString()
        val age = etUpdateAge.text

        if (inputCheck(firstName, lastName, age)){
            //create user Object
            val updatedUser = User(args.currentUser.id, firstName, lastName, Integer.parseInt(age.toString()))
            //Update Current
            mUserViewModel.updateUser(updatedUser)
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(requireContext(), "Please Fill Out All Fields !", Toast.LENGTH_SHORT).show()
        }

    }

    //inputs function to check if empty
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age?.isEmpty())

    }


    //delete
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->

            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), getString(R.string.removed) +
                    args.currentUser.FirstName,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        builder.setNegativeButton("No"){_, _ ->}
        builder.setTitle("Delete ${args.currentUser.FirstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.FirstName}")
        builder.show()
    }

}